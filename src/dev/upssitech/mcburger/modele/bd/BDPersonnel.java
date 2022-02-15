package dev.upssitech.mcburger.modele.bd;

import dev.upssitech.mcburger.modele.profil.Personnel;

import java.util.HashMap;

public class BDPersonnel {

    private static class InstanceHolder {
        public static final BDPersonnel instance = new BDPersonnel();
    }

    public static BDPersonnel getInstance() {
        return InstanceHolder.instance;
    }

    private final HashMap<Integer, Personnel> listePersonnel;
    private int numClients;

    private BDPersonnel() {
        listePersonnel = new HashMap<>();
        numClients = 0;
    }

    public void addPersonnel(Personnel personnel) {
        listePersonnel.put(numClients, personnel);
        numClients++;
    }

    @Override
    public String toString() {
        return "BDPersonnel [" +
                "listePersonnel=" + listePersonnel +
                ']';
    }
}
