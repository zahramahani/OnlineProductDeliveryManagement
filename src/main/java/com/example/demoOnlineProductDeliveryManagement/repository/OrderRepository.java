package com.example.demoOnlineProductDeliveryManagement.repository;

import com.example.demoOnlineProductDeliveryManagement.entity.Order;
import com.example.demoOnlineProductDeliveryManagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("select o from Order o where o.product.user.userName=:userName and  o.product.user.isDeleted=false")
    List<Order> getOrders(@Param("userName") String userName);

    List<Order>getOrderByProductName(String productNamr);
}
