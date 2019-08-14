package org.katheer.tradeserviceapp;

import org.katheer.tradeserviceapp.controller.ConsoleTradeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class TradeServiceApplication implements CommandLineRunner {
   @Autowired
   private ConsoleTradeController tradeController;
   private Scanner scanner;
   private static ConfigurableApplicationContext context;
   public static void main(String[] args) {
      context = SpringApplication.run(TradeServiceApplication.class, args);
   }

   @Override
   public void run(String... strings) throws Exception {
      scanner = new Scanner(System.in);

      int choice = 0;
      while (true) {
         System.out.println("================================");
         System.out.println();
         System.out.println("***Trade Service Application***");
         System.out.println("1.Create Trade");
         System.out.println("2.Find Trade by ID");
         System.out.println("3.Find by Venue");
         System.out.println("4.Find by Share Name and Total Quantity");
         System.out.println("5.Create Trades from CSV file");
         System.out.println("6.Exit");
         System.out.print("Enter your choice : ");

         choice = scanner.nextInt();

         switch (choice) {
            case 1:
               System.out.println(tradeController.createTrade());
               break;
            case 2:
               System.out.println(tradeController.findTradeById());
               break;
            case 3:
               System.out.println(tradeController.findByVenue());
               break;
            case 4:
               System.out.println(tradeController.findBuyersByShareNameAndQuantity());
               break;
            case 5:
               System.out.println(tradeController.createTradesFromCsv());
               break;
            case 6:
               context.close();
               return;
            default:
               System.out.println("Wrong Choice! Please try again!!");
         }
      }
   }
}
