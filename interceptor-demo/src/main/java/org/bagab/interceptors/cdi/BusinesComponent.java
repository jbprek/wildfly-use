package org.bagab.interceptors.cdi;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * A Rudimentaty business component.
 */
@Stateless
@LocalBean
public class BusinesComponent {

    /**
     * This method can run without Application.isStarted() == false;
     * @param v
     * @return
     */
    public int aBusinesMethod(int v){
        return 0;
    }

    /**
     * This method can run only when Application.isStarted() == false;
     * @param v
     * @return
     */
    @ApplicationStartRequired
    public int anotherBusinesMethod(int v){
        return 1;
    }


}
