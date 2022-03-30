package dev.upssitech.mcburger.vue.graphique;

import dev.upssitech.mcburger.controleur.ControlCommander;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * class: PanCommander
 * author: Guillaume Roussin
 * date: 10/03/2022
 */
public class PanCommander extends JPanel {

    // Attributes
    private static final String id = "COMMANDER";
    private int numClient, numeroHamburger, numeroBoisson, numeroAccompagnement;

    private final PanEnregistrerCoordonneesBancaires panEnregistrerCoordonneesBancaires;
    private final ControlCommander controlCommander;

    // Les elements graphiques :
    // Declaration et creation des polices d'ecritures
    private final Font policeTitre = new Font("Calibri", Font.BOLD, 24);
    private final Font policeParagraphe = new Font("Calibri", Font.ITALIC, 16);

    // ComboBox
    JComboBox<String> comboBoxHamburger, comboBoxAccompagnement, comboBoxBoisson;

    // Constructor
    public PanCommander(ControlCommander controlCommander) {
        this.panEnregistrerCoordonneesBancaires = new PanEnregistrerCoordonneesBancaires();
        this.controlCommander = controlCommander;
        initialisation();
    }

    // Methods

    public String getId() {
        return id;
    }

    public void initialisation() {
        this.setBackground(Color.YELLOW);

        // creation des differents elements graphiques (JLabel, Combobox, Button, TextAera ...)
        // Declaration et creation des ComboBox
        comboBoxHamburger = new JComboBox<>();
        comboBoxHamburger.addActionListener(e -> numeroHamburger = comboBoxHamburger.getSelectedIndex());

        //comboBoxAccompagnement = new JComboBox<>();
        //comboBoxAccompagnement.addActionListener(e -> nu);

        // Declaration et creation des Button
        // Declaration et creation des TextArea
        // Declaration et creation des Labels
        JLabel texteCommander = new JLabel("Votre menu");
        texteCommander.setFont(policeTitre);

        JLabel texteHamburger = new JLabel("Choisissez votre Hamburger");
        texteHamburger.setFont(policeParagraphe);

        // mise en page : placements des differents elements graphiques dans des Box
        Box boxPrincipale = Box.createVerticalBox();
        Box boxChoixHamburger = Box.createHorizontalBox();

        boxChoixHamburger.add(texteHamburger);
        boxChoixHamburger.add(Box.createRigidArea(new Dimension(10, 0)));
        boxChoixHamburger.add(comboBoxHamburger);

        // mise en page : placements des differentes box dans une box principale
        boxPrincipale.add(texteCommander);
        boxPrincipale.add(Box.createRigidArea(new Dimension(0, 30)));
        boxPrincipale.add(boxChoixHamburger);

        // mise en page : ajout de la box principale dans le panel
        this.add(boxPrincipale);
    }

    public void commander( int numClient ) {
        this.numClient = numClient;

        if(controlCommander.verifierIdentification(numClient)) {
            affichageMenu();
        }

    }

    private void affichageMenu() {
        setComboBoxContent(comboBoxHamburger, controlCommander.donnerListeHamburger());
        //setComboBoxContent(comboBoxAccompagnement, ControlCommander.donnerListeAccompagnement());
        //setComboBoxContent(comboBoxBoisson, ControlCommander.donnerListeBoisson());
    }

    private void setComboBoxContent(JComboBox<String> comboBox, List<String> list) {
        comboBox.removeAllItems();
        comboBox.addItem("");
        for(String s : list) comboBox.addItem(s);
    }
}