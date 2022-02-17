package dev.upssitech.mcburger.controleur;

import dev.upssitech.mcburger.modele.bd.BDClient;
import dev.upssitech.mcburger.modele.bd.BDPersonnel;
import dev.upssitech.mcburger.modele.profil.Client;
import dev.upssitech.mcburger.modele.profil.FabriqueProfil;
import dev.upssitech.mcburger.modele.profil.Personnel;
import dev.upssitech.mcburger.modele.profil.Profil;
import dev.upssitech.mcburger.modele.profil.ProfilUtilisateur;

public class ControlCreerProfil {

    public void creerProfil(ProfilUtilisateur profilUtilisateur, String nom, String prenom, String mdp) {

        // Etape 1 - Création du profil
        Profil profil = FabriqueProfil.creerProfil(profilUtilisateur, nom, prenom, mdp);

        // Etape 2 - Ajout à la base de données
        switch (profilUtilisateur) {
            case CLIENT -> BDClient.getInstance().addClient((Client) profil);
            default -> BDPersonnel.getInstance().addPersonnel((Personnel) profil);
        }

    }

    public String visualiserBDUtilisateur() {
        return BDPersonnel.getInstance() + "\n" + BDClient.getInstance() + "\n";
    }
}
