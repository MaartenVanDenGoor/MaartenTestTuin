package com.vijfhart.casus.tree.dao;

import java.util.function.Predicate;
import java.util.stream.Stream;

import com.vijfhart.casus.tree.Node;
import com.vijfhart.casus.tree.file.*;

public interface NodeDAO <T extends Node<T>> {
	  Stream<TreeNode<T>> findAll();

	  void create(TreeNode<T> node); 
	  //
	  default Stream<TreeNode<T>> findByFilter( Predicate<TreeNode<T>> filter){ 
		  return null;
	  }
}
