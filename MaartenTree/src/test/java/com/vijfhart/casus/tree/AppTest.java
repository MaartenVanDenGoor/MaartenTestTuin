package com.vijfhart.casus.tree;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    NameNode a     = new NameNode("A");
    NameNode c     = new NameNode("C",a);
    NameNode b     = new NameNode("B",a);
    NameNode b1     = new NameNode("B1",b);
    NameNode b2     = new NameNode("B2",b);
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    public void testLevelA(){
    	assertTrue( a.compareTo(b)==-1 );
    }
    public void testLevelB(){
    	assertTrue( b.compareTo(c)==-1 );
    }
    public void testLevelC(){
    	assertTrue( b1.compareTo(c)==-1 );
    }  
    public void testLevelD(){
    	assertTrue( b1.compareTo(c)==-1 );
    }
    public void testLevelE(){
    	assertTrue( c.compareTo(b2)==-1 );
    }  
}
