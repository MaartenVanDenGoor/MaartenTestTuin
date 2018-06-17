package com.vijfhart.casus.tree.file;

import java.nio.file.Path;
import com.vijfhart.casus.tree.WrapperNode;

public class PathNode extends WrapperNode<PathNode, Path> {

	public PathNode(Path object) {
		super(object);
	}
	public PathNode(Path object, PathNode parent ) {
		super (object,parent);
	}
	public void setOptions(FilePrintOption... opties) {
		
	}
	public String toString() {
		return "PN-"+super.toString();
	}
}
