package com.vijfhart.casus.tree.file;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Arrays;
import com.vijfhart.casus.tree.NodeTree;
import com.vijfhart.casus.tree.stat.OptionalLongSummaryStatistics;
import com.vijfhart.casus.util.Timer;
public class FileTreeApp {

	public static void main(String[] args) {
		if (args.length == 0 ) {
			throw new RuntimeException("Minimaal EEN argument (de startdirectory) opgeven");
		}
		// Directory moet laatste argument zijn
		String dir = args[args.length-1];
		// de rest zijn FilePrintOptions
		FilePrintOption[] optieLijst = Arrays.stream(args)
				                             .limit(args.length-1)                 // laatste overslaan
				                             .map(s -> FilePrintOption.getEnum(s)) // omzetten naar enum
				                             .filter(o -> o!=null)                 // niet omgezette waarden overslaan
				                             .toArray(FilePrintOption[]::new);     // array van maken
    	FileTree f = new FileTree(dir);
    	//
    	Timer<FileTree> timer = new Timer<>(); 
    	timer.accept(f, t -> t.printTree(optieLijst)); 
    	//
   // 	NodeTree<PathNode> tree = f.getTree();
   // 	tree.stream()
   // 	    .filter(node -> !node.isLeaf())                                                     // Alleen bestanden
   // 	    .map(pathnode  -> tree.descendantLongStatistics(pathnode.node(), a -> a.getSize())) // Maak Statistiek object
   // 	    .forEach(System.out::println);
 	//
//    	System.out.println("-------");
//    	Map<PathNode,OptionalLongSummaryStatistics> map
//    	    = tree.stream()
//    	          .collect(Collectors.toMap( pathnode -> pathnode.node()
//    	        		  , pathnode -> tree.descendantLongStatistics(pathnode.node(), a -> a.getSize())));
//    	map.entrySet().stream().sorted().limit(20).forEach(System.out::println);
    	

	}
}
