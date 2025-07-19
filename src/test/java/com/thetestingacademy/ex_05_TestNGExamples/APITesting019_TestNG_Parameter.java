package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITesting019_TestNG_Parameter {

    @Parameters("browser")
    @Test
    public void demo1(String value){
        System.out.println("hi am demo browser");
        System.out.println("hey!browser param is running");

        if(value.equalsIgnoreCase("chrome")){
            System.out.println("chrome is running");
        }
        if(value.equalsIgnoreCase("Firefox")){
            System.out.println("fire fox is running");
        }
    }

}
