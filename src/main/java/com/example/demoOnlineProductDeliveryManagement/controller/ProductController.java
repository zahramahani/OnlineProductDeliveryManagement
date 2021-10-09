package com.example.demoOnlineProductDeliveryManagement.controller;

import com.example.demoOnlineProductDeliveryManagement.entity.*;
import com.example.demoOnlineProductDeliveryManagement.service.ProductService;
import com.example.demoOnlineProductDeliveryManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    ProductService service;
    @Autowired
    UserService  userService;
    @Autowired
    ProductService  productService;

    @PostMapping(path = "products/add/{userName}")
    public String addProduct(@PathVariable String  userName,@RequestParam String tagName ,@RequestBody ProductInput product) {
        Optional<User> user = userService.findUserByUserName(userName);
        if(user.isPresent()) {
//            Tag tag= new Tag(tagName);
//            List<Tag>tags = null;
//            tags.add(tag);
            Product p=new Product(product.getName(),product.getAmount(),user.get());
            service.addProduct(p);
        }
        return "user Not Exists, Not able to update";

    }
    @GetMapping(path = "products/list")
    public Iterable<Product> productList() {
        return service.findAllProducts();
    }

    @PutMapping(path = "products/update/{productName}")
    public String  updateProduct(@PathVariable String productName, @RequestBody ProductInput product) {
        String res = service.updateProduct(productName,product.getName(), product.getAmount());
        return res;
    }

    @PutMapping(path = "products/update/{productName}/addOrder")
    public String addOrderProduct(@PathVariable String productName,@RequestBody String deliveryAddress) {
        Optional<Product> product = service.findProductByProductName(productName);
        if(product.isPresent()) {
            Product p=product.get();
            Order order=new Order( deliveryAddress);
            p.setOrder(order);
            productService.deleteProductByProductName(productName);
            productService.addProduct(p);
            order.setProduct(product.get());
            service.updateOrderProduct(order,"add");
        }
        return "product Not Exists, Not able to update";
    }
    @GetMapping("/products/remove/{productName}")
    public String delete(@PathVariable String productName) {
        Optional<Product> product = service.findProductByProductName(productName);

        if(product.isPresent()) {
            service.deleteProductByProductName(productName);
            return "deleted Successfully";
        }
        return "product Not Exists, Not able to delete";
    }

    @GetMapping("/products/search")
    public Iterable<Product> productList(@RequestParam String tag ,@RequestParam String productName ) {
        return service.SearchProductList(productName);
    }


    @GetMapping("/products/{productName}/orders")
    public Iterable<Order> orderList(@PathVariable String productName) {
        return service.orderList(productName);
    }
}
