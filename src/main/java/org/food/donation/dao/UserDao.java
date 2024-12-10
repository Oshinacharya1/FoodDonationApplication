package org.food.donation.dao;
import org.food.donation.model.User;

import java.util.List;

public interface UserDao {
    void addUser(org.food.donation.model.User user);
    User getUser(String name);
    List<User> getAllUsers();
}
