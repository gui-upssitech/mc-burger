package dev.upssitech.mcburger.vue.graphique;

import dev.upssitech.mcburger.controleur.ControlCommander;
import dev.upssitech.mcburger.controleur.ControlEnregistrerCoordonneesBancaires;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * class: PanCommander
 * author: Guillaume Roussin
 * date: 10/03/2022
 */
public class PanCommander extends JPanel implements PanEnregistrerCoordonneesBancaires.IUseEnregistrerCoordonneesBancaires {

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
    private Box boxPrincipale;
    private final Box boxMiseEnPageNumeroCommande = Box.createVerticalBox();
    private final JLabel numeroCommande = new JLabel();
    private JComboBox<String> comboBoxHamburger, comboBoxAccompagnement, comboBoxBoisson;

    // Constructor
    public PanCommander(ControlCommander controlCommander, PanEnregistrerCoordonneesBancaires panEnregistrerCoordonneesBancaires) {
        this.panEnregistrerCoordonneesBancaires = panEnregistrerCoordonneesBancaires;
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

        comboBoxAccompagnement = new JComboBox<>();
        comboBoxAccompagnement.addActionListener(e -> numeroAccompagnement = comboBoxAccompagnement.getSelectedIndex());

        comboBoxBoisson = new JComboBox<>();
        comboBoxBoisson.addActionListener(e -> numeroBoisson = comboBoxBoisson.getSelectedIndex());

        // Declaration et creation des Button
        JButton validerCommande = new JButton();

        validerCommande.setText("Valider");
        validerCommande.addActionListener(e -> {
            if(numeroHamburger != 0 && numeroAccompagnement != 0 && numeroBoisson != 0) {
                validationCartePayement();
            }
        });
        // Declaration et creation des TextArea
        // Declaration et creation des Labels
        JLabel texteCommander = new JLabel("Votre menu");
        texteCommander.setFont(policeTitre);

        // mise en page : placements des differents elements graphiques dans des Box
        boxPrincipale = Box.createVerticalBox();
        Box boxValiderChoix = Box.createVerticalBox();

        JLabel texteNumeroCommandeTitre = new JLabel("Votre commande");
        texteNumeroCommandeTitre.setFont(policeTitre);

        boxMiseEnPageNumeroCommande.add(texteNumeroCommandeTitre);
        boxMiseEnPageNumeroCommande.add(Box.createRigidArea(new Dimension(0, 30)));

        numeroCommande.setFont(policeParagraphe);
        boxMiseEnPageNumeroCommande.add(numeroCommande);

        this.add(boxMiseEnPageNumeroCommande);

        // mise en page : placements des differentes box dans une box principale
        boxPrincipale.add(texteCommander);
        boxPrincipale.add(Box.createRigidArea(new Dimension(0, 30)));

        boxPrincipale.add(createChoiceBox("Choisissez votre Hamburger", comboBoxHamburger));
        boxPrincipale.add(Box.createRigidArea(new Dimension(0, 10)));
        boxPrincipale.add(createChoiceBox("Choisissez votre Accompagnement", comboBoxAccompagnement));
        boxPrincipale.add(Box.createRigidArea(new Dimension(0, 10)));
        boxPrincipale.add(createChoiceBox("Choisissez votre Boisson", comboBoxBoisson));

        boxValiderChoix.add(validerCommande);
        boxPrincipale.add(Box.createRigidArea(new Dimension(0, 10)));
        boxPrincipale.add(boxValiderChoix);

        // mise en page : ajout de la box principale dans le panel
        this.add(boxPrincipale);
    }

    public void commander( int numClient ) {
        this.numClient = numClient;

        boxPrincipale.setVisible(true);
        boxMiseEnPageNumeroCommande.setVisible(false);

        if(controlCommander.verifierIdentification(numClient)) {
            affichageMenu();
        }

    }

    @Override
    public void retourEnregistrerCoordonneesBancaire(boolean carteValide) {
        this.panEnregistrerCoordonneesBancaires.setVisible(false);
        if(carteValide) this.enregistrerCommande(carteValide);
    }

    // Private methods

    private void validationCartePayement() {
        boolean carteRenseignee = controlCommander.verifierExistanceCarteBancaire(numClient);
        if (!carteRenseignee) {
            this.setVisible(false);
            this.repaint();
            panEnregistrerCoordonneesBancaires.enregistrerCoordonneesBancaires(numClient, this);
        } else
            this.enregistrerCommande(carteRenseignee);
    }

    private void enregistrerCommande(boolean carteRenseignee) {
        if (carteRenseignee) {
            int numCommande = controlCommander.enregistrerCommande(numClient, numeroHamburger-1,
                    numeroAccompagnement-1, numeroBoisson-1);
            numeroCommande.setText("Votre numero est : " + numCommande);
        }
        this.setVisible(true);

        boxPrincipale.setVisible(false);
        boxMiseEnPageNumeroCommande.setVisible(true);

        this.repaint();
    }

    private void affichageMenu() {
        setComboBoxContent(comboBoxHamburger, controlCommander.donnerListeHamburger());
        setComboBoxContent(comboBoxAccompagnement, controlCommander.donnerListeAccompagnement());
        setComboBoxContent(comboBoxBoisson, controlCommander.donnerListeBoisson());
    }

    private void setComboBoxContent(JComboBox<String> comboBox, List<String> list) {
        comboBox.removeAllItems();
        comboBox.addItem("");
        for(String s : list) comboBox.addItem(s);
    }

    private Box createChoiceBox(String titre, JComboBox<String> comboBox) {
        Box boxChoix = Box.createHorizontalBox();
        JLabel texte = new JLabel(titre);

        texte.setFont(policeParagraphe);

        boxChoix.add(texte);
        boxChoix.add(Box.createRigidArea(new Dimension(10, 0)));
        boxChoix.add(comboBox);

        return boxChoix;
    }
}