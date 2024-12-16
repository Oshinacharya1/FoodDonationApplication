package org.food.donation.daoImpl;

import org.food.donation.dao.AdminDao;
import org.food.donation.dao.DonationDao;
import org.food.donation.dao.NGODao;
import org.food.donation.dao.UserDao;
import org.food.donation.model.Admin;
import org.food.donation.model.Donation;
import org.food.donation.model.NGO;
import org.food.donation.model.User;

import java.util.List;
import java.util.Map;


public abstract class AdminDaoImpl implements AdminDao {
    private int adminID = 123;

    private UserDao userDAO;
    private NGODao ngoDAO;
    private DonationDao donationDao;
    private Admin admin = new Admin(adminID, "admin", "password");

    public AdminDaoImpl(UserDao userDAO, NGODao ngoDAO, DonationDao donationDAO) {
        this.userDAO = userDAO;
        this.ngoDAO = ngoDAO;
        this.donationDao = donationDAO;
    }

    @Override
    public boolean login(String username, String password) {
        return admin.getUsername().equals(username) && admin.getPassword().equals(password);
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
        Map<String, List<Donation>> donationList = donationDao.getAllDonations();
        for (Map.Entry<String, List<Donation>> indivisual : donationList.entrySet()){
            System.out.println("Key " + indivisual.getKey()+ "Values" + indivisual.getValue());
        }
    }
}
