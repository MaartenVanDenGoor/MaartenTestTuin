package com.vijfhart.casus.tree.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.vijfhart.casus.tree.file.TreeNode;
import com.vijfhart.casus.tree.memo.MemoNode;

public class MemoNodeFileDAO implements NodeDAO<MemoNode> {
	public static void main(String[] args) {
		MemoNodeFileDAO dao = new MemoNodeFileDAO();
	}
    private Path pad  = Paths.get("//home/maarten/Documenten/tmp/memonodes.txt");
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
		return null;
	}

	@Override
	public void create(TreeNode<MemoNode> node) {
		// TODO Auto-generated method stub
	//	node.getId()
		
	}
}
