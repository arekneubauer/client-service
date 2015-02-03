package com.nordea.bpss.application;

import com.nordea.bpss.client.Client;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.net.URISyntaxException;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ClientResourceTest {

    ClientResource resource = new ClientResource();

    @Before
    public void setup() throws URISyntaxException {
        resource.uriInfo = mock(UriInfo.class);
        when(resource.uriInfo.getAbsolutePath()).thenReturn(new URI("/mock"));
    }

    @Test
    public void should_get_valid_client() {
        Response r = resource.getClient("105150", "PL");

        assertThat(r.getStatus(), is(equalTo(Response.Status.OK.getStatusCode())));

        Client client = (Client) r.getEntity();
        assertThat(client, is(notNullValue()));
        assertThat(client.getClCusNo(), is(notNullValue()));
    }

    @Test
    public void should_UA_not_valid_country() {
        Response r = resource.getClient("105150", "UA");
        assertThat(r.getStatus(), is(equalTo(Response.Status.BAD_REQUEST.getStatusCode())));
    }

    @Test
    public void should_not_validate_non_numeric_cust_number() {
        Response r = resource.getClient("aaaaaa", "PL");
        assertThat(r.getStatus(), is(equalTo(Response.Status.BAD_REQUEST.getStatusCode())));
    }

}
