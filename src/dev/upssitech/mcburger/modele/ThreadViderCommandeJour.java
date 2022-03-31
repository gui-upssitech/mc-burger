package dev.upssitech.mcburger.modele;

import dev.upssitech.mcburger.modele.bd.BDCommande;

import java.util.Calendar;

/**
 * class: ThreadViderCommande
 * author: Guillaume Roussin
 * date: 31/03/2022
 */
public class ThreadViderCommandeJour extends Thread {

    // Attributes
    private boolean running;
    private final Calendar calendar;

    private int oldMinute;
    private final BDCommande bdCommande;

    // Constructor
    public ThreadViderCommandeJour() {
        super("THREAD_VIDER_COMMANDE_JOUR");
        running = true;

        calendar = Calendar.getInstance();
        oldMinute = -1;

        bdCommande = BDCommande.getInstance();
    }

    // Methods

    public void arret() {
        running = false;
    }

    @Override
    public void run() {
        do {
            try {
                int curMinute = calendar.get(Calendar.MINUTE);
                if(curMinute != oldMinute) {
                    oldMinute = curMinute - 1;
                    bdCommande.viderCommandeJour();
                }

                Thread.sleep(60000);
            } catch(InterruptedException ignored) {
                running = false;
            }
        } while(running);

        System.out.println(this.getName() + ": Arret du thread");
    }

}