package com.nordea.bpss.application;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Sets response object when runtime exception happens. 
 *
 * @author m317746
 */
@Provider
public class RuntimeExceptionMapper implements ExceptionMapper<RuntimeException> {

    private static final Logger LOG = LoggerFactory.getLogger(RuntimeExceptionMapper.class);

    @Override
    public Response toResponse(RuntimeException exception) {
        
        LOG.error("Runtime exception {} ", exception.getMessage(), exception);

        return Response
                .status(Status.INTERNAL_SERVER_ERROR)
                .entity(exception.getMessage())
                .build();
        
    }
    
}