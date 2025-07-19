package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.annotations.Test;

public class APITesting020_TestNG_Enabled {

    @Test(enabled = true)
    public void test1() {
        System.out.println("test 1");
    }

    @Test(enabled = true)
    public void test2() {
        System.out.println("test 1");
    }
    @Test(enabled = false)
    public void test3() {
        System.out.println("test 1");
    }
}