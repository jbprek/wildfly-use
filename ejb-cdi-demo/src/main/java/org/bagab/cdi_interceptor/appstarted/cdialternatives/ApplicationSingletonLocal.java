package org.bagab.cdi_interceptor.appstarted.cdialternatives;

import javax.ejb.Local;

/**
 * @author prekezes.
 */
@Local
public interface ApplicationSingletonLocal {

    String hello();
}
