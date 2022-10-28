package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class urinalsTest {

    operationsForUrinals operation = new operationsForUrinals();
    @Test
    void main() {
    }

    @Test
    void isValidString(){
        assertEquals(false, operation.isValidString("Manan Patel"));
        System.out.println("====== Manan Patel == TEST ONE EXECUTED For Validation=======");
        assertEquals(true, operation.isValidString("100"));
        assertEquals(false, operation.isValidString("0011"));
        assertEquals(true, operation.isValidString("1001"));
        assertEquals(true, operation.isValidString("01010100"));
        assertEquals(false, operation.isValidString("10111"));
        assertEquals(true, operation.isValidString("01010100"));
        assertEquals(true, operation.isValidString("00100"));
        assertEquals(false, operation.isValidString("1111"));
        assertEquals(true, operation.isValidString("0000"));
        assertEquals(true, operation.isValidString("01"));


    }

    @Test
    void countMaximumAvailableUrinals(){
        assertEquals(1, operation.countMaximumAvailableUrinals("10001"));
        System.out.println("======= '10001' ===== Fist test case for counting urinals executed");
        assertEquals(4, operation.countMaximumAvailableUrinals("1000100001000001"));
        assertEquals(0, operation.countMaximumAvailableUrinals("010101"));
        assertEquals(0, operation.countMaximumAvailableUrinals("101001"));
        assertEquals(2, operation.countMaximumAvailableUrinals("10000001"));
        assertEquals(3, operation.countMaximumAvailableUrinals("00000"));
        assertEquals(2, operation.countMaximumAvailableUrinals("00100"));
        assertEquals(2, operation.countMaximumAvailableUrinals("0000"));
        assertEquals(0, operation.countMaximumAvailableUrinals("01"));

    }
}