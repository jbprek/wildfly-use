package org.bagab.ejbmod;

/**
 * Counter business interface
 * @author prekezes.
 */
public interface Counter {
    public int getCount();

    public void  inc(int value);
}
