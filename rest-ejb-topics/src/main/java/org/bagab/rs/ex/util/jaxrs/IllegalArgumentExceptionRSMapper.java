package org.bagab.rs.ex.util.jaxrs;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.logging.Logger;

/**
 * Created by john on 9/7/15.
 */
@Provider
public class IllegalArgumentExceptionRSMapper implements ExceptionMapper<IllegalArgumentException> {

    @Inject
    private Logger logger;

    @Override
    public Response toResponse(IllegalArgumentException exception) {
        logger.warning(exception.getMessage());

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

}
