package com.vijfhart.casus.tree.memo;

import com.vijfhart.casus.tree.WrapperNode;

public class MemoNode extends WrapperNode<MemoNode, Memo> {
    private static long teller = 0;
    private long id;
	protected MemoNode(Memo object) {
		super(object);
		id = teller;
		teller++;
	}
	public MemoNode(Memo object, MemoNode parent ) {
		super (object,parent);
		id = teller;
		teller++;		
	} 
	public long getId() {
		return id;
	}
    
	
}
