package com.library.service;

import com.library.Shop;
import com.library.User;
import com.library.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testservicesUser () {
        List<User> userList = userService.findAll();
        userService.add(userList.get(0));
        userService.control(userList.get(0));
        for (User u:userList
                ) {
            System.out.println("Test BookName : "+u.getPseudo());
        }
        userService.delete(userList.get(0));
        userService.findById(108);
        userMapper.userListEtoD(userList);
    }
}
