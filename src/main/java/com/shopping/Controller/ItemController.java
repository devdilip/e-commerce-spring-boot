package com.shopping.Controller;

import com.shopping.DTO.RequestDTO.ItemRequestDTO;
import com.shopping.DTO.RequestDTO.ItemUpdateRequestDTO;
import com.shopping.Model.Items;
import com.shopping.Services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Items saveItem(@RequestBody ItemRequestDTO item) {
        return itemService.saveItem(item);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Items> getAllItems() {
        return itemService.getAllItem();
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<?> getItem(@PathVariable int itemId){
        Items items = itemService.getItem(itemId);
        return ( items != null )
                ? new ResponseEntity<>(items, HttpStatus.OK)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item Not Available!");
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<?> deleteItem(@PathVariable int itemId){
        String res = itemService.deleteItem(itemId);
        return ( res != null )
                ? new ResponseEntity<>(res, HttpStatus.OK)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item Record Not Found!");
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<?> updateItem(@RequestBody ItemUpdateRequestDTO itemUpdateRequestDTO, @PathVariable int itemId) {
        Items items =  itemService.updateItem(itemUpdateRequestDTO, itemId);
        return (items != null)
                ? new ResponseEntity<>(items, HttpStatus.OK)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item Record Not Found!");
    }

}
