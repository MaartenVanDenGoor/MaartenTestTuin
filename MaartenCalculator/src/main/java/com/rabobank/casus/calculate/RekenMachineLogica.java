package com.rabobank.casus.calculate;

import org.apache.commons.lang3.StringUtils;


import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.ForkJoinPool;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RekenMachineLogica {
	private final static Logger LOGGER = Logger.getLogger(RekenMachineLogica.class.getName());
	public static void main(String[] args) {
		System.out.println(facultyRecursive(BigInteger.valueOf(1000)));
	//	System.out.println(calculateS("10 * 0.1"));
	//	System.out.println(isValidString("1."));
	//	System.out.println(StringUtils.isNumeric("-1"));
		try {
		System.out.println(calculate("2 * 5"));
		  if (calculate("2 * 5").compareTo(new BigDecimal(10.0))==0)
				   {
			  System.out.println("true");
		  } else {
			  System.out.println("false");
		  }
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	/**
	 * Execute a calculation
	 * @param str contains a calculation, eg "1 + 3 / 2" where
	 *        commands an numbers are seperated by a space
	 * @return result of the calculation as a String, in case of an
	 *        error "Ǝ" is returned
	 */
	public static String calculateS(String str) {
		try {
			return ""+ calculate(str);
		} catch (Exception e) {
		    LOGGER.log(Level.SEVERE, e.getMessage()+" "+str);
			return "Ǝ";
		}
	}
	/**
	 * Calculate a calculation
	 * @param str contains a calculation, eg "1 + 3 / 2" where
	 *        commands an numbers are seperated by a space
	 * @return true  if parameter str contains valid calculation
	 *         false if parameter str does not contain valid calculation
	 */
	public static boolean isValidString(String str) {
		// Validate String, number and command must alternate
		String[] parts = str.split(" ");
		String vorig = null;
		for (String s:parts) {
			if (vorig==null || !isValidDouble(vorig)) {
				// If first part or after command must follow a number
				if (!isValidDouble(s)) return false;
			} else {
				// After a number should follow a valid command
				if (invalidCommand(s)) return false;
			}
			vorig = s;
       	}
		
		return true;
	}
	/*
	 * Validate if command is valid
	 */
	private static boolean invalidCommand(String s) {
		if (!s.equals("+") &&
			!s.equals("-") &&
			!s.equals("*") &&
			!s.equals("/") &&
			!s.equals("n!") &&
			!s.equals("=")  ) return true;
		return false;
				
	}
	/**
	 * Calculate a calculation
	 * @param str contains a calculation, eg "1 + 3 / 2" where
	 *        commands an numbers are seperated by a space
	 * @return Result of the calculation
	 * @throws Exception in case of invalid string or innvalid operation
	 */
	public static BigDecimal calculate(String str) throws Exception{
		if (!isValidString(str)) throw new Exception("Not a valid string to calculate");
		BigDecimal ret =  BigDecimal.ZERO;
		String[] parts = str.split(" ");
		String action = null;
		//if (parts.length==2) return Double.valueOf(parts[0]);
		for (String s:parts) {
			if ( isValidDouble(s)) {
				double d = Double.parseDouble(s);
				BigDecimal b= BigDecimal.valueOf(d);
				if (action!=null) {
					switch (action) {
					case "+":
						ret = ret.add(b);
						break;
					case "-":
						ret = ret.subtract(b);
						break;
					case "/":
						ret  = ret.divide(b);
						break;
					case "*":
					    ret = ret.multiply(b);
					    break;
					}
				} else {
					ret = b;
				}
			}
			else {
				action = s;
				if (action.equals("n!")) {
					if (ret.compareTo(BigDecimal.ZERO) < 0 )
						throw new Exception("Faculty of negative number can not be done");
					/*
					// niet parallelle berekening
					BigInteger tmp = BigInteger.ONE;
				    for (int i = 1; i <= ret.intValue(); i++) 
				    {
				        tmp = tmp.multiply(BigInteger.valueOf(i));
				    }
				    // ret = tmp;
				    // niet parallelle recursieve berekening
				    tmp = ret.toBigInteger();
			    	tmp = facultyRecursive(tmp);
				    //ret =  new BigDecimal(tmp);
			    	*/
				    // 	parallelle berekening forkjoin
				    ForkJoinPool fjPool = new ForkJoinPool();
				    ForkFactorial ff = new ForkFactorial(ret.intValue());
				    ret = new BigDecimal(fjPool.invoke(ff));
				    fjPool.shutdown();
				}
			}
		}
		return ret;
	}
    public static BigInteger facultyRecursive(BigInteger d) {
    	if (d.equals(BigInteger.ONE)) return BigInteger.ONE;
    	return d.multiply(facultyRecursive(d.subtract(BigInteger.ONE)));
    }	
    private static boolean isValidDouble(String s) {
    	try {
    		double d = Double.parseDouble(s);
    		return true;
    	} catch (Exception e) {
    		return false;
    	}
    }
	static {
		FileHandler fh;
		try {
			fh = new FileHandler("C:/tmp/RekenMachineLogica.log");
			LOGGER.addHandler(fh);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}
}
