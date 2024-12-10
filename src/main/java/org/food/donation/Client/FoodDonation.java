package org.food.donation.Client;

import org.food.donation.dao.AdminDao;
import org.food.donation.dao.DonationDao;
import org.food.donation.dao.NGODao;
import org.food.donation.dao.UserDao;
import org.food.donation.daoImpl.AdminDaoImpl;
import org.food.donation.daoImpl.DonationDaoImpl;
import org.food.donation.daoImpl.NGODaoImpl;
import org.food.donation.daoImpl.UserDaoImpl;
import org.food.donation.model.Donation;
import org.food.donation.model.NGO;
import org.food.donation.model.User;

import java.util.Scanner;

public class FoodDonation {

    private static Scanner scanner = new Scanner(System.in);
    private static NGODao ngoDAO = new NGODaoImpl();
    private static DonationDao donationDAO = new DonationDaoImpl();

    public static void init() {

        // DAO Initialization
        UserDao userDAO = new UserDaoImpl();

        AdminDao adminDAO = new AdminDaoImpl(userDAO, ngoDAO, donationDAO) {
            @Override
            public void addAdmin(NGO ngo) {
            }
        };
        // Sample Data
        ngoDAO.addNGO(new NGO(1,"THC", "Texas", "14528457", "texasHelp", "pass123"));
        ngoDAO.addNGO(new NGO(2,"WCF", "NewYork", "12345678", "womenCare", "care123"));

//        userDAO.addUser(new User("NewYork" , "James", "12345"));
//        userDAO.addUser(new User("Austin" , "Nancy", "54321"));
        System.out.println("\t\t\tWelcome to the Food Donation System!");
        System.out.println("\t\tPlease select the operation You want to perform!");

        while (true) {
            System.out.println("1. Admin Login\n2. User Registration\n3. User Login\n4. NGO Login\n5. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    handleAdminLogin( adminDAO);
                    break;
                case 2:
                    handleUserRegistration( userDAO);
                    break;
                case 3:
                    handleUserLogin( userDAO, ngoDAO, donationDAO);
                    break;
                case 4:
                    handleNGOLogin(donationDAO);
                    break;
                case 5:
                    System.out.println("Exiting the system. Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void handleAdminLogin(AdminDao adminDAO) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        if (adminDAO.login(username, password)) {
            System.out.println("Admin logged in successfully!");
            System.out.println("1. Manage Users\n2. Manage NGOs\n3. Manage Donations\n4. Logout");
            int adminChoice = scanner.nextInt();
            scanner.nextLine();

            switch (adminChoice) {
                case 1 -> adminDAO.manageUsers();
                case 2 -> adminDAO.manageNGOs();
                case 3 -> adminDAO.manageDonations();
                case 4 -> System.out.println("Admin logged out.");
            }
        } else {
            System.out.println("Invalid credentials!");
        }
    }

    private static void handleUserRegistration(UserDao userDAO) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter contact number: ");
        String contactNumber = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        userDAO.addUser(new User(name, contactNumber, address));
        System.out.println("User registered successfully!");
        System.out.println("Redirected to the main menu!");
    }

    private static void handleUserLogin( UserDao userDao, NGODao ngoDao, DonationDao donationDao) {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your contact no.: ");
        String userName = scanner.nextLine();
        User user = userDao.getUser(userName);
        if (user != null) {
            System.out.println("User logged in successfully!");
            System.out.println("1. Donate Food\n2. View NGOs\n3. Logout");
            int userChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (userChoice) {
                case 1:
                    System.out.println("Available NGOs:");
                    for (NGO ngo : ngoDao.getAllNGOs()) {
                        System.out.println(ngo);
                    }
                    System.out.print("Enter NGO name: ");
                    String ngoName = scanner.nextLine();
                    NGO ngo = ngoDao.getNGO(ngoName);
                    if (ngo != null) {
                        System.out.print("Enter food details: ");
                        String foodDetails = scanner.nextLine();
                        Donation donation = new Donation(user, ngo, foodDetails);
                        donationDao.addDonation(donation);
                        System.out.println("Food donated successfully!");
                    } else {
                        System.out.println("NGO not found!");
                    }
                    break;
                case 2:
                    for (NGO ngoView : ngoDao.getAllNGOs()) {
                        System.out.println(ngoView);
                    }
                    break;
                case 3:
                    System.out.println("User logged out.");
                    break;
            }
        } else {
            System.out.println("User not found! Please register.");
        }
    }

    private static void handleNGOLogin(DonationDao donationDao) {
        scanner.nextLine();
        System.out.print("Enter NGO username: ");
        String username = scanner.nextLine();
        System.out.print("Enter NGO password: ");
        String password = scanner.nextLine();

        NGO ngo = ngoDAO.login(username, password);
        if (ngo != null) {
            System.out.println("Welcome, " + ngo.getName() + "!");
            System.out.println("1. View Donations\n2. Logout");
            int ngoChoice = scanner.nextInt();
            scanner.nextLine();

            switch (ngoChoice) {
                case 1:
                    System.out.println("Donations received by your NGO:");
                    for (Donation donation : donationDao.getAllDonations()) {
                        if (donation.getNgoId()==ngo.getId()) {
                            System.out.println(donation);
                        }
                    }
                    break;
                case 2:
                    System.out.println("NGO logged out.");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } else {
            System.out.println("Invalid NGO credentials!");
        }
    }
}