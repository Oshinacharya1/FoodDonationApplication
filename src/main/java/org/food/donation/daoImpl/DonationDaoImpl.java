package org.food.donation.daoImpl;
import org.food.donation.dao.DonationDao;
import org.food.donation.model.Donation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DonationDaoImpl implements DonationDao {
    private Map<String, List<Donation>> donations = new HashMap<>(
            Map.of(
                   "Oshin", new ArrayList<>(
                           List.of (new Donation(1, 1, 1, "Apple", "2024"),
                                   new Donation(2, 2, 2, "Bananas", "2022"))
                    )
            )
    );

    @Override
    public void addDonation( Donation donation) {
        donations.putIfAbsent("Oshin", new ArrayList<>());
        donations.get("Oshin").add(donation);
        System.out.println("Donation added " + donation);
    }

    @Override
    public Map<String, List<Donation>> getAllDonations() {
        // Return all users as a list
        return donations;
    }
}
