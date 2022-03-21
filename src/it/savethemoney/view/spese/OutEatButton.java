package it.savethemoney.view.spese;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class OutEatButton extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OutEatButton(String name) {
		super(name);
		
		setPreferredSize(new Dimension(30, 30));
		setFont(new Font("Cambria", Font.BOLD, 18));
	}
}
