package com.vijfhart.casus.tree;

import java.util.List;
import java.util.function.ToLongFunction;
import java.util.function.ToDoubleFunction;

public interface Tree<E extends Node<E>> extends TreeIterable<E> {
	/**
	 * Toevoegen node aan de lijst
	 * @param node
	 */
	void add(E node);
	/**
	 * Ophalen alle nodes die onder een node hangen (inclusief startnode)
	 * @param node waarmee gestart wordt
	 * @return lijst met alle nodes
	 */
	List<E> descendantsOf(E node);
	/**
	 * Ophalen aantal nodes die onder een node hangen
	 * @param node
	 * @return aantal
	 */
	int descendantCount(E node);
    /**
     * Bepaal met op te geven lambda expressie welke waardes opgeteld moeten
     *  van alle nodes onder mee te geven node
     * @param node
     * @return long
     */
	long DescendantSum(E node, ToLongFunction<E> func);
	/**
     * Bepaal met op te geven lambda expressie welke waardes opgeteld moeten
     *  van alle nodes onder mee te geven node
	 * @param node
	 * @return double
	 */
	 double DescendantSum(E node, ToDoubleFunction<E> func);
}
