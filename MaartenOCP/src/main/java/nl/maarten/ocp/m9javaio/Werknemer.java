package nl.maarten.ocp.m9javaio;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Werknemer implements Serializable {

	  private int persnr;
	  private String naam;
	  private String functie;
	  private int sal;
	  private Kantoor kantoor;

	  final static long serialVersionUID=1;
	 

	  public Werknemer() {
	  }

	  public int getPersnr() {
	    return persnr;
	  }

	  public void setPersnr(int persnr) {
	    this.persnr = persnr;
	  }

	  public String getNaam() {
	    return naam;
	  }

	  public void setNaam(String naam) {
	    this.naam = naam;
	  }

	  public String getFunctie() {
	    return functie;
	  }

	  public void setFunctie(String functie) {
	    this.functie = functie;
	  }

	  public int getSal() {
	    return sal;
	  }

	  public void setSal(int sal) {
	    this.sal = sal;
	  }

	  public Kantoor getKantoor() {
	    return kantoor;
	  }

	  public void setKantoor(Kantoor kantoor) {
	    this.kantoor = kantoor;
	  }
      private void writeObject(ObjectOutputStream out) throws IOException {
    	  out.writeInt(persnr);
    	  out.writeUTF(naam);
    	  out.writeUTF(functie);
    	  out.writeObject(kantoor);
      }
      private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    	  persnr  = in.readInt();
    	  naam    = in.readUTF();
    	  functie = in.readUTF();
    	  kantoor = (Kantoor) in.readObject();
      }      

	}
