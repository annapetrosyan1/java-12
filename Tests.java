package com.company;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class Tests {
    @Test
    public void Test_EmptyString(){
        var exception = assertThrows(NumberFormatException.class, () -> Integer.decode(""));

        assert "Zero length string".equals(exception.getMessage());
    }

    @Test
    public void Test_InvalidFormatNumber(){
        var exception = assertThrows(NumberFormatException.class, () -> Integer.decode("#-1"));

        assert "Sign character in wrong position".equals(exception.getMessage());
    }

    @Test
    public void Test_StringWithPositiveNumber(){
        var value = Integer.decode("5");

        assert 5 == value;
    }

    @Test
    public void Test_StringWithNegativeNumber(){
        var value = Integer.decode("-1");

        assert -1 == value;
    }

    @Test
    public void Test_Positive16RadixNumber(){
        assert 0xf1f == Integer.decode("0xf1f");
        assert 0x1dc == Integer.decode("0X1dc");
        assert 0xf1 == Integer.decode("#f1");
    }

    @Test
    public void test_Negative16HexDigits() {
        assert -0xAF2 == Integer.decode("-0xAF2");
        assert -0X5B == Integer.decode("-0X5B");
        assert -0xF1 == Integer.decode("-#F1");
    }

    @Test
    public void test_Positive8RadixNumber(){
        assert 35 == Integer.decode("043");
        assert 62 == Integer.decode("076");
        assert 45 == Integer.decode("055");
    }

    @Test
    public void test_Negative8RadixNumber(){
        assert -35 == Integer.decode("-043");
        assert -62 == Integer.decode("-076");
        assert -45 == Integer.decode("-055");
    }
}