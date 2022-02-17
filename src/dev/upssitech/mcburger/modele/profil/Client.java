package dev.upssitech.mcburger.modele.profil;

public class Client extends Profil {

    private CarteBancaire carteBancaire;

    public Client(String nom, String prenom, String mdp) {
        super(nom, prenom, mdp);
    }

    public void enregistrerCoordonneesBancaires(int numeroCarte, int dateCarte) {
        this.carteBancaire = new CarteBancaire(numeroCarte, dateCarte);
    }

    @Override
    public String toString() {
        return "Client [" +
                "carteBancaire=" + carteBancaire +
                ", " + toStringArgs() +
                ']';
    }
}
