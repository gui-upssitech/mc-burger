package dev.upssitech.mcburger.vueconsole;

import dev.upssitech.mcburger.Clavier;
import dev.upssitech.mcburger.controleur.ControlCreerProfil;
import dev.upssitech.mcburger.modele.ProfilUtilisateur;

public class BoundaryCreerProfilGerant {

    private final ControlCreerProfil controlCreerProfil;

    public BoundaryCreerProfilGerant(ControlCreerProfil controlCreerProfil) {
        this.controlCreerProfil = controlCreerProfil;
    }

    public void creerProfilGerant() {
        String nom, prenom, mdp;

        // Etape 1 - Saisie des données

        System.out.print("Veuillez entrer votre nom: ");
        nom = Clavier.entrerClavierString();

        System.out.print("Veuillez entrer votre prénom: ");
        prenom = Clavier.entrerClavierString();

        System.out.print("Veuillez entrer votre mot de passe: ");
        mdp = Clavier.entrerClavierString();

        // Etape 2 - Création du profil

        controlCreerProfil.creerProfil(ProfilUtilisateur.GERANT, nom, prenom, mdp);
    }
}
