package org.bagab.wapp.control;

import org.eu.ingwar.tools.arquillian.extension.suite.annotations.ArquillianSuiteDeployment;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

import java.io.File;

/**
 * @author prekezes.
 */
@ArquillianSuiteDeployment
public class Deployments {
    @Deployment(name = "test-suite", order = 2)
    public static Archive<?> generateDefaultDeployment() {
        File[] files = Maven.resolver().resolve("org.bagab.wildfly:template-ejb-module:1.0-SNAPSHOT").withTransitivity().asFile();
        return ShrinkWrap.create(WebArchive.class, "normal.war")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsLibraries(files)
//                .addPackage(Deployments.class.getPackage())
                .addPackage(Greeter.class.getPackage());
    }

}
