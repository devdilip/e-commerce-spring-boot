package com.shopping.Services;

import com.shopping.DTO.ResponseDTO.OrderResponseDTO;
import com.shopping.Model.Items;
import com.shopping.Model.Orders;
import com.shopping.Model.User;
import com.shopping.Repository.ItemRepository;
import com.shopping.Repository.OrderRepository;
import com.shopping.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Orders> getAllOrder(){
        List<Orders> orders = orderRepository.findAll();
//        for(Or : Order)
         return null;
    }

    public Orders saveOrder (int itemId, int noOfItems, String email){
        Orders orders = new Orders();
        orders.setItemId(itemId);
        orders.setUserEmail(email);
        orders.setNoOfItems(noOfItems);
        return orderRepository.save(orders);
    }

    public OrderResponseDTO getOrder(int orderId) {
        Optional<Orders> order = orderRepository.findById(orderId);
        if(order.isPresent()){
            Optional<Items> items = itemRepository.findById(order.get().getItemId());
            Optional<User> user = userRepository.findById(order.get().getUserId());
            String itemName = items.isPresent() ? items.get().getItemName() : null;
            OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
            orderResponseDTO.setItemName(itemName);
            orderResponseDTO.setItemId(order.get().getItemId());
            orderResponseDTO.setName(user.get().getName());
            orderResponseDTO.setMobile(user.get().getMobile());
            orderResponseDTO.setUserEmail(order.get().getUserEmail());
            return orderResponseDTO;
        }
        else {
            return null;
        }
    }


}
