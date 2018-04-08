package com.vijfhart.casus.tree;

import java.util.Iterator;

public interface TreeIterator<E extends Node<E>>  extends Iterator<E> {

    int level();
    
    void startWith(E node);
    
    boolean isLeaf();

}
