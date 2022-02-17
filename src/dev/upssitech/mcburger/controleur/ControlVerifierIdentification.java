package dev.upssitech.mcburger.controleur;

import dev.upssitech.mcburger.modele.profil.ProfilUtilisateur;
import dev.upssitech.mcburger.modele.bd.BDClient;
import dev.upssitech.mcburger.modele.bd.BDPersonnel;
import dev.upssitech.mcburger.modele.profil.Client;
import dev.upssitech.mcburger.modele.profil.Personnel;

public class ControlVerifierIdentification {

    public boolean verifierIdentification(ProfilUtilisateur profilUtilisateur, int numeroProfil) {
        switch (profilUtilisateur) {
            case CLIENT -> {
                Client client = BDClient.getInstance().trouverClient(numeroProfil);
                return client != null && client.isConnecte();
            }

            case PERSONNEl -> {
                Personnel personnel = BDPersonnel.getInstance().trouverPersonnel(numeroProfil);
                return personnel != null && personnel.isConnecte();
            }

            default -> {
                Personnel gerant = BDPersonnel.getInstance().trouverPersonnel(numeroProfil);
                return gerant != null && gerant.isConnecte() && gerant.isGerant();
            }
        }
    }

}
