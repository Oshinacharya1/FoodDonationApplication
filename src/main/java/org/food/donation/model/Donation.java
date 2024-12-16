package org.food.donation.model;

import java.util.Date;

public class Donation {
    private int donationId;
    private int userId;
    private int ngoId;
    private String foodDetails;
    private String donationDate;


    private User user;
    private NGO ngo;

    public Donation(int donationId, int userId, int ngoId, String foodDetails, String donationDate) {
        this.donationId = donationId;
        this.userId = userId;
        this.ngoId = ngoId;
        this.foodDetails = foodDetails;
        this.donationDate = donationDate;
    }

    public Donation(int donationId, int userId, int ngoId, String foodDetails, Date date) {
    }

    public Donation(User user, NGO ngo, String foodDetails) {
        this.user = user;
        this.ngo = ngo;
        this.foodDetails = foodDetails;
    }

    // Getters and Setters
    public int getDonationId() {
        return donationId;
    }

    public void setDonationId(int donationId) {
        this.donationId = donationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getNgoId() {
        return ngoId;
    }

    public void setNgoId(int ngoId) {
        this.ngoId = ngoId;
    }
    public String getFoodDetails() {
        return foodDetails;
    }

    public void setFoodDetails(String foodDetails) {
        this.foodDetails = foodDetails;
    }

    public String getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(String donationDate) {
        this.donationDate = donationDate;
    }
    public NGO getNgo() {
        return ngo;
    }

    public void setNgo(NGO ngo) {
        this.ngo = ngo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Donation{" +
                "donationId=" + donationId +
                ", userId=" + userId +
                ", ngoId=" + ngoId +
                ", foodDetails='" + foodDetails + '\'' +
                ", donationDate=" + donationDate +
                '}';
    }

}
