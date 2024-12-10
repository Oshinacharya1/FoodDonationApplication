package org.food.donation.daoImpl;
import org.food.donation.dao.DonationDao;
import org.food.donation.model.Donation;

import java.util.ArrayList;
import java.util.List;

public class DonationDaoImpl implements DonationDao {
    private List<org.food.donation.model.Donation> donations = new ArrayList<>();

    @Override
    public void addDonation(org.food.donation.model.Donation donation) {
        donations.add(donation);
    }

    @Override
    public List<org.food.donation.model.Donation> getAllDonations() {
        return donations;
    }
}
