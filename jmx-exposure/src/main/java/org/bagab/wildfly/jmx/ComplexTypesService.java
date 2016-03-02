package org.bagab.wildfly.jmx;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.Date;

/**
 * @author prekezes.
 */

@Singleton
@Startup
public class ComplexTypesService extends AbstractComponentMBean  implements IComplexTypesServiceMBean {

    public MyEnum myEnum = MyEnum.OK;
    public MyPojo myPojo = new MyPojo();

    public ComplexTypesService() {
        super("bagab-wildfly-jmx");
    }

    @Override
    public MyEnum getMyEnum() {
        return myEnum;
    }

    @Override
    public void setMyEnum(MyEnum myEnum) {
        this.myEnum = myEnum;
    }

    @Override
    public MyPojo getMyPojo() {
        return myPojo;
    }

    @Override
    public String readMyPojo() {
        return myPojo.toString();
    }

    @Override
    public void updatePojoNum(int value) {
       myPojo.setNum(value);
    }

    @Override
    public void updatePojoText(String text) {
       myPojo.setText(text);
    }

    @Override
    public void updatePojoDate(Date date) {
        myPojo.setDate(date);
    }
}
