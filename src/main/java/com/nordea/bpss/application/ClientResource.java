package com.nordea.bpss.application;

import com.nordea.bpss.client.Client;
import com.nordea.bpss.client.CustomerCountry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

/**
 * RESTful Client resource class
 * 
 * @author m317746
 */
@Stateless
@Path("clients")
public class ClientResource {

    private static final Logger LOG = LoggerFactory.getLogger(ClientResource.class);

    @Context
    UriInfo uriInfo;
    
    /**
     * Returns single Client data
     * 
     * @param cusNo
     * @param countryCode
     * @return Response with Client
     */
    @GET
    @Path("{country}/{cusNo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClient (@PathParam("country") String countryCode, 
                               @PathParam("cusNo") String cusNo) {
        
        LOG.info("Client requested at: {}", uriInfo.getAbsolutePath());
        if (!CustomerCountry.coutryExists(countryCode)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        if (cusNo == null || !cusNo.matches("[0-9]*")) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        CustomerCountry customerCountry = CustomerCountry.valueOf(cusNo);

        return Response.ok("").build();
    }
    
    /**
     * Creates new Client
     * 
     * @param countryCode
     * @param client
     * @return Response
     */
    @POST
    @Path("{country}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postClient (@PathParam("country") String countryCode, Client client) {

        LOG.info("Client posted at: {} ", uriInfo.getAbsolutePath());
        String location = uriInfo.getAbsolutePath().toString();

        return Response
                .status(Status.CREATED)
                .location(URI.create(location))
                .entity("")
                .build();
    }
        
    /**
     * Updates Client
     * 
     * @param countryCode
     * @param cusNo
     * @param client
     * @return Response
     */
    @PUT
    @Path("{country}/{cusNo}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putClient (@PathParam("country") String countryCode,
                               @PathParam("cusNo") String cusNo,
                               Client client) {

        LOG.info("Client update requested at: {} ", uriInfo.getAbsolutePath());
        return Response.status(Response.Status.ACCEPTED).entity("").build();
    }
    
}
