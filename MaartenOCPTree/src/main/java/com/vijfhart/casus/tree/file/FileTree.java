package com.vijfhart.casus.tree.file;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.vijfhart.casus.tree.*;


public class FileTree {
    private NodeTree<PathNode> tree  ;
    private String dir;

    public FileTree(String dir) {
		this.dir = dir;
		fillTree(dir);
	}
    public void fillTree(String startDir) {
    	Path path = Paths.get(startDir);
    	try {
    		// Aanmaken Key/Value met Path/PathNode
    		final Map<Path, PathNode> map = Files.walk(path)
    		           .map(PathNode::new)
    		           .collect(Collectors.toMap(PathNode::getObject,p -> p));
            // Vullen van de tree met de PathNode objecten waarbij in de peek
    		// de parent gevuld wordt
        	tree = map.entrySet().stream()
        			             .peek(eset -> eset.getValue().setParent(map.get(eset.getKey().getParent())))
        	                     .collect(NodeTree<PathNode>::new
        	                    		 ,(a, b) -> a.add(b.getValue())
        	                    		 ,(a, b) -> a.addAll(b));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    public void printTree() {
        TreeIterator<PathNode> iterator = tree.iterator();
//        while(iterator.hasNext()){
//        	Path p = iterator.next().getObject();
//        	long filesize = p.toFile().length();
//        	int filenumber = p.toFile().list()==null?0:p.toFile().list().length;
//        	System.out.printf("|%20s|%20s|%-50s|\n",filenumber ,filesize, p.toString());
//            }
       tree.stream().filter(node -> !node.isLeaf())
                    .forEach(node -> System.out.println(node.path("-")));
    }
    /* 
     * Maak in FileTree ook een methode printTree aan. Deze doorloopt de tree met een TreeIterator, en toont van elke PathNode in de tree de volgende informatie: 
• het aantal bestanden onder de directory 
• het totale aantal bytes binnen de directory 
• het pad van het bestand / de directory 

     */
}
