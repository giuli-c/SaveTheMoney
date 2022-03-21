package it.savethemoney.view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class BankAccountNameLabel extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BankAccountNameLabel(String name) {
		super("Hi, " + name, SwingConstants.LEFT);
		
		setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		setPreferredSize(new Dimension(0, 20));
		setFont(new Font("Cambria", Font.ITALIC, 20));
	}
}
