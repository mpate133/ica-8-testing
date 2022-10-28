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

    }

    @Test
    void countMaximumAvailableUrinals(){
        assertEquals(2, operation.countMaximumAvailableUrinals("10001"));
        System.out.println("======= '10001' ===== false case written");
    }
}