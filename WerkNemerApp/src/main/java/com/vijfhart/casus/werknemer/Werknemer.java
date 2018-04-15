package com.vijfhart.casus.werknemer;

public class Werknemer implements Comparable<Werknemer> {
	private int nummer;
	private String naam;
	private double salaris;
	private Functie functie;
	private int manager;

	public Werknemer(int nummer,String naam,  Functie functie,int manager,double salaris) {
		super();
		this.nummer = nummer;
		this.naam = naam;
		this.functie = functie;
        this.manager = manager;
		this.salaris = salaris;
	}
	public int getManager() {
		return manager;
	}
	public void setManager(int manager) {
		this.manager = manager;
	}
	public int getNummer() {
		return nummer;
	}
	public void setNummer(int nummer) {
		this.nummer = nummer;
	}
	@Override
	public int compareTo(Werknemer arg0) {
		// compare op naam
		return naam.compareToIgnoreCase(arg0.getNaam());
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(String.format("%1$-5s",nummer  ));
		sb.append(String.format("%1$-20s",naam  ));
		sb.append(String.format("%1$-20s",functie  ));
		sb.append(String.format("%1$-20s",salaris  )); 
		//
		return sb.toString();
	}	
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public double getSalaris() {
		return salaris;
	}
	public void setSalaris(double salaris) {
		this.salaris = salaris;
	}
	public Functie getFunctie() {
		return functie;
	}
	public void setFunctie(Functie functie) {
		this.functie = functie;
	}
}
