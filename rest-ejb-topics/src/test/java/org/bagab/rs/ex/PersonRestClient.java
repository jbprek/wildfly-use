package org.bagab.rs.ex;

import org.bagab.rs.ex.model.Person;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.logging.Logger;

/**
 * CRUD Operations calling Rest services from  EJB
 */
@Stateless
public class PersonRestClient {
    @Inject
    private Logger logger;
    private Client client;
    private WebTarget base;

// WebTarget

    @PostConstruct
    public void setup() {
        client = ClientBuilder.newClient();
        base = client.target("http://localhost:8080/rest1/person");
        logger.info("setup");
    }

    @PreDestroy
    public void tearDown() {
        if (client != null)
            client.close();
        logger.info("tearDown");
    }


    public Person createPerson(String name) {
        Person out = new Person();
        out.setName(name);
        Person in = base.request(MediaType.APPLICATION_JSON)
                .post(Entity.json(out), Person.class);
        return in;
    }

    public Person read(long id) {
        return base
                .path("{id}")
                .resolveTemplate("id", "" + id)
                .request(MediaType.APPLICATION_JSON)
                .get(Person.class);
    }

//
//    public Person updatePerson(Person person) {
//
//    }
//
//    public Person deletePerson(Person person) {
//
//    }


}
