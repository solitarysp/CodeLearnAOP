package com.thanh.aspect;/*
  By Chi Can Em  17-01-2018
 */

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TestTuTaoAnnotationExcu {// liên kết đến nhưng ai dùng annotation TestTuTaoAnnotation thì sẽ chạy biểu thưc này

    @Before("@annotation(com.thanh.aspect.TestTuTaoAnnotation)")
    public void test() {
        System.out.println("TestTuTaoAnnotation    Before");
    }

    @After("@annotation(com.thanh.aspect.TestTuTaoAnnotation)")
    public void after() {
        System.out.println("TestTuTaoAnnotation   After");
    }
}
