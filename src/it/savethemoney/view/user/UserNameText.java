package it.savethemoney.view.user;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class UserNameText extends JTextField{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNameText(String sentence) {
		super(sentence);
		
		setPreferredSize(new Dimension(100, 30));
		setFont(new Font("Cambria", Font.ITALIC, 11));
	}
}