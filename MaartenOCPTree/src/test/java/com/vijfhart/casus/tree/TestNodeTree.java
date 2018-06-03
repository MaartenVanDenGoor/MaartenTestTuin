package com.vijfhart.casus.tree;

import junit.framework.TestCase;

public class TestNodeTree extends TestCase {
    NameNode a = new NameNode("a",null);
    NameNode b = new NameNode("b",a);
    NameNode c = new NameNode("c",b);
    NameNode d = new NameNode("d",a);
    NameNode e = new NameNode("e",b);
    NameNode f = new NameNode("f",e);
    NameNode g = new NameNode("g",b);
    NameNode h = new NameNode("h",e);    
  
    final NodeTree<NameNode> list = new NodeTree<>();
    final NodeTree<NameNode> list2 = new NodeTree<>();
    {
    list.add(b);
    list.add(a);
    list.add(e);
    list.add(c);
    list.add(f);
    list.add(d); 
    list2.add(g);
    list2.add(h);
    }
    public void testAddAll(){
    	// Test NodeTree.addAll
    	list.addAll(list2);
  	    TreeIterator<NameNode> iterator = list.iterator();
  	    int i = 0;
	    while(iterator.hasNext()){
	    	i++;
	    	iterator.next();
	      }	  
    	assertTrue( i==8);
    }

}
