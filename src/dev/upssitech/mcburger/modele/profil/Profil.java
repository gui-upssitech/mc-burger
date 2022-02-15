package dev.upssitech.mcburger.modele.profil;

public abstract class Profil {

    private final String nom, prenom, login, mdp;

    public Profil(String nom, String prenom, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;

        this.login = prenom + "." + nom;
    }

}
