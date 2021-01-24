package my.primayoriko.cashierapi.service.impl;

import my.primayoriko.cashierapi.database.Database;
import my.primayoriko.cashierapi.entity.Order;
import org.springframework.stereotype.Service;

import my.primayoriko.cashierapi.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public Order[] getOrders(){
        Database db = Database.getInstance();

        return db.getOrders();
    }

    @Override
    public Order getOrder(int n) throws Exception{
        try{
            Database db = Database.getInstance();

            return db.getOrder(n);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public void insertOrder(Order order) throws Exception{
        try{
            Database db = Database.getInstance();

            db.insertOrder(order);
        } catch (Exception e){
            throw e;
        }
    }
}
