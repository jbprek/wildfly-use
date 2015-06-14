package org.bagab.rs.hello;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Created by john on 6/14/15.
 */

@Stateless
@Path("/")
public class HelloText {

    @GET
    @Path("helloworld")
    @Produces("text/plain")
    public String helloWorld() {
        return "Hello World!";
    }

    @GET
    @Path("hellotext/{name}")
    @Produces("text/plain")
    public String hello(@PathParam("name")String name) {
        StringBuilder bui = new StringBuilder();
        bui.append("Go to Hell ")
                .append(name).append("!");
        return bui.toString();
    }
}
