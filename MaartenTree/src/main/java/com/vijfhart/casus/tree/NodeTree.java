package com.vijfhart.casus.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NodeTree<E extends Node<E>> implements Tree<E>, TreeIterable<E> {
	private List<Node> nodeList = new ArrayList<>();
	@Override
	public TreeIterator<E> iterator() {
		return new TreeIterator<E>(){
			Iterator<Node> iterator;

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return iterator.hasNext();
			}

			@Override
			public E next() {
				// TODO Auto-generated method stub
				return (E) iterator.next();
			}

			@Override
			public int level() {
				// TODO Auto-generated method stub
				return 0;
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
