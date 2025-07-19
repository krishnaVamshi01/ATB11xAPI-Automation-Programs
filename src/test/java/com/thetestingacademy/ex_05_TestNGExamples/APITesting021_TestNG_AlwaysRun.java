package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.annotations.Test;

public class APITesting021_TestNG_AlwaysRun {

    @Test
    public void test_registeration(){
        System.out.println("registeration is done");
    }

    @Test(alwaysRun = true)
    public void test_Login(){
        System.out.println("Successful Login");
    }

    @Test
    public void test_NormalTest(){
        System.out.println("Normal Testing is being done");
    }
}
