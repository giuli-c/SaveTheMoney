package it.savethemoney.view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class SavingButton extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SavingButton(String name){
		super(name);
		
		setPreferredSize(new Dimension(0, 40));
		setFont(new Font("Cambria", Font.BOLD, 20));
	}
}