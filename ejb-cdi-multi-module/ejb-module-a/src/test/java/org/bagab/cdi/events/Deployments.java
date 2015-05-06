package org.bagab.cdi.events;

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
//
//    @Deployment(name = "test-alt", order = 1)
//    public static Archive<?> generateStatefulDeployment() {
//        return ShrinkWrap.create(WebArchive.class, "test-alternatives.war")
//                .addAsWebInfResource("alternatives/beans.xml","beans.xml")
//                .addPackage(AppControlSingleton.class.getPackage())
//                ;
//    }

    @Deployment(name = "test-ejb-module-a", order = 2)
    public static Archive<?> generateStatelessDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test-events.war")
                .addAsWebInfResource("beans.xml")
                .addClass(AppControlSingleton.class)
                .addClass(TestEvent.class)
                .addClass(ApplicationStartedEvent.class)
                ;

    }


}
