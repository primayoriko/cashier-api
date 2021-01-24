package my.primayoriko.cashierapi.controller.model.request;

import lombok.Builder;
import lombok.Data;

import my.primayoriko.cashierapi.entity.Customer;
import my.primayoriko.cashierapi.entity.Item;
import my.primayoriko.cashierapi.entity.Order;

@Data
@Builder
public class OrderRequest {
    private Customer customer;
    private ItemRequest[] items;

    public Order toOrder(){
        Item[] items = null;
        if(this.items != null){
            items = new Item[this.items.length];
            for(int i = 0; i < this.items.length; i++){
                items[i] = this.items[i].toItem();
            }
        }

        return Order.builder().customer(customer).items(items).build();
    }
}

@Data
@Builder
class ItemRequest {
    private int price;
    private String name;
    private int quantity;

    public Item toItem(){
        return Item.builder().price(price).name(name).quantity(quantity).build();
    }
}
