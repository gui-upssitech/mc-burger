package dev.upssitech.mcburger.controleur;

import dev.upssitech.mcburger.modele.bd.BDHistorique;
import dev.upssitech.mcburger.modele.commande.Commande;
import dev.upssitech.mcburger.modele.commande.ItemHistorique;

import java.util.ArrayList;
import java.util.List;

/**
 * class: ControlHistorique
 * author: Guillaume Roussin
 * date: 31/03/2022
 */
public class ControlHistorique {

    // Attributes
    private final BDHistorique bdHistorique;

    // Constructor
    public ControlHistorique() {
        bdHistorique = BDHistorique.getInstance();
    }

    // Methods
    public void ajouterCommande(int numClient, String[] commandeInfos) {
        bdHistorique.ajouterCommandeClient(numClient, commandeInfos);
    }

    public List<String[]> donnnerHistoriqueClient(int numClient) {
        List<String[]> infosHistorique = new ArrayList<>();

        for(ItemHistorique item : bdHistorique.donnerHistoriqueClient(numClient)) {
            List<String> infos = new ArrayList<>();
            infos.add(item.date().toString());
            infos.addAll(List.of(item.commandeInfos()));

            infosHistorique.add((String[]) infos.toArray());
        }

        return infosHistorique;
    }

}