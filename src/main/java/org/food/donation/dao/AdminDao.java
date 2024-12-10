package org.food.donation.dao;

import org.food.donation.model.NGO;

public interface AdminDao {
    boolean login(String username, String password);
    void manageUsers();
    void manageNGOs();
    void manageDonations();

    void addAdmin(NGO ngo);
}
