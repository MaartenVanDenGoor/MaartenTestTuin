package com.vijfhart.casus.tree.memo;

public class Memo implements Comparable<Memo>{
	private String titel;
	private String memo;
	public Memo(String titel, String memo) {
		this.titel = titel;
		this.memo = memo;
	}
	public Memo(String titel) {
		this(titel,null);
	}	
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	@Override
	public String toString() {
		return memo==null?titel:titel+": "+memo;
	}
	@Override
	public int compareTo(Memo that) {
		// TODO Auto-generated method stub
		if (this==that) return 0;
		return this.titel.compareTo(that.getTitel());
	}

	
}
