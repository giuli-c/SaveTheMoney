package it.savethemoney.view.expense;

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
import it.savethemoney.view.AbstractGenericButton;
import it.savethemoney.view.BankAccountView;

public abstract class AbstractExpenseGeneralView extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String title = "EXPENCE";
	private BankAccount controller;
	private JPanel principalPanel;
	private JTextArea userDate;
	private JTextArea userImport;
	private ExpenceView expenceView;
	
	public AbstractExpenseGeneralView(ExpenceView expence) {
		this.expenceView = expence;
		this.Init();		
	}
	
	/**
	 * Inizializzazione della finestra
	 */
	private void Init() {
		this.setTitle(title);
		this.setSize(300, 450);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);				// dove si apre l'interfaccia (al centro)
		this.getContentPane().setBackground(Color.BLACK);
		
		principalPanel = new JPanel();	
		principalPanel.setLayout(new BorderLayout());	
		
		principalPanel.add(createPrincipalPanel(), BorderLayout.PAGE_START);
		principalPanel.add(createButtonsPanel(userDate, userImport), BorderLayout.CENTER);
		
		this.getContentPane().add(principalPanel);
		this.pack();
		this.setVisible(true);
	}
	
	private JPanel createPrincipalPanel() {
		
		final JPanel userDataPanel = new JPanel();
		userDataPanel.setLayout(new GridLayout());
		userDataPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20)); 
		
		/**
		 * aggiungo i vari pannelli al pannello principale
		 */
		userDataPanel.add(createDatePanel());
		userDataPanel.add(createImportPanel());
		
		return userDataPanel;
	}
		
	private JPanel createDatePanel() {
		/**
		 * Creazione della sezione data
		 * 
		 */
		JPanel userDatePanel = new JPanel();
		userDatePanel.setLayout(new BorderLayout());
				
		/** 
		 * domanda
		 */
		JTextField dataDate 	= new JTextField("Date: ");
		dataDate.setPreferredSize(new Dimension(150, 40));
		dataDate.setFont(new Font("Cambria", Font.ITALIC, 15));
		dataDate.setEditable(false);
				
		/** 
		 * risposta
		 */
		userDate 	= new JTextArea();
		userDate.setPreferredSize(new Dimension(150, 40));
		userDate.setFont(new Font("Cambria", Font.ITALIC, 15));
			
		/**
		 * agggiungo le domande al pannello
		 */
		userDatePanel.add(dataDate, BorderLayout.LINE_START);
		userDatePanel.add(userDate, BorderLayout.CENTER);
		
		return userDatePanel;
	}	
	
	private JPanel createImportPanel() {
		/**
		 * Creazione della sezione risposte dell'utente
		 * 
		 */
		JPanel userImportPanel = new JPanel();
		userImportPanel.setLayout(new BorderLayout());
		
		/** 
		 * creazione della sezione bilancio
		 */
		JTextField dataImport 	= new JTextField("Import: ");
		dataImport.setPreferredSize(new Dimension(150, 40));
		dataImport.setFont(new Font("Cambria", Font.ITALIC, 15));
		dataImport.setEditable(false);
		
		/** 
		 * creazione della sezione bilancio
		 */
		userImport 	= new JTextArea();
		userImport.setPreferredSize(new Dimension(150, 40));
		userImport.setFont(new Font("Cambria", Font.ITALIC, 15));
			
		/**
		 * agggiungo le domande al pannello
		 */
		userImportPanel.add(dataImport, BorderLayout.LINE_START);
		userImportPanel.add(userImport, BorderLayout.CENTER);
		
		return userImportPanel;
	}
	
	public JPanel createButtonsPanel(JTextArea userName, JTextArea userBalance) {
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BorderLayout());
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20)); 
		
		/**
		 * Definizione della funzione del bottone go
		 */
		JButton confirmButton = new GenericButton("Go");
		confirmButton.addActionListener(event -> {
			this.controller = new BankAccountImpl(controller.getName(), controller.getAccountBalance().getBalance());	
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
			this.expenceView.setVisible(true);
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

