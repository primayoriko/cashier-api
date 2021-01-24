package my.primayoriko.cashierapi.controller;

import my.primayoriko.cashierapi.controller.model.request.NewOrderRequest;
import my.primayoriko.cashierapi.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import my.primayoriko.cashierapi.service.impl.OrderServiceImpl;

@RestController
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping(value="/orders/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order getOrderById(@PathVariable int id){
        try {
            Order order = orderService.getOrder(id);
            return order;
        } catch (Exception e){
            return null;
        }
    }

    @GetMapping(value="/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order[] getOrderById(){
        try {
            Order[] orders = orderService.getOrders();

            return orders;
        } catch (Exception e){
            return new Order[]{};
        }
    }

    @PostMapping(value = "/orders")
    public void addOrder(@RequestBody NewOrderRequest newOrder){
        try {

        } catch (Exception e){

        }
    }
}
