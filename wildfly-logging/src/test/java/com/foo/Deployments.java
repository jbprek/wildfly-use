package com.foo;

import org.eu.ingwar.tools.arquillian.extension.suite.annotations.ArquillianSuiteDeployment;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import java.io.File;

/**
 * @author prekezes.
 */
@ArquillianSuiteDeployment
public class Deployments {
    @Deployment(name = "test-suite", order = 1)
    public static Archive<?> generateDefaultDeployment() {
        return ShrinkWrap.create(WebArchive.class, "war-test.war")
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/beans.xml"))
                .addPackages(true, Deployments.class.getPackage())
                ;
    }

}
