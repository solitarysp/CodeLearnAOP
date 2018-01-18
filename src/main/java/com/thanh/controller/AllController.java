package com.thanh.controller;/*
  By Chi Can Em  12-01-2018
 */

import com.thanh.aspect.EmployeeAroundAspect;
import com.thanh.aspect.EmployeeAspect;
import com.thanh.aspect.TestTuTaoAnnotation;
import com.thanh.model.Employee;
import com.thanh.model2.Student;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AllController {
    @Autowired
    Employee employee;
    @Autowired
    Student student;

    @TestTuTaoAnnotation
    @RequestMapping(value = "/test")
    public String Home() {
/*        employee.setName("fdvcv");
        employee.getName();
        employee.setThamSo1("test", "test2");
       // employee.throwException();
        System.out.println("get name student "+student.getName());*/

        // thông qua Proxy liên kết AOP.
        Student student1 = new Student();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory(student1);

        //Add Aspect class to the factory
        proxyFactory.addAspect(EmployeeAspect.class);
        proxyFactory.addAspect(EmployeeAroundAspect.class);

        //Get the proxy object
        Student proxyStudent = proxyFactory.getProxy();
        //Invoke the proxied method.
        proxyStudent.setName("test");
        proxyStudent.getName();

    /*    //không thông qua Proxy sẽ k liên kết AOp đc
        student1.setName("ff");
        student1.getName();*/
        return "home";
    }

    @RequestMapping(value = "/testEmployeeAfterAspectThrowing")
    public String testEmployeeAfterAspectThrowing() {
        employee.throwException();
        return "home";
    }

    @RequestMapping(value = "/AfterReturning")
    public String afterReturning() {
        employee.getName();
        return "home";
    }

    @TestTuTaoAnnotation
    @RequestMapping(value = "/testAnnotationAspect")
    public String testAnnotationAspect() {
        return "home";
    }

    @RequestMapping(value = "/testAroundAdvice")
    public String testAroundAdvice() {
        student.getName();
        return "home";
    }

    @RequestMapping(value = "/testEmployeeAspectBeforeAndAfter")
    public String testEmployeeAspectBeforeAndAfter() {
        student.getName1();
        return "home";
    }

    @RequestMapping(value = "/testEmployeeAspectJoinPointArgs")
    public String testEmployeeAspectJoinPointArgs() {
        employee.setThamSo1("test", "test");
        return "home";
    }
}
