package com.vijfhart.casus.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    	NameNode klaassen  = new NameNode("Klaassen",kraay);
    	NameNode alkema    = new NameNode("Alkema",klaassen);
    	NameNode walstra   = new NameNode("Walstra",klaassen);
    	NameNode vergeer   = new NameNode("Vergeer",klaassen);
    	NameNode dost      = new NameNode("Dost",klaassen);
    	NameNode appel     = new NameNode("Appel",klaassen);
    	NameNode heuvel    = new NameNode("Heuvel",kraay);
    	NameNode manders   = new NameNode("Manders",heuvel);
    	/*
    	Tree<NameNode> lijst = new NodeTree<>();
    	lijst.add(kraay);
    	lijst.add(pieters);
    	lijst.add(klaassen);
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
        while (iterator.hasNext()){
          System.out.println(String.format("%1$-30s",   iterator.next())+" "+iterator.path("/"));
        }
        ///////
        iterator = lijst.iterator();
        while (iterator.hasNext()){
        	iterator.next();
            System.out.println(iterator.path("/", E ->E.toString().toUpperCase() ));
          }      
        /*/
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
        while (iteratorA.hasNext()){
          System.out.println(iteratorA.next()+" "+iteratorA.level());
        }       
    }
}
