package com.esliceu.PracticaFigures.DAO;

import com.esliceu.PracticaFigures.Model.User;

import java.util.HashMap;
import java.util.Map;

public class UserDAO implements UserDAOInter {

    public static Map userMap = new HashMap<>();
    static int userId= 0;

    @Override
    public boolean createUser(User user) {
        user.setId(userId);
        userMap.put(user.getName(),user.getPassword());
        userId+=1;
        return false;
    }
}
