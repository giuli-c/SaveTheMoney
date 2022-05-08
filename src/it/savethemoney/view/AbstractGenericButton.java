package it.savethemoney.view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public abstract class AbstractGenericButton extends JButton{

	/**
	 * Set generic button 
	 */
	private static final long serialVersionUID = 1L;

	public AbstractGenericButton(String name) {
		super(name);
		
		setFont(new Font("Cambria", Font.BOLD, 18)); 
		setPreferredSize(new Dimension(100, 50));
		setBounds(150, 50, 80, 30);
	}
}