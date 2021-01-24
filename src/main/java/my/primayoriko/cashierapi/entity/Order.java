package my.primayoriko.cashierapi.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {
    private int id;
    private Customer customer;
    private Item[] items;
    private int totalPrice;
}
