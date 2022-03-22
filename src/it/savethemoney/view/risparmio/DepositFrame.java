package it.savethemoney.view.risparmio;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DepositFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel nameLabel;
	private JButton depositeButton;
	private JPanel objectivesButton;
	
	public DepositFrame(String name) {
		super(name);
		setSize(300, 200);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);				// dove si apre l'interfaccia (al centro)
		getContentPane().setBackground(Color.WHITE);
		setLayout(new BorderLayout());
	
		this.nameLabel 			= new DepositLabel("Saving Plain..");
		this.depositeButton 	= new DepositAddObjectivesButton("ADD OBJECTIVE");
		this.objectivesButton 	= new ObjetivesButtonPanel();
		
		this.add(nameLabel, BorderLayout.PAGE_START);
		this.add(objectivesButton, BorderLayout.CENTER);
		this.add(depositeButton, BorderLayout.PAGE_END);
		
		setVisible(true);
	}
}
