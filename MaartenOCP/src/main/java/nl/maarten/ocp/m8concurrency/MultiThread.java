package nl.maarten.ocp.m8concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiThread implements Runnable {
	AtomicInteger max = new AtomicInteger(0);
	AtomicInteger min = new AtomicInteger(101);
	List<Integer> lijst = new CopyOnWriteArrayList<>();
	//
	public static void main(String[] args) throws InterruptedException {

		MultiThread mt = new MultiThread();
		ArrayList<Thread> arrThreads = new ArrayList<Thread>();
		for (int i=1;i<=10;i++) {
			Thread thread = new Thread(mt);
			thread.start();
			arrThreads.add(thread);
		}
		// Wacht tot de laatste thread klaar is
        for (int i = 0; i < arrThreads.size(); i++) 
        {
            arrThreads.get(i).join(); 
        } 
	    System.out.println(mt.lijst);
	    System.out.println("Hoogste "+mt.max);
	    System.out.println("Laagste "+mt.min);
	}
	@Override
	public void run() {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100);
        max.updateAndGet(x -> (x>randomInt?x:randomInt));
        min.updateAndGet(x -> Math.min(x,randomInt));
        lijst.add(randomInt);
	}
}

/*
Maak een multi-threaded applicatie die 10 random int getallen genereert. 
De applicatie houdt bij wat de hoogste en de laagste waarde is, 
en stopt de gegenereerde getallen in een list. 
Toon na afloop de inhoud van de list, en de hoogste en laagste waarde. 

Tips:   

• Maak voor de hoogste en laagste waarde gebruik van twee AtomicInteger objecten, 
en gebruik daarin de nieuwe Java 8 method updateAndGet() met een lambda expressie.   
• Gebruik een concurrent collectie voor de lijst. 
*/