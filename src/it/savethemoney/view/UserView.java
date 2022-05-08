package it.savethemoney.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import it.savethemoney.controller.BankAccount;
import it.savethemoney.controller.BankAccountImpl;

public class UserView extends JFrame{

	/**
	 * Finestra di benvenuto dove lo user può inserire i propri dati personali 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String title = "WELCOME";
	private BankAccount controller;
	private JTextArea userName;
	private JTextArea userBalance;
	private JPanel principalPanel;
	
	public UserView() {
		this.Init();		
	}
	
	/**
	 * Inizializzazione della finestra
	 */
	private void Init() {
		this.setTitle(title);
		this.setSize(600, 950);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.BLACK);
		
		principalPanel = new JPanel();	
		principalPanel.setLayout(new BorderLayout());	
		
		principalPanel.add(createPrincipalPanel(), BorderLayout.PAGE_START);
		principalPanel.add(createButtonsPanel(), BorderLayout.CENTER);
		
		this.getContentPane().add(principalPanel);
		this.pack();
		this.setLocationRelativeTo(null);				// dove si apre l'interfaccia (al centro)
		this.setVisible(true);
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
	
	public JPanel createTextPanel() {
		/**
		 * Creazione della sezione risposte dell'utente
		 * 
		 */
		JPanel userTextPanel = new JPanel();
		userTextPanel.setLayout(new BorderLayout());
				
		/** 
		 * creazione della sezione nome
		 */
		JTextField dataName 	= new JTextField("What's your name?");
		dataName.setPreferredSize(new Dimension(170, 40));
		dataName.setFont(new Font("Cambria", Font.ITALIC, 15));
		dataName.setEditable(false);
				
		/** 
		 * creazione della sezione bilancio
		 */
		JTextField dataBalance 	= new JTextField("What's your balance?");
		dataBalance.setPreferredSize(new Dimension(170, 40));
		dataBalance.setFont(new Font("Cambria", Font.ITALIC, 15));
		dataBalance.setEditable(false);
			
		/**
		 * agggiungo le domande al pannello
		 */
		userTextPanel.add(dataName, BorderLayout.PAGE_START);
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
		this.userName 	= new JTextArea("\n  \n");
		this.userName.setPreferredSize(new Dimension(150, 40));
		this.userName.setFont(new Font("Cambria", Font.ITALIC, 15));
				
		/** 
		 * creazione della sezione bilancio
		 */
		this.userBalance 	= new JTextArea("\n ");
		this.userBalance.setPreferredSize(new Dimension(150, 40));
		this.userBalance.setFont(new Font("Cambria", Font.ITALIC, 15));
			
		/**
		 * agggiungo le domande al pannello
		 */
		userTextAreaPanel.add(userName, BorderLayout.PAGE_START);
		userTextAreaPanel.add(userBalance, BorderLayout.CENTER);
		
		return userTextAreaPanel;
	}

	public JPanel createButtonsPanel() {
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BorderLayout());
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(20,150,20,150)); 
		
		JButton confirmButton = new GenericButton("Go");		
		confirmButton.addActionListener(event -> {
			// exception: NumberFormatException se balance non è Double
			this.controller = new BankAccountImpl(userName.getText(), Double.valueOf(userBalance.getText()));	
			this.setVisible(false);
			this.dispose();													// fa sì che la JFramefinestra venga distrutta e ripulita dal sistema operativo.
			new BankAccountView(this.controller);
		});
		buttonsPanel.add(confirmButton);
		
		return buttonsPanel;
	}
	
}