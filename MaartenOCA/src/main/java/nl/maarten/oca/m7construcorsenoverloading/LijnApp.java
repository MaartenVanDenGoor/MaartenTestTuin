package nl.maarten.oca.m7construcorsenoverloading;

public class LijnApp{
    
    public static void main (String[] args) {
        Lijn l = new Lijn(0,1,4,5);
        System.out.println("Lengte "+l.getLengte());
        
    }

    
}
class Lijn {
    Punt a , b;
    Lijn (int x1,int x2, int y1,int y2){
        a = new Punt(x1,x2);
        b = new Punt(y1,y2);
    }
    float getLengte(){
        return a.getAfstand(b);
    }
    private class Punt {
        int x , y;
        Punt(int x, int y) {
            this.x = x;
            this.y = y;
        }
        private float getAfstand(Punt p){
            return (float) Math.sqrt(Math.pow(x-p.x,2)+Math.pow(y-p.y,2));
        }
    }
}