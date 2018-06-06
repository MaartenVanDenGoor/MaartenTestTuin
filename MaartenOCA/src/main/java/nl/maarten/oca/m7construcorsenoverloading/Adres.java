package nl.maarten.oca.m7construcorsenoverloading;

public class Adres {
	    private String straatnaam;
	    private int huisnummer;
	    private String postcode;
	    private String plaats;
	    
	    public static void main(String[] args) {
	        Adres adres = new Adres("Dommer van Poldersveldweg",307,"Nijmegen");
	        System.out.println(adres);
	    }
	    Adres() {
	    }
	    Adres(String straatnaam,int huisnummer,String postcode,String plaats){
	        this.straatnaam = straatnaam;
	        this.postcode = postcode;
	        this.plaats = plaats;
	        this.huisnummer = huisnummer;
	    }
	    Adres(String straatnaam,int huisnummer,String plaats){
	        this(straatnaam,huisnummer,null,plaats);
	    }
	    Adres(String postcode,int huisnummer){
	        this(null,huisnummer,postcode,null);
	    }     
	    public void setStraatnaam (String straatnaam){
	        this.straatnaam = straatnaam;
	    }
	    public void setPostcode (String postcode){
	        this.postcode = postcode;
	    }
	     public void setPlaats (String plaats){
	        this.plaats = plaats;
	    }
	    public void setHuisnummer (int huisnummer){
	        this.huisnummer = huisnummer;
	    }
	    public String toString(){
	        return straatnaam+" "+huisnummer+"\n"+postcode+" "+plaats;
	    }
	    
	    
	}