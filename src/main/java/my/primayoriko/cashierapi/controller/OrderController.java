package my.primayoriko.cashierapi.controller;

//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;

import my.primayoriko.cashierapi.service.impl.OrderServiceImpl;
import my.primayoriko.cashierapi.controller.model.response.DefaultResponse;
import my.primayoriko.cashierapi.controller.model.request.OrderRequest;
import my.primayoriko.cashierapi.entity.*;

//import org.springframework.web.server.ResponseStatusException;

@RestController
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping(value="/orders/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getOrderById(@PathVariable int id, HttpServletResponse response){
        try {
            Order order = orderService.getOrder(id);
            if(order == null){
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return DefaultResponse.builder().statusCode(404).message("not found").build();
            }

            return order;
        } catch (Exception e){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return DefaultResponse.builder().statusCode(404).message("not found").build();
//            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "not found");
//            return DefaultResponse.builder().statusCode(500).message("internal server error").build();
        }
    }

    @GetMapping(value="/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getOrders(HttpServletResponse response){
        try {
            Order[] orders = orderService.getOrders();

            return orders;
        } catch (Exception e){
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return DefaultResponse.builder().statusCode(500).message("internal server error").build();
        }
    }

    @PostMapping(value = "/orders")
    public Object addOrder(@RequestBody OrderRequest newOrder, HttpServletResponse response){
        try {
            orderService.insertOrder(newOrder.toOrder());

            return DefaultResponse.builder().statusCode(201).message("created").build();
        } catch (Exception e){
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return DefaultResponse.builder().statusCode(500).message("internal server error").build();
        }
    }
}
