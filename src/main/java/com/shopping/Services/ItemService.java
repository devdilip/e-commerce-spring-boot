package com.shopping.Services;

import com.shopping.DTO.RequestDTO.ItemRequestDTO;
import com.shopping.DTO.RequestDTO.ItemUpdateRequestDTO;
import com.shopping.Model.Items;
import com.shopping.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Items saveItem(ItemRequestDTO itemRequestDTO) {
        Items item = new Items();
        item.setItemName(itemRequestDTO.getItemName());
        item.setItemNo(itemRequestDTO.getItemNo());
        item.setItemPrice(itemRequestDTO.getItemPrice());
        item.setNoOfItem(itemRequestDTO.getNoOfItem());
        Items items;

        return itemRepository.save(item);
    }

    public List<Items> getAllItem (){
        return itemRepository.findAll();
    }

    public Items getItem(int itemId) {
        Optional<Items> items = itemRepository.findById(itemId);
        return items.isPresent() ? items.get() : null;
    }

    public String deleteItem(int id) {
        Optional<Items> items = itemRepository.findById(id);
        if (items.isPresent()) {
            itemRepository.delete(items.get());
            return "Record Deleted!!";
        }
        return null;
    }

    public Items updateItem(ItemUpdateRequestDTO itemUpdateRequestDTO, int id) {
        Optional<Items> items = itemRepository.findById(id);
        if (items.isPresent()) {
            items.get().setNoOfItem(itemUpdateRequestDTO.getNoOfItem());
            items.get().setItemPrice(itemUpdateRequestDTO.getItemPrice());
            return itemRepository.save(items.get());
        }
        return null;
    }

}
