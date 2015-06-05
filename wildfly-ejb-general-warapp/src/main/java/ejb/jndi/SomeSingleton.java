package ejb.jndi;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;

/**
 * @author prekezes.
 */
@Singleton
public class SomeSingleton {

    SomeStateless slsb;

    @PostConstruct
    public void setup(){

    }
}
