package org.food.donation.daoImpl;

import org.food.donation.dao.NGODao;
import org.food.donation.model.NGO;

import java.util.*;

public class NGODaoImpl implements NGODao {
    private Map<String, NGO> ngos = new HashMap<>(Map.of("texasHelp", new NGO(1, "12345", "Texas Help Center", "Texas", "texasHelp", "pass123" )));

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
//        for (NGO ngo : ngos.values()) {
//            if (ngo.getUsername().equals(username) && ngo.getPassword().equals(password)) {
//                return ngo;
//            }
//        }
//        return null;

        for (Map.Entry<String, NGO> ngo : ngos.entrySet()) {
            NGO currentNGO=ngo.getValue();
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