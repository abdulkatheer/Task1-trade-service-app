package org.katheer.tradeserviceapp.operation;

import org.katheer.tradeserviceapp.data.TradeStorage;
import org.katheer.tradeserviceapp.entity.Trade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindBuyersByShareNameAndQuantityOperation implements Operation {
   private String shareName;
   private int quantity;
   private char criteria;//l for lesser than and g for greater than

   public FindBuyersByShareNameAndQuantityOperation(String shareName, int quantity, char criteria) {
      this.shareName = shareName;
      this.quantity = quantity;
      this.criteria = criteria;
   }

   @Override
   public final List<String> perform() throws Exception {
      if (!(criteria == 'l' || criteria == 'g')) {
         throw new Exception("Criteria should be l or g only!");
      }

      //filter trades by shareName
      Map<String, List<Trade>> trades = TradeStorage.trades.stream()
            .filter(trade -> trade.getShareName().equals(shareName))
            .collect(Collectors.groupingBy(Trade::getBuyerId));

      //aggregate buyers and tradeQuantity
      Map<String, Integer> aggregated = new HashMap<>();
      trades.forEach(((buyerId, tradeList) -> aggregated.put(buyerId,
            tradeList.stream()
                  .mapToInt(Trade::getQuantity)
                  .sum())));

      //find the right buyers based on criteria
      List<String> result = new ArrayList<>();
      if (criteria == 'l') {
         aggregated.forEach((buyerId, totalQuantity) -> {
            if (totalQuantity < quantity)
               result.add(buyerId);
         });
      } else {
         aggregated.forEach((buyerId, totalQuantity) -> {
            if (totalQuantity > quantity)
               result.add(buyerId);
         });
      }

      Collections.sort(result);
      return result;
   }
}
