package com.vijfhart.casus.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToLongFunction;

public class NodeTree<E extends Node<E>> implements Tree<E>, TreeIterable<E> {
	private List<E> nodeList = new ArrayList<>();
	
    NodeTree(){
    }
	NodeTree(Collection<E> nodes) {
		nodeList.addAll(nodes);
	}
	@Override
	public TreeIterator<E> iterator() {
		return new TreeIterator<E>(){
			Iterator<E> iterator;
			E           current;
			E           start;
			{
				// Sort in natural order
				Collections.sort(nodeList);
				iterator = nodeList.iterator();
			}			
			@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}
			@Override
			public E next() {
				current = iterator.next();
				return current;
			}
			@Override
			public int level() {
				if (current.equals(start)){
					return 0;
				}
				if (current.getParent()==null) {
					return 0;
				} else {
					E node = current.getParent();
					int teller = 0;
					while (node != null && !node.equals(start))  {
						teller++;
					    node = node.getParent();
					}
					// Een erbij tellen als we ergens gestart zijn
					if (start!=null) {
						teller++;
					}
					return teller;
				}
			}
			@Override
			public void remove() {
				if (current==null) {
					throw new IllegalStateException();
				}
				if (start == null) {
					if (current.isLeaf()) {
				       iterator.remove();
				       current=null;
					} else {
						throw new RuntimeException("Node is geen leaf en mag dus niet verwijderd worden");
					}
				}
			}
			@Override
			public void startWith(E node) {
				if (current!=null) {
					throw new RuntimeException("Methode kan niet worden aangeroepen na aanroep next()");
				}
				start = node;
				 List<E> nLijst = new ArrayList<>();
				 for (E nod:nodeList) {
					 if (descendantOfStartWith(nod) ) {
						 nLijst.add(nod);
					 }
				 }
				 iterator = nLijst.iterator();
			}
			private boolean descendantOfStartWith(E node) {
				if (start !=null && node.equals(start)) {
					return true;
				}
				E parent = node.getParent();
				while (parent !=null) {
					if (parent.equals(start)) {
						return true;
					}
					parent = parent.getParent();
				}
				return false;
				
			}
			@Override
			public boolean isLeaf() {
				return descendantCount(current)==0?true:false;
			}
			@Override
		    public String path(String separator) {
				return path(separator,E -> E.toString() );
			}
			@Override
		    public String path(String separator, Function<E, String> f) {
				StringBuilder sb = new StringBuilder();
				sb.append(f.apply(current));
				E parent = current.getParent();
				for (int i = 0 ; i < level();i++) {
					sb.insert(0,separator);
					sb.insert(0,f.apply(parent));
					parent = parent.getParent();
				}
				return sb.toString();
			}
			@Override
			public void orderSiblingsBy(Comparator<E> comparator) {
				if (current!=null) {
					throw new RuntimeException("Methode kan niet worden aangeroepen na aanroep next()");
				}
				TreeComparator<E> treeComparator = new TreeComparator<>(comparator);
				Collections.sort(nodeList,treeComparator);
				iterator = nodeList.iterator();
				
			};
		 };
	}

	@Override
	public void add(E node) {
		nodeList.add(node);
		
	}
	@Override
	public List<E> descendantsOf(E node) {
		List<E> retList = new ArrayList<>();
		NodeTree<E> copyTree = new NodeTree<>(nodeList);
		//
		TreeIterator<E> treeIt = copyTree.iterator();
		treeIt.startWith(node);
	     while (treeIt.hasNext()){
			retList.add(treeIt.next());
		}
	    return retList;
	}
	@Override
	public int descendantCount(E node) {
		if (node==null) {
			throw new RuntimeException("Node meegeven !");
		}
		return  descendantsOf(node).size()-1; 
	}
	@Override
	public long DescendantSum(E node, ToLongFunction<E> func) {
		List<E> retList = descendantsOf(node);
		long retWaarde = 0;
		for (E elem:retList) {
			if (!elem.equals(node)) {
			    retWaarde += func.applyAsLong(node);
			}
		}
		return retWaarde;
	}
	@Override
	public double DescendantSum(E node, ToDoubleFunction<E> func) {
		List<E> retList = descendantsOf(node);
		double retWaarde = 0;
		for (E elem:retList) {
			if (!elem.equals(node)) {
			   retWaarde += func.applyAsDouble(node);
			}
		}
		return retWaarde;
	}
	
}
