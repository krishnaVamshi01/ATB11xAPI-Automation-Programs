package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.annotations.Test;

public class APITesting022_TestNG_invocationCount {

    @Test(invocationCount = 2)
    public void test1() {
        System.out.println("Hello");
    }

    @Test(invocationCount = 3)
    public void test2() {
        System.out.println("How are you");
    }
    @Test(invocationCount = 4)
    public void test3() {
        System.out.println("Have a Good day");
    }

}
