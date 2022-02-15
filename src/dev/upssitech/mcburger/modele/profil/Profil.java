package dev.upssitech.mcburger.modele.profil;

public abstract class Profil {

    protected final String nom, prenom, login, mdp;
    protected boolean connecte;

    public Profil(String nom, String prenom, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;

        this.login = prenom + "." + nom;
        this.connecte = false;
    }

    public boolean verifierCorrespondanceProfil(String login, String mdp) {
        return this.login.equals(login) && this.mdp.equals(mdp);
    }

    public void connexionProfil() {
        connecte = true;
    }

    public boolean isConnecte() {
        return connecte;
    }

}
