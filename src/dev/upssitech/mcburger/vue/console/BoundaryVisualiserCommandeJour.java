package dev.upssitech.mcburger.vue.console;

import dev.upssitech.mcburger.modele.bd.BDCommande;
import dev.upssitech.mcburger.modele.commande.Commande;
import dev.upssitech.mcburger.modele.commande.PropertyName;

/**
 * class: BoundaryVisualiserCommandeJour
 * author: Guillaume Roussin
 * date: 24/03/2022
 */
public class BoundaryVisualiserCommandeJour {

    // Attributes

    // Constructor
    public BoundaryVisualiserCommandeJour() {
        BDCommande.getInstance().addListener(evt -> {
            PropertyName propertyName = PropertyName.valueOf(evt.getPropertyName());
            switch(propertyName) {
                case ENREGISTRER_COMMANDE -> System.out.println("Nouvelle commande: " + evt.getNewValue());
                default -> System.out.println("blah");
            }
        });
    }

    // Methods
}