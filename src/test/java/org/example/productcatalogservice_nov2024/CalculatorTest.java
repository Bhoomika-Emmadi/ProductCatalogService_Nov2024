package org.example.productcatalogservice_nov2024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    //methodName_when_then
    @Test
    public void AdditionOn2Integers_RunsSucessfully() {
        //arrange
        Calculator calculator = new Calculator();

        //act
        int result = calculator.add(1,2);

        //assert
        assert(result==3);
        assertEquals(3,result);
    }

    @Test
    public void DivideByZero_ThrowsException() {
        //arrange
        Calculator calculator = new Calculator();

        //act and assert
        assertThrows(ArithmeticException.class,
                ()->calculator.divide(1,0));
    }

}