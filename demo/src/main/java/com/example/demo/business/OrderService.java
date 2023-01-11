package com.example.demo.business;

import com.example.demo.dao.Order;
import com.example.demo.dao.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public void createOrders(Order order){
        orderRepository.save(order);
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Integer id){
        return orderRepository.findById(id);
    }

    public void updateOrder(Integer id, Order order){
        orderRepository.save(order);
    }
    public void deleteOrderById(Integer id){
        orderRepository.deleteById(id);
    }
    public void deleteOrder(Order order){
        orderRepository.delete(order);
    }
}
