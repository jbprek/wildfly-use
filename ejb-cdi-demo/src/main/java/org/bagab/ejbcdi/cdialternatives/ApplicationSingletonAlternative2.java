package org.bagab.ejbcdi.cdialternatives;

/**
 * @author prekezes.
 */
public class ApplicationSingletonAlternative2 implements ApplicationSingletonLocal {
    @Override
    public String hello() {
        return "###Hello from second alternative###";
    }
}
