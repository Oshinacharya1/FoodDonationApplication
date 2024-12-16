package org.food.donation.dao;

import org.food.donation.model.Donation;

import java.util.List;
import java.util.Map;

public interface DonationDao {
    void addDonation(Donation donation);
    Map<String, List<Donation>> getAllDonations();
}
