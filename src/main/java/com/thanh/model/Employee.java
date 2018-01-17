package com.thanh.model;/*
  By Chi Can Em  12-01-2018
 */

import com.thanh.aspect.Loggable;

public class Employee {
    private String name;

    public String getName() {
        System.out.println("thực hien get name");
        return name;
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee() {
    }

    @Loggable
    public void setName(String name) {
        System.out.println("thuc hien setName");
        System.out.println("thuc hien setName");
        this.name = name;
    }

    public void getThamSo(String thamso) {
        System.out.println(thamso);
    }

    public void getThamSo1(String thamso1, String thamso2) {
    }

    public void throwException() {
        throw new RuntimeException("Dummy Exception");
    }


}
