package nl.maarten.ocp.m9javaio;

import java.io.*;
import java.util.Collection;
import java.util.ArrayList;
import java.nio.file.*;

public class WerknemersKantoren {   
  // een dubbele backslash om niet aan te geven dat er een escape karakter gebruikt moet worden
  private static String LOKATIE = ".\\";
  private static File f = new File(LOKATIE+"werknemers_kantoren.txt");

  public static void main(String[] args)  {
    maakObjecten();
    leesObjecten();
  }
    
  static void maakObjecten(){
    try(FileReader in = new FileReader(f);
        BufferedReader bin = new BufferedReader(in)) {
      boolean end = false;
      while (!end) {
          Werknemer werkn = new Werknemer();
          int persnr = Integer.parseInt(bin.readLine());
          werkn.setPersnr(persnr);
          werkn.setNaam(bin.readLine());
          werkn.setFunctie(bin.readLine());
          werkn.setSal(Integer.parseInt(bin.readLine()));

          Kantoor kant = new Kantoor();
          kant.setKantnr(Integer.parseInt(bin.readLine()));
          kant.setNaam(bin.readLine());
          kant.setPlaats(bin.readLine());
          werkn.setKantoor(kant);
          if (bin.readLine() == null) {
            end = true;
          }
          // Schrijf hieronder het object werkn weg als een object met extensie .obj:
          try (FileOutputStream f = new FileOutputStream(LOKATIE+werkn.getNaam()+".obj");
        	   BufferedOutputStream b = new BufferedOutputStream(f);
        	   ObjectOutputStream out = new ObjectOutputStream(b);
        	) {
        		out.writeObject(werkn);
        	}
      }
    }
    catch (IOException e) {
      e.printStackTrace(); 
    }
  }
  
  static void leesObjecten() {
    Collection<Werknemer> werknemers = new ArrayList<Werknemer>();
    File dir = new File(LOKATIE);
    String[] listing = dir.list();
    for (int i=0; i<listing.length; i++) {
      if (listing[i].endsWith(".obj")) {
	   // lees hieronder werknemer in en voeg toe aan de collectie werknemers
       try (FileInputStream f = new FileInputStream(LOKATIE+listing[i]);
    		BufferedInputStream b = new BufferedInputStream(f);
    		ObjectInputStream in = new ObjectInputStream(b);
    		) {
      	        werknemers.add((Werknemer) in.readObject());
       } catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
            
      }
    }
    if (werknemers != null && werknemers.size()>0) {
	   // doorloop de werknemers collectie
       // en schrijf elke werknemer als regel weg in werknemers_tabel.csv
       PrintStream stdout = System.out;
       File file = new File(LOKATIE+"werknemers_tabel.csv");
       try (PrintStream ps = new PrintStream(file);
    		){
		      System.setOut(ps);    	  
		      for(Werknemer werkn: werknemers){
		            Kantoor kant = werkn.getKantoor();
		            // System.out schrijft nu naar bestand
		            System.out.printf("%d,%s,%s,%d,%d,%s,%s%n",
		                           werkn.getPersnr(),
		                           werkn.getNaam(),
		                           werkn.getFunctie(),
		                           werkn.getSal(),
		                           kant.getKantnr(),
		                           kant.getNaam(),
		                           kant.getPlaats());
		         }
		      } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				System.setOut(stdout); 
			}
       System.out.println("klaar");
      }
  }
}
