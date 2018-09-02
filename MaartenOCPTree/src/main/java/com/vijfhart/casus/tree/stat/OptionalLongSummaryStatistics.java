package com.vijfhart.casus.tree.stat;

import java.text.NumberFormat;
import java.util.*;
import java.util.OptionalDouble;
import java.util.OptionalLong;

public class OptionalLongSummaryStatistics {
	private long count, validCount,  sum;
	private long min = Long.MAX_VALUE;
	private long max = Long.MIN_VALUE;
	private double average;
	private ResourceBundle lables;
	public void accept(OptionalLong value) {
		count++;
		if (value.isPresent()) {
			validCount++;
			long x = value.getAsLong();
			min = x < min ? x:min;
			max = x > max ? x:max;
			sum += x;
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
			max = other.max().getAsLong() < max?other.max().getAsLong():max;
		}
		if (other.sum().isPresent()) {
			sum += other.sum;
		}
		if (validCount != 0) {
			average = sum / validCount;
		}
	}
	public String toString(ResourceBundle lables) {
		this.lables = lables;
		StringBuilder ret = new StringBuilder("{ ") 
				.append(lables.getString("count"))
				.append(": ")
				.append(count)
				.append(LabelMaker("validCount"))
				.append(validCount)
				.append(LabelMaker("sum"))
				.append(sum)
				.append(LabelMaker("min"))
				.append(min)
				.append(LabelMaker("max"))
				.append(max)
				.append(LabelMaker("avg"))
				.append(average)
				.append(" }");
		return ret.toString();
	}
	private String LabelMaker(String label) {
		return new StringBuilder(", ")
				.append(lables.getString(label))
				.append(": ")
				.toString();
	}
	public String toStringHumanReadable(ResourceBundle lables){
		this.lables = lables;
		StringBuilder sb = 
				new StringBuilder("{ ")     
				.append(lables.getString("count")).append(": ")
				.append(humanReadable(count))
				.append(LabelMaker("validCount")).append(humanReadable(validCount));
		if(validCount>0) { 
			sb.append(LabelMaker("sum")).append(humanReadable(sum))
			.append(LabelMaker("min")).append(humanReadable(min))
			.append(LabelMaker("max")).append(humanReadable(max))
			.append(LabelMaker("avg")).append(humanReadable(average().orElse(0)));
		}
		return sb.append(" }").toString();
	}


	private String humanReadable(double value){
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(2);
		if(value<1000) return nf.format(value);
		if(value<1_000_000) return nf.format(value/1000D)+"K";
		if(value<1_000_000_000) return nf.format(value/1_000_000D)+"M";
		return nf.format(value/1_000_000_000D)+"G";
	}    
}
