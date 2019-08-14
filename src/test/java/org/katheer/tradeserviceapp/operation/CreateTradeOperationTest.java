package org.katheer.tradeserviceapp.operation;

import org.junit.Before;
import org.junit.Test;
import org.katheer.tradeserviceapp.data.TradeStorage;
import org.katheer.tradeserviceapp.entity.Trade;
import org.katheer.tradeserviceapp.utils.TestUtils;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreateTradeOperationTest {
   private CreateTradeOperation createTradeOperation;

   @Before
   public void setup() {
      //given
      TradeStorage.trades = TestUtils.getSampleTrades();
   }

   @Test
   public void shouldReturnSuccess_IfTradeIsInserted() {
      //when
      createTradeOperation = new CreateTradeOperation(Trade.builder()
            .tradeId(10)
            .buyerId("B-111")
            .buyerName("Abdul")
            .shareId("S-111")
            .shareName("Infosys")
            .quantity(10)
            .price(1000)
            .venue("Bangalore")
            .tradingDateTime(new Date())
            .build());

      //then
      assertEquals("Success", createTradeOperation.perform());
   }

   @Test
   public void shouldReturnFailedMessage_IfTradeIsNotInserted() {
      //when
      createTradeOperation = new CreateTradeOperation(Trade.builder()
            .tradeId(1)
            .buyerId("B-111")
            .buyerName("Abdul")
            .shareId("S-111")
            .shareName("Infosys")
            .quantity(10)
            .price(1000)
            .venue("Bangalore")
            .tradingDateTime(new Date())
            .build());

      //then
      assertTrue(createTradeOperation.perform().contains("Failed"));
   }
}