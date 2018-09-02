package com.vijfhart.casus.util;

import java.time.Duration;
import java.time.Instant;
import java.util.function.*;


public class Timer<T> {
   private Instant start;
   public void accept(T t, Consumer<T>  c) {
	   start = Instant.now();
	   c.accept(t);
	   printDuration();
   }
   public T get(Supplier<T> s) {
	   start = Instant.now();
	   T t = s.get();
	   printDuration();
	   return t;	
   }
   public <R> R apply(T t, Function<T,R> f) {
	   start = Instant.now();
	   R value = f.apply(t);
	   printDuration();
	   return value;
   }
   private void printDuration() {
	   Instant einde = Instant.now();
	   System.out.println("======================================");
	   System.out.println(Duration.between(start, einde));	   
   }
}
