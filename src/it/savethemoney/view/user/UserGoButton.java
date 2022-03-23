package it.savethemoney.view.user;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class UserGoButton extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserGoButton(String name) {
		super(name);
		
		setSize(new Dimension(60, 40));
		setFont(new Font("Cambria", Font.BOLD, 18)); 
	}
}
