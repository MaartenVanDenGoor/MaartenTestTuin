package com.vijfhart.casus.tree;

import java.util.Comparator;

public class TreeComparator<E extends Node<E>> implements Comparator<E> {
    private Comparator siblingComparator;
    //
	public TreeComparator(Comparator siblingComparator) {
		super();
		this.siblingComparator = siblingComparator;
	}
	public void setSiblingComparator(Comparator siblingComparator) {
		this.siblingComparator = siblingComparator;
	}
	@Override
	public int compare(E o1, E o2) {
		/*
        // this heeft geen parent
		if (o1==null && o2.getParent()!=null) {
			return -1;
		}
		// other is (klein) kind van this
		if (isDescendant(o1,o2)) {
			return 1;
		}
		// Gelijke ouders, vergelijking op naam
		if (o1.getParent()!=null && o1.getParent().equals(o2.getParent())) {
			if (siblingComparator!=null) {
				return siblingComparator.compare(o1, o2);
			}
			return o1.toString().compareTo(o2.toString());
		}
		int levelCompare = compareLevelTo(abstractNode);
		
		// Gelijk level
		if (levelCompare==0) {
			return this.getParent().compareTo(abstractNode.getParent());
		}
		// this heeft lager level
		if (levelCompare==-1) {
			return this.getParent().compareTo(abstractNode);
		}
		// o heeft lager level
		return abstractNode.getParent().compareTo(this);
		*/
		return 0;
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
