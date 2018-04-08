package com.vijfhart.casus.tree;

public class NameNode implements Node<NameNode> {
	private String   name;
	private NameNode parent;
    //
	NameNode(String name, NameNode parent){
		this.name   = name;
		this.parent = parent;
	}
	NameNode(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}

	@Override
	public void setParent(NameNode node) {
		this.parent = node;
		
	}
	@Override
	public String toString() {
	//	if (parent==null) return name;
	//	return parent.toString()+"/"+name;
		return name; // + " :"+getLevel();
	}
    public int getLevel() {
        if (parent==null) return 1;
        return 1 + parent.getLevel();
    }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NameNode other = (NameNode) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public int compareTo(NameNode o) {
		if (parent==null && o.getParent()!=null) {
			return -1;
		}
		if (parent!=null && o.getParent()==null) {
			return 1;
		}	
		if (parent==o.getParent()) {
			return 0;
		} else {
			return parent.compareTo(o.getParent());
		}
	}
	@Override
	public int compareLevelTo(NameNode o) {
		if (parent==null && o.getParent()!=null) {
			return -1;
		}
		if (parent!=null && o.getParent()==null) {
			return 1;
		}	
		if (parent==o.getParent()) {
			return 0;
		} else {
			return parent.compareTo(o.getParent());
		}
	}
	@Override
	public NameNode getParent() {
		return parent;
	}
	@Override
	public boolean isLeaf(NameNode node) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
