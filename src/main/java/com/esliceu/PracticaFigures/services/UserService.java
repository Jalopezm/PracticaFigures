package com.esliceu.PracticaFigures.services;

import com.esliceu.PracticaFigures.DAO.UserDAO;
import com.esliceu.PracticaFigures.DAO.UserDAOInter;
import com.esliceu.PracticaFigures.Model.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    UserDAOInter userDAO = new UserDAO();

    public void userCreation(String name, String pass) {
        User user = new User();
        user.setName(name);
        user.setPassword(pass);
        userDAO.createUser(user);
    }

}
