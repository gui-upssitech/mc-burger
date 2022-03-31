package dev.upssitech.mcburger.controleur;

import dev.upssitech.mcburger.modele.bd.BDCommande;
import dev.upssitech.mcburger.modele.profil.ProfilUtilisateur;

import java.beans.PropertyChangeListener;

/**
 * class: ControlVisualiserCommandeJour
 * author: Guillaume Roussin
 * date: 24/03/2022
 */
public class ControlVisualiserCommandeJour {

    private final ControlVerifierIdentification verifierIdentification;
    private final BDCommande bdCommande;

    public ControlVisualiserCommandeJour(ControlVerifierIdentification controlVerifierIdentification) {
        this.verifierIdentification = controlVerifierIdentification;
        bdCommande = BDCommande.getInstance();
    }

    public void setListener(String propertyName, PropertyChangeListener listener) {
        bdCommande.addPropertyChangeListener(propertyName, listener);
    }

    public boolean verifierIdentificationCuisinier(int numCuisinier) {
        return verifierIdentification.verifierIdentification(ProfilUtilisateur.PERSONNEl, numCuisinier);
    }

}