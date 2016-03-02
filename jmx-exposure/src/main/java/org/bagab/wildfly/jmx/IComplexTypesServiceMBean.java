package org.bagab.wildfly.jmx;

import javax.management.MXBean;
import java.io.Serializable;
import java.util.Date;

/**
 * @author prekezes.
 */

@MXBean
public interface IComplexTypesServiceMBean {

    enum MyEnum {
        OK, SUCKS;
    }

    class MyPojo implements Serializable {
        private int num;
        private String text = "";
        private Date date = new Date();

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        @Override
        public String toString() {
            return "MyPojo{" +
                    "num=" + num +
                    ", text='" + text + '\'' +
                    ", date=" + date +
                    '}';
        }
    }


    MyEnum getMyEnum();

    void setMyEnum(MyEnum myEnum);

    MyPojo getMyPojo();

    String readMyPojo();

    void updatePojoNum(int value);

    void updatePojoText(String text);

    void updatePojoDate(Date date);

}
