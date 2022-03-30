package dev.upssitech.mcburger.controleur;

import dev.upssitech.mcburger.modele.aliment.*;
import dev.upssitech.mcburger.modele.bd.Menu;
import dev.upssitech.mcburger.modele.profil.ProfilUtilisateur;

public class ControlAjouterAlimentMenu {

    private final ControlVerifierIdentification controlVerifierIdentification;
    private final Menu menu;

    public ControlAjouterAlimentMenu(ControlVerifierIdentification controlVerifierIdentification) {
        this.controlVerifierIdentification = controlVerifierIdentification;
        this.menu = Menu.getInstance();
    }

    // Methods
    public boolean verifierIdentificationProfilUtilisateur(ProfilUtilisateur profilUtilisateur, int numeroProfil) {
        return controlVerifierIdentification.verifierIdentification(profilUtilisateur, numeroProfil);
    }

    public void ajouterAliment(AlimentMenu typeAliment, String nom) {
        Aliment aliment = FabriqueAliment.creerAliment(typeAliment, nom);

        switch(typeAliment) {
            case HAMBURGER -> menu.ajouterAliment((Hamburger) aliment);
            case BOISSON -> menu.ajouterAliment((Boisson) aliment);
            case ACCOMPAGNEMENT -> menu.ajouterAliment((Accompagnement) aliment);
        }
    }

    public String visualiserMenu() {
        return menu.toString();
    }
}
