package org.katheer.tradeserviceapp.operation;

import org.katheer.tradeserviceapp.data.TradeStorage;
import org.katheer.tradeserviceapp.entity.Trade;

import java.util.List;
import java.util.stream.Collectors;

public class FindByIdOperation implements Operation {
   private int tradeId;

   public FindByIdOperation(int tradeId) {
      this.tradeId = tradeId;
   }

   @Override
   public final Trade perform() {
      List<Trade> trades = TradeStorage.trades.stream()
            .filter(trade -> trade.getTradeId() == tradeId)
            .collect(Collectors.toList());
      return trades.size() == 0 ? null : trades.get(0);
   }
}
