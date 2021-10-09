package com.example.demoOnlineProductDeliveryManagement.controller;

import com.example.demoOnlineProductDeliveryManagement.entity.*;
import com.example.demoOnlineProductDeliveryManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserService service;
    @PostMapping(path = "users/add")
    public String addUser(@RequestBody UserInput user) {
        Optional<User> userCheck=service.findUserByUserName(user.getUserName());
        if(userCheck.isPresent()){
            return "this  UserName exist try other!!!!";
        }
        String res = service.addUser(user.getFirstName(), user.getLastName(),user.getUserName(),user.getPassword());
        return res;
    }
    @GetMapping(path = "users/list")
    public Iterable<User> userList() {
        return service.findAllUsers();
    }

    @PutMapping(path = "users/update/{userName}")
    public ResponseEntity<?> updateUser(@PathVariable String userName,@RequestBody UserInput user) {
        String res = service.updateUser(userName,user.getFirstName(), user.getLastName(),user.getUserName(),user.getPassword());
        return ResponseEntity.ok(res);
    }
    //    doesnt Work :/
    @PutMapping(path = "users/update/{userName}/addProducts")
    public String addUserProduct(@PathVariable String userName,@RequestBody ProductInput product) {
        Optional<User> user = service.findUserByUserName(userName);
        if(user.isPresent()) {
            Product p=new Product(product.getName(),product.getAmount(),user.get());
            service.updateUserProduct(p,"add");
        }
        return "user Not Exists, Not able to update";
    }
    @GetMapping("/users/remove/{userName}")
    public String delete(@PathVariable String userName) {
        Optional<User> user = service.findUserByUserName(userName);
        if(user.isPresent()) {
            service.deleteUserByUserName(userName);
            return "deleted Successfully";
        }
        return "user Not Exists, Not able to delete";
    }

    @GetMapping("/users/{userName}/products")
    public Iterable<Product> productList(@PathVariable String userName) {
        return service.productList(userName);
    }

//    doesnt Work :/
    @GetMapping("/users/{userName}/orders")
    public Iterable<Order> orderList(@PathVariable String userName) {
        return service.orderList(userName);
    }

}
