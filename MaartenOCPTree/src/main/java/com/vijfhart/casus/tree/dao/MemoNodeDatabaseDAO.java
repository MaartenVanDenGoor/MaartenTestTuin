package com.vijfhart.casus.tree.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import javax.swing.*;

import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;

import com.vijfhart.casus.tree.*;
import com.vijfhart.casus.tree.file.TreeNode;
import com.vijfhart.casus.tree.memo.*;


public class MemoNodeDatabaseDAO implements NodeDAO<MemoNode> {
	private String password = null;
	private Connection con = null;
	String insertMemo= "insert into memo"
			+ "(Id, idref, title, description) values"
			+ "(?,?,?,?)";
	String selectMemo = "select * from memo order by id asc";

	public MemoNodeDatabaseDAO() {
		// Get password for root
		Console cnsl = null;
		cnsl = System.console();
		if (cnsl!=null) {
			password = new String(cnsl.readPassword("Password voor root: "));
		} else {
			// System.console does not work in Eclipse :(
			getPassword();
		}
		// remove old data from table memo
		con = MyConnection.connect(password);
		try {
			Statement stmt = con.createStatement();
			stmt.execute("truncate table memo;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public Stream<TreeNode<MemoNode>> findAll() {
		List<MemoNode> lijst = new ArrayList<>();
		PreparedStatement ps;
		Map<Integer,MemoNode> map = new HashMap<>();
		try {
			ps = con.prepareStatement(selectMemo);
			ResultSet rset = ps.executeQuery();
			while (rset.next()) {
				lijst.add(createMemoNode(rset,map));
			}
		    return new NodeTree<MemoNode>(lijst).stream();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//  Maak van het ingelezen record weer een MemoNode
	private MemoNode createMemoNode(ResultSet rs,Map<Integer,MemoNode> map) {
		Memo m = null;
		MemoNode mn = null;
		try {
			m = new Memo(rs.getString("title"),rs.getString("description"));
			mn = new MemoNode(m);
			map.put(rs.getInt("id"),mn);
			if (rs.getInt("id")!=0) {
				mn.setParent(map.get(rs.getInt("idref")));
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return mn;
	}
	@Override
	public void create(TreeNode<MemoNode> node) {
		PreparedStatement ps;
		String title = node.node().getObject().getTitel();
		String description = node.node().getObject().getMemo();
		try {
			ps = con.prepareStatement(insertMemo);
			ps.setLong(1, node.getId());
			if (node.node().getParentId().isPresent()) {
				ps.setLong(2, node.node().getParentId().getAsLong());
			} else {
				ps.setNull(2, java.sql.Types.INTEGER);
			}
			ps.setString(3, title);
			ps.setString(4, description);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void getPassword() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Password voor root: ");
		JPasswordField pass = new JPasswordField(10);
		panel.add(label);
		panel.add(pass);
		String[] options = new String[]{"OK", "Cancel"};
		int option = JOptionPane.showOptionDialog(null, panel, "Pasword",
				JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, options, options[1]);
		if(option == 0) // pressing OK button
		{
			password = new String(pass.getPassword());
			System.out.println("Your password is: " + password);
		}    	
	}
}
class MyConnection {
	private final static String url = 
			"jdbc:mysql://localhost:3306/tree_casus?useSSL=false&useJDBCCompliantTimezoneShift=true&allowPublicKeyRetrieval=true&useLegacyDatetimeCode=false&serverTimezone=CET";
	//protocol:vendor//locatie:poort/database
	public static Connection connect(String pwd) {
		try {
			Connection conn = DriverManager.getConnection(url,"root",pwd);
			conn.setAutoCommit(false);
			return conn;
		} catch (SQLException e) {
			System.err.println("Fout bij inloggen "+e.getMessage());
			return null;
		}
	}
}	 