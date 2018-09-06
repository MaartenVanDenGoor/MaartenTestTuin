package com.rabobank.casus.calculate.test;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.rabobank.casus.calculate.RekenMachineLogica;
public class RekenmachineLogicaTest {
    @Test
    public void Test1()
    {
        assertTrue( RekenMachineLogica.calculate("1 + 3 / 4")==1 );
    }
    @Test
    public void Test2()
    {
        assertTrue( RekenMachineLogica.calculate("2 * 5")==10 );
    }   
    @Test
    public void Test3()
    {
        assertTrue( RekenMachineLogica.calculate("2 * 4 - 2 / 3")==2 );
    }  
	
    @Test
    public void Test4()
    {   assertTrue( RekenMachineLogica.calculateS("1 / 0").equals("Ǝ") );
    } 
    @Test
    public void TestFaculteit()
    {   assertTrue( RekenMachineLogica.faculteit(10)==3628800.0 );
    }     
 }
