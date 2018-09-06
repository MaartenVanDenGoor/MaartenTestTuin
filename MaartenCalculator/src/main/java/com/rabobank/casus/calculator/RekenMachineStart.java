package com.rabobank.casus.calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.*;

import org.apache.commons.lang3.math.NumberUtils;

import com.rabobank.casus.calculate.RekenMachineLogica;

public class RekenMachineStart {
	
    private static JTextArea displayField;
    private static JTextArea breadCrumbField;
    private static boolean resultaat = false;
	public static void main(String[] args) {
		JFrame frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container container = frame.getContentPane();
		container.setLayout(null);
		
		displayField = new JTextArea();
		breadCrumbField = new JTextArea();
		breadCrumbField.setBounds(10, 20, 180, 20);
		displayField.setBounds(10, 45, 180, 155);
		// User input alleen via de knoppen
		displayField.setEditable(false);
		breadCrumbField.setEditable(false);
        //
		Font font = new Font("Courier", Font.PLAIN, 16);
		container.add(breadCrumbField);
		container.add(displayField);
		//
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(6, 3));
		//
		Stream.of("1","2","3","4","5","6","7","8","9","0",".","+","-","*","/","n!","=","C")
		      .map(x -> new JButton(x))
		      .peek(x -> x.setFont(font))
		      .peek(x -> x.addActionListener(e ->	buttonClicked(e)))
		      .forEach(x -> buttonPanel.add(x));
		buttonPanel.setBounds(10, 220, 180, 240);
		container.add(buttonPanel);
		frame.setSize(220, 520);
		frame.setVisible(true);
	}
    private static void buttonClicked(ActionEvent event) {
		String actionCommand = event.getActionCommand();  
		switch (actionCommand) {                           
    		case "+": case "-": case "*": case "/": case "n!":       
    			breadCrumbField.append(" "+actionCommand+" ");
    			displayField.setText(RekenMachineLogica.calculateS(breadCrumbField.getText()));
    			resultaat = true;
    			break;    
    		case "=": 
    			displayField.setText(RekenMachineLogica.calculateS(breadCrumbField.getText()));
    			break;
    		case "C": // Alles leegpoetsen
    			displayField.setText("");
    			breadCrumbField.setText("");
    			break;
    		default : // Dus alle cijfers + decimale punt
    			breadCrumbField.append(actionCommand);
    			if (resultaat) {
    				displayField.setText(actionCommand); 
    				resultaat = false;
    			} else {
    				displayField.append(actionCommand);  
    			}
    		    break;                                         
                            
		}      	
    }


}
