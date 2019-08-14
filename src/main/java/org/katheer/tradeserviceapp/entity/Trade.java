package org.katheer.tradeserviceapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Trade {
   private int tradeId;
   @NotNull(message = "Buyer ID cannot be null")
   private String buyerId;
   @NotNull(message = "Buyer Name cannot be null")
   private String buyerName;
   @NotNull(message = "Seller ID cannot be null")
   private String shareId;
   @NotNull(message = "Seller Name cannot be null")
   private String shareName;
   @NotNull(message = "Quantity cannot be zero")
   private int quantity;
   @NotNull(message = "Price cannot be zero")
   private int price;
   @NotNull(message = "Venue cannot be null")
   private String venue;
   @NotNull(message = "Date cannot be null")
   private Date tradingDateTime;

   @Override
   public String toString() {
      return "Trade{" +
            "tradeId=" + tradeId +
            ", buyerId=" + buyerId +
            ", buyerName='" + buyerName + '\'' +
            ", sellerId=" + shareId +
            ", sellerName='" + shareName + '\'' +
            ", quantity=" + quantity +
            ", price=" + price +
            ", venue='" + venue + '\'' +
            ", tradingDateTime=" + tradingDateTime +
            '}';
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Trade trade = (Trade) o;
      return tradeId == trade.tradeId;
   }

   @Override
   public int hashCode() {
      return Objects.hash(tradeId);
   }
}
