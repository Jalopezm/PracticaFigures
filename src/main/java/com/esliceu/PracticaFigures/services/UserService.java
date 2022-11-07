package com.esliceu.PracticaFigures.services;

import com.esliceu.PracticaFigures.DAO.UserDAO;
import com.esliceu.PracticaFigures.DAO.UserDAOInter;
import com.esliceu.PracticaFigures.Model.User;

import java.util.List;

public class UserService {
    UserDAOInter userDAO = new UserDAO();

    public User userCreation(String name) {
        User user = new User();
        user.setName(name);
        userDAO.createUser(user);
        return getUserByName(name);
    }
    public User getUserByName(String name){
        List<User> userList = userDAO.getAllUsers();
        System.out.println(userList);
            for (User user:userList) {
                if (user.getName() == name){
                    return user;
                }
            }
        return null;
    }

}
