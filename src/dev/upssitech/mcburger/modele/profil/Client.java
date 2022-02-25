package dev.upssitech.mcburger.modele.profil;

import java.util.Objects;

public class Client extends Profil {

    private CarteBancaire carteBancaire;

    public Client(String nom, String prenom, String mdp) {
        super(nom, prenom, mdp);
    }

    public void enregistrerCoordonneesBancaires(int numeroCarte, int dateCarte) {
        this.carteBancaire = new CarteBancaire(numeroCarte, dateCarte);
    }

    public boolean verifierExistanceCarteBancaire() {
        return carteBancaire != null;
    }

    @Override
    public String toString() {
        return "Client [" +
                "carteBancaire=" + carteBancaire +
                ", " + toStringArgs() +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        boolean eq = super.equals(o);

        if(eq) {
            Client c = (Client) o;
            eq = Objects.equals(carteBancaire, c.carteBancaire);
        }

        return eq;
    }
}
