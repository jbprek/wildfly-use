package ejb.jndi;

import javax.ejb.Stateless;

/**
 * @author prekezes.
 */
@Stateless
public class SomeStateless {

    public String ping() {
        return "pong";
    }
}
