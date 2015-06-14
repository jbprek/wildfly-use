package org.bagab.rs.app;

import org.bagab.rs.hello.HelloText;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by john on 6/14/15.
 */
@ApplicationPath("rest")
public class MyApplication extends Application {
//
//    @Override
//    public Set<Class<?>> getClasses() {
//        HashSet<Class<?>> set = new HashSet<Class<?>>();
//        set.add(HelloText.class);
//        return set;
//    }
}
