package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class urinalsTest {

    operationsForUrinals operation = new operationsForUrinals();
    @Test
    void main() {
    }

    @Test
    void isValidString(){
        Assertions.assertEquals(true, operation.isValidString(new String("Manan Patel")));
        System.out.println("====== Manan Patel == TEST ONE EXECUTED =======");
    }

    @Test
    void countMaximumAvailableUrinals(){

    }
}