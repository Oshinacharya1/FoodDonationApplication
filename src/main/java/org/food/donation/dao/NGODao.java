package org.food.donation.dao;
import org.food.donation.model.NGO;

import java.util.List;
public interface NGODao {
    void addNGO(NGO ngo);
    NGO getNGO(String name);
    NGO login(String username, String password); // New method
    List<NGO> getAllNGOs();
}
