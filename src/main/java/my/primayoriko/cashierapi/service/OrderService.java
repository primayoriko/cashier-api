package my.primayoriko.cashierapi.service;

import my.primayoriko.cashierapi.entity.Order;

public interface OrderService {
    public Order[] getOrders();
    public Order getOrder(int num) throws Exception;
    public void insertOrder(Order order) throws Exception;
}
