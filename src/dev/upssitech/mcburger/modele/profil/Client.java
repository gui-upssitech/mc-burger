package dev.upssitech.mcburger.modele.profil;

public class Client extends Profil {

    public Client(String nom, String prenom, String mdp) {
        super(nom, prenom, mdp);
    }

    @Override
    public String toString() {
        return "Client [" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", login='" + login + '\'' +
                ", mdp='" + mdp + '\'' +
                ']';
    }
}
