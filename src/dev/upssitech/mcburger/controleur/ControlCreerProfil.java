package dev.upssitech.mcburger.controleur;

import dev.upssitech.mcburger.modele.bd.BDClient;
import dev.upssitech.mcburger.modele.bd.BDPersonnel;
import dev.upssitech.mcburger.modele.profil.Client;
import dev.upssitech.mcburger.modele.profil.FabriqueProfil;
import dev.upssitech.mcburger.modele.profil.Personnel;
import dev.upssitech.mcburger.modele.profil.Profil;
import dev.upssitech.mcburger.modele.profil.ProfilUtilisateur;

public class ControlCreerProfil {

    private final BDPersonnel bdPersonnel;
    private final BDClient bdClient;

    public ControlCreerProfil() {
        bdPersonnel = BDPersonnel.getInstance();
        bdClient = BDClient.getInstance();
    }

    public void creerProfil(ProfilUtilisateur profilUtilisateur, String nom, String prenom, String mdp) {

        // Etape 1 - Création du profil
        Profil profil = FabriqueProfil.creerProfil(profilUtilisateur, nom, prenom, mdp);

        // Etape 2 - Ajout à la base de données
        if (profilUtilisateur == ProfilUtilisateur.CLIENT) {
            bdClient.addClient((Client) profil);
        } else {
            bdPersonnel.addPersonnel((Personnel) profil);
        }

    }

    public String visualiserBDUtilisateur() {
        return bdPersonnel + "\n" + bdClient + "\n";
    }
}
