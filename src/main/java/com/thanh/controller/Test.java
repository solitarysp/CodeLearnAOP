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
public class Test {
    @Autowired
    Employee employee;
    @Autowired
    Student student;

    @TestTuTaoAnnotation
    @RequestMapping(value = "/test")
    public String Home() {
/*        employee.setName("fdvcv");
        employee.getName();
        employee.getThamSo1("test", "test2");
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
}
