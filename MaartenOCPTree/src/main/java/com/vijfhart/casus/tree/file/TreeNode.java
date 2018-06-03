package com.vijfhart.casus.tree.file;

import java.util.function.Function;

public interface TreeNode<T> {
	T node(); 
	 
	String path(String separator); 
	 
	String path(String separator, Function<T, String> f); 
	 
	boolean isLeaf(); 
	 
	int level(); 


}
