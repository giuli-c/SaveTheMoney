package it.savethemoney.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import it.savethemoney.controller.BankAccount;
import it.savethemoney.implementation.ObjectivesImpl;

public class ModififyObjectiveView extends JFrame{

	private final String title = "MODIFY OBJECTIVE";
	private BankAccount controller;
	private SavingPlainView savingPlainView;
	private JPanel principalPanel;
	private JTextArea answerText;
	private JTextField paidAmountText;
	private JButton depositButton;
	
	private String objectiveName;
	private Double objectiveAmount;
	
	public ModififyObjectiveView(SavingPlainView savingPlain, BankAccount controller, String name, Double amount) {
		this.objectiveName = name;
		this.objectiveAmount = amount;
		
		this.savingPlainView = savingPlain;
		this.controller		 = controller;
		this.Init();
	}
	
	/**
	 * Inizializzazione della finestra
	 */
	private void Init() {
		this.setTitle(title);
		this.setSize(500, 350);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);						// dove si apre l'interfaccia (al centro)

		principalPanel = new JPanel();	
		principalPanel.setLayout(new BorderLayout());
		principalPanel.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));
		
		principalPanel.add(createTextPanel(), BorderLayout.PAGE_START);
		principalPanel.add(paidAmountObjectivePanel(), BorderLayout.CENTER);
		principalPanel.add(createButtonsPanel(), BorderLayout.PAGE_END);
		
		this.getContentPane().add(principalPanel);
		this.pack();
		this.setVisible(true);
	}
	
	private JPanel createTextPanel() {
		/**
		 * creazione della sezione nome e importo obbiettivo
		 */
		JPanel dataObjectivePanel = new JPanel();
		dataObjectivePanel.setLayout(new BorderLayout());
		dataObjectivePanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		/** 
		 * creazione della sezione nome obbiettivo
		 */
		JTextField dataName 	= new JTextField("Name: "+ this.objectiveName);
		dataName.setPreferredSize(new Dimension(150, 40));
		dataName.setFont(new Font("Cambria", Font.ITALIC, 15));
		dataName.setEditable(false);
				
		/** 
		 * creazione della sezione importo da raggiungere
		 */
		JTextField dataBalance 	= new JTextField("Balance: " + objectiveAmount);
		dataBalance.setPreferredSize(new Dimension(150, 40));
		dataBalance.setFont(new Font("Cambria", Font.ITALIC, 15));
		dataBalance.setEditable(false);
		
		/**
		 * agggiungo i dati al pannello
		 */
		dataObjectivePanel.add(dataName, BorderLayout.LINE_START);
		dataObjectivePanel.add(dataBalance, BorderLayout.LINE_END);	
		
		return dataObjectivePanel;
	}	
	
	private JPanel paidAmountObjectivePanel() {
		/**
		 * Creazione della sezione importo versato
		 * 
		 */
		JPanel paidAmountPanel = new JPanel();
		paidAmountPanel.setLayout(new BorderLayout());
		paidAmountPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		/** 
		*creazione della sezione IMPORTO VERSATO
		*/
		this.paidAmountText 	= new JTextField("Paid Amount: " + 0);
		paidAmountText.setPreferredSize(new Dimension(150, 40));
		paidAmountText.setFont(new Font("Cambria", Font.ITALIC, 15));
		paidAmountText.setEditable(false);
		
		/**
		 * Creazione della sezione domanda, risposta
		 * 
		 */
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new BorderLayout());
		
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
		 * Definizione della funzione del bottone DEPOSIT
		 */
		this.depositButton = new GenericButton("Deposit");
		this.depositButton.addActionListener(event -> { 
			this.dispose();													// fa sì che la JFramefinestra venga distrutta e ripulita dal sistema operativo.
			this.setBalanceLable();	
			this.setVisible(true);
		});
		
		textPanel.add(requestText, BorderLayout.LINE_START);
		textPanel.add(answerText, BorderLayout.CENTER);
		textPanel.add(depositButton, BorderLayout.LINE_END);
		
		paidAmountPanel.add(paidAmountText, BorderLayout.PAGE_START);
		paidAmountPanel.add(Box.createVerticalStrut(20));
		paidAmountPanel.add(textPanel, BorderLayout.PAGE_END);
		
		return paidAmountPanel;
	}
	
	public JPanel createButtonsPanel() {
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BorderLayout());
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20)); 
		
		/**
		 * definizione della funzione del bottone back
		 */
		JButton backButton = new GenericButton("Back");
		backButton.addActionListener(event -> {
			this.dispose();
			this.setVisible(false);
			this.savingPlainView.setVisible(true);
		});
		
		/////////////////////////////////////////////////////////////////////////////
		/**
		 * definizione della funzione modifica nome
		 */
		JButton modifyNameButton = new GenericButton("Name");
		modifyNameButton.addActionListener(event -> {
			this.dispose();
			this.setVisible(true);
			this.controller.getObjectiveSet().stream()
											.filter(o -> o.getName().equals(objectiveName))
											.findFirst()
											.get().modifyData(" ");
		});
		
		/////////////////////////////////////////////////////////////////////////////
		/**
		 * definizione della funzione del bottone back
		 */
		JButton modifyGoalAmountButton = new GenericButton("GoalAmount");
		modifyGoalAmountButton.addActionListener(event -> {
			this.dispose();
			this.setVisible(true);
			this.controller.getObjectiveSet().stream()
			.filter(o -> o.getGoalAmount().equals(objectiveAmount))
			.findFirst()
			.get().modifyData(objectiveName, objectiveAmount);
		});
		
		/**
		 * definizione della funzione del bottone remove
		 */
		JButton removeButton = new JButton("Remove");
		removeButton.setPreferredSize(new Dimension(100, 50));
		removeButton.setFont(new Font("Cambria", Font.BOLD, 18)); 
		removeButton.addActionListener(event -> {
			this.setVisible(false);
			this.dispose();
			this.savingPlainView.editRemoveObjective(objectiveName);
			//this.controller.removeObjective(this.savingPlainView.editRemoveObjective(objectiveName));
			//System.out.println(this.controller.getObjectiveSet().size());
		});
		
		buttonsPanel.add(backButton, BorderLayout.LINE_START);
		buttonsPanel.add(modifyNameButton, BorderLayout.CENTER);
		buttonsPanel.add(modifyGoalAmountButton, BorderLayout.CENTER);
		buttonsPanel.add(removeButton, BorderLayout.LINE_END);
		
		return buttonsPanel;
	}
	
	/**
	 * metodo necessario a settare il valore di "Paid Amount:"
	 */
	public void setBalanceLable() {
		ObjectivesImpl objective = controller.getObjectiveSet()
										     .stream()
										     .filter(o -> o.getName().equals(objectiveName))
										     .findFirst()
										     .get();
		objective.deposit(Double.valueOf(answerText.getText()));
		this.paidAmountText.setText("Paid Amount: " + objective.getPaidAmount());
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