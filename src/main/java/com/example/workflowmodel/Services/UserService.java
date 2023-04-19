package com.example.workflowmodel.Services;

import com.example.workflowmodel.DAO.UserDao;
import com.example.workflowmodel.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getAllUsers(){

        try {
             List<User> userList = userDao.findAll();

             return userList;
        }catch (Exception e){
            System.out.println("fetching users list error");
            throw new RuntimeException();
        }
    }

}
