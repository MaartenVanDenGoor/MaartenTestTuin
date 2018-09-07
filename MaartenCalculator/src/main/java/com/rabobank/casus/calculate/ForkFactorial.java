package com.rabobank.casus.calculate;

import java.math.BigInteger;
import java.util.concurrent.RecursiveTask;

public class ForkFactorial extends RecursiveTask<BigInteger> {
    private final long START, END;
    private final static int  THRESHOLD = 10;
    ForkFactorial(long start, long end) {
    	this.START = start;
    	this.END   = end;
    }
    ForkFactorial(long end) {
    	this(1,end);
    }    
	@Override
	protected BigInteger compute() {
		if (END - START < THRESHOLD) { 
			// NO SPLIT
			if (END <= 1) {
				return BigInteger.ONE;
			} else {
				BigInteger factorial = BigInteger.ONE;
				for (long count = START; count < END;count++) {
					factorial= factorial.multiply(BigInteger.valueOf(count));
				}
				return factorial;
			} 
		} else {
		   // SPLIT
			long mid = START + ((END-START)/2);
			ForkFactorial ff1 = new ForkFactorial(START,mid);
			ForkFactorial ff2 = new ForkFactorial(mid,END);
			ff1.fork();
			BigInteger val =ff2.compute().multiply(ff1.join());
			return val;
		}
	}

}
