package org.katheer.tradeserviceapp.utils;

import org.katheer.tradeserviceapp.entity.Trade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestUtils {
   public static List<Trade> getSampleTrades() {
      List<Trade> trades = new ArrayList<>();
      trades.add( Trade.builder()
                  .tradeId(1)
                  .buyerId("B-111")
                  .buyerName("Abdul")
                  .shareId("S-111")
                  .shareName("Infosys")
                  .quantity(100)
                  .price(10000)
                  .venue("Bangalore")
                  .tradingDateTime(new Date())
                  .build()
      );

      trades.add( Trade.builder()
                  .tradeId(2)
                  .buyerId("B-112")
                  .buyerName("Manasa")
                  .shareId("S-111")
                  .shareName("Infosys")
                  .quantity(50)
                  .price(5000)
                  .venue("Chennai")
                  .tradingDateTime(new Date())
                  .build()
      );

      trades.add( Trade.builder()
                  .tradeId(3)
                  .buyerId("B-113")
                  .buyerName("Utpal")
                  .shareId("S-111")
                  .shareName("Infosys")
                  .quantity(150)
                  .price(15000)
                  .venue("Mumbai")
                  .tradingDateTime(new Date())
                  .build()
      );

      trades.add( Trade.builder()
                  .tradeId(4)
                  .buyerId("B-111")
                  .buyerName("Abdul")
                  .shareId("S-112")
                  .shareName("IBM")
                  .quantity(170)
                  .price(157000)
                  .venue("Bangalore")
                  .tradingDateTime(new Date())
                  .build()
      );

      trades.add( Trade.builder()
                  .tradeId(5)
                  .buyerId("B-114")
                  .buyerName("Mandar")
                  .shareId("S-111")
                  .shareName("Infosys")
                  .quantity(170)
                  .price(168000)
                  .venue("Hyderabad")
                  .tradingDateTime(new Date())
                  .build()
      );

      trades.add( Trade.builder()
                  .tradeId(6)
                  .buyerId("B-115")
                  .buyerName("Rishi")
                  .shareId("S-111")
                  .shareName("Infosys")
                  .quantity(200)
                  .price(1268000)
                  .venue("Delhi")
                  .tradingDateTime(new Date())
                  .build()
      );

      trades.add( Trade.builder()
                  .tradeId(7)
                  .buyerId("B-111")
                  .buyerName("Abdul")
                  .shareId("S-111")
                  .shareName("Infosys")
                  .quantity(200)
                  .price(1268000)
                  .venue("Bangalore")
                  .tradingDateTime(new Date())
                  .build()
      );

      trades.add( Trade.builder()
                  .tradeId(8)
                  .buyerId("B-111")
                  .buyerName("Abdul")
                  .shareId("S-111")
                  .shareName("IBM")
                  .quantity(200)
                  .price(1268000)
                  .venue("Bangalore")
                  .tradingDateTime(new Date())
                  .build()
      );
      return trades;
   }
}
