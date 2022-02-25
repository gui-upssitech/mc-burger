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

    protected String toStringArgs() {
        return
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", login='" + login + '\'' +
                ", mdp='" + mdp + '\'' +
                ", connecte=" + connecte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profil profil = (Profil) o;
        return
                connecte == profil.connecte &&
                nom.equals(profil.nom) &&
                prenom.equals(profil.prenom) &&
                login.equals(profil.login) &&
                mdp.equals(profil.mdp);
    }
}
