package com.thanh.aspect;/*
  By Chi Can Em  15-01-2018
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class EmployeeAfterAspect {
    @AfterThrowing("within(com.thanh.model.*)")// bắt các lôi ngoại lệ thì sẽ chạy
    public void logExceptions(JoinPoint joinPoint) {
        System.out.println("có lỗi gì đó. bug bug bug" + joinPoint.getKind());
    }
    @AfterReturning(returning = "re",pointcut = "within(com.thanh.model.*)")// lấy tất cả methods trả về String
    public void getReturningAdvice(String re) {
        System.out.println("AfterReturning  "+re);
    }
}
