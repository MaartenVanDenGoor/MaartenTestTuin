package com.vijfhart.casus.util;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Timer<T> {
	   private Instant start;
   public void accept(T t, Consumer<T>  c) {
	   start = Instant.now();
	   c.accept(t);
	   printDuration();
   }
   public void get(Supplier<T> s) {
	   start = Instant.now();
	   s.get();
	   printDuration();
   }
   public void apply(T t, Function<T,String> f) {
	   start = Instant.now();
	   f.apply(t);
	   printDuration();
   }
   private void printDuration() {
	   Instant einde = Instant.now();
	   System.out.println("======================================");
	   System.out.println(Duration.between(start, einde));	   
   }
}
