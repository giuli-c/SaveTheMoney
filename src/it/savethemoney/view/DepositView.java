package it.savethemoney.view;

import java.awt.BorderLayout;
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

public class DepositView extends JFrame {

	private final String title = "CREDIT TRANSFER";
	private final BankAccount controller;
	private final BankAccountView bankAccountView;
	private JPanel depositPanel;
	private JTextArea answerText;
	
	/**
	 * Finestra principale di pagamenti elettronici
	 */
	private static final long serialVersionUID = 1L;

	public DepositView(BankAccountView bankAccount, BankAccount controller) {
		this.bankAccountView = bankAccount;
		this.controller		 = controller;
		this.Init();
	}
	
	/**
	 * Inizializzazione della finestra
	 */
	private void Init() {
		this.setTitle(title);
		this.setSize(600, 350);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.depositPanel = new JPanel();	
		this.depositPanel.setLayout(new BorderLayout());	
		
		this.depositPanel.add(createPrincipalPanel(), BorderLayout.CENTER);
		this.depositPanel.add(createButtonsPanel(), BorderLayout.PAGE_END);
		
		this.getContentPane().add(depositPanel);
		this.pack();
		this.setLocationRelativeTo(null);				// dove si apre l'interfaccia (al centro)
		this.setVisible(true);
	}
	
	private JPanel createPrincipalPanel() {
		
		final JPanel userDataPanel = new JPanel();
		userDataPanel.setLayout(new GridLayout());
		userDataPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20)); 
		
		/**
		 * Creazione della sezione domande all'utente
		 * 
		 */
		JTextField requestText 	= new JTextField("How much do you want to deposit?");
		requestText.setPreferredSize(new Dimension(250, 40));
		requestText.setFont(new Font("Cambria", Font.ITALIC, 15));
		requestText.setEditable(false);
		
		/**
		 * Creazione della sezione risposte dell'utente
		 * 
		 */
		this.answerText 	= new JTextArea("\n  \n");
		answerText.setPreferredSize(new Dimension(150, 40));
		answerText.setFont(new Font("Cambria", Font.ITALIC, 15));
		
		/**
		 * aggiungo i vari pannelli al pannello principale
		 */
		userDataPanel.add(requestText);
		userDataPanel.add(answerText);
		
		return userDataPanel;
	}
	
	public JPanel createButtonsPanel() {
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BorderLayout());
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20)); 
		
		/**
		 * Definizione della funzione del bottone go
		 */
		JButton confirmButton = new GenericButton("Go");
		confirmButton.addActionListener(event -> {
			this.setVisible(false);			
			this.bankAccountView.setBalanceLable(Double.valueOf(answerText.getText()));
			this.bankAccountView.setVisible(true);
			this.dispose();													// fa sì che la JFramefinestra venga distrutta e ripulita dal sistema operativo.
			
		});
		
		/**
		 * definizione della funzione del bottone back
		 */
		JButton backButton = new GenericButton("Back");
		backButton.addActionListener(event -> {
			this.setVisible(false);
			this.dispose();	
			this.bankAccountView.setVisible(true);
		});
		
		buttonsPanel.add(backButton, BorderLayout.LINE_START);
		buttonsPanel.add(confirmButton, BorderLayout.LINE_END);
		
		return buttonsPanel;
	}
}
