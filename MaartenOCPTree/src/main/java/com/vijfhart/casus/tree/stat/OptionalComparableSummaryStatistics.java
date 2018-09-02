package com.vijfhart.casus.tree.stat;
import java.util.Optional;

public class OptionalComparableSummaryStatistics<T extends Comparable<T>> {

  
   private T min, max;
   private long count, validCount;

   public OptionalComparableSummaryStatistics(){}


   public void add(Optional value){
      count++;
      if(value.isPresent()){
        T val = (T) value.get();
        validCount++;
        if(min==null)min=val;
        if(max==null)max=val;
        if(val.compareTo(min)<0)min=val;
        if(val.compareTo(max)>0)max=val;
      }
   }

   public void combine(OptionalComparableSummaryStatistics<T> other){
     this.count+=other.count;
     this.validCount+=other.validCount;
     if(this.min==null&&other.min!=null)this.min=other.min;
     if(this.max==null&&other.min!=null)this.max=other.max;
     if(this.min!=null&&other.min!=null){
       if(this.min.compareTo(other.min)>0)this.min=other.min;
	 }
     if(this.max!=null&&other.max!=null){
 	   if(this.max.compareTo(other.max)<0)this.max=other.max;
	 }
  }
   

  public long count() { return count; }
  public long validCount() { return validCount; }
  public Optional<T> min() { return validCount==0?Optional.empty():Optional.of(min); }
  public Optional<T> max() { return validCount==0?Optional.empty():Optional.of(max); }

  public String toString(){
    StringBuilder sb = 
         new StringBuilder("{ count: ")     
        .append(count)
        .append(", validCount: ")
        .append(validCount);
    if(validCount>0) { 
        sb.append(", min: ").append(min)
          .append(", max: ").append(max);
    }
    return sb.append(" }").toString();
  }
}

