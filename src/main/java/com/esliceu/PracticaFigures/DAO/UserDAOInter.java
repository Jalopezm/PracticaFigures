package com.esliceu.PracticaFigures.DAO;

import com.esliceu.PracticaFigures.Model.User;

import java.util.List;

public interface UserDAOInter {
    void createUser(User user);

    List<User> getAllUsers();
}
