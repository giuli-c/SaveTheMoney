package it.savethemoney.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import it.savethemoney.controller.BankAccount;
import it.savethemoney.controller.BankAccountImpl;

public class CreditTransferView extends AbstractPaymentsStructure {

	private final String title = "CREDIT TRANSFER";
	private BankAccount controller;
	private PaymentsServiceView paymentsServiceView;
	private BankAccountView bankAccountView;
	private JComboBox<Object> expenseComboBar;
	
	/**
	 * Finestra principale di Trasferimento denaro
	 */
	private static final long serialVersionUID = 1L;

	public CreditTransferView(PaymentsServiceView paymentsService, BankAccountView bankAccount, BankAccount controller, JComboBox<Object> expenseCombo) {
		this.paymentsServiceView = paymentsService;
		this.bankAccountView 	 = bankAccount;
		this.controller			 = controller;
		this.expenseComboBar	 = expenseCombo;
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
	public JPanel createButtonsPanel(JTextArea transferDate, JTextArea transferName, JTextArea transferBalance) {
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BorderLayout());
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20)); 
		
		/**
		 * Definizione della funzione del bottone go
		 */
		JButton confirmButton = new GenericButton("Go");
		confirmButton.addActionListener(event -> {
			this.setVisible(false);
			this.dispose();													// fa sì che la JFramefinestra venga distrutta e ripulita dal sistema operativo.
			expenseComboBar.add(createdCreditTransferToTransactionPanel(transferDate, transferName, transferBalance));
			bankAccountView.setVisible(true);
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
	
	private JPanel createdCreditTransferToTransactionPanel(JTextArea transferDate, JTextArea transferName, JTextArea transferBalance) {
		JPanel creditTransferToTransactionPanel = new JPanel();
		creditTransferToTransactionPanel.setLayout(new BoxLayout(creditTransferToTransactionPanel, BoxLayout.LINE_AXIS));
		creditTransferToTransactionPanel.setBorder(BorderFactory.createLoweredBevelBorder()); 
		
		/** 
		 * creazione della sezione data trasferimento
		 */
		JTextField dataDate 	= new JTextField(transferDate.getText());
		dataDate.setPreferredSize(new Dimension(150, 40));
		dataDate.setFont(new Font("Cambria", Font.ITALIC, 15));
		dataDate.setEditable(false);
		
		/** 
		 * creazione della sezione nome a cui effettuare il trasferimento
		 */
		JTextField dataName 	= new JTextField(transferName.getText());
		dataName.setPreferredSize(new Dimension(150, 40));
		dataName.setFont(new Font("Cambria", Font.ITALIC, 15));
		dataName.setEditable(false);
				
		/** 
		 * creazione della sezione importo del trasferimento
		 */
		JTextField dataBalance 	= new JTextField(transferBalance.getText());
		dataBalance.setPreferredSize(new Dimension(150, 40));
		dataBalance.setFont(new Font("Cambria", Font.ITALIC, 15));
		dataBalance.setEditable(false);
		
		/**
		 * agggiungo i dati al pannello
		 */
		creditTransferToTransactionPanel.add(dataDate);
		creditTransferToTransactionPanel.add(dataName);	
		creditTransferToTransactionPanel.add(dataBalance);		
		
		return creditTransferToTransactionPanel;
	}
}
