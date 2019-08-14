package org.katheer.tradeserviceapp.operation;

import org.katheer.tradeserviceapp.data.TradeStorage;
import org.katheer.tradeserviceapp.entity.Trade;

import java.util.List;
import java.util.stream.Collectors;

public class FindByVenueOperation implements Operation {
   private String venue;

   public FindByVenueOperation(String venue) {
      this.venue = venue;
   }

   @Override
   public final List<Trade> perform() {
      return TradeStorage.trades.stream()
            .filter(trade -> trade.getVenue().equals(venue))
            .collect(Collectors.toList());
   }
}
