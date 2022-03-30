package modele;

import java.util.HashMap;
import java.util.Map;


public class BDCommande {
    private Map<Integer, Commande> mapCommandes = new HashMap<>();


    //SINGLETON
    private BDCommande(){
    }

    public static BDCommande getInstance() {
        return BDCommandeHolder.instance;
    }

    private static class BDCommandeHolder {
        private static final BDCommande instance = new BDCommande();

    }

	//METHODES
    public int enregistrerCommande(int numClient, Hamburger hamburger, Accompagnement accompagnement, Boisson boisson) {
        Commande commande = new Commande(numClient, hamburger, accompagnement, boisson);
        int numCommande = commande.getNumeroCommandeAttribuee();
        this.mapCommandes.put(numCommande, commande);
        return numCommande;
    }
}
