package com.vijfhart.casus.tree;

public class NameNode extends AbstractNode  {
	private String   name;
    //
	NameNode(String name, NameNode parent){
		this.name   = name;
		this.setParent(parent);
	}
	NameNode(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
	//	if (parent==null) return name;
	//	return parent.toString()+"/"+name;
		return name; // + " :"+getLevel();
	}
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof NameNode)) {
			return false;
		}
		NameNode other = (NameNode) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
}
