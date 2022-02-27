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
    private int numPersonnels;

    private BDPersonnel() {
        listePersonnel = new HashMap<>();
        numPersonnels = 0;
    }

    public void addPersonnel(Personnel personnel) {
        listePersonnel.put(numPersonnels, personnel);
        numPersonnels++;
    }

    public int connexionPersonnel(String login, String mdp) {
        for(int numPersonnel : listePersonnel.keySet()) {
            Personnel personnel = listePersonnel.get(numPersonnel);
            if(personnel.verifierCorrespondanceProfil(login, mdp)) {
                personnel.connexionProfil();
                return numPersonnel;
            }
        }
        return -1; // Retourn -1 si aucun compte correspondant n'est trouvé
    }

    public Personnel trouverPersonnel(int numPersonnel) {
        return listePersonnel.getOrDefault(numPersonnel, null);
    }

    @Override
    public String toString() {
        return "BDPersonnel [" +
                "listePersonnel=" + listePersonnel +
                ']';
    }
}
