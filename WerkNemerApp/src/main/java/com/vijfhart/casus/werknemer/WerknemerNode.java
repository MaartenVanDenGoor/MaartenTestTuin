package com.vijfhart.casus.werknemer;

import com.vijfhart.casus.tree.AbstractNode;
import com.vijfhart.casus.tree.Node;

public class WerknemerNode  extends AbstractNode<WerknemerNode> {
	private Werknemer werknemer;

	public WerknemerNode(Werknemer werknemer) {
		super();
		this.werknemer = werknemer;
	}
	public WerknemerNode(Werknemer werknemer, WerknemerNode manager) {
		super();
		this.werknemer = werknemer;
		this.setParent(manager);
	}

	public Werknemer getWerknemer() {
		return werknemer;
	}

	public void setWerknemer(Werknemer werknemer) {
		this.werknemer = werknemer;
	}
	
}
