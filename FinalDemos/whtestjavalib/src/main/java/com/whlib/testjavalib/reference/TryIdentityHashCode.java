package com.whlib.testjavalib.reference;

import com.whlib.testjavalib.ABaseTry;

/**
 * Created by wanghui5-s on 2016/9/2.
 * <p/>
 * Conclusion:
 * #1:
 */
public class TryIdentityHashCode extends ABaseTry {

    @Override
    public void startTry() {
        super.startTry();

        A a1 = new A();
        A a2 = new A();

        System.out.println("TryIdentityHashCode a1:" + System.identityHashCode(a1)
                + ", a2:" + System.identityHashCode(a2) + ", 10:" + System.identityHashCode(10));
        System.out.println("TryIdentityHashCode a1:" + System.identityHashCode(a1));
    }

    static class A {
        int a;

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof  A) {
                if (((A)obj).a == a) {
                    return true;
                }
            }
            return super.equals(obj);
        }

        @Override
        public int hashCode() {
            return System.identityHashCode(a);
        }
    }
}
