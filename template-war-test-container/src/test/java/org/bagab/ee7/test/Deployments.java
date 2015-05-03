package org.bagab.ee7.test;

import org.eu.ingwar.tools.arquillian.extension.suite.annotations.ArquillianSuiteDeployment;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

import java.io.File;

/**
 * @author prekezes.
 */
@ArquillianSuiteDeployment
public class Deployments {

    static  File[] ejbCode = Maven.resolver().resolve("org.bagab.wildfly:template-ejb-module:1.0-SNAPSHOT").withTransitivity().asFile();

    @Deployment(name = "test-suite", order = 1)
    public static Archive<?> generateDefaultDeployment() {
        return ShrinkWrap.create(WebArchive.class, "war-test.war")
                .addAsWebInfResource(new File("src/test/resources/beans.xml"))
                .addAsLibraries(ejbCode)
                .addPackage(Deployments.class.getPackage())
                ;
    }

}
