package org.katheer.tradeserviceapp.operation;

import org.junit.Before;
import org.junit.Test;
import org.katheer.tradeserviceapp.data.TradeStorage;
import org.katheer.tradeserviceapp.entity.Trade;
import org.katheer.tradeserviceapp.utils.TestUtils;

import static org.junit.Assert.assertEquals;

public class FindByIdOperationTest {
   private FindByIdOperation findByIdOperation;

   @Before
   public void setup() {
      //given
      TradeStorage.trades = TestUtils.getSampleTrades();
   }

   @Test
   public void shouldReturnTrade_WhenTradeWithPassedIdExists() {
      //given
      Trade expected = TradeStorage.trades.get(0);

      //when
      findByIdOperation = new FindByIdOperation(1);
      Trade actual = findByIdOperation.perform();

      //then
      assertEquals(expected, actual);
   }

   @Test
   public void shouldReturnNull_WhenTradeWithPassedIdNotExists() {
      //given
      Trade expected = null;

      //when
      findByIdOperation = new FindByIdOperation(100);
      Trade actual = findByIdOperation.perform();

      //then
      assertEquals(expected, actual);
   }
}