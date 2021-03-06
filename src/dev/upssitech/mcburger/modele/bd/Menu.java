package dev.upssitech.mcburger.modele.bd;

import dev.upssitech.mcburger.modele.aliment.Accompagnement;
import dev.upssitech.mcburger.modele.aliment.Boisson;
import dev.upssitech.mcburger.modele.aliment.Hamburger;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    // Singleton

    private static class MenuHolder {
        public static final Menu instance = new Menu();
    }

    public static Menu getInstance() {
        return MenuHolder.instance;
    }

    // Attributes
    private final List<Hamburger> listeHamburger;
    private final List<Accompagnement> listeAccompagnement;
    private final List<Boisson> listeBoisson;

    // Constructor
    private Menu() {
        listeHamburger = new ArrayList<>();
        listeAccompagnement = new ArrayList<>();
        listeBoisson = new ArrayList<>();
    }


    // Methods
    public void ajouterAliment(Hamburger hamburger) {
        listeHamburger.add(hamburger);
    }

    public void ajouterAliment(Accompagnement accompagnement) {
        listeAccompagnement.add(accompagnement);
    }

    public void ajouterAliment(Boisson boisson) {
        listeBoisson.add(boisson);
    }

    public List<Hamburger> getListeHamburger() {
        return listeHamburger;
    }

    public List<Accompagnement> getListeAccompagnement() {
        return listeAccompagnement;
    }

    public List<Boisson> getListeBoisson() {
        return listeBoisson;
    }

    public Hamburger choixHamburger(int numHamburger) {
        return listeHamburger.get(numHamburger);
    }

    public Accompagnement choixAccompagnement(int numAccompagnement) {
        return listeAccompagnement.get(numAccompagnement);
    }

    public Boisson choixBoisson(int numBoisson) {
        return listeBoisson.get(numBoisson);
    }

    @Override
    public String toString() {
        return "Menu [" +
                "listeHamburger=" + listeHamburger +
                ", listeBoisson=" + listeBoisson +
                ", listeAccompagnement=" + listeAccompagnement +
                ']';
    }
}
