package it.savethemoney.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public abstract class AbstractPaymentsStructur extends JFrame{
	
	/**
	 * Set generic structur
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel principalPanel;
	private JTextArea userName;
	private JTextArea userBalance;
	
	public AbstractPaymentsStructur() {
		
		this.setVisible(true);
		principalPanel = new JPanel();	
		principalPanel.setLayout(new BorderLayout());	
		
		principalPanel.add(createPrincipalPanel(), BorderLayout.PAGE_START);
		principalPanel.add(createButtonsPanel(userName, userBalance), BorderLayout.PAGE_END);
		
		this.getContentPane().add(principalPanel);
		this.pack();
	}
	
	private JPanel createPrincipalPanel() {
		
		final JPanel userDataPanel = new JPanel();
		userDataPanel.setLayout(new GridLayout());
		userDataPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20)); 
		
		/**
		 * aggiungo i vari pannelli al pannello principale
		 */
		userDataPanel.add(createTextPanel());
		userDataPanel.add(creatTextAreaPanel());
		
		return userDataPanel;
	}
		
	private JPanel createTextPanel() {
		/**
		 * Creazione della sezione risposte dell'utente
		 * 
		 */
		JPanel userTextPanel = new JPanel();
		userTextPanel.setLayout(new BorderLayout());
			
		/** 
		 * creazione della sezione data
		 */
		JTextField dataDate 	= new JTextField("Date: ");
		dataDate.setPreferredSize(new Dimension(150, 40));
		dataDate.setFont(new Font("Cambria", Font.ITALIC, 15));
		dataDate.setEditable(false);
				
		
		/** 
		 * creazione della sezione nome
		 */
		JTextField dataName 	= new JTextField("Name: ");
		dataName.setPreferredSize(new Dimension(150, 40));
		dataName.setFont(new Font("Cambria", Font.ITALIC, 15));
		dataName.setEditable(false);
				
		/** 
		 * creazione della sezione bilancio
		 */
		JTextField dataBalance 	= new JTextField("Balance: ");
		dataBalance.setPreferredSize(new Dimension(150, 40));
		dataBalance.setFont(new Font("Cambria", Font.ITALIC, 15));
		dataBalance.setEditable(false);
			
		/**
		 * agggiungo le domande al pannello
		 */
		userTextPanel.add(dataDate, BorderLayout.PAGE_START);
		userTextPanel.add(dataName, BorderLayout.CENTER);
		userTextPanel.add(dataBalance, BorderLayout.CENTER);
		
		return userTextPanel;
	}	
	
	private JPanel creatTextAreaPanel() {
		/**
		 * Creazione della sezione risposte dell'utente
		 * 
		 */
		JPanel userTextAreaPanel = new JPanel();
		userTextAreaPanel.setLayout(new BorderLayout());
				
		/** 
		 * creazione della sezione nome
		 */
		userName 	= new JTextArea("\n  \n");
		userName.setPreferredSize(new Dimension(150, 40));
		userName.setFont(new Font("Cambria", Font.ITALIC, 15));
				
		/** 
		 * creazione della sezione bilancio
		 */
		userBalance 	= new JTextArea("\n ");
		userBalance.setPreferredSize(new Dimension(150, 40));
		userBalance.setFont(new Font("Cambria", Font.ITALIC, 15));
			
		/**
		 * agggiungo le domande al pannello
		 */
		userTextAreaPanel.add(userName, BorderLayout.PAGE_START);
		userTextAreaPanel.add(userBalance, BorderLayout.CENTER);
		
		return userTextAreaPanel;
	}
	
	public abstract JPanel createButtonsPanel(JTextArea userName, JTextArea userBalance);
}
