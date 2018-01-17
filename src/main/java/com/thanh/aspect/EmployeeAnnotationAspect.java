package com.thanh.aspect;/*
  By Chi Can Em  15-01-2018
 */

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmployeeAnnotationAspect {
    @Before("@annotation(com.thanh.aspect.Loggable)") // liên kết đến nhưng ai dùng annotation Loggable thì sẽ chạy biểu thưc này
    public void truockhigoi() {
        System.out.println("thuc hien truoc khi duoc goi voi Loggable");
    }

    @After("@annotation(com.thanh.aspect.Loggable)")// liên kết đến nhưng ai dùng annotation Loggable thì sẽ chạy biểu thưc này
    public void saukhigoi() {
        System.out.println("thuc hien sau khi duoc goi voi Loggable");
    }
}
