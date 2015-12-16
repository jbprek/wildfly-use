package org.bagab.rs.ex;

import org.bagab.rs.Deployments;
import org.bagab.rs.ex.control.PersonDAO;
import org.bagab.rs.ex.model.Person;
import org.jboss.arquillian.container.test.api.OperateOnDeployment;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import javax.ejb.EJB;

/**
 * @author prekezes.
 */
@RunWith(Arquillian.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Test {

    @EJB
    private PersonRestClient rest;

    @EJB
    private PersonDAO dao;


    @org.junit.Test
    @OperateOnDeployment(Deployments.NAME)
    public void a_create_Test() {
        Person created =   rest.createPerson("A");
        Assert.assertEquals(created, dao.findPerson(created.getId()));
    }


}
