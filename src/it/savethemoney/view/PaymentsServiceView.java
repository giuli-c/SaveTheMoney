package it.savethemoney.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import it.savethemoney.controller.BankAccount;

public class PaymentsServiceView extends JFrame{

	private JPanel paymentsPanel;
	private String title = "PAYMENTS SERVICE";
	private BankAccount controller;
	private BankAccountView bankAccountView;
	
	/**
	 * Finestra principale di Payments Service
	 */
	private static final long serialVersionUID = 1L;

	public PaymentsServiceView(BankAccountView bankAccount) {
		this.bankAccountView = bankAccount;
		this.Init();
	}
	
	/**
	 * Inizializzazione della finestra
	 */
	private void Init() {
		this.setTitle(title);
		this.setPreferredSize(new Dimension(300, 450));
		this.setResizable(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		paymentsPanel = new JPanel();	
		paymentsPanel.setLayout(new BorderLayout());		
		paymentsPanel.add(createButtonsPanel());
		
		this.getContentPane().add(paymentsPanel);
		this.pack();
		this.setLocationRelativeTo(null);				// dove si apre l'interfaccia (al centro)
		this.setVisible(true);
	}
	
	/**
	 * Creazione del pannello dei bottoni
	 * 
	 * @return il pannello creato
	 */
	private JPanel createButtonsPanel() {
		final JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BorderLayout());
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20)); 
		
		/**
		 * creazione dei bottoni relativi ai vari pagamenti
		 */
		JPanel paymentsPanel = new JPanel();
		paymentsPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20)); 
		paymentsPanel.setLayout(new GridLayout(3, 1));
		
		JButton transferButton 	= new JButton("Credit Transfer");
		transferButton.setPreferredSize(new Dimension(200, 80));
		transferButton.addActionListener(event -> {
			
			this.setVisible(false);
			this.dispose();
			new CreditTransferView(this);
		});			
		
		JButton paymentsButton 	= new JButton("Payments");
		paymentsButton.setPreferredSize(new Dimension(200, 80));
		paymentsButton.addActionListener(event -> {
			
			this.setVisible(false);
			this.dispose();
			new PaymentsView(this);
		});			
		
		JButton withdrawButton 	= new JButton("Withdraw");
		withdrawButton.setPreferredSize(new Dimension(200, 80));
		withdrawButton.addActionListener(event -> {
			
			this.setVisible(false);
			this.dispose();
			new WithdrawView(this);
		});
		
		paymentsPanel.add(transferButton);
		paymentsPanel.add(paymentsButton);
		paymentsPanel.add(withdrawButton);
		
		/**
		 * creazione del bottone back
		 */
		
		JPanel backPanel = new JPanel();		
		backPanel.setLayout(new BorderLayout());
		backPanel.setBorder(BorderFactory.createEmptyBorder(20,65,0,65)); 
		
		JButton backButton = new JButton("Back");		
		backButton.setPreferredSize(new Dimension(100, 50));
		backButton.addActionListener(event -> {
			this.setVisible(false);
			this.dispose();	
			this.bankAccountView.setVisible(true);
		});
		backPanel.add(backButton);
	
		buttonsPanel.add(paymentsPanel, BorderLayout.PAGE_START);
		buttonsPanel.add(backPanel, BorderLayout.PAGE_END);
		
		return buttonsPanel;
	}
}
