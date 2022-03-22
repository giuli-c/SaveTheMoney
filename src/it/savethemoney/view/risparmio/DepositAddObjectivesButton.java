package it.savethemoney.view.risparmio;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class DepositAddObjectivesButton extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	public DepositAddObjectivesButton(String name) {
		super(name);
		
		setPreferredSize(new Dimension(150, 50));
		setFont(new Font("Cambria", Font.BOLD, 18));
		setBorder(BorderFactory.createEmptyBorder(40,40,40,40)); 
	}
}
