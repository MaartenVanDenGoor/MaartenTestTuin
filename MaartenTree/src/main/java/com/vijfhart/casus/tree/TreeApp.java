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
    	Tree<NameNode> lijst = new NodeTree<>();
    	lijst.add(kraay);
    	lijst.add(pieters);
    	lijst.add(sanders);
    	lijst.add(adelaar);
    	lijst.add(vermeulen);
    	lijst.add(smits);
    	lijst.add(klaassen);
    	lijst.add(alkema);
    	lijst.add(walstra);
    	lijst.add(vergeer);
    	lijst.add(dost);
    	lijst.add(appel);
    	lijst.add(heuvel);
    	lijst.add(manders);
    	// Ongesorteerd
    	for (Node n:lijst) {
    		System.out.println(n);
    	}
    	// Gesorteerd
    	//Collections.sort(lijst,(n1,n2) -> n1.compareLevelTo(n2));
    	//System.out.println(lijst);

    }
}
