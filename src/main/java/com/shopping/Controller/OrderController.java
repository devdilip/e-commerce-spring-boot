package com.shopping.Controller;

import com.shopping.DTO.OrderResponseDTO;
import com.shopping.Model.Orders;
import com.shopping.Model.User;
import com.shopping.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> saveOrder(@RequestParam int itemId, @RequestParam int noOfItems, @RequestParam String email) {
        Orders orders =  orderService.saveOrder(itemId, noOfItems, email);
        return  new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Orders> getAllOrder() {
        return orderService.getAllOrder();
    }

    @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
    public ResponseEntity<?> getOrder(@PathVariable int orderId){
        OrderResponseDTO orderResponseDTO =  orderService.getOrder(orderId);
        return ( orderResponseDTO != null )
                ? new ResponseEntity<>(orderResponseDTO, HttpStatus.OK)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order Record Not Found!");
    }
}
