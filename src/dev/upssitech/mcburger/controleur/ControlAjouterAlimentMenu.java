package dev.upssitech.mcburger.controleur;

import dev.upssitech.mcburger.modele.aliment.*;
import dev.upssitech.mcburger.modele.bd.Menu;
import dev.upssitech.mcburger.modele.profil.ProfilUtilisateur;

public class ControlAjouterAlimentMenu {

    // Methods
    public static boolean verifierIdentificationProfilUtilisateur(ProfilUtilisateur profilUtilisateur, int numeroProfil) {
        return ControlVerifierIdentification.verifierIdentification(profilUtilisateur, numeroProfil);
    }

    public static void ajouterAliment(AlimentMenu typeAliment, String nom) {
        Menu menu = Menu.getInstance();
        Aliment aliment = FabriqueAliment.creerAliment(typeAliment, nom);

        switch(typeAliment) {
            case HAMBURGER -> menu.ajouterAliment((Hamburger) aliment);
            case BOISSON -> menu.ajouterAliment((Boisson) aliment);
            case ACCOMPAGNEMENT -> menu.ajouterAliment((Accompagnement) aliment);
        }
    }

    public static String visualiserMenu() {
        return Menu.getInstance().toString();
    }
}
