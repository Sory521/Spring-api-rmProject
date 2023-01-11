package com.example.demo.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.OrderService;
import com.example.demo.dao.Order;

@RestController
@RequestMapping("api")
public class OrderApiController {
    
    @Autowired
    OrderService orderService;

    @GetMapping("orders")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("orders/{id}")
    public ResponseEntity<Order>  getOrderById(@PathVariable Integer id){
        Optional<Order> optional = orderService.getOrderById(id);
        if(optional.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            Order order = optional.get();
            return ResponseEntity.ok(order);
        }
    }

    @PostMapping("orders")
    public void createOrders(@RequestBody Order order){
        orderService.createOrders(order);
    }

    @DeleteMapping("orders/{id}")
    public ResponseEntity<Order> deleteOrderById(@PathVariable Integer id){
        Optional<Order> optional = orderService.getOrderById(id);
        if(optional.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            Order order = optional.get();
            orderService.deleteOrder(order);
            return ResponseEntity.ok().build();
        }
    }

    @PutMapping("orders/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Integer id, @RequestBody Order order){
        Optional<Order> optional = orderService.getOrderById(id);
        if(optional.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            if(id.equals(order.getId())){
                orderService.updateOrder(id, order);
                return ResponseEntity.ok().build();
            }else{
                return ResponseEntity.badRequest().build();
            }
        }
    }
}
