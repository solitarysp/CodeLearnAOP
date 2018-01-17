package com.thanh.aspect;/*
  By Chi Can Em  15-01-2018
 */

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class EmployeeAspectPointcut {
    @Before("getNamePointcut()")// truyền methods lại vào đây để nơi đây mới là nơi thực hiện thật sự
    public void loggingAdvice() {
        System.out.println("getName() duoc goi tu mot methods Pointcut");
    }

    @Pointcut("execution(public String getName())")// dùng cut lấy để thực hiện tất cả methods public String getName()
    public void getNamePointcut() {
    }

    @Before("allMethodsPointcut()")// nơi thực hiện thật sự
    public void allServiceMethodsAdvice() {
        System.out.println("phuong thuc nao cung duoc goi. voi Pointcut within ");
    }

    @Pointcut("within(com.thanh.model.*)")//within tìm kiếm theo thư mục, tất cả methods trong thư mục đó sẽ đc tiêp AOP
    public void allMethodsPointcut() {
    }
}
