package com.thanh.aspect;/*
  By Chi Can Em  15-01-2018
 */

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class EmployeeAspectJoinPoint {
    @Before("args(thamso,thamso2)")// chạy theo tham số truyền vào tìm emthods có 2 tham số Spring truyền vào sẽ chạy emthods này
    public void testArgs(String thamso, String thamso2) {// chỉ những methods có 2 đối số là String sẽ nhận đc
        System.out.println("String argument passed=" + thamso + "  " + thamso2);
    }
}
