package nl.maarten.ocp.m8concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DobbelSpelApp {

	public static void main(String[] args) {
		DobbelSpel DobbelSpel1 = new DobbelSpel(1);
		new Thread(DobbelSpel1).start();
        //
		DobbelSpel DobbelSpel2 = new DobbelSpel(2);		
		ExecutorService service = null;
		try {service = Executors.newFixedThreadPool(1);
		     service.execute(DobbelSpel2);
		} finally {
			if (service!=null) {
				service.shutdown();
			}
		}
		//
		DobbelSpel DobbelSpel3 = new DobbelSpel(3);		
		List<Callable<DobbelSpel>> lijst = new ArrayList<>();
		List<Future<DobbelSpel>> lijstF = null;
		lijst.add(DobbelSpel3);
		try {service = Executors.newFixedThreadPool(1);
	         lijstF = service.invokeAll(lijst);
	    } catch (Exception e) {
	    	System.out.println(e.getMessage());
	    }
		finally {
		   if (service!=null) {
			service.shutdown();
		}
	  }
	}
	private static void tryGet(Future<DobbelSpel> future) {
		
	}
}
class DobbelSpel implements Runnable, Callable {

	private int nummer;
	DobbelSpel (int nummer) {
		this.nummer = nummer;
	}
	@Override
	public void run() {
	    for (int i=1;i<=10;i++) {
	        int worp =(int)(Math.random()*6+1);
	        System.out.println(nummer+" worp "+i+": "+worp);
	    }
	    System.out.println("Einde dobbelspel "+nummer);
	}
	@Override
	public Object call() throws Exception {
		run();
		return null;
	}
	
}
