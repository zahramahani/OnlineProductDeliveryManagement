package com.example.demoOnlineProductDeliveryManagement.repository;
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
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUsersByUserNameAndIsDeletedFalse(String username);

    List<User> findAllByIsDeletedFalse();

    @Transactional
    @Modifying
    @Query("update User s set s.isDeleted=true where s.userName=:userName and  s.isDeleted=false")
    int deleteUser( @Param("userName") String userName);

    @Transactional
    @Modifying
    @Query("update User s set s.firstName=:firstName ,s.lastName=:lastName,s.userName=:updateUserName,s.password=:password  where s.userName=:userName and  s.isDeleted=false")
    int updateUser( @Param("userName")String userName, @Param("firstName")String firstName,  @Param("lastName")String lastName,  @Param("updateUserName")String updateUserName, @Param("password") String password);

}
