package my.primayoriko.cashierapi.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {
    private int price;
    private String name;
    private int quantity;
    private int orderId;
}
