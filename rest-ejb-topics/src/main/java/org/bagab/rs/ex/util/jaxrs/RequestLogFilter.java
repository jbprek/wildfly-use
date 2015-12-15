package org.bagab.rs.ex.util.jaxrs;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * REST Intercepting filter, logging request
 */
@Provider
@PreMatching
public class RequestLogFilter implements ContainerRequestFilter {

    @Inject
    private Logger logger;

    @Override
    public void filter(ContainerRequestContext ctx) throws IOException {
        UriInfo uriInfo = ctx.getUriInfo();
        logger.info("Request " + ctx.getMethod() + " " + ctx.getUriInfo().getPath());
    }
}
