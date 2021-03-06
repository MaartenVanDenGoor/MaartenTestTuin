package com.vijfhart.casus.tree.memo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToDoubleFunction;

import com.vijfhart.casus.tree.*;
import com.vijfhart.casus.tree.dao.MemoNodeDatabaseDAO;
import com.vijfhart.casus.tree.dao.MemoNodeFileDAO;
import com.vijfhart.casus.tree.file.TreeNode;

public class MemoApp {
	public static void main(String[] args) {
		Memo memo = new Memo("memo");
		Memo thuis = new Memo("thuis");
		Memo boodschappen = new Memo("boodschappen","aardappelen, groenten, fruit");
		Memo werk = new Memo("werk");
		Memo casus = new Memo("casus","DAO pattern implementeren");
		//
		List<MemoNode> lijst = new ArrayList<>();
		//
		MemoNode mn = new MemoNode(memo);
		lijst.add(mn);
		MemoNode mt = new MemoNode(thuis,mn);
		lijst.add(mt);
		MemoNode mtb = new MemoNode(boodschappen,mt);
		lijst.add(mtb);
		MemoNode mw = new MemoNode(werk,mn);
		lijst.add(mw);
		MemoNode mwc = new MemoNode(casus,mw);
		lijst.add(mwc);		
		//
		Tree<MemoNode> tree = new NodeTree<>(lijst);
	    //
		tree.stream().forEach(n->System.out.println(n.getId()+" "+n.path("/")));
		//

		System.out.println("Opslaan in bestand en uitlezen");
		MemoNodeFileDAO dao = new MemoNodeFileDAO();
		tree.stream().forEach(m -> dao.create(m));
		dao.findAll().forEach(n->System.out.println(n.path("/")));
		System.out.println("=========================");

		System.out.println("Opslaan in database en uitlezen");
		MemoNodeDatabaseDAO daoDb = new MemoNodeDatabaseDAO();
		tree.stream().forEach(m -> daoDb.create(m));
		daoDb.findAll().forEach(n->System.out.println(n.path("/")));

	}
}
