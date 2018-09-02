package com.vijfhart.casus.tree.stat;
import java.util.OptionalDouble;

public class OptionalDoubleSummaryStatistics {


   private long count, validCount;
   double sum, min=Double.MAX_VALUE, max=Double.MIN_VALUE;

   public OptionalDoubleSummaryStatistics(){}


   public void add(OptionalDouble value){
     count++;
     if(value.isPresent()){
       double x = value.getAsDouble();
       validCount++;
       sum+=x;
       if(x<min)min=x;
       if(x>max)max=x;
     }
   }

   public void combine(OptionalDoubleSummaryStatistics other){
     this.sum+=other.sum;
     this.count+=other.count;
     this.validCount+=other.validCount;
     if(other.min<this.min)this.min=other.min;
     if(other.max>this.max)this.max=other.max;
   }
   

  public OptionalDouble sum() { return validCount==0?OptionalDouble.empty():OptionalDouble.of(sum); }
  public long count() { return count; }
  public long validCount() { return validCount; }
  public OptionalDouble average() { return validCount==0?OptionalDouble.empty():OptionalDouble.of((double)sum/validCount); }
  public OptionalDouble min() { return validCount==0?OptionalDouble.empty():OptionalDouble.of(min); }
  public OptionalDouble max() { return validCount==0?OptionalDouble.empty():OptionalDouble.of(max); }

  public String toString(){
    StringBuilder sb = 
         new StringBuilder("{ count: ")     
        .append(count)
        .append(", validCount: ")
        .append(validCount);
    if(validCount>0) { 
      sb.append(", sum: ").append(sum)
        .append(", min: ").append(min)
        .append(", max: ").append(max)
        .append(", average: " ).append(average().getAsDouble());
    }
    return sb.append(" }").toString();
  }

}