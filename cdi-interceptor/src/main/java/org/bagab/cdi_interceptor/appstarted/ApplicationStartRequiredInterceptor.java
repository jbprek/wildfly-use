package org.bagab.cdi_interceptor.appstarted;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * @author prekezes.
 */
@Interceptor
@ApplicationStartRequired
public class ApplicationStartRequiredInterceptor {

    @Inject
    private Application application;

    @AroundInvoke
    public Object checkStarted(InvocationContext context) throws Exception {
        if (!application.isStarted())
            return Integer.MIN_VALUE;
//            throw new IllegalStateException("Application is not started, cannot invoke " + context.getMethod().getName());

        return context.proceed();
    }
}
