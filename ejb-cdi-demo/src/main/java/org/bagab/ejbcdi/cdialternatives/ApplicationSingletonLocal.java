package org.bagab.ejbcdi.cdialternatives;

import javax.ejb.Local;

/**
 * @author prekezes.
 */
@Local
public interface ApplicationSingletonLocal {

    String hello();
}
