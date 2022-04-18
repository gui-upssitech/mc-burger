package dev.upssitech.mcburger.vue.console;

import dev.upssitech.mcburger.controleur.ControlHistorique;
import dev.upssitech.mcburger.modele.commande.PropertyName;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * class: BoundaryHistorique
 * author: Guillaume Roussin
 * date: 31/03/2022
 */
public class BoundaryHistorique implements PropertyChangeListener {

    // Attributes
    private final ControlHistorique controlHistorique;

    // Constructor
    public BoundaryHistorique(ControlHistorique controlHistorique) {
        this.controlHistorique = controlHistorique;
    }

    // Methods

    public void visualiserHistorique(int numClient) {
        System.out.println("Historique:");
        for( String[] infos : controlHistorique.donnnerHistoriqueClient(numClient))
            System.out.println(infos[0] + " - No " + infos[1] + " " + infos[2] + ", " + infos[3] + ", " + infos[4]);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        PropertyName propertyName = PropertyName.valueOf(evt.getPropertyName());
        if(propertyName == PropertyName.ENREGISTRER_COMMANDE) {
            controlHistorique.ajouterCommande(1, (String[]) evt.getNewValue());
        }
    }
}