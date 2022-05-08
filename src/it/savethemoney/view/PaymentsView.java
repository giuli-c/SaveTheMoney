package it.savethemoney.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import it.savethemoney.controller.BankAccount;
import it.savethemoney.controller.BankAccountImpl;

public class PaymentsView extends AbstractPaymentsStructur {

	private final String title = "CREDIT TRANSFER";
	private BankAccount controller;
	PaymentsServiceView paymentsServiceView;
	
	/**
	 * Finestra principale di pagamenti elettronici
	 */
	private static final long serialVersionUID = 1L;

	public PaymentsView(PaymentsServiceView paymentsService) {
		
		this.paymentsServiceView = paymentsService;
		this.Init();
		this.setVisible(true);
	}
	
	/**
	 * Inizializzazione della finestra
	 */
	private void Init() {
		this.setTitle(title);
		this.setSize(400, 250);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);						// dove si apre l'interfaccia (al centro)
		this.getContentPane().setBackground(Color.BLACK);
	}
	
	@Override
	public JPanel createButtonsPanel(JTextArea userName, JTextArea userBalance) {
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BorderLayout());
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20)); 
		
		/**
		 * Definizione della funzione del bottone go
		 */
		JButton confirmButton = new GenericButton("Go");
		confirmButton.addActionListener(event -> {
			this.controller = new BankAccountImpl(userName.getText(), Double.valueOf(userBalance.getText()));
			this.setVisible(false);
			this.dispose();													// fa sì che la JFramefinestra venga distrutta e ripulita dal sistema operativo.
			//// Una volta che viene confermato cosa succede?
		});
		
		/**
		 * definizione della funzione del bottone back
		 */
		JButton backButton = new GenericButton("Back");
		backButton.addActionListener(event -> {
			this.setVisible(false);
			this.dispose();	
			this.paymentsServiceView.setVisible(true);
		});
		
		buttonsPanel.add(backButton, BorderLayout.LINE_START);
		buttonsPanel.add(confirmButton, BorderLayout.LINE_END);
		
		return buttonsPanel;
	}
	
	private class GenericButton extends AbstractGenericButton{	
		/**
		 * creata classe innestata per evitare una ridondanza del codice
		 */
		private static final long serialVersionUID = 1L;
	
		public GenericButton(String name) {
			super(name);
		}
	}
}
