package dev.upssitech.mcburger.modele.bd;

import dev.upssitech.mcburger.modele.profil.Client;

import java.util.HashMap;

public class BDClient {

    private static class InstanceHolder {
        public static final BDClient instance = new BDClient();
    }

    public static BDClient getInstance() {
        return InstanceHolder.instance;
    }

    private final HashMap<Integer, Client> listeClients;
    private int numClients;

    private BDClient() {
        listeClients = new HashMap<>();
        numClients = 0;
    }

    public void addClient(Client client) {
        listeClients.put(numClients, client);
        numClients++;
    }

    @Override
    public String toString() {
        return "BDClient [" +
                "listeClients=" + listeClients +
                ']';
    }
}
