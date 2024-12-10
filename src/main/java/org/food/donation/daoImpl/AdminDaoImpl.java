package org.food.donation.daoImpl;

import org.food.donation.dao.AdminDao;
import org.food.donation.dao.DonationDao;
import org.food.donation.dao.NGODao;
import org.food.donation.dao.UserDao;
import org.food.donation.model.Donation;
import org.food.donation.model.NGO;
import org.food.donation.model.User;

import javax.swing.*;

public abstract class AdminDaoImpl implements AdminDao {
    private String adminID = "123";

    private UserDao userDAO;
    private NGODao ngoDAO;
    private DonationDao donationDao;

    public AdminDaoImpl(UserDao userDAO, NGODao ngoDAO, DonationDao donationDAO) {
        this.userDAO = userDAO;
        this.ngoDAO = ngoDAO;
        this.donationDao = donationDAO;
    }

    @Override
    public boolean login(String username, String password) {
        String username1 = "admin";
        String password1 = "password";
        return username1.equals(username) && password1.equals(password);
    }

    @Override
    public void manageUsers() {
        System.out.println("Managing Users...");
        for (User user : userDAO.getAllUsers()) {
            System.out.println(user);
        }
    }

    @Override
    public void manageNGOs() {
        System.out.println("Managing NGOs...");
        for (NGO ngo : ngoDAO.getAllNGOs()) {
            System.out.println(ngo);
        }
    }

    @Override
    public void manageDonations() {
        System.out.println("Managing Donations...");
        for (Donation donation : donationDao.getAllDonations()) {
            System.out.println(donation);
        }
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }
}
