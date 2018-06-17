package com.vijfhart.casus.tree.stat;

import java.util.OptionalDouble;
import java.util.OptionalLong;

public class OptionalLongSummaryStatistics {
    private long count, validCount,  sum;
    private long min = Long.MAX_VALUE;
    private long max = Long.MIN_VALUE;
    private double average;
    public void accept(OptionalLong value) {
    	count++;
    	if (value.isPresent()) {
    		validCount++;
    		min = value.getAsLong() < min ? value.getAsLong():min;
    		max = value.getAsLong() > max ? value.getAsLong():max;
    		sum += value.getAsLong();
    		average = sum / validCount;
     	}
    }
    public long count() {
    	return count;
    }
    public long validCount() {
    	return validCount;
    }
    public OptionalLong min() {
    	return min==0?OptionalLong.empty():OptionalLong.of(min);
    }
    public OptionalLong max() {
    	return max==0?OptionalLong.empty():OptionalLong.of(max);
    }
    public OptionalLong sum() {
    	return sum==0?OptionalLong.empty():OptionalLong.of(sum);
    }    
    public OptionalDouble average() {
    	return average==0?OptionalDouble.empty():OptionalDouble.of(average);
    }
    public void combine(OptionalLongSummaryStatistics other) {
    	count += other.count;
    	validCount += other.validCount();
    	if (other.min().isPresent() ) {
    	min = other.min().getAsLong() < min?other.min().getAsLong():min;
    	}
    	if (other.max().isPresent() ) {
    	max = other.max().getAsLong() < max?other.min().getAsLong():max;
    	}
    	if (other.sum().isPresent()) {
    		sum += other.sum;
    	}
    	if (validCount != 0) {
    	   average = sum / validCount;
    	}
    }
    public String toString() {
    	StringBuilder ret = new StringBuilder("{ count: ")
    	                                    .append(count)
    	                                    .append(", validCount: ")
    	                                    .append(validCount)
    	                                    .append(", sum: ")
    	                                    .append(sum)
    	                                    .append(", min: ")
    	                                    .append(min)
    	                                    .append(", max: ")
    	                                    .append(max)
    	                                    .append(", average: ")
    	                                    .append(average)
    	                                    .append(" }");
    	return ret.toString();
    }
}
