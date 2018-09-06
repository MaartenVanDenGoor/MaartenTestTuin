package com.rabobank.casus.calculator;

import java.awt.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.*;

public class RekenMachineStart {
	
    private static JTextArea displayField;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container container = frame.getContentPane();
		container.setLayout(null);
		
		displayField = new JTextArea();
		displayField.setBounds(10, 20, 180, 180);
		Font font = new Font("Courier", Font.PLAIN, 9);
		container.add(displayField);
		//
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(5, 3));
		//
		Stream.of("1","2","3","4","5","6","7","8","9","0","+","-","*","/","=")
		      .map(x -> new JButton(x))
		      .peek(x -> x.setFont(font))
		      .peek(x -> x.addActionListener(		e -> {
		    		String actionCommand = e.getActionCommand();   
		    		switch (actionCommand) {                           
			    		case "1":                                          
			    			displayField.setText("1");   
			    			break;                                         
			    		default :
			    		    displayField.setText(actionCommand);  
			    			break;                                         
			    		case "3":                                          
			    			break;                                         
		    		}                                                  
		    	  
		      }	))
		      .forEach(x -> buttonPanel.add(x));

		buttonPanel.setBounds(10, 220, 180, 200);
		container.add(buttonPanel);
		
		frame.setSize(220, 500);
		frame.setVisible(true);
	}

}
