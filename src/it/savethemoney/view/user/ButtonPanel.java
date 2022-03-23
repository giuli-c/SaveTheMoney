package it.savethemoney.view.user;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class ButtonPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton goButton;
	
	public ButtonPanel() {
		this.goButton = new UserGoButton("Procedi");
		
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(20,20,20,20)); 
		
		add(goButton, BorderLayout.CENTER);
	}
}
