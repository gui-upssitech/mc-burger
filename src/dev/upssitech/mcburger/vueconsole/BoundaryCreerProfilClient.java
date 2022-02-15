package dev.upssitech.mcburger.vueconsole;

import dev.upssitech.mcburger.Clavier;
import dev.upssitech.mcburger.controleur.ControlCreerProfil;
import dev.upssitech.mcburger.modele.ProfilUtilisateur;

public class BoundaryCreerProfilClient {

    private final ControlCreerProfil controlCreerProfil;

    public BoundaryCreerProfilClient(ControlCreerProfil controlCreerProfil) {
        this.controlCreerProfil = controlCreerProfil;
    }

    public void creerProfilClient() {
        String nom, prenom, mdp;

        // Etape 1 - Saisie des données

        System.out.println("Création de compte client\n===\n");
        System.out.print("Nom: ");
        nom = Clavier.entrerClavierString();

        System.out.print("Prénom: ");
        prenom = Clavier.entrerClavierString();

        System.out.print("Mot de passe: ");
        mdp = Clavier.entrerClavierString();

        // Etape 2 - Création du profil

        controlCreerProfil.creerProfil(ProfilUtilisateur.CLIENT, nom, prenom, mdp);
    }
}
