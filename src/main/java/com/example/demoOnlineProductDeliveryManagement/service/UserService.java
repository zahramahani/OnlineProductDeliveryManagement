package com.example.demoOnlineProductDeliveryManagement.service;

import com.example.demoOnlineProductDeliveryManagement.entity.Order;
import com.example.demoOnlineProductDeliveryManagement.entity.Product;
import com.example.demoOnlineProductDeliveryManagement.entity.User;
import com.example.demoOnlineProductDeliveryManagement.repository.OrderRepository;
import com.example.demoOnlineProductDeliveryManagement.repository.ProductRepository;
import com.example.demoOnlineProductDeliveryManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository repo;
    @Autowired
    ProductRepository productRepo;
    @Autowired
    OrderRepository orderRepo;

    public String addUser(String firstName, String lastName, String userName, String password) {
        User user = new User(firstName, lastName, userName, password);
        repo.save(user);
        return "User " + firstName + " " + lastName + " added";
    }

    public Iterable<User> findAllUsers() {
        return repo.findAll();
    }

    public Optional<User> findUserByUserName(String userName) {

        return repo.findUsersByUserNameAndIsDeletedFalse(userName);
    }

    public String updateUser(String userName,String firstName, String lastName, String updateUserName, String password){
        int updatedUser=repo.updateUser(userName,firstName,lastName,updateUserName,password);
        if(updatedUser>=1) {
            return "user info's updated";
        }
        return "user Not Exists, Not able to update";
    }


    public String updateUserProduct(Product product, String behave ){
        switch (behave){
            case "add":
                productRepo.save(product);
                return "product added to user";
        }
     return "other functions will coming soon";
    }

    public String deleteUserByUserName(String userName) {
        repo.deleteUser(userName);
       return ("user deleted::" +userName);
    }

    public Iterable<Product> productList(String userName){
       return  productRepo.getProducts(userName);
    }

    public Iterable<Order> orderList(String userName){
        return  orderRepo.getOrders(userName);
    }
}
