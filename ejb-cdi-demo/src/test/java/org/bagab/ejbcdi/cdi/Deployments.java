package org.bagab.ejbcdi.cdi;

import org.bagab.ejbcdi.cdi.alternatives.ApplicationSingletonLocal;
import org.bagab.ejbcdi.cdi.events.AppControlSingleton;
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

    @Deployment(name = "test-alternatives", order = 1)
    public static Archive<?> generateStatefulDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test-alternatives.war")
                .addAsWebInfResource("alternatives/beans.xml","beans.xml")
                .addPackage(ApplicationSingletonLocal.class.getPackage())
                ;
    }

    @Deployment(name = "test-events", order = 2)
    public static Archive<?> generateStatelessDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test-events.war")
                .addAsWebInfResource("events/beans.xml", "beans.xml")
                .addPackage(AppControlSingleton.class.getPackage())
                ;

    }


}
