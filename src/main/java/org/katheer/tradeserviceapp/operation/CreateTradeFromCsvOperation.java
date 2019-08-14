package org.katheer.tradeserviceapp.operation;

import org.katheer.tradeserviceapp.entity.Trade;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CreateTradeFromCsvOperation implements Operation {

   @Override
   public final String perform() throws Exception {
      int count = 0;
      String row;
      String status;
      String pathToCsv = "C:\\DEV\\trades.csv";
      BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));
      int i = 1;
      while ((row = csvReader.readLine()) != null) {
         String[] data = row.split(",");
         System.out.println("Inserting Record " + i);
         Trade trade = parseTrade(data);
         if (trade != null) {
            status = new CreateTradeOperation(trade).perform();
            if (status == "Success") {
               count++;
               System.out.println(status);
            } else {
               System.out.println(status);
            }

         } else {
            System.out.println("Failed to add record " + i);
         }
         i++;
      }
      csvReader.close();
      System.out.println();
      return count + " trades have been created";
   }

   private Trade parseTrade(String[] values) {
      Trade trade = new Trade();
      try {
         trade.setTradeId(Integer.parseInt(values[0]));
         trade.setBuyerId(values[1]);
         trade.setBuyerName(values[2]);
         trade.setShareId(values[3]);
         trade.setShareName(values[4]);
         trade.setQuantity(Integer.parseInt(values[5]));
         trade.setPrice(Integer.parseInt(values[6]));
         trade.setVenue(values[7]);
         try {
            trade.setTradingDateTime(new SimpleDateFormat("DD/MM/YYYY").parse(values[8]));
         } catch (ParseException e) {
            System.out.println(e.getMessage());
            return null;
         }
      } catch (Exception e) {
         System.out.println(e.getMessage());
         System.out.println("Failed Trade Data : " + trade);
         return null;
      }
      return trade;
   }
}
