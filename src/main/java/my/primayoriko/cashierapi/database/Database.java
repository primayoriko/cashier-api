package my.primayoriko.cashierapi.database;

import java.util.ArrayList;

import my.primayoriko.cashierapi.entity.*;

public class Database {
    private ArrayList<Customer> customers;
    private ArrayList<Order> orders;
    private ArrayList<Item> items;

    private static Database instance = new Database();

    private Database(){
        customers = new ArrayList<Customer>();
        orders = new ArrayList<Order>();
        items = new ArrayList<Item>();

        customers.add(
                Customer.builder().name("fal1").email("f1@g.com").build()
                );
        customers.add(
                Customer.builder().name("fal3").email("f3@g.com").build()
                );
        customers.add(
                Customer.builder().name("fal2").email("f2@g.com").build()
                );

        items.add(
                Item.builder().
                        orderId(0).
                        name("bawang").price(1000).quantity(10).
                        build()
                );

        items.add(
                Item.builder().
                        orderId(0).
                        name("kacang").price(1000).quantity(10).
                        build()
                );

        orders.add(
                Order.builder().
                        id(0).
                        customer(customers.get(0)).
                        items(new Item[]{
                                items.get(0), items.get(1)
                        }).
                        totalPrice(20000).
                        build()
                );
        orders.add(
                Order.builder().
                        id(1).
                        customer(customers.get(1)).
                        totalPrice(0).
                        build()
                );
    }

    public static Database getInstance() {
        return instance;
    }

    public Order[] getOrders(){
        return orders.toArray(new Order[0]);
    }

    public Order getOrder(int n) throws Exception{
        return orders.get(n);
    }

    public void insertOrder(Order order) throws Exception {
        if(order != null){
            int newId = orders.size();

            if(order.getCustomer() != null){
                customers.add(order.getCustomer());
            }

            int totalPrice = 0;
            Item[] orderItems = order.getItems();
            if(orderItems != null){
                for(Item item: orderItems){
                    item.setOrderId(newId);
                    items.add(item);
                    totalPrice += item.getQuantity() * item.getPrice();
                }
            }

            order.setId(newId);
            order.setTotalPrice(totalPrice);
            orders.add(order);
        }
    }
}
