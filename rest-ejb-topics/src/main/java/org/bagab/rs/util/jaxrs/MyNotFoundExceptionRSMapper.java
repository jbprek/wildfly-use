package org.bagab.rs.util.jaxrs;


import org.bagab.rs.ex.model.MyApplicationException;
import org.bagab.rs.ex.model.MyNotFoundException;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.logging.Logger;

/**
 * Created by john on 9/7/15.
 */
@Provider
public class MyNotFoundExceptionRSMapper implements ExceptionMapper<MyNotFoundException> {

    @Inject
    private Logger logger;

    @Override
    public Response toResponse(MyNotFoundException exception) {

        logger.warning(exception.getMessage());
        return Response.status(Response.Status.NOT_FOUND).build();

    }
}
