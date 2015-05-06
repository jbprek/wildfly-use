package org.bagab.ejbcdi.cdi.alternatives;

import org.jboss.arquillian.container.test.api.OperateOnDeployment;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

/**
 * Created by x on 5/6/15.
 */
@RunWith(Arquillian.class)
public class AlternativesTest {

    @Inject
    private ApplicationSingletonLocal bean;

    @Test
    @OperateOnDeployment("test-alternatives")
    public void test() {
        Assert.assertEquals("Alt-2", bean.version());
    }


}
