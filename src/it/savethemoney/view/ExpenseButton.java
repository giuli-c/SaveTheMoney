package it.savethemoney.view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class ExpenseButton extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExpenseButton(String name) {
		super(name);
		
		setPreferredSize(new Dimension(0, 40));
		setFont(new Font("Cambria", Font.BOLD, 18));
		setHorizontalTextPosition(SwingConstants.CENTER);
	}
}