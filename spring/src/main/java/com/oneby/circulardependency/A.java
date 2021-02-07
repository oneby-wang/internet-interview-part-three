package com.oneby.circulardependency;

/**
 * @ClassName A
 * @Description TODO
 * @Author Oneby
 * @Date 2021/1/22 18:44
 * @Version 1.0
 */
public class A {
    private B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public A() {
        System.out.println("---A created success");
    }
}
