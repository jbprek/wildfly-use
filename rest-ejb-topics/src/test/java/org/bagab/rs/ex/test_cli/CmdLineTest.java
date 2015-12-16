package org.bagab.rs.ex.test_cli;

import org.bagab.rs.ex.model.Person;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.logging.Logger;

/**
 * TODO Show/test usage of API from cmdline
 *
 */
public class CmdLineTest {
//
//    private static final Logger logger = Logger.getLogger(CmdLineTest.class.getName());
//    private static Client client;
//    private static WebTarget base;
//
//// WebTarget
//    @BeforeClass
//    public static void setup() {
//        client = ClientBuilder.newClient();
//        base = client.target("http://localhost:8080/rest1/person");
//        logger.info("setup");
//    }
//
//    @AfterClass
//    public static  void tearDown() {
//        if (client != null)
//            client.close();
//        logger.info("tearDown");
//    }
//
//    public static Long id_in = null;
//
//    @Test
//    public void createReadPerson() {
//
//        // CREATE
//        Person post = new Person();
//        post.setName("AA");
//        Person created = base.request(MediaType.APPLICATION_JSON)
//                .post(Entity.json(post), Person.class);
//        Assert.assertEquals(created.getName(), "AA");
//        logger.info("Created :"+created);
//        // READ
//        Person read = base
//                .path("{id}")
//                .resolveTemplate("id", "" + created.getId())
//                .request(MediaType.APPLICATION_JSON)
//                .get(Person.class);
//        Assert.assertEquals(created, read);
//    }
//
////    public Person read(long id) {
////        return base
////                .path("{id}")
////                .resolveTemplate("id", "" + id)
////                .request(MediaType.APPLICATION_JSON)
////                .get(Person.class);
////    }
////
////
////    public static void main(String[] args) {
////
////    }


}
