package org.bagab.ejbcdi.interceptors;

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
    private Application app;

    @Inject
    private BusinesComponent comp;

    @GET
    @Path("/start")
    @Produces({"application/json"})
    public void start() {
        app.start();
    }

    @GET
    @Path("/stop")
    @Produces({"application/json"})
    public void stop() {
        app.stop();
    }

    @GET
    @Path("/isStarted")
    @Produces({"application/json"})
    public JsonObject isStarted() {
        return Json.createObjectBuilder()
                .add("isStarted", app.isStarted())
                .build();
    }

    @GET
    @Path("/aMethod")
    @Produces({"application/json"})
    public JsonObject aMethod() {
        return Json.createObjectBuilder()
                .add("aMethod result", comp.aBusinesMethod(1))
                .build();
    }


    @GET
    @Path("/anotherMethod")
    @Produces({"application/json"})
    public JsonObject anotherMethod() {
        return Json.createObjectBuilder()
                .add("anotherMethod result", comp.anotherBusinesMethod(1))
                .build();
    }



//    int aMethod();
//
//    int anotherMethod();

    /*
     @Inject
    HelloService helloService;

    @GET
    @Path("/")
    @Produces({ "application/json" })
    public JsonObject getHelloWorldJSON() {
        return Json.createObjectBuilder()
                .add("result", helloService.createHelloMessage("World"))
                .build();
    }
     */
}
