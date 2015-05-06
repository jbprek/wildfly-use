package org.bagab.ejbmod;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;

/**
 * Counter Implementation
 * @author prekezes.
 */
@Stateful
@Local(Counter.class)
@Remote(CounterRemote.class)
public class CounterlBean implements Counter {
    int count = 0;

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public void inc(int increment) {
        count += increment;
    }
}
