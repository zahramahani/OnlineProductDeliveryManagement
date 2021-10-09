package com.example.demoOnlineProductDeliveryManagement.service;

import com.example.demoOnlineProductDeliveryManagement.entity.Order;
import com.example.demoOnlineProductDeliveryManagement.entity.Product;
import com.example.demoOnlineProductDeliveryManagement.entity.Tag;
import com.example.demoOnlineProductDeliveryManagement.repository.OrderRepository;
import com.example.demoOnlineProductDeliveryManagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService {
    @Autowired
    ProductRepository productRepo;
    @Autowired
    OrderRepository orderRepo;
//doesnt work :/
    public String addProduct(Product product) {
      productRepo.save(product);
        return "product " + product.getName() + " added";
    }

    public Iterable<Product> findAllProducts() {
        return productRepo.findAll();
    }

    public String updateProduct(String productName, String name, int amount) {
        int updatedProduct=productRepo.updateProduct(productName,name,amount);
        if(updatedProduct>=1) {
            return "product info's updated";
        }
        return "Not able to update";
    }

    public Optional<Product> findProductByProductName(String productName) {
        return productRepo.findProductsByNameAndIsDeletedFalse(productName);
    }

    public String deleteProductByProductName(String name) {
        productRepo.deleteProduct(name);
        return "Product "+name+" deleted";
    }

    public String updateOrderProduct(Order order, String behave) {
        switch (behave){
            case "add":
                orderRepo.save(order);
                return "order added to product";
        }
        return "other functions will coming soon";

    }

    public Iterable<Order> orderList(String productName) {
        return orderRepo.getOrderByProductName(productName);
    }

    public Iterable<Product> SearchProductList( String productName) {
       List<Product> productByName=productRepo.findAllByNameLikeAndIsDeletedFalse(productName);
        if(productByName.size()>0) {
            return productByName;
        }
//        List<Product> productByTag=productRepo.findAllByTagsInAndIsDeletedFalse(tag);
//        if(productByTag.size()>0) {
//            return productByTag;
//        }
        return null;
    }
}
