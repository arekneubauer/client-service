package com.nordea.bpss.client;

public class ClientService {
    public Client getClient(String clientId, CustomerCountry country) {
        return new Client();
    }

    public Client saveClient(Client client) {
        return client;
    }
}
