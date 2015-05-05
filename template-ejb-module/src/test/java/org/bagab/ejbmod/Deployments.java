package org.bagab.ejbmod;

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

  static  File[] interfaceCode = Maven.resolver().resolve("org.bagab.wildfly:template-ejb-module-interfaces:1.0-SNAPSHOT").withTransitivity().asFile();


    @Deployment(name = "test-stateful", order = 1)
    public static Archive<?> generateStatefulDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test-stateful.war")
//                .addAsWebInfResource(EmptyAsset.INSTANCE, "web.xml")
//                .addPackage(Deployments.class.getPackage())
//                .addPackage(SimpleStatelessBean.class.getPackage());
                .addAsLibraries(interfaceCode)
                .addClass(CounterTest.class)
                .addClass(CounterlBean.class);

    }
    @Deployment(name = "test-stateless", order = 2)
    public static Archive<?> generateStatelessDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test-stateless.war")
//                .addAsWebInfResource(EmptyAsset.INSTANCE, "web.xml")
//                .addPackage(Deployments.class.getPackage())
//                .addPackage(SimpleStatelessBean.class.getPackage());
                .addAsLibraries(interfaceCode)
                .addClass(HelloTest.class)
                .addClass(HelloBean.class);

    }


}
