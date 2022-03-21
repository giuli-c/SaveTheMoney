package it.savethemoney.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.BorderLayout;

public class BankAccountFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel labelPanel;
	private JPanel buttonPanel;
	
	public BankAccountFrame(String name, String namePerson, double totalBalance) {
		super(name);
		setSize(400, 600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);				// dove si apre l'interfaccia (al centro)
		getContentPane().setBackground(Color.BLACK);
		setLayout(new BorderLayout());
		
		this.labelPanel 	= new BankAccountLabelPanel(namePerson, totalBalance);
		this.buttonPanel 	= new BankAccountButtonPanel();
		
		this.add(labelPanel, BorderLayout.PAGE_START);
		this.add(buttonPanel, BorderLayout.CENTER);
		
		setVisible(true);
	}
}
