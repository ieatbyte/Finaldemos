package com.wh.finaldemos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanghui5-s on 2015/11/18.
 */
public abstract class DemoGroup extends Demo{

    protected List<Demo> subDemos;

    public List<Demo> getSubDemos() {
        if (subDemos == null) {
            subDemos = new ArrayList<>();
            Class[] subDemoClasses = getSubDemoClasses();
            if (subDemoClasses != null && subDemoClasses.length > 0) {
                for(Class c : subDemoClasses) {
                    Demo d = null;
                    try {
                        d = (Demo) c.newInstance();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    if (d != null) {
                        subDemos.add(d);
                    }
                }
            }
        }
        return subDemos;
    }

    public abstract Class[] getSubDemoClasses();
}
