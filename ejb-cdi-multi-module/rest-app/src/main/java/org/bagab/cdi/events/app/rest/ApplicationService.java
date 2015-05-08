package org.bagab.cdi.events.app.rest;

import org.bagab.cdi.events.moda.AppControlSingleton;
import org.bagab.cdi.events.moda.ApplicationChangedStatusEvent;
import org.bagab.cdi.events.modb.AsyncBean;
import org.bagab.cdi.events.modb.AsyncBeanDoneEvent;

import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.enterprise.event.Observes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Objects;

/**
 * @author prekezes.
 */
@Singleton
@Path("/rest")
public class ApplicationService {

    // In Module A
    @EJB
    private AppControlSingleton modAControl;

    @GET
    @Path("/open")
    @Asynchronous
    public void open(){
        modAControl.start();
    }

    @GET
    @Path("/close")
    @Asynchronous
    public void close(){
        modAControl.stop();
    }

    private boolean open = false;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/isOpen")
    public boolean isOpen() {
        return open;
    }

    /**
     * Receives event from ModuleA
     * @param newStatus
     */
    public void observeModA(@Observes @ApplicationChangedStatusEvent AppControlSingleton.Status newStatus) {
        Objects.requireNonNull(newStatus);
        switch(newStatus){
            case STARTED:
                open = true;
                break;
            case STOPPED:
                open = false;
                break;
        }
    }

    @EJB
    private AsyncBean abean;

    public String response;

    @GET
    @Path("/request")
    public void request(@PathParam("input") String input){
        abean.doWork(input);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/response")
    public String getResponse() {
        return response;
    }

    public void waitAsyncResult(@Observes @AsyncBeanDoneEvent String output){
           response = output;
    }

}
