package com.oneby.circulardependency;

/**
 * @ClassName B
 * @Description TODO
 * @Author Oneby
 * @Date 2021/1/22 18:44
 * @Version 1.0
 */
public class B {
    private A a;

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public B() {
        System.out.println("---B created success");

    }
}
