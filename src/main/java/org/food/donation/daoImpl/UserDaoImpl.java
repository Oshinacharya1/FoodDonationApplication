package org.food.donation.daoImpl;

import org.food.donation.dao.UserDao;
import org.food.donation.model.User;

import java.util.*;

public class UserDaoImpl implements UserDao {
    // Map to store users with their name as the key
    private Map<String, User> users = new HashMap<>(
            Map.of(
                    "testuser1", new User("NewYork", "test", "12345", "password"),
                    "testuser2", new User("Texas", "test2", "123456", "password2")

            )
    );

    @Override
    public void addUser(User user) {
        // Add user to the map
        users.put(user.getName(), user);
    }

    @Override
    public User getUser(String name) {
        // Retrieve user by name
        return users.get(name);
    }

    @Override
    public List<User> getAllUsers() {
        // Return all users as a list
        return new ArrayList<>(users.values());
    }
}