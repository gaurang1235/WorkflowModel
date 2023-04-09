package com.example.workflowmodel.Services;

import com.example.workflowmodel.DAO.UserDao;
import com.example.workflowmodel.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User findUser(int userId){
        User user;

        try {
             user = userDao.findByUserId(userId);
        }catch (Exception e){
            System.out.println("searching user error");
            throw new RuntimeException();
        }

        return user;
    }

}
