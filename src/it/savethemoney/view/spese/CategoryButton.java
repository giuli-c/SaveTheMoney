package it.savethemoney.view.spese;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class CategoryButton extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CategoryButton(String name) {
		super(name);
		
		setPreferredSize(new Dimension(30, 60));
		setFont(new Font("Cambria", Font.BOLD, 18));
		setBorder(BorderFactory.createEmptyBorder(40,40,40,40)); 
	}
}
