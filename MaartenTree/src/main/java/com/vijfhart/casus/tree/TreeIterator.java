package com.vijfhart.casus.tree;

import java.util.Iterator;

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

}
