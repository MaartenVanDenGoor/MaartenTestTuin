package com.vijfhart.casus.tree.dao;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import com.vijfhart.casus.tree.NodeTree;
import com.vijfhart.casus.tree.Tree;
import com.vijfhart.casus.tree.file.TreeNode;
import com.vijfhart.casus.tree.memo.Memo;
import com.vijfhart.casus.tree.memo.MemoNode;

public class MemoNodeFileDAO implements NodeDAO<MemoNode> {
	public static void main(String[] args) {
		MemoNodeFileDAO dao = new MemoNodeFileDAO();
	}
    private Path pad;
    private File bestand;
    private String sep ="~";
    public MemoNodeFileDAO() {
    	try {
			Files.deleteIfExists(pad);
			Files.createFile(pad);
		} catch (IOException e) {
			e.printStackTrace();
		}

    }
	@Override
	public Stream<TreeNode<MemoNode>> findAll() {
		// TODO Auto-generated method stub
		Map<Integer,MemoNode> map = new HashMap<>();
		Tree<MemoNode> tree = null;
		try {
			tree =
					Files.lines(pad).map(s -> createMemoNode(s.split(sep,-1),map))
			                .collect(NodeTree::new,NodeTree::add,NodeTree::combine);
		    return tree.stream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	//  Maak van het ingelezen record weer een MemoNode
	private MemoNode createMemoNode(String[] s,Map<Integer,MemoNode> map) {
		Memo m = new Memo(s[2],s[3]);
		MemoNode mn = new MemoNode(m);
		map.put(Integer.valueOf(s[0]),mn);
		if (!s[1].equals("")) {
			mn.setParent(map.get(Integer.valueOf(s[1])));
		}
		return mn;
	}

	@Override
	// Wegschrijven van treeNode naar bestan met een regel per MemoNode
	public void create(TreeNode<MemoNode> node) {
	    StringBuffer sb = new StringBuffer(""+node.node().getId())
	                          .append(sep)
	                          .append(node.node().getParentId().isPresent()?
	                        		  node.node().getParentId().getAsLong():"")
	                          .append(sep)
	                          .append(node.node().getObject().getTitel())
	                          .append(sep)
	                          .append(node.node().getObject().getMemo()!=null?node.node().getObject().getMemo():"")
	                          .append(sep)
	                          .append(System.lineSeparator() );
    try {
		Files.write(pad,sb.toString().getBytes()
				       ,StandardOpenOption.CREATE
				       ,StandardOpenOption.APPEND
				       );
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	{
	      if (System.getProperty("os.name").startsWith("Windows")) {
	    	  pad  = Paths.get("C:\\tmp\\memonodes.txt");
	      }
	      else {
	    	  pad  = Paths.get("//home/maarten/Documenten/tmp/memonodes.txt");
	      }
	}
}
