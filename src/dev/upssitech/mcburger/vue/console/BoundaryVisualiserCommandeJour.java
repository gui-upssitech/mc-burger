package dev.upssitech.mcburger.vue.console;

import dev.upssitech.mcburger.controleur.ControlVisualiserCommandeJour;
import dev.upssitech.mcburger.modele.commande.PropertyName;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * class: BoundaryVisualiserCommandeJour
 * author: Guillaume Roussin
 * date: 24/03/2022
 */
public class BoundaryVisualiserCommandeJour implements PropertyChangeListener {

    // Attributes
    private final ControlVisualiserCommandeJour controlVisualiserCommandeJour;

    // Constructor
    public BoundaryVisualiserCommandeJour(ControlVisualiserCommandeJour controlVisualiserCommandeJour) {
        this.controlVisualiserCommandeJour = controlVisualiserCommandeJour;
    }

    // Methods

    public void visualiserCommandeJour(int numCuisinier) {
        boolean cuisinierIdentifie = controlVisualiserCommandeJour.verifierIdentificationCuisinier(numCuisinier);
        if(cuisinierIdentifie) {
            controlVisualiserCommandeJour.setListener(PropertyName.ENREGISTRER_COMMANDE.toString(), this);
            controlVisualiserCommandeJour.setListener(PropertyName.VIDER_COMMANDE_JOUR.toString(), this);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        PropertyName propertyName = PropertyName.valueOf(evt.getPropertyName());

        if(propertyName == PropertyName.ENREGISTRER_COMMANDE) {
            String[] commandeDesc = (String[]) evt.getNewValue();
            String numeroCommande = commandeDesc[0],
                    nomHamburger = commandeDesc[1],
                    nomAccompagnement = commandeDesc[2],
                    nomBoisson = commandeDesc[3];

            String desc = "Commande no "+ numeroCommande + " : " + nomHamburger + ", " + nomAccompagnement + ", " + nomBoisson;
            Fichier.ecrire(desc);
        }
        else if(propertyName == PropertyName.VIDER_COMMANDE_JOUR) {
            Fichier.effacer();
        }
    }
}