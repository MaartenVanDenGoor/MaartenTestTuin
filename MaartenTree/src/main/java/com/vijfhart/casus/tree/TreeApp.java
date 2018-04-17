																																																																																						package com.vijfhart.casus.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.ToLongFunction;
import java.util.function.ToDoubleFunction;

/**
 * Hello world!
 *
 */
public class TreeApp 
{
    public static void main( String[] args )
    {
    	
    	NameNode kraay     = new NameNode("Kraay");
    	NameNode pieters   = new NameNode("Pieters",kraay);
    	NameNode sanders   = new NameNode("Sanders",pieters);
    	NameNode adelaar   = new NameNode("Adelaar",sanders);
    	NameNode vermeulen = new NameNode("Vermeulen",pieters);
    	NameNode smits     = new NameNode("Smits",vermeulen);
    	NameNode brandsma  = new NameNode("Brandsma",kraay);
    	NameNode alkema    = new NameNode("Alkema",brandsma);
    	NameNode walstra   = new NameNode("Walstra",brandsma);
    	NameNode vergeer   = new NameNode("Vergeer",brandsma);
    	NameNode dost      = new NameNode("Dost",brandsma);
    	NameNode appel     = new NameNode("Appel",brandsma);
    	NameNode heuvel    = new NameNode("Heuvel",kraay);
    	NameNode manders   = new NameNode("Manders",heuvel);
    	
    	Tree<NameNode> lijst = new NodeTree<>();
    	lijst.add(kraay);
    	lijst.add(pieters);
    	lijst.add(brandsma);
    	lijst.add(heuvel);
    	lijst.add(sanders);
       	lijst.add(adelaar);
    	lijst.add(vermeulen);
    	lijst.add(smits);
    	lijst.add(alkema);
    	lijst.add(walstra);
    	lijst.add(vergeer);
    	lijst.add(dost);
    	lijst.add(appel); 
    	lijst.add(manders);
    	TreeIterator<NameNode> iterator = lijst.iterator();
   	
    	System.out.println("Siblings op alfabetische volgorde");
    	System.out.println(String.format("%1$-30s", "Naam"  )
      		  + String.format("%1$-5s","Kids")
      		  +" "+String.format("%1$-60s","Pad")
      		  + "Totaal aantal letters kids"
      		  );
    	iterator.orderSiblingsBy((o1,o2) -> o1.toString().compareTo(o2.toString()));
        while (iterator.hasNext()){
        NameNode elem = iterator.next();
          System.out.println(String.format("%1$-30s", elem  )
        		  + String.format("%1$-5s",lijst.descendantCount(elem))
        		  +" "+String.format("%1$-60s",iterator.path("/"))
        		  + lijst.descendantSum(elem,(ToLongFunction<NameNode>) node -> node.getName().length())
        		  );
        }

        System.out.println();
        System.out.println("Siblings op volgorde lengte naam");        
        iterator = lijst.iterator();
        iterator.orderSiblingsBy((o1,o2) -> Integer.compare(o1.getName().length(),o2.getName().length()));
        while (iterator.hasNext()){
            System.out.println(String.format("%1$-30s",   iterator.next())+" "+iterator.path("/"));
          }
        System.out.println();
        System.out.println(" Gemiddelde lengte namen nakomelingen "+brandsma+" "
        		+ lijst.descendantAvg(brandsma, node -> node.getName().length()));
        System.out.println(" Max lengte namen nakomelingen "+brandsma+" "
        		+ lijst.descendantMax(brandsma, (ToLongFunction<NameNode>) node -> node.getName().length()));
        System.out.println(" Min lengte namen nakomelingen "+brandsma+" "
        		+ lijst.descendantMin(brandsma, (ToDoubleFunction<NameNode>) node -> node.getName().length()));
        /*
        NameNode a     = new NameNode("A");
        NameNode c     = new NameNode("C",a);
        NameNode b     = new NameNode("B",a);
        NameNode b1     = new NameNode("B1",b);
        NameNode b2     = new NameNode("B2",b);
        NameNode b21     = new NameNode("B21",b2);
        NameNode c1     = new NameNode("C1",c);
        NameNode c2     = new NameNode("C2",c);
        NameNode c11     = new NameNode("C11",c1);
        NameNode c12     = new NameNode("C12",c1);  
        Tree<NameNode> lijstA = new NodeTree<>();
        lijstA.add(a);
        lijstA.add(b);
        lijstA.add(c);
        lijstA.add(b2);
        lijstA.add(b21); 
        lijstA.add(b1); 
        lijstA.add(c2); 
        lijstA.add(c1);
        lijstA.add(c12);
        lijstA.add(c11); 
        TreeIterator<NameNode> iteratorA = lijstA.iterator();
        iteratorA.orderSiblingsBy(null);
        while (iteratorA.hasNext()){
          System.out.println(iteratorA.next()+" "+iteratorA.level());
        }       
        */
    }
}
