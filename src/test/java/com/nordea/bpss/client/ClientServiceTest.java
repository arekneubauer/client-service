package com.nordea.bpss.client;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.internal.matchers.Null;

import static org.hamcrest.core.Is.*;
import static org.hamcrest.core.IsNot.*;

public class ClientServiceTest {

    ClientService service = new ClientService();

    @Test
    public void should_return_client() {
        Client client = service.getClient("105150", CustomerCountry.PL);
        Assert.assertThat(client, is(not(Null.NULL)));
    }

}
