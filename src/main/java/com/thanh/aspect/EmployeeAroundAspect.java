package com.thanh.aspect;/*
  By Chi Can Em  15-01-2018
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class EmployeeAroundAspect {
    // một dạng xunh qoanh, ví dụ như trước và sau, cái này cũng dạng vậy nhưng phía trước
    //proceedingJoinPoint.proceed() sẽ là trước, sau nó sẽ là sau.
    // nếu k gọi proceedingJoinPoint.proceed() thì chỉ có trước và k vào methods và k có sau
    @Around("within(com.thanh.model2.*)")
    public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("bat dau Around truoc khi vao methods");
        proceedingJoinPoint.proceed(); // nếu k khai báo dòng này, sẽ không chạy vào methos thực hiện, sẽ chạy đến đây và tạm dừng
        System.out.println(" kết thúc.");

        return null;
    }
}
