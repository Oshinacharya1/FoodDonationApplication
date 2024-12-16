package org.food.donation.daoImpl;

import org.food.donation.dao.NGODao;
import org.food.donation.model.NGO;


import java.util.*;

public class NGODaoImpl implements NGODao {
    private Map<String, NGO> ngos = new HashMap<>(
    Map.of(
            "NGO1", new NGO(1, "Helping Hand", "Texas", "12345", "username", "password" )
    )
    );

    @Override
    public void addNGO(NGO ngo) {
        ngos.put(ngo.getName(), ngo);
    }

    @Override
    public NGO getNGO(String name) {
        return ngos.get(name);
    }
    @Override
    public NGO login(String username, String password) {
        /*
         * ngos = {
         * "THC" : {id=1, name='THC', address='Texas', contact='14528457', username='texasHelp', password='pass123'},
         * "WCF" : {id=2, name='WCF', address='NewYork', contact='12345678', username='womenCare', password='care123'},
         * }
         * */

        for (Map.Entry<String, NGO> ngo : ngos.entrySet()) {
            NGO currentNGO = ngo.getValue();
            if (currentNGO.getUsername().equals(username) && currentNGO.getPassword().equals(password)) {
                return currentNGO;
            }
        }
        return null;
    }


    @Override
    public List<NGO> getAllNGOs() {
        return new ArrayList<>(ngos.values());
    }
}