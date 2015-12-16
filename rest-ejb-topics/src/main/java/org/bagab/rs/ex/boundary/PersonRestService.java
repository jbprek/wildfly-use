package org.bagab.rs.ex.boundary;

import org.bagab.rs.ex.control.PersonDAO;
import org.bagab.rs.ex.model.Person;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
    @Produces("application/json")
    public List<Person> list() {
        List<Person> list = dao.displayAll();
        return list;
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Person get(@PathParam("id") Long id) {
        Person p =  dao.findPerson(id);
        return p;
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Person create( Person newPerson) {
        return dao.addPerson(newPerson.getName());
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Person update( Person newPerson) {
        return dao.updatePerson(newPerson
        );
    }

    @DELETE
    @Consumes("application/json")
    @Produces("application/json")
    public Person delete( Person newPerson) {
        return dao.addPerson(newPerson.getName());
    }

}
