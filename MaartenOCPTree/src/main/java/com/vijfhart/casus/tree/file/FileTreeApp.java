package com.vijfhart.casus.tree.file;

import java.util.Arrays;
import java.util.stream.Stream;

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
    	f.printTree(optieLijst);
	}
}
