package com.vijfhart.casus.tree;

import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Function;

public interface TreeIterator<E extends Node<E>>  extends Iterator<E> {
    /**
     * Bepaal level van de node, level = 0 indien node geen parent heeft
     * @return int Het bepaalde leven van de node
     */
    int level();
    /**
     * Opgeven van de node waarmee de lijst moet beginnen
     * @param node De node die moet dienen als de parent van de lijst
     */
    void startWith(E node);
    /**
     * Bepaal of huidige node een leaf, dus geen parent, is
     * @return True als huidige node geen parent, false als node wel parent is
     */
    boolean isLeaf();
    /**
     * Ophalen van pad (opeenvolgende -voor-ouders) gescheiden door seperator
     * @param separator
     * @return String met daarin het pad (opeenvolgende -voor-ouders) gescheiden door seperator
     */
     String path(String separator); 
     
     String path(String separator, Function<E, String> f); 
     /**
      * Bepaal door de mee te geven comparator de volgorde van zuster elementen
      * @param comparato
      */
     void orderSiblingsBy(Comparator<E> comparator);
}
