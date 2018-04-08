package com.vijfhart.casus.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NodeTree<E extends Node<E>> implements Tree<E>, TreeIterable<E> {
	private List<E> nodeList = new ArrayList<>();
	@Override
	public TreeIterator<E> iterator() {
		return new TreeIterator<E>(){
			Iterator<E> iterator;
			E           current;
			

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return iterator.hasNext();
			}

			@Override
			public E next() {
				// TODO Auto-generated method stub
				current = iterator.next();
				return current;
			}

			@Override
			public int level() {
				// TODO Auto-generated method stub
				if (current.getParent()==null) {
					return 0;
				} else {
					E node = current.getParent();
					int teller = 0;
					while (node != null) {
						teller++;
					    node = node.getParent();
					}
					return teller;
				}
			}

			@Override
			public void startWith(E node) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public boolean isLeaf() {
				// TODO Auto-generated method stub
				return false;
			} 
			{
				// Sort in natural order
				Collections.sort(nodeList);
				iterator = nodeList.iterator();
			}
			
		 };
	}

	@Override
	public void add(E node) {
		nodeList.add(node);
		
	}
}
