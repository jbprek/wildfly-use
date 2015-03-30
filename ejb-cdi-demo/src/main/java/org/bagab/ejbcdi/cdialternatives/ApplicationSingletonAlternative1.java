package org.bagab.ejbcdi.cdialternatives;

/**
 * @author prekezes.
 */
public class ApplicationSingletonAlternative1 implements ApplicationSingletonLocal{
    @Override
    public String hello() {
        return "!!!Hello from first alternative!!!!";
    }
}
