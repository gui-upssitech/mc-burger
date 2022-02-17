package dev.upssitech.mcburger.modele.bd;

import dev.upssitech.mcburger.modele.aliment.Accompagnement;
import dev.upssitech.mcburger.modele.aliment.Boisson;
import dev.upssitech.mcburger.modele.aliment.Hamburger;
import dev.upssitech.mcburger.modele.commande.Commande;

import java.util.HashMap;

public class BDCommande {

    // Singleton
    private static class BDHolder {
        public static final BDCommande instance = new BDCommande();
    }

    public static BDCommande getInstance() {
        return BDHolder.instance;
    }

    // Attributes
    private final HashMap<Integer, Commande> mapCommandes;

    // Constructor
    private BDCommande() {
        mapCommandes = new HashMap<>();
    }

    // Methods
    public int enregistrerCommande(int numClient, Hamburger hamburger, Accompagnement accompagnement, Boisson boisson) {
        Commande commande = new Commande(numClient, hamburger, accompagnement, boisson);
        int commandeId = commande.getNumeroCommandeAttribuee();
        mapCommandes.put(commandeId, commande);

        return commandeId;
    }

    @Override
    public String toString() {
        return "BDCommande [" +
                "mapCommandes=" + mapCommandes +
                ']';
    }
}
