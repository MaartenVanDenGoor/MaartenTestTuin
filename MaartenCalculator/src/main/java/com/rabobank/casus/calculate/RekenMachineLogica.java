package com.rabobank.casus.calculate;

import org.apache.commons.lang3.math.NumberUtils;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RekenMachineLogica {
	private final static Logger LOGGER = Logger.getLogger(RekenMachineLogica.class.getName());
	public static void main(String[] args) {
		System.out.println(faculteit(10));
	}
	public static String calculateS(String str) {
		try {
			double d = calculate(str);
			if (Double.isInfinite(d)) {
				    LOGGER.log(Level.SEVERE, str);
					return  "Ǝ";
			} else {
				return ""+d;
			}
		} catch (Exception e) {
		    LOGGER.log(Level.SEVERE, str);
			return "Ǝ";
		}
	}
	public static double calculate(String str) {
		double ret = 0;
		String[] parts = str.split(" ");
		String action = null;
		//if (parts.length==2) return Double.valueOf(parts[0]);
		for (String s:parts) {
			if (NumberUtils.isNumber(s)) {
				double d = Double.parseDouble(s);
				if (action!=null) {
					switch (action) {
					case "+":
						ret = ret +d;
						break;
					case "-":
						ret -=d;
						break;
					case "/":
						ret /=d;
						break;
					case "*":
					    ret *=d;
					    break;
					}
				} else {
					ret = d;
				}
			}
			else {
				action = s;
				if (action.equals("n!")) {
					// niet parallelle berekening
				    int tmp = 1;
				    for (int i = 1; i <= ret; i++) 
				    {
				        tmp*= i;
				    }
				    // ret = tmp;
				    // niet parallelle recursieve berekening
				    ret = faculteit(ret);
				    // 	parallelle berekening forkjoin
				}
			}
		}
		return ret;
	}
    public static double faculteit(double d) {
    	if (d==1) return 1;
    	return d * faculteit(--d);
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
