package dev.upssitech.mcburger.modele.commande;

import java.util.Date;

public record ItemHistorique(Date date, String[] commandeInfos) {

}
