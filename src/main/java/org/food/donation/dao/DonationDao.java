package org.food.donation.dao;

import org.food.donation.model.Donation;

import java.util.List;
public interface DonationDao {
    void addDonation(Donation donation);
    List<Donation> getAllDonations();
}
