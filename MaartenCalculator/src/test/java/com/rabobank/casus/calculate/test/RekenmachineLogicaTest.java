package com.rabobank.casus.calculate.test;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Test;

import com.rabobank.casus.calculate.RekenMachineLogica;
public class RekenmachineLogicaTest {
    @Test
    public void Test1() throws Exception
    {
        assertTrue( RekenMachineLogica.calculate("1 + 3 / 4").equals(BigDecimal.ONE) );
    }
    @Test
    public void Test2() throws Exception
    {
        assertTrue( RekenMachineLogica.calculate("2 * 5").compareTo(new BigDecimal(10))==0 );
    }   
    @Test
    public void Test3() throws Exception
    {
        assertTrue( RekenMachineLogica.calculate("2 * 4 - 2 / 3").compareTo(new BigDecimal(2))==0);
    }  
	
    @Test
    public void Test4()
    {   assertTrue( RekenMachineLogica.calculateS("1 / 0").equals("Ǝ") );
    } 
    @Test
    public void TestFaculteit()
    {   assertTrue( RekenMachineLogica.facultyRecursive(BigInteger.valueOf(10)).equals(BigInteger.valueOf(3628800)));
    }     
 }
