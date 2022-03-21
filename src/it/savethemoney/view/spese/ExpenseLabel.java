package it.savethemoney.view.spese;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class ExpenseLabel extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExpenseLabel(String name) {
		super(name);
		
		setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		setPreferredSize(new Dimension(0, 40));
		setFont(new Font("Cambria", Font.ITALIC, 20));
	}
}
