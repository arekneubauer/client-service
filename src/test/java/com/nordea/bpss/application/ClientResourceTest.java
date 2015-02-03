package com.nordea.bpss.application;

import com.nordea.bpss.client.Client;
import com.nordea.bpss.client.ClientService;
import com.nordea.bpss.client.CustomerCountry;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.net.URISyntaxException;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
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
        //given
        final String clCusNo = "105150";

        final Client mockClient = new Client();
        mockClient.setClCusNo(clCusNo);

        resource.service = mock(ClientService.class);
        when(resource.service.getClient(anyString(), any(CustomerCountry.class)))
                .thenReturn(mockClient);

        //when
        Response r = resource.getClient(clCusNo, "PL");

        //then
        assertThat(r.getStatus(), is(equalTo(Response.Status.OK.getStatusCode())));

        final Client returnedClient = (Client) r.getEntity();
        assertThat(returnedClient, is(notNullValue()));
        assertThat(returnedClient.getClCusNo(), is(notNullValue()));
    }

    @Test
    public void should_get_fail_on_not_valid_country() {
        Response r = resource.getClient("105150", "UA");
        assertThat(r.getStatus(), is(equalTo(Response.Status.BAD_REQUEST.getStatusCode())));
    }

    @Test
    public void should_get_fail_on_not_validate_non_numeric_cust_number() {
        Response r = resource.getClient("aaaaaa", "PL");
        assertThat(r.getStatus(), is(equalTo(Response.Status.BAD_REQUEST.getStatusCode())));
    }

    @Test
    public void should_fail_create_on_not_valid_country() {
        Response r = resource.postClient("UA", new Client());
        assertThat(r.getStatus(), is(equalTo(Response.Status.BAD_REQUEST.getStatusCode())));
    }

    @Test
    public void should_fail_create_on_not_valid_client() {
        Response r = resource.postClient("PL", new Client());
        assertThat(r.getStatus(), is(equalTo(Response.Status.BAD_REQUEST.getStatusCode())));
    }

    @Test
    public void should_create_valid_client() {
        Response r = resource.postClient("PL", new Client());

        assertThat(r.getStatus(), is(equalTo(Response.Status.CREATED.getStatusCode())));
        assertThat(r.getLocation().getPath(), is(equalTo("/mock/PL/105150")));
    }

}
