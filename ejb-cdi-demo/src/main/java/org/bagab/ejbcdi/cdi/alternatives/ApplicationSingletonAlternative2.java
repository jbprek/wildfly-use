package org.bagab.ejbcdi.cdi.alternatives;

import javax.ejb.Singleton;
import javax.enterprise.inject.Alternative;

/**
 * @author prekezes.
 */
@Singleton
@Alternative
public class ApplicationSingletonAlternative2 implements ApplicationSingletonLocal {
    @Override
    public String hello() {
        return "###Hello from second alternative###";
    }

    @Override
    public String version() {
        return "Alt-2";
    }
}
