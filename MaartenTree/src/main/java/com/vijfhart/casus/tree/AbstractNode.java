package com.vijfhart.casus.tree;

public abstract class AbstractNode implements Node<AbstractNode> {
	private AbstractNode parent;
	private int childCount;

	@Override
	public int compareTo(AbstractNode o) {
		return this.compareLevelTo(o); 
	}
	@Override
	public int compareLevelTo(AbstractNode o) {
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
	public AbstractNode getParent() {
		return parent;
	}
	@Override
	public boolean isLeaf() {
		return childCount==0?true:false;
	}
	@Override
	public void setParent(AbstractNode node) {
		if (isDescendant(node)) {
			throw new RuntimeException("Node is descendant van de huidige node");
		}
		// aantal kinderen eventuele vorige parent verlagen
		if (this.parent != null) {
			this.parent.subtractChildCount();
		}
		this.parent = node;
		// Ophogen aantal kinderen vd parent
		node.addChildCount();
		
	}
	private boolean isDescendant(AbstractNode node) {
		// Als een vd (voor)ouders van de meegegeven node de huidge node is dan return true
		AbstractNode parent = node.getParent();
		if (parent==null) {
			return false;
		} else {
			while (parent!=null) {
				if (parent.equals(this)) {
					return true;
				}
				parent = parent.getParent();
			}
		}
		return false;
	}
	public void addChildCount() {
		childCount++;
	}
	public void subtractChildCount() {
		childCount--;
	}	
}
