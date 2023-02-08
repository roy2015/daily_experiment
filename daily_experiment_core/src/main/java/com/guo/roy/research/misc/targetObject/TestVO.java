package com.guo.roy.research.misc.targetObject;

import java.util.List;

/**
 * Created by apple on 2019/4/8.
 */
public class TestVO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private String field1;
    private String field2;
    private String field3;
    private String field4;

    private List<String> field4s;


    public TestVO(String field1, String field2, String field3, List<String> field4s) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
        this.field4s = field4s;
    }

    public TestVO(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public List<String> getField4s() {
        return field4s;
    }

    public void setField4s(List<String> field4s) {
        this.field4s = field4s;
    }
}
