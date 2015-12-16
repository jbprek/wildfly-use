package org.bagab.rs;

import org.eu.ingwar.tools.arquillian.extension.suite.annotations.ArquillianSuiteDeployment;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;

/**
 * @author prekezes.
 */
@ArquillianSuiteDeployment
public class Deployments {
    public static final String NAME = "rest1.war";

    @Deployment(name = NAME, order = 1)
    public static Archive<?> generateDefaultDeployment() {
        return ShrinkWrap.create(WebArchive.class, "rest1.war")
                .addAsWebInfResource("beans.xml", "beans.xml")
                .addPackage(Deployments.class.getPackage())
                ;
    }

}
