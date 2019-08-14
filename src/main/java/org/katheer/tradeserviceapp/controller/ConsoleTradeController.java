package org.katheer.tradeserviceapp.controller;

import org.katheer.tradeserviceapp.entity.Trade;
import org.katheer.tradeserviceapp.operation.CreateTradeFromCsvOperation;
import org.katheer.tradeserviceapp.operation.CreateTradeOperation;
import org.katheer.tradeserviceapp.operation.FindBuyersByShareNameAndQuantityOperation;
import org.katheer.tradeserviceapp.operation.FindByIdOperation;
import org.katheer.tradeserviceapp.operation.FindByVenueOperation;
import org.katheer.tradeserviceapp.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleTradeController {
   @Autowired
   private TradeService tradeService;
   private Scanner scanner;

   ConsoleTradeController() {
      this.scanner = new Scanner(System.in);
   }

   public final String createTrade() {
      String status;
      Trade trade = new Trade();
      System.out.println("***Create Trade***");
      System.out.println("Enter the trade data : ");
      System.out.print("Trade ID  : ");
      trade.setTradeId(scanner.nextInt());
      System.out.print("Buyer ID  : ");
      trade.setBuyerId(scanner.next());
      System.out.print("Buyer Name: ");
      trade.setBuyerName(scanner.next());
      System.out.print("Share ID  : ");
      trade.setShareId(scanner.next());
      System.out.print("Share Name: ");
      trade.setShareName(scanner.next());
      System.out.print("Quantity  : ");
      trade.setQuantity(scanner.nextInt());
      System.out.print("Price     : ");
      trade.setPrice(scanner.nextInt());
      System.out.print("Venue     : ");
      trade.setVenue(scanner.next());
      System.out.print("Date(DD/MM/YYYY): ");
      String sDate = scanner.next();
      try {
         trade.setTradingDateTime(new SimpleDateFormat("dd/MM/yyyy").parse(sDate));
      } catch (ParseException e) {
         return "Invalid Date Format!";
      }
      try {
         status = tradeService.performOperation(new CreateTradeOperation(trade));
      } catch (Exception e) {
         e.printStackTrace();
         status = "Operation Failed due to exception => " + e.getMessage();
      }
      return status;
   }

   public final String findTradeById() {
      String status;
      System.out.println("***Find Trade by ID***");
      System.out.print("Trade ID : ");
      int id = scanner.nextInt();
      Trade trade;
      try {
         trade = tradeService.performOperation(new FindByIdOperation(id));
      } catch (Exception e) {
         return "Operation Failed due to exception => " + e.getMessage();
      }

      if (trade == null) {
         status = "Not Exists";
      } else {
         status = trade.toString();
      }
      return status;
   }

   public final String findByVenue() {
      String status;
      System.out.println("***Find by Venue***");
      System.out.print("Venue  : ");
      String venue = scanner.next();

      List<Trade> tradeList;
      try {
         tradeList = tradeService.performOperation(new FindByVenueOperation(venue));
      } catch (Exception e) {
         return "Operation Failed due to exception => " + e.getMessage();
      }

      if (tradeList.isEmpty()) {
         status = "Not Exists";
      } else {
         StringBuilder trades = new StringBuilder();
         tradeList.forEach(trade -> trades.append(trade + "\n"));
         status = trades.toString();
      }

      return status;
   }

   public final String findBuyersByShareNameAndQuantity() {
      String status;
      System.out.println("Find Buyers by Share Name and Quanity");
      System.out.print("Share Name  : ");
      String shareName = scanner.next();
      System.out.print("Quantity    : ");
      int quantity = scanner.nextInt();
      System.out.print("Criteria (l or g) : ");
      char criteria = scanner.next().charAt(0);

      List<String> buyers;
      try {
         buyers = tradeService.performOperation(new FindBuyersByShareNameAndQuantityOperation(shareName, quantity, criteria));
      } catch (Exception e) {
         return "Operation Failed due to exception => " + e.getMessage();
      }

      if (buyers.isEmpty()) {
         status = "Not Exists";
      } else {
         status = buyers.toString();
      }
      return status;
   }

   public final String createTradesFromCsv() {
      String status;
      try {
         status = tradeService.performOperation(new CreateTradeFromCsvOperation());
      } catch (Exception e) {
         status = "Operation Failed due to exception => " + e.getMessage();
      }
      return status;
   }
}
