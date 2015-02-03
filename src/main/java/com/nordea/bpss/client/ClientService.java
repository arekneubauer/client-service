package com.nordea.bpss.client;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ClientService {

    @PersistenceContext
    EntityManager em;

    public AbstractClient getClient(String clientId, CustomerCountry country) {
        List<Client> list = em.createNamedQuery("Client.findByClCusNoAndCunitId", Client.class)
                .setParameter("clCusNo", clientId)
                .setParameter("clCunitId", country.countryCode())
                .getResultList();

        if (list.isEmpty())
            return new NullClient();

        return list.get(0);
    }

    public Client saveClient(Client client) {
        em.persist(client);
        em.flush();
        return client;
    }
}
