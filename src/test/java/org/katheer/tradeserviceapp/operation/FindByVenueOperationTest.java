package org.katheer.tradeserviceapp.operation;

import org.junit.Before;
import org.junit.Test;
import org.katheer.tradeserviceapp.data.TradeStorage;
import org.katheer.tradeserviceapp.entity.Trade;
import org.katheer.tradeserviceapp.utils.TestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FindByVenueOperationTest {
   private FindByVenueOperation findByVenueOperation;

   @Before
   public void setup() {
      //given
      TradeStorage.trades = TestUtils.getSampleTrades();
   }

   @Test
   public void shouldReturnTrades_WhenTradesWithPassedVenueExists() {
      //given
      List<Trade> expected = new ArrayList<>();
      expected.add(TradeStorage.trades.get(5));

      //when
      findByVenueOperation = new FindByVenueOperation("Delhi");
      List<Trade> actual = findByVenueOperation.perform();

      //then
      assertEquals(expected, actual);

   }

   @Test
   public void shouldReturnEmptyList_WhenTradesWithPassedVenue() {
      //given
      List<Trade> expected = new ArrayList<>();

      //when
      findByVenueOperation = new FindByVenueOperation("Trichy");
      List<Trade> actual = findByVenueOperation.perform();

      //then
      assertEquals(expected, actual);
   }
}