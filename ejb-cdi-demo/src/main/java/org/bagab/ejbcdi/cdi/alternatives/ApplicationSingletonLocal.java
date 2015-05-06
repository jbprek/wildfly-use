package org.bagab.ejbcdi.cdi.alternatives;

import javax.ejb.Local;

/**
 * @author prekezes.
 */
@Local
public interface ApplicationSingletonLocal {

    String hello();

    String version();
}
