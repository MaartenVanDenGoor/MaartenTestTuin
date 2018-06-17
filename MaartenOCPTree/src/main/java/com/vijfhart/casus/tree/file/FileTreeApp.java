package com.vijfhart.casus.tree.file;
import java.util.Map;
import java.util.OptionalLong;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.vijfhart.casus.tree.NodeTree;
import com.vijfhart.casus.tree.TreeIterator;
import com.vijfhart.casus.tree.stat.OptionalLongSummaryStatistics;
import com.vijfhart.casus.util.Timer;
public class FileTreeApp {

	public static void main(String[] args) {
    	FileTree f = new FileTree("G:\\\\Mijn Documenten\\\\JavaTraining\\\\tree_casus_start_8_deel_2\\\\java8");
    	Timer<FileTree> timer = new Timer<>(); 
    	timer.accept(f, t -> t.printTree()); 
    	NodeTree<PathNode> tree = f.getTree();
    	tree.stream()
    	     .map(pathnode  -> tree.descendantLongStatistics(pathnode.node(), a -> a.getSize()))
    	     .forEach(System.out::println);
	//
    	Map<PathNode,OptionalLongSummaryStatistics> map
    	    = tree.stream()
    	          .collect(Collectors.toMap( pathnode -> pathnode.node()
    	        		  , pathnode -> tree.descendantLongStatistics(pathnode.node(), a -> a.getSize())));
    //	map.entrySet().stream().sorted().limit(20).forEach(System.out::println);
    	
 // descendantLongStatistics(T t, Function<T,OptionalLong> f)   	
	}

}
