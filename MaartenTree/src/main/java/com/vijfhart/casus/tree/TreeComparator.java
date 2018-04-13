package com.vijfhart.casus.tree;

import java.util.Comparator;

public class TreeComparator<E extends Node<E>> implements Comparator<E> {
    private Comparator<E> siblingComparator;
    //
	public TreeComparator(Comparator<E> siblingComparator) {
		super();
		this.siblingComparator = siblingComparator;
	}
	public void setSiblingComparator(Comparator<E> siblingComparator) {
		this.siblingComparator = siblingComparator;
	}
	@Override
	public int compare(E o1, E o2) {
        // o1 heeft geen parent, o2 wel
		if (o1.getParent()==null && o2.getParent()!=null) {
			return -1;
		}
        // o1 heeft parent, o2 niet
		if (o1.getParent()!=null && o2.getParent()==null) {
			return 1;
		}	
		// beide objecten zijn gelijk aan elkaar
		if (o1==o2) {
			return 0;
		}
		// o1 is (klein) kind van 02
		if (isDescendant(o1,o2)) {
			return 1;
		}
		if (isDescendant(o2,o1)) {
			return -1;
		}		
		// Gelijke ouders, vergelijking via siblingComparator
		if (o1.getParent().equals(o2.getParent())) {
			if (siblingComparator!=null) {
				return siblingComparator.compare(o1, o2);
			}
			return o1.toString().compareTo(o2.toString());
		}
		
		int levelCompare = o1.compareLevelTo(o2);
		// Gelijk level
		if (levelCompare==0) {
			return compare(o1.getParent(),o2.getParent());
		}
		// o1 heeft lager level
		if (levelCompare==1) {
			return compare(o1.getParent(),o2);
		}
		// o2 heeft lager level
		return compare(o1,o2.getParent());
        //
	}
	private boolean isDescendant(E o1, E o2) {
		// Als een vd (voor)ouders van de meegegeven node de huidge node is dan return true
		E parent = o1.getParent();
		if (parent==null) {
			return false;
		} else {
			while (parent!=null) {
				if (parent.equals(o2)) {
					return true;
				}
				parent = parent.getParent();
			}
		}
		return false;
	}
}
