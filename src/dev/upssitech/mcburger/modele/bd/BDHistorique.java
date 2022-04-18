package dev.upssitech.mcburger.modele.bd;

import dev.upssitech.mcburger.modele.commande.Commande;
import dev.upssitech.mcburger.modele.commande.ItemHistorique;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 * class: BDHistorique
 * author: Guillaume Roussin
 * date: 31/03/2022
 */
public class BDHistorique {

    // Singleton
    private static class BDHistoriqueHolder {
        public static final BDHistorique instance = new BDHistorique();
    }

    public static BDHistorique getInstance() {
        return BDHistoriqueHolder.instance;
    }

    // Attributes
    private final HashMap<Integer, List<ItemHistorique>> mapHistorique;

    // Constructor
    private BDHistorique() {
        mapHistorique = new HashMap<>();
    }

    // Methods
    public void ajouterCommandeClient(int numClient, String[] commandeInfos) {
        if(!mapHistorique.containsKey(numClient))
            mapHistorique.put(numClient, new ArrayList<>());

        ItemHistorique item = new ItemHistorique(Calendar.getInstance().getTime(), commandeInfos);
        mapHistorique.get(numClient).add(item);
    }

    public List<ItemHistorique> donnerHistoriqueClient(int numClient) {
        return mapHistorique.get(numClient);
    }
}