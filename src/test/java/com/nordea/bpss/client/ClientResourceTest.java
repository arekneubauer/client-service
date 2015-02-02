package com.nordea.bpss.client;

import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

public class ClientResourceTest {

    ClientResource resource = new ClientResource();

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
