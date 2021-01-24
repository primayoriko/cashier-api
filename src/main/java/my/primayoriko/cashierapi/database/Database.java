package my.primayoriko.cashierapi.database;

import my.primayoriko.cashierapi.entity.*;

public class Database {
    private Customer[] customers;
    private Order[] orders;
    private Item[] items;

    private static Database instance = new Database();

    private Database(){
        customers = new Customer[]{
            Customer.builder().name("fal").email("f@g.com").build(),
                Customer.builder().name("fal1").email("f1@g.com").build(),
                Customer.builder().name("fal2").email("f2@g.com").build(),
        };

        items = new Item[]{
                Item.builder().
                        orderId(0).
                        name("bawang").price(1000).quantity(10).
                        build(),
                Item.builder().
                        orderId(0).
                        name("kacang").price(1000).quantity(10).
                        build(),
        };

        orders = new Order[]{
                Order.builder().
                        customer(customers[0]).
                        items(new Item[]{
                           items[0], items[1]
                        }).
                        totalPrice(20000).
                        build(),
                Order.builder().
                        customer(customers[1]).
                        totalPrice(0).
                        build(),
        };
    }

    public static Database getInstance() {
        return instance;
    }

    public Order[] getOrders(){
        return orders;
    }

    public Order getOrder(int n) throws Exception{
        return orders[n];
    }

    public void insertOrder(Order order) throws Exception {
//        Order[] newOrder = []
    }
}
