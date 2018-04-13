package com.vijfhart.casus.tree;
public abstract class AbstractNode< E extends AbstractNode<E>> implements Node<E> {
	private E parent;
	private int childCount;

	@Override
	public int compareTo(E other) {
        // this heeft geen parent
		if (parent==null && other.getParent()!=null) {
			return -1;
		}
		if (parent!=null && other.getParent()==null) {
			return 1;
		}	
		if (this.equals(other)) {
			return 0;
		}
		// this is (klein) kind van other
		if (isDescendant(other)) {
			return 1;
		}
		// Gelijke ouders, vergelijking op naam
		if (other.getParent()!=null && parent.equals(other.getParent())) {
			return this.toString().compareTo(other.toString());
		}
		
		int levelCompare = compareLevelTo(other);
		System.out.println(this+" <-> "+other+" : "+levelCompare);
		// Gelijk level
		if (levelCompare==0) {
			return this.getParent().compareTo(other.getParent());
		}
		// this heeft lager level
		if (levelCompare==1) {
			return this.getParent().compareTo(other);
		}
		// o heeft lager level
		return -this.compareTo(other.getParent());
	}
	@Override
	public int compareLevelTo(E other) {
		if (parent==null && other.getParent()!=null) {
			return -1;
		}
		if (parent!=null && other.getParent()==null) {
			return 1;
		}	
		if (parent==other.getParent()) {
			return 0;
		} else {
			return parent.compareLevelTo(other.getParent());
		}
		
	}
	@Override
	public E getParent() {
		return parent;
	}
	@Override
	public boolean isLeaf() {
		return childCount==0?true:false;
	}
	@Override
	public void setParent(E node) {
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
	private boolean isDescendant(E other) {
		// Als een vd (voor)ouders van de meegegeven node de huidge node is dan return true
		E parent = getParent();
		if (parent==null) {
			return false;
		} else {
			while (parent!=null) {
				if (parent.equals(other)) {
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
