package it.savethemoney.view.user;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

public class UserFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel buttonPanel;
	private JPanel userPanel;
	
	public UserFrame(String name, String sentenceName, String sentenceAmount) {
		super(name);
		setSize(400, 200);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);				// dove si apre l'interfaccia (al centro)
		getContentPane().setBackground(Color.BLACK);
		
		this.buttonPanel = new ButtonPanel();
		this.userPanel = new UserPanel(sentenceName, sentenceAmount);
	
		setLayout(new BorderLayout());
		
		add(userPanel, BorderLayout.PAGE_START);
		add(buttonPanel, BorderLayout.CENTER);
		
		setVisible(true);
	}
}
