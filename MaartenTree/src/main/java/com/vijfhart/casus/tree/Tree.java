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
     * @return Som (long) 
     */
	long descendantSum(E node, ToLongFunction<E> func);
	/**
     * Bepaal met op te geven lambda expressie welke waardes opgeteld moeten
     *  van alle nodes onder mee te geven node
	 * @param node
	 * @return Som (double)
	 */
	 double descendantSum(E node, ToDoubleFunction<E> func);
	 /**
     * Bepaal met op te geven lambda expressie van welke waardes het gemiddelde
     *  van alle nodes onder mee te geven node wordt bepaald
	 * @param node
	 * @return double Som
	 */
	 double descendantAvg(E node, ToDoubleFunction<E> func);
	 /**
     * Bepaal met op te geven lambda expressie van welke waardes het minimum
     *  van alle nodes onder mee te geven node wordt bepaald
	 * @param node
	 * @return Minimale waarde (long)
	 */
	 long descendantMin(E node, ToLongFunction<E> func);
	 /**
     * Bepaal met op te geven lambda expressie van welke waardes het minimum
     *  van alle nodes onder mee te geven node wordt bepaald
	 * @param node
	 * @return Minimale waarde (double)
	 */
	 double descendantMin(E node, ToDoubleFunction<E> func);
	 /**
     * Bepaal met op te geven lambda expressie van welke waardes het maximum
     *  van alle nodes onder mee te geven node wordt bepaald
	 * @param node
	 * @return Maximale waarde (long)
	 */
	 long descendantMax(E node, ToLongFunction<E> func);
	 /**
     * Bepaal met op te geven lambda expressie van welke waardes het maximum
     *  van alle nodes onder mee te geven node wordt bepaald
	 * @param node
	 * @return Maximale waarde (double)
	 */
	 double descendantMax(E node, ToDoubleFunction<E> func);	 
}
