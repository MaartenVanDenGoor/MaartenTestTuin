package nl.maarten.ocp.m7exceptions;

import java.io.IOException;
import java.util.stream.*;

public class BronApp  {
	public static void main(String[] args) {
		
//        try (Bron a = new Bron("a");Bron b = new Bron("b")) {
//            Bron[] blijst = {a,b};
//            Stream.of(blijst)
//                  .onClose(() -> System.out.println("OnClose"))
//                  .forEach(Bron::open);            
//         }

        try (Bron a = new Bron("a");
        	 Bron b = new Bron("b");
        		Stream<Bron> stream = Stream.of(a,b)) {
                     stream.onClose(() -> System.out.println("OnClose"))
        		      .forEach(Bron::open);
          }
	}
}
class Bron implements AutoCloseable {
    private String naam;
    Bron(String naam) {
        this.naam = naam;
    }
    public void open()// throws IOException
    {
        System.out.println("Open "+naam);
    //    throw new IOException();

    }
    public void close(){
        System.out.println("Close "+naam);
    }    
}
/*
 In de voorbeelden bij dit hoofdstuk werden varianten van een class Bron gebruikt. Maak in een class BronApp een Stream aan
 van twee Bron objecten en doorloop deze stream, waarbij de bronnen geopend worden. Stream is zelf ook AutoCloseable.
 Toon d.m.v. ARM aan dat ook de close() van Stream automatisch wordt gesloten.  

Tip: 

• gebruik de onClose() method van BaseStream. Hieraan moet een functional interface worden meegegeven: bepaal aan de hand van
de signatuur van de method van deze interface wat voor lambda-expressie in de onClose() method kan worden meegegeven. 
*/