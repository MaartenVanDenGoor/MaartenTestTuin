package com.vijfhart.casus.tree;

public interface Node<E extends Node<E>> extends Comparable<E> , LevelComparable<E>{
   
	E getParent();
   
    void setParent(E node);
    
    boolean isLeaf(E node);

	}