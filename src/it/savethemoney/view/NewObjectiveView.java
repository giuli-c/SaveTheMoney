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
import it.savethemoney.implementation.PresentElementException;

public class NewObjectiveView extends JFrame{

	/**
	 * Finestra di benvenuto dove lo user può inserire i propri dati personali 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String title = "NEW OBJECTIVE";
	private BankAccount controller;
	private SavingPlainView savingPlainView;
	private JPanel principalPanel;
	private JTextArea userObjectiveName;
	private JTextArea userGoalAmount;
	
	public NewObjectiveView(final SavingPlainView savingPlain, BankAccount controller) {
		this.savingPlainView 	= savingPlain;
		this.controller			= controller;
		this.Init();
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
		
		this.setVisible(true);
		principalPanel = new JPanel();	
		principalPanel.setLayout(new BorderLayout());	
		
		principalPanel.add(createPrincipalPanel(), BorderLayout.PAGE_START);
		principalPanel.add(createButtonsPanel(), BorderLayout.PAGE_END);
		
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
		userObjectiveName 	= new JTextArea("\n  \n");
		userObjectiveName.setPreferredSize(new Dimension(150, 40));
		userObjectiveName.setFont(new Font("Cambria", Font.ITALIC, 15));
				
		/** 
		 * creazione della sezione bilancio
		 */
		userGoalAmount 	= new JTextArea("\n ");
		userGoalAmount.setPreferredSize(new Dimension(150, 40));
		userGoalAmount.setFont(new Font("Cambria", Font.ITALIC, 15));
			
		/**
		 * agggiungo le domande al pannello
		 */
		userTextAreaPanel.add(userObjectiveName, BorderLayout.PAGE_START);
		userTextAreaPanel.add(userGoalAmount, BorderLayout.CENTER);
		
		return userTextAreaPanel;
	}
	
	private JPanel createButtonsPanel() {
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BorderLayout());
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20)); 
		
		/**
		 * Definizione della funzione del bottone go
		 */
		JButton confirmButton = new GenericButton("Go");
		confirmButton.addActionListener(event -> {
	
			
			// HA FATTO DA SOLO
			try {
				controller.newObjective(userObjectiveName.getText(), Double.valueOf(userGoalAmount.getText()));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (PresentElementException e) {
				e.printStackTrace();
			}
			
			this.setVisible(false);
			this.savingPlainView.edit();
			this.dispose();													// fa sì che la JFramefinestra venga distrutta e ripulita dal sistema operativo.
		});
		
		/**
		 * definizione della funzione del bottone back
		 */
		JButton backButton = new GenericButton("Back");
		backButton.addActionListener(event -> {
			this.setVisible(false);
			this.dispose();	
			this.savingPlainView.setVisible(true);
		});
		
		buttonsPanel.add(backButton, BorderLayout.LINE_START);
		buttonsPanel.add(confirmButton, BorderLayout.LINE_END);
		
		return buttonsPanel;
	}
}
