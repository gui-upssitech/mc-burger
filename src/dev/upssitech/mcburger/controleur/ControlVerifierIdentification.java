package dev.upssitech.mcburger.controleur;

import dev.upssitech.mcburger.modele.profil.ProfilUtilisateur;
import dev.upssitech.mcburger.modele.bd.BDClient;
import dev.upssitech.mcburger.modele.bd.BDPersonnel;
import dev.upssitech.mcburger.modele.profil.Client;
import dev.upssitech.mcburger.modele.profil.Personnel;

public class ControlVerifierIdentification {

    private final BDClient bdClient;
    private final BDPersonnel bdPersonnel;

    public ControlVerifierIdentification() {
        bdClient = BDClient.getInstance();
        bdPersonnel = BDPersonnel.getInstance();
    }

    public boolean verifierIdentification(ProfilUtilisateur profilUtilisateur, int numeroProfil) {
        switch (profilUtilisateur) {
            case CLIENT -> {
                Client client = bdClient.trouverClient(numeroProfil);
                return client != null && client.isConnecte();
            }

            case PERSONNEl -> {
                Personnel personnel = bdPersonnel.trouverPersonnel(numeroProfil);
                return personnel != null && personnel.isConnecte();
            }

            default -> {
                Personnel gerant = bdPersonnel.trouverPersonnel(numeroProfil);
                return gerant != null && gerant.isConnecte() && gerant.isGerant();
            }
        }
    }

}
