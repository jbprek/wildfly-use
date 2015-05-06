package org.bagab.ejbmod;

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

    @Deployment(name = "template-ejb-module-simple", order = 1)
    public static Archive<?> generateStatefulDeployment() {
        return ShrinkWrap.create(WebArchive.class, "template-ejb-module-simple.war")
                .addPackage(Deployments.class.getPackage())
                ;
    }

}
