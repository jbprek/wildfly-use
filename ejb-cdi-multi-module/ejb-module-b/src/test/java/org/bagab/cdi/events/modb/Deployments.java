package org.bagab.cdi.events.modb;

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

    static  File[] modACode = Maven.resolver().resolve("org.bagab.wildfly.ejbcdi.multimod:ejb-module-a:1.0-SNAPSHOT").withTransitivity().asFile();

    @Deployment(name = "test-ejb-module-b", order = 2)
    public static Archive<?> generateStatelessDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test-events.war")
                .addAsWebInfResource("beans.xml")
                .addAsLibraries(modACode)
                .addPackages(true, Deployments.class.getPackage())
                ;

    }


}
