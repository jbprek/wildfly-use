package org.bagab.rs.ex.boundary;

import org.bagab.rs.ex.control.PersonDAO;
import org.bagab.rs.ex.model.Person;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author prekezes.
 */

@Stateless
@Path("/person")
public class PersonRestService {

    @EJB
    private PersonDAO dao;

    @GET
    @Path("/list")
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<String> list() {
        List<String> list = dao.displayAll();
        return list;
    }

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person get(@PathParam("id") Long id) {
        Person p =  dao.findPerson(id);
        return p;
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Person create( Person newPerson) {
        return dao.addPerson(newPerson.getName());
    }

}
