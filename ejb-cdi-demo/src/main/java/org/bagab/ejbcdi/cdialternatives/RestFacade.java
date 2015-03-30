package org.bagab.ejbcdi.cdialternatives;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author prekezes.
 */
@Path("/")
public class RestFacade {

    @Inject
    ApplicationSingletonLocal app;

    @GET
    @Path("/get")
    @Produces({"application/json"})
    public JsonObject get() {
        return Json.createObjectBuilder()
                .add("value", app.hello())
                .build();
    }

}
