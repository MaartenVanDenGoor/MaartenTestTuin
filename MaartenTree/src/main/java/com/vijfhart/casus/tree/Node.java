package com.vijfhart.casus.tree;

public interface Node<E extends Node<E>> extends Comparable<E> , LevelComparable<E>{
    /**
     * Ophalen van de parent van de node. Indien deze null retourneert heeft de node 
     *  dus geen parent
     * @return node die de parent is
     */
	E getParent();
    /**
     * Zetten van de parten van de node
     * @param node
     */
    void setParent(E node);
    /**
     * Bepaal of de node een Leaf is, dus geen descendants heeft
     * @return True als er geen descendants zijn, False als die er wel zijn
     */
    boolean isLeaf();

	}