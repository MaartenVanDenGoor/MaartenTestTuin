package com.vijfhart.casus.tree.file;

import java.util.function.Function;

import com.vijfhart.casus.tree.Node;

public interface TreeNode<T extends Node<T>> {
	
	T node();  // toegang tot de node

	String path(String separator);  // toegang tot de TreeIterator methods
	 
	String path(String separator, Function<T, String> f); 
	 
	boolean isLeaf(); 
	 
	int level(); 


}
