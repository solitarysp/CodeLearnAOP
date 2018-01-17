package com.thanh.aspect;/*
  By Chi Can Em  12-01-2018
 */

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmployeeAspect {
    @Before("execution(public String getName())")// gọi trước khi methods có dạng public String getName() đc thực hiện
    public void getNameAdvice() {
        System.out.println("Executing Advice on getName()");
    }

    @After("execution(public String getName())")//gọi sau
    public void getAllAdvice() {
        System.out.println("getName sau khi được gọi");
    }

}
