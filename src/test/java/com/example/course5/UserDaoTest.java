package com.example.course5;

import org.springframework.boot.test.context.SpringBootTest;
import com.example.course5.Dao.IuserDao;
import com.example.course5.Entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;


@SpringBootTest
public class UserDaoTest {
    @Autowired
    private IuserDao userdao;

    @Test
    public void creatUser() {
        User u = new User();
        u.setId("3");
        u.setName("Sur");
        u.setAge(12);
        u.setPassword("123456");
        u.setSex(true);
        userdao.save(u);
    }

    @Test
    public void updateUser() {
        User u = new User();
        u.setId("1");
        u.setName("Suri");
        u.setAge(12);
        u.setPassword("1256");
        u.setSex(true);
        userdao.save(u);
    }

    @Test
    public void InsertUsertes() {
        List<User> ulist = new ArrayList<User>();
        User u1 = new User();
        u1.setId("16");
        u1.setName("Surq1");
        u1.setAge(142);
        u1.setPassword("1456");
        u1.setSex(true);


        User u2 = new User();
        u2.setId("17");
        u2.setName("Sur1");
        u2.setAge(212);
        u2.setPassword("1236");
        u2.setSex(true);


        User u3 = new User();
        u3.setId("18");
        u3.setName("Sur1");
        u3.setAge(112);
        u3.setPassword("1256");
        u3.setSex(true);


        ulist.add(u1);
        ulist.add(u2);
        ulist.add(u3);

        userdao.saveAll(ulist);
    }

    @Test
    public void findAllUser() {
        List<User> ulist = userdao.findAll();
        System.out.println("");

    }

    @Test
    public void login() {
        User u = userdao.findUserByIdAndPassword("1", "1256");
        System.out.println("");
    }

     @Test
    public void findUserWithAge1(){
        List<User> ulist=userdao.findUserByAge(12);
        System.out.println("");
    }
    @Test
    public void updateUserName() {
        int result = userdao.updateUserNameById("1", "Suphero");
        System.out.println(result);
    }
    @Test
    public void findUserWithAge2(){
        List<User> ulist=userdao.getUserslagerThanAge(12);
        System.out.println("");
    }

}



