package dev.upssitech.mcburger.modele.profil;

public class FabriqueProfil {

    public static Profil creerProfil(ProfilUtilisateur profilUtilisateur, String nom, String prenom, String mdp) {
        Profil profil;

        switch (profilUtilisateur) {
            case GERANT -> {
                profil = new Personnel(nom, prenom, mdp);
                ((Personnel) profil).setGerant();
            }
            case PERSONNEl -> profil = new Personnel(nom, prenom, mdp);
            default -> profil = new Client(nom, prenom, mdp);
        }

        return profil;
    }
}
