package com.example.course5.Dao;

import com.example.course5.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IuserDao extends JpaRepository<User, String> {

       User findUserByIdAndPassword(String id,String password);
        List<User> findUserByAge(int age);

       @Modifying
       @Transactional
       @Query("update User u set u.name=:name where u.id=:id")
       int updateUserNameById(@Param("id") String id, @Param("name") String name);
       @Query("select u from User u where u.age<=:age")
       List<User> getUserslagerThanAge( @Param("age")int age);


}
