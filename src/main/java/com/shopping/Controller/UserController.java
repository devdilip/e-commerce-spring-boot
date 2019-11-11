package com.shopping.Controller;


import com.shopping.DTO.UserRequestDTO;
import com.shopping.Model.User;
import com.shopping.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public User savePerson(@RequestBody UserRequestDTO user) {
        return userService.saveUser(user);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> getAllPersons() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ResponseEntity<?>  getUser(@PathVariable int userId){
        User user =  userService.getUser(userId);
        return ( user != null )
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Record Not Found!");
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable int userId){
        String res =  userService.deleteUser(userId);
        return ( res != null )
                ? new ResponseEntity<>(res, HttpStatus.OK)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Record Not Found!");
    }

}
