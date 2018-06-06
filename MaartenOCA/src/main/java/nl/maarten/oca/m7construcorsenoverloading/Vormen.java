package nl.maarten.oca.m7construcorsenoverloading;

public class Vormen{
    public static void main (String[] args){
        Kubus k = new Kubus(2);
        System.out.println("Inhoud "+k.getInhoud());
        System.out.println("Opp.   "+k.getOppervlakte());
        
    }
}
abstract class Vorm {
    abstract public int getOppervlakte();
}

class Rechthoek extends Vorm {
    private int breedte;
    private int hoogte;   
    Rechthoek(int breedte,int hoogte){
        this.breedte = breedte;
        this.hoogte  = hoogte;
    }
    @Override
    public int getOppervlakte() {
        return hoogte * breedte;
    }
    public int  getBreedte(){
        return breedte;
    }
    public void  setBreedte(int breedte){
        this.breedte = breedte;
    }
    public int  getHoogte(){
        return hoogte;
    }
    public void  setHoogte(int hoogte){
        this.hoogte = hoogte;
    }     
}
class Vierkant extends Rechthoek {
    Vierkant(int zijde){
        super(zijde,zijde);
    }
}
abstract class Vorm3d extends Vorm {
    public abstract  int getInhoud();
}
class Balk extends Vorm3d {
    private int diepte;
    private int breedte;
    private int hoogte;
    //
    Balk(int breedte,int hoogte,int diepte) {
        this.breedte = breedte;
        this.hoogte  = hoogte;
        this.diepte  = diepte;
    }
    @Override
    public int getOppervlakte() {
     return 2* (hoogte*breedte + hoogte*diepte + breedte*diepte);
    }
    public int getInhoud() {
        return hoogte*breedte *diepte;
    }    
}
class Kubus extends Balk {
    Kubus(int zijde) {
        super(zijde,zijde,zijde);
    }
}
