package testconsole;

import controleur.ControlVisualiserCommandeJour;
import controleur.ProtoControlVerifierIdentification;
import modele.Accompagnement;
import modele.BDCommande;
import modele.Boisson;
import modele.Hamburger;
import modele.ThreadViderCommandeJour;
import vueconsole.BoundaryVisualiserCommandeJour;

public class ProtoTestVisualiserCommandeJour {
	public static void main(String[] args) {
		BDCommande bdCommande = BDCommande.getInstance();
		Hamburger cheeseBurger = new Hamburger("cheeseBurger");
		Hamburger baconBurger = new Hamburger("baconBurger");
		Accompagnement frites = new Accompagnement("frites");
		Accompagnement pommesChips = new Accompagnement("pommesChips");
		Boisson coca = new Boisson("coca");
		Boisson orange = new Boisson("orangeBubbles");

		// creation pour la visualisation de la commande
		ProtoControlVerifierIdentification protoControlVerifierIdentification = new ProtoControlVerifierIdentification();
		ControlVisualiserCommandeJour controlVisualiserCommandeJour = new ControlVisualiserCommandeJour();
		BoundaryVisualiserCommandeJour boundaryVisualiserCommandeJour = new BoundaryVisualiserCommandeJour(controlVisualiserCommandeJour);
	//	boundaryVisualiserCommandeJour.visualiserCommandeJour(1);
	//	boundaryVisualiserCommandeJour.visualiserCommandeJour(2);

		// Thread
	//	ThreadViderCommandeJour threadViderCommande = new ThreadViderCommandeJour();
	//	threadViderCommande.start();
		
		// lancement du test
		bdCommande.enregistrerCommande(2, cheeseBurger, pommesChips, orange);
		bdCommande.enregistrerCommande(1, baconBurger, frites, coca);

		// Résultat attendu
		// Commande no 1 : cheeseBurger, pommesChips, orangeBubbles
		// Commande no 2 : baconBurger, frites, coca
	}
}
