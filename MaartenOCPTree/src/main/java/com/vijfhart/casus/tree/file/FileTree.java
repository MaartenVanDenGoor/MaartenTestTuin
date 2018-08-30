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
     /* Eigen uitwerking
    		tree = map.entrySet().stream()
        			             .peek(eset -> eset.getValue().setParent(map.get(eset.getKey().getParent())))
        	                     .collect(NodeTree<PathNode>::new
        	                    		 ,(a, b) -> a.add(b.getValue())
        	                    		 ,(a, b) -> a.addAll(b));
     */
            // Doorloop de map en zoek bij elke PathNode de parent node
            map.forEach((k,v) -> v.setParent(map.get(k.getParent())));
            
            // stop de values uit de map in de tree
            tree =
            map.values()
               .stream()
               .collect(NodeTree::new,NodeTree::add,NodeTree::addAll);  

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    public void printTree(FilePrintOption... opties) {
    	
        TreeIterator<PathNode> iterator = tree.iterator();
//        while(iterator.hasNext()){
//        	Path p = iterator.next().getObject();
//        	long filesize = p.toFile().length();
//        	int filenumber = p.toFile().list()==null?0:p.toFile().list().length;
//        	System.out.printf("|%20s|%20s|%-50s|\n",filenumber ,filesize, p.toString());
//            }
        boolean dirsOnly = false;
        for (FilePrintOption optie:opties) {
			if (optie==FilePrintOption.DIRS_ONLY) dirsOnly =true;
		}
       tree.stream().filter(pathnode -> pathnode.isLeaf())
                    .forEach(pathnode -> System.out.println(pathnode.node().getDate()+"=="
                        +pathnode.node().getSize().getAsLong() +"=="+pathnode.node().getName()+"=="
                        +pathnode.path("==")));
       /*
       System.out.println("Printing out the tree ....");
       System.out.println();
       TreeIterator<PathNode> iterator = tree.iterator();
       while(iterator.hasNext()){
         PathNode node = iterator.next();
         System.out.println(iterator.descendantCount(node) + "  " + 
                            iterator.descendantSum(node, n -> size(n.getObject())) + " " + // delegeer naar method die checked exception opvangt 
                            iterator.path(File.separator, n -> n.getObject().getName())   
                            );
       }
       */
    }
    //
    public NodeTree<PathNode> getTree() {
    	return tree;
    }
    private long size(Path p){  // method die checked exception opvangt
        try{
          return Files.size(p);
        } catch (IOException ioe){
           throw new RuntimeException(ioe);
        }
      }
    

}
