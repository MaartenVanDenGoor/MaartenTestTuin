package com.vijfhart.casus.werknemer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.ToDoubleFunction;
import java.util.function.ToLongFunction;

import com.vijfhart.casus.tree.AbstractNode;
import com.vijfhart.casus.tree.NameNode;
import com.vijfhart.casus.tree.NodeTree;
import com.vijfhart.casus.tree.Tree;
import com.vijfhart.casus.tree.TreeIterator;

/**
 * Hello world!
 *
 */
public class WerknemerApp 
{
    public static void main( String[] args )
    {
    	String[][] wlijst = new String[][] {
    		{"3381","SMITS","KLERK","7902","2400","","20"},
     	    {"3462","ALKEMA","VERKOPER","4621","2600","300","30"},
     		{"3518","WALSTRA","VERKOPER","4621","2250","500","30"},
     		{"3930","PIETERS","MANAGER","6221","3975","","20"},
     		{"4510","VERGEER","VERKOPER","4621","2250","1400","30"},
     		{"4621","KLAASEN","MANAGER","6221","3850","","30"},
     		{"5810","HEUVEL","MANAGER","6221","3450","","10"},
     		{"5931","SANDERS","ANALIST","3930","4000","","20"},
     		{"6221","KRAAY","DIRECTEUR","","6000","","10"},
     		{"6500","DROST","VERKOPER","4621","2500","0","30"},
     		{"6681","ADELAAR","KLERK","5931","2100","","20"},
     		{"7900","APPEL","KLERK","4621","1950","","30"},
     		{"7902","VERMEULEN","ANALIST","3930","3900","","20"},
     		{"8222","MANDERS","KLERK","5810","2300","","10"}  		
    	};
    	List<WerknemerNode> lijst = new ArrayList<>();
    	for (int i=0 ; i< wlijst.length; i++) {
    		Werknemer w = new Werknemer(Integer.parseInt(wlijst[i][0])
    				                   ,wlijst[i][1]
    				                   ,Functie.valueOf(wlijst[i][2])
    				                   ,Integer.parseInt(wlijst[i][3]==""?"0":wlijst[i][3])
    				                   ,Double.parseDouble(wlijst[i][4]));
    		WerknemerNode wn = new WerknemerNode(w);
    		lijst.add(wn);
    	}
       	for (WerknemerNode elem:lijst) {
    		int manager = elem.getWerknemer().getManager();
    		if (manager!=0) {
    			// Zoek parent node
    			WerknemerNode mm = lijst.stream().filter(p -> p.getWerknemer().getNummer()==manager)
    					.findFirst().get();
    			elem.setParent(mm);
    		}
    		
    	}
   	    
    	Tree<WerknemerNode> tree = new NodeTree<WerknemerNode>(lijst);

    	//
    	TreeIterator<WerknemerNode> iterator = tree.iterator();

        while (iterator.hasNext()){
          WerknemerNode elem = iterator.next();
          System.out.println(elem.getWerknemer().toString()
        		            + String.format("%1$-5s", iterator.level())
        		            + tree.descendantSum(elem,
        		            		(ToDoubleFunction<WerknemerNode>) node -> node.getWerknemer().getSalaris())
        		            );

        }
    }

}
