package dev.upssitech.mcburger.modele.profil;

public class Personnel extends Profil {

    private boolean gerant;

    public Personnel(String nom, String prenom, String mdp) {
        super(nom, prenom, mdp);
        gerant = false;
    }

    public void setGerant() {
        this.gerant = true;
    }

    public boolean isGerant() {
        return gerant;
    }

    @Override
    public String toString() {
        return "Personnel [" +
                "gerant=" + gerant +
                ", " + toStringArgs() +
                ']';
    }
}
