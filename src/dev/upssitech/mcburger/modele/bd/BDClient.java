package dev.upssitech.mcburger.modele.bd;

import dev.upssitech.mcburger.modele.profil.Client;

import java.util.ArrayList;
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

    public int connexionClient(String login, String mdp) {
        for(int numClient : listeClients.keySet()) {
            Client client = listeClients.get(numClient);
            if(client.verifierCorrespondanceProfil(login, mdp)) {
                client.connexionProfil();
                return numClient;
            }
        }
        return -1; // Retourn -1 si aucun compte correspondant n'est trouvé
    }

    public Client trouverClient(int numClient) {
        return listeClients.getOrDefault(numClient, null);
    }

    @Override
    public String toString() {
        return "BDClient [" +
                "listeClients=" + listeClients +
                ']';
    }
}
