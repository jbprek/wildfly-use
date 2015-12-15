package org.bagab.rs.ex.util.jaxrs;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * This occurs while marshalling unmarshalling JSON using Jackson
 */
@Provider
public class IOExceptionRSMapper  implements ExceptionMapper<IOException> {

    @Inject
    private Logger logger;

    @Override
    public Response toResponse(IOException exception) {
        logger.warning(exception.getMessage());
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

}
