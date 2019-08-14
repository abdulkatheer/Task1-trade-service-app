package org.katheer.tradeserviceapp.operation;

import org.katheer.tradeserviceapp.data.TradeStorage;
import org.katheer.tradeserviceapp.entity.Trade;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
public class CreateTradeOperation implements Operation {
   private Trade trade;
   public CreateTradeOperation(@Valid Trade trade) {
      this.trade = trade;
   }

   @Override
   public final String perform() {
      if (new FindByIdOperation(trade.getTradeId()).perform() != null) {
         return "Failed! Trade with ID " + trade.getTradeId() + " already exists!";
      }
      TradeStorage.trades.add(trade);
      return "Success";
   }
}
