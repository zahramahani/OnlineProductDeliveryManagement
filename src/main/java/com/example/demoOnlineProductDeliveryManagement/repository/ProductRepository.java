package com.example.demoOnlineProductDeliveryManagement.repository;

import com.example.demoOnlineProductDeliveryManagement.entity.Product;
import com.example.demoOnlineProductDeliveryManagement.entity.Tag;
import com.example.demoOnlineProductDeliveryManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p where p.user.userName=:userName and p.user.isDeleted=false")
    List<Product> getProducts(@Param("userName") String userName);

    Product findProductsById( Long id);

    @Transactional
    @Modifying
    @Query("update Product  p set p.name=:name , p.amount=:amount where p.name=:productName and  p.isDeleted=false")
    int updateProduct( @Param("productName")String productName, @Param("name")String name,  @Param("amount")int  amount);

    Optional<Product> findProductsByNameAndIsDeletedFalse(String productName);

    @Transactional
    @Modifying
    @Query("update Product p set p.isDeleted=true where p.name=:name and p.isDeleted=false")
    int deleteProduct( @Param("name") String name);

    List<Product>findAllByNameLikeAndIsDeletedFalse(String nameLike);
//    List<Product>findAllByTagsInAndIsDeletedFalse(Tag tag);
}

