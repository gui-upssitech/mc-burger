package dev.upssitech.mcburger.vue.graphique;

import dev.upssitech.mcburger.controleur.ControlEnregistrerCoordonneesBancaires;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * class: PanEnregistrerCoordonneesBancaires
 * author: Guillaume Roussin
 * date: 10/03/2022
 */
public class PanEnregistrerCoordonneesBancaires extends JPanel {

    // Interfaces
    public interface IUseEnregistrerCoordonneesBancaires {
        void retourEnregistrerCoordonneesBancaire(boolean carteValide);
    }

    // Attributes
    private final String id = "ENREGISTRER_COORDS_BANCAIRES";

    // controleurs du cas + panel des cas inclus ou etendus en lien avec un acteur
    // les attributs metiers (ex : numClient)
    private int numClient;
    private IUseEnregistrerCoordonneesBancaires panAppelant;
    private final ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires;

    // Mise en page : les Box
    private final Box boxMiseEnPageCoordonneesBancaires = Box.createVerticalBox();
    private final Box boxNumeroCarte = Box.createHorizontalBox();
    private final Box boxValiditeCarte = Box.createHorizontalBox();
    private final Box boxValiderCarte = Box.createHorizontalBox();

    // Les elements graphiques :
    // Declaration et creation des polices d'ecritures
    private final Font policeTitre = new Font("Calibri", Font.BOLD, 24);
    private final Font policeParagraphe = new Font("Calibri", Font.ITALIC, 16);
    private final Font policeARemplacer = new Font("Arial", Font.ITALIC, 12);
    private final Font policeChoixUtilisateur = new Font("Arial", Font.PLAIN, 12);

    // Declaration et creation des ComboBox
    // Declaration et creation des Button
    // Declaration et creation des TextArea
    private final JTextArea textAeraNumeroCarte = new JTextArea();
    private final JTextArea textAreaDateExpiration = new JTextArea();
    // Declaration et creation des Labels

    // Constructor
    public PanEnregistrerCoordonneesBancaires(ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires) {
        // initialisation des attributs metiers
        this.controlEnregistrerCoordonneesBancaires = controlEnregistrerCoordonneesBancaires;
        // initilaisation du controleur du cas + panels
        // des cas inclus ou etendus en lien avec un acteur
        initialisation();
    }

    // Methods

    public String getId() {
        return this.id;
    }

    public void initialisation() {
        this.setBackground(Color.YELLOW);

        // creation des differents elements graphiques (JLabel, Combobox, Button, TextAera ...)
        JLabel texteCoordsBancaires = new JLabel("Entrer vos coordonnées bancaires");
        texteCoordsBancaires.setFont(policeTitre);

        JLabel texteNumCarteBancaire = new JLabel("Entrer le numero de votre carte bancaire");
        texteNumCarteBancaire.setFont(policeParagraphe);

        JLabel texteValiditeCarte = new JLabel("Entrer la date d'expiration de votre carte");
        texteValiditeCarte.setFont(policeParagraphe);

        JButton validationCoordonneeBancaire = new JButton();
        validationCoordonneeBancaire.setText("Valider");
        validationCoordonneeBancaire.addActionListener(e -> {
            int numeroCarte = Integer.parseInt(textAeraNumeroCarte.getText());
            int dateCarte = Integer.parseInt(textAreaDateExpiration.getText());
            traitementCoordonneesBancaires(numeroCarte, dateCarte);
        });

        textAeraNumeroCarte.setMaximumSize(new Dimension(120,20));
        textAeraNumeroCarte.setFont(policeChoixUtilisateur);

        textAreaDateExpiration.setForeground(Color.GRAY);
        textAreaDateExpiration.setFont(policeARemplacer);
        textAreaDateExpiration.setMaximumSize(new Dimension(60, 20));
        textAreaDateExpiration.addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent arg0) {}
            public void mousePressed(MouseEvent arg0) {}
            public void mouseExited(MouseEvent arg0) {}
            public void mouseEntered(MouseEvent arg0) {}
            public void mouseClicked(MouseEvent arg0) {
                textAreaDateExpiration.setText(null);
                textAreaDateExpiration.setFont(policeChoixUtilisateur);
                textAreaDateExpiration.setForeground(Color.black);
            }
        });

        // mise en page : placements des differents elements graphiques dans des Box
        boxNumeroCarte.add(texteNumCarteBancaire);
        boxNumeroCarte.add(Box.createRigidArea(new Dimension(10, 0)));
        boxNumeroCarte.add(textAeraNumeroCarte);

        boxValiditeCarte.add(texteValiditeCarte);
        boxValiditeCarte.add(Box.createRigidArea(new Dimension(10, 0)));
        boxValiditeCarte.add(textAreaDateExpiration);

        boxValiderCarte.add(validationCoordonneeBancaire);

        // mise en page : placements des differentes box dans une box principale
        boxMiseEnPageCoordonneesBancaires.add(texteCoordsBancaires);
        boxMiseEnPageCoordonneesBancaires.add(Box.createRigidArea(new Dimension(0, 30)));
        boxMiseEnPageCoordonneesBancaires.add(boxNumeroCarte);
        boxMiseEnPageCoordonneesBancaires.add(Box.createRigidArea(new Dimension(0, 10)));
        boxMiseEnPageCoordonneesBancaires.add(boxValiditeCarte);
        boxMiseEnPageCoordonneesBancaires.add(Box.createRigidArea(new Dimension(0, 10)));
        boxMiseEnPageCoordonneesBancaires.add(boxValiderCarte);

        // mise en page : ajout de la box principale dans le panel
        this.add(boxMiseEnPageCoordonneesBancaires);
        boxMiseEnPageCoordonneesBancaires.setVisible(true);
        this.setVisible(false);
    }

    public void enregistrerCoordonneesBancaires(int numClient, IUseEnregistrerCoordonneesBancaires panAppelant) {
        this.numClient = numClient;
        this.panAppelant = panAppelant;

        textAeraNumeroCarte.setText("");
        textAreaDateExpiration.setText("MMAA");
        this.setVisible(true);
        this.repaint();
    }

    private void traitementCoordonneesBancaires(int numCarte, int dateCarte) {
        boolean carteValide = controlEnregistrerCoordonneesBancaires.enregistrerCoordonneesBancaires(numClient, numCarte, dateCarte);
        panAppelant.retourEnregistrerCoordonneesBancaire(carteValide);
    }

}