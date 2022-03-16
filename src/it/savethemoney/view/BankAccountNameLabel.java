package it.savethemoney.view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class BankAccountNameLabel extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BankAccountNameLabel(String name) {
		super("Hi, " + name, SwingConstants.LEFT);
		
		setPreferredSize(new Dimension(0, 100));
		setFont(new Font("Cambria", Font.ITALIC, 20));
	}
}
