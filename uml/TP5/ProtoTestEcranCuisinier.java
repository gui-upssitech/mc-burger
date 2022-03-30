package testgraphique;

import controleur.ControlVisualiserCommandeJour;
import controleur.ProtoControlVerifierIdentification;
import modele.Accompagnement;
import modele.BDCommande;
import modele.Boisson;
import modele.Hamburger;
import modele.ThreadViderCommandeJour;
import vuegraphique.FrameCuisinier;

public class ProtoTestEcranCuisinier {
	public static void main(String[] args) {
		BDCommande bdCommande = BDCommande.getInstance();
		Hamburger cheeseBurger = new Hamburger("cheeseBurger");
		Hamburger baconBurger = new Hamburger("baconBurger");
		Accompagnement frites = new Accompagnement("frites");
		Accompagnement pommesChips = new Accompagnement("pommesChips");
		Boisson coca = new Boisson("coca");
		Boisson orange = new Boisson("orangeBubbles");

		// cas visualisation commande du jour
		ProtoControlVerifierIdentification controlVerifierIdentification = new ProtoControlVerifierIdentification();
		ControlVisualiserCommandeJour controlVisualiserCommandeJour = new ControlVisualiserCommandeJour(
				controlVerifierIdentification);
		new FrameCuisinier(1, controlVisualiserCommandeJour);
		new FrameCuisinier(2, controlVisualiserCommandeJour);

		// Thread
		ThreadViderCommandeJour threadViderCommande = new ThreadViderCommandeJour();
		threadViderCommande.start();

		// attente pour que les cuisiniers puissent selectionner dans le menu la
		// visualisation des commades
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// lancement du test
		bdCommande.enregistrerCommande(2, cheeseBurger, pommesChips, orange);
		bdCommande.enregistrerCommande(1, baconBurger, frites, coca);

		// Résultat attendu
		// Commande no 1 : cheeseBurger, pommesChips, orangeBubbles
		// Commande no 2 : baconBurger, frites, coca
	}
}
