package com.vijfhart.casus.tree.memo;

import com.vijfhart.casus.tree.WrapperNode;

public class MemoNode extends WrapperNode<MemoNode, Memo> {

	protected MemoNode(Memo object) {
		super(object);
	}
	public MemoNode(Memo object, MemoNode parent ) {
		super (object,parent);
	} 
	
}
