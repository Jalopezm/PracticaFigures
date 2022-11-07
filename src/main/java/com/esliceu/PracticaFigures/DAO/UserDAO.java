package com.esliceu.PracticaFigures.DAO;

import com.esliceu.PracticaFigures.Model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO implements UserDAOInter {

    public static List<User> userList = new ArrayList<User>();
    static int userId = 0;

    @Override
    public void createUser(User user) {
        if (!userList.contains(user.getName())) {
            user.setId(userId);
            userList.add(user);
            userId += 1;
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userList;
    }

}
