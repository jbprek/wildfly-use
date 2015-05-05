package org.bagab.cdi_interceptor.appstarted.cdialternatives;

import javax.ejb.Singleton;
import javax.enterprise.inject.Alternative;

/**
 * @author prekezes.
 */
@Singleton
@Alternative
public class ApplicationSingletonAlternative1 implements ApplicationSingletonLocal{
    @Override
    public String hello() {
        return "!!!Hello from first alternative!!!!";
    }
}
