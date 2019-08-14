package org.katheer.tradeserviceapp.operation;

import org.junit.Before;
import org.junit.Test;
import org.katheer.tradeserviceapp.data.TradeStorage;
import org.katheer.tradeserviceapp.utils.TestUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FindBuyersByShareNameAndQuantityOperationTest {
   private FindBuyersByShareNameAndQuantityOperation findBuyersByShareNameAndQuantityOperation;

   @Before
   public void setup() {
      //given
      TradeStorage.trades = TestUtils.getSampleTrades();
   }

   @Test
   public void shouldReturnBuyerIds_WhenTradesWithShareNameXAndAggregateQuantityLesserThanYExists() throws Exception {
      //given
      List<String> expected = new ArrayList<>();
      expected.add("B-112");

      //when
      findBuyersByShareNameAndQuantityOperation = new FindBuyersByShareNameAndQuantityOperation("Infosys", 100, 'l');
      List<String> actual = findBuyersByShareNameAndQuantityOperation.perform();

      //then
      assertEquals(expected, actual);
   }

   @Test
   public void shouldReturnBuyerIds_WhenTradesWithShareNameXAndAggregateQuantityGreaterThanYExists() throws Exception {
      //given
      List<String> expected = new ArrayList<>(Arrays.asList("B-111", "B-113", "B-114", "B-115"));

      //when
      findBuyersByShareNameAndQuantityOperation = new FindBuyersByShareNameAndQuantityOperation("Infosys", 100, 'g');
      List<String> actual = findBuyersByShareNameAndQuantityOperation.perform();

      //then
      assertEquals(expected, actual);
   }

   @Test
   public void shouldReturnEmptyList_WhenTradesWithShareNameXAndAggregateQuantityConditionYNotExists() throws Exception {
      //when
      findBuyersByShareNameAndQuantityOperation = new FindBuyersByShareNameAndQuantityOperation("Infosys", 1000, 'g');
      List<String> actual = findBuyersByShareNameAndQuantityOperation.perform();

      //then
      assertEquals(0, actual.size());
   }

   @Test(expected = Exception.class)
   public void shouldThrowException_WhenCriteriaIsInvalid() throws Exception {
      //when
      findBuyersByShareNameAndQuantityOperation = new FindBuyersByShareNameAndQuantityOperation("Infosys", 100, 'k');
      findBuyersByShareNameAndQuantityOperation.perform();
   }
}