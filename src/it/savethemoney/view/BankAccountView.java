package it.savethemoney.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import it.savethemoney.controller.BankAccount;
import it.savethemoney.view.expense.ExpenceView;

public class BankAccountView extends JFrame{

	private final String title = "BANK ACCOUNT";
	private final BankAccount controller;
	private JPanel bankAccountPanel;
	private JLabel balanceLabel;
	
	/**
	 * Finestra del proprio BankAccount
	 */
	private static final long serialVersionUID = 1L;

	public BankAccountView(BankAccount controller) {
		this.controller = controller;
		this.Init();
	}
	
	/**
	 * Inizializzazione della finestra
	 */
	private void Init() {
		this.setTitle(title);
		this.setPreferredSize(new Dimension(400, 550));
		this.setResizable(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bankAccountPanel = new JPanel();	
		bankAccountPanel.setLayout(new BorderLayout());	
		
		bankAccountPanel.add(createLabelPanel(), BorderLayout.PAGE_START);
		bankAccountPanel.add(createButtonsPanel(), BorderLayout.CENTER);
		bankAccountPanel.add(createTransactionPanel(), BorderLayout.PAGE_END);
		
		this.getContentPane().add(bankAccountPanel);
		this.pack();
		this.setLocationRelativeTo(null);				// dove si apre l'interfaccia (al centro)
		this.setVisible(true);
	}
	
	/**
	 * Creazione del pannello delle etichette
	 * 
	 * @return il pannello creato
	 */
	private JPanel createLabelPanel() {
		
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new BorderLayout());
					
		/** 
		 * creazione dell'etichetta nome
		 */
		JLabel nameLabel = new JLabel("\n Hi " + controller.getName());
		nameLabel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		nameLabel.setPreferredSize(new Dimension(0, 20));
		nameLabel.setFont(new Font("Cambria", Font.ITALIC, 20));
	
		/**
		 * creazione dell'etichetta bilancio
		 */
		this.balanceLabel = new JLabel("Tot. Balance: " + controller.getAccountBalance().getBalance());
		balanceLabel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		balanceLabel.setPreferredSize(new Dimension(0, 20));
		balanceLabel.setFont(new Font("Cambria", Font.ITALIC, 20));
		
		/**
		 * inserimento delle etichette nel pannello
		 */
		labelPanel.add(Box.createVerticalStrut(20));
		labelPanel.add(nameLabel, BorderLayout.PAGE_START);
		labelPanel.add(Box.createVerticalStrut(30));
		labelPanel.add(balanceLabel, BorderLayout.PAGE_END);
		
		return labelPanel;
	}
	
	/**
	 * Creazione del pannello dei bottoni
	 * 
	 * @return il pannello creato
	 */
	private JPanel createButtonsPanel() {
		final JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(2, 2, 30, 40));
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20)); 
			
		JButton depositButton 	= new ActivityButton("DEPOSIT");
		depositButton.addActionListener(event -> {
			
			this.setVisible(false);
			this.dispose();
			new DepositView(this, controller);
		});			
		
		JButton expenseButton 	= new ActivityButton("<html>EXPENSE<br /> MANAGEMENT</html>");
		expenseButton.addActionListener(event -> {
			
			this.setVisible(false);
			this.dispose();
			new ExpenceView(this);
		});			
		
		JButton paymentsButton 	= new ActivityButton("<html>PAYMENT<br /> SERVICES</html>");
		paymentsButton.addActionListener(event -> {
			
			this.setVisible(false);
			this.dispose();
			new PaymentsServiceView(this);
		});			
		
		JButton savingButton 	= new ActivityButton("<html>SAVING<br /> PLAIN<html>");
		savingButton.addActionListener(event -> {
			
			this.setVisible(false);
			this.dispose();
			
			//Ho invocato il getInstance in maniera statica passandogli i valori che verranno inseriti solo
			//se non esiste già l'istanza. Dopodichè ho impostato la visibilità così da garantire la visibilità
			//anche se esiste già la classe
			SavingPlainView.getInstance(this, controller).setVisible(true);			
		});			
		
		buttonsPanel.add(depositButton);
		buttonsPanel.add(expenseButton);
		buttonsPanel.add(paymentsButton);
		buttonsPanel.add(savingButton);
		
		return buttonsPanel;
	}
	
	/**
	 * Creazione del pannello del menu a tendina
	 * 
	 * @return il pannello creato
	 */
	private JPanel createTransactionPanel() {
		
		JPanel transactionPanel = new JPanel();
		transactionPanel.setLayout(new BorderLayout());
		
		setBounds(80, 50, 140, 20);
		setLayout(new BorderLayout());
		
		/**
		 * Creazione del menu a tendina
		 * 
		 */
		JComboBox<Object> expenseCombo = new JComboBox<Object>();
		
		transactionPanel.add(expenseCombo, BorderLayout.CENTER);
		
		return transactionPanel;
	}
	
	public void setBalanceLable(Double balanceUser) {
		this.balanceLabel.setText("Tot. Balance: " + String.valueOf(controller.getAccountBalance().addBalance(balanceUser)));
	}
	
	private class ActivityButton extends JButton{

		/**
		 * creata classe innestata per evitare una ridondanza del codice
		 */
		private static final long serialVersionUID = 1L;

		public ActivityButton(String name) {
			super(name);		
			this.setFont(new Font("Cambria", Font.BOLD, 18)); 
			this.setPreferredSize(new Dimension(30, 40));
		}
	}
}
