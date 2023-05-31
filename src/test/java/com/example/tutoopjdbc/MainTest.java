package com.example.tutoopjdbc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void checkLeapYear() {  //MyUtils이 없어도 실행할 수 있음
        assertEquals(false, MyUtils.checkLeapYear(1700));
    }

    @Test
    void testLeapYear() {
        assertEquals(true, MyUtils.isLeapYear(2020));
        assertEquals(false, MyUtils.isLeapYear(1900));
        assertEquals(true, MyUtils.isLeapYear(2400));
    }

    @Test
    void testIs369() {
        assertEquals("*", MyUtils.is369(3));
        assertEquals("", MyUtils.is369(15));
        assertEquals("**", MyUtils.is369(33));
        assertEquals("***", MyUtils.is369(333));
        assertEquals("****", MyUtils.is369(3369));
    }
}