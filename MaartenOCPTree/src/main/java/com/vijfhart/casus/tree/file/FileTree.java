package com.vijfhart.casus.tree.file;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.vijfhart.casus.tree.*;
import com.vijfhart.casus.tree.stat.OptionalComparableSummaryStatistics;


public class FileTree {
	private NodeTree<PathNode>  tree  ;
	private String dir;
	private  boolean humanReadable, printDate, dirsOnly, filesOnly;
	private  int maxDepth=-1, minDepth;
	private ResourceBundle datums ;
	private ResourceBundle lables ;

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
			// Doorloop de map en zoek bij elke PathNode de parent node
			map.forEach((k,v) -> v.setParent(map.get(k.getParent())));

			// stop de values uit de map in de tree
			tree =
					map.values()
					.stream()
					.collect(NodeTree::new,NodeTree::add,NodeTree::addAll);  

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void printTree(FilePrintOption... opties) {
		setOptions(opties);
		// Bepaal Locale uit opstart parameters (of default)
		Locale loc = Locale.getDefault();
		for (FilePrintOption optie:opties) {
			if (optie==FilePrintOption.LANGUAGE) {
				String language=optie.getStringValue();
				loc = new Locale.Builder()
						.setLanguage(language)
						.setRegion(language.toUpperCase())
						.build();
			}
		}   
		// Ophalen labels
		lables = ResourceBundle.getBundle("FileLabels",loc);
		// Ophale date time format
		datums = ResourceBundle.getBundle("FileDates",loc);
		//
		System.out.println("Printing out the tree ....");
		System.out.println();       
		tree.stream()
		.filter(x->dirsOnly?!x.isLeaf():true)
		.filter(x->filesOnly?x.isLeaf():true)
		.filter(x->maxDepth>=0?x.level()<=maxDepth:true)
		.filter(x->minDepth>0?x.level()>=minDepth:true)
		.map(x-> x.level()+ " " + x.toString()+"\n" 
				+ (humanReadable?tree.descendantLongStatistics(x.node(),y->y.getSize()).toStringHumanReadable(lables)
						:              tree.descendantLongStatistics(x.node(),y->y.getSize()).toString(lables)) 
		         + (printDate? "\n"  + formatDate(x.node().getLastModified(), tree.descendantComparableStatistics(x.node(), y->Optional.of(y.getLastModified())))
		         :"") 
				+"\n")
		.forEach(System.out::println);   
	}
	//
	public NodeTree<PathNode> getTree() {
		return tree;
	}
	private String longStatistics(List<PathNode> lijst, Function f) {
		return "";
	}
	private long size(Path p){  // method die checked exception opvangt
		try{
			return Files.size(p);
		} catch (IOException ioe){
			throw new RuntimeException(ioe);
		}
	}
	private void setOptions(FilePrintOption ... options){

		for(FilePrintOption option:options){
			if(option==FilePrintOption.HUMAN_READABLE)
				humanReadable=true;
			if(option==FilePrintOption.DATE)
				printDate=true;
			if(option==FilePrintOption.DIRS_ONLY)
				dirsOnly=true;
			if(option==FilePrintOption.FILES_ONLY)
				filesOnly=true;
			if(option==FilePrintOption.MAX_DEPTH)
				maxDepth=option.getIntValue();
			if(option==FilePrintOption.MIN_DEPTH)
				minDepth=option.getIntValue();
			if(option==FilePrintOption.LANGUAGE){
				try {
					Locale locale = new Locale(option.getStringValue());
					Locale.setDefault(locale);
				} catch(Exception e){ throw new RuntimeException(e);}
			}
		}

	}    
	private String humanReadable(double value){ // in dit voorbeeld niet gebruikt, 
		// in plaats daarvan toStringHumanReadable van OptionalLongSummaryStatistics
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(2);
		if(value<1000) return nf.format(value);
		if(value<1_000_000) return nf.format(value/1000D)+"K";
		if(value<1_000_000_000) return nf.format(value/1_000_000D)+"M";
		return nf.format(value/1_000_000_000D)+"G";
	}
	// Formatteren datumTijd
	private String formatDate(FileTime datum) {
		SimpleDateFormat df = new SimpleDateFormat(datums.getString("f1"));
	    return df.format(datum.toMillis());

	}
	private String formatDate(FileTime lastModified, OptionalComparableSummaryStatistics<FileTime> stats){
	    FileTime min = stats.min().orElse(null);
	    FileTime max = stats.max().orElse(null);
	    String modifiedLabel = lables.getString("modified");
	    String firstLabel = lables.getString("first");
	    String lastLabel = lables.getString("last");
	    return "{ "+ modifiedLabel + ": [" + formatDate(lastModified) + "], " +
	                 firstLabel + ": ["+ formatDate(stats.min().orElse(null))+"], " + 
	                 lastLabel + ": ["+formatDate(stats.max().orElse(null))+"] }";
	  }
	
}
