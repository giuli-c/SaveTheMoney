package it.savethemoney.view.expense;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import it.savethemoney.controller.BankAccount;
import it.savethemoney.view.BankAccountView;

public class ExpenceView extends JFrame{
	/**
	 * Finestra di benvenuto dove lo user può inserire i propri dati personali 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String title = "EXPENCE";
	private BankAccount controller;
	private JPanel principalPanel;
	private BankAccountView bankAccountView;
	
	public ExpenceView(BankAccountView bankAccount) {
		this.bankAccountView = bankAccount;
		this.Init();		
	}
	
	/**
	 * Inizializzazione della finestra
	 */
	private void Init() {
		this.setTitle(title);
		this.setPreferredSize(new Dimension(300, 450));
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		principalPanel = new JPanel();	
		principalPanel.setLayout(new BorderLayout());		
		principalPanel.add(createButtonsPanel(), BorderLayout.CENTER);
		
		this.getContentPane().add(principalPanel);
		this.pack();
		this.setLocationRelativeTo(null);				// dove si apre l'interfaccia (al centro)
		this.setVisible(true);
	}

	public JPanel createButtonsPanel() {
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BorderLayout());
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20)); 
		
		/**
		 * creazione dei bottoni relativi alle spese
		 */
		JPanel expensePanel = new JPanel();
		expensePanel.setLayout(new GridLayout(3, 3, 5, 5));
		expensePanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20)); 
		
		Icon billsIcon		= new ImageIcon("C:\\Users\\andre\\Desktop\\GIULIA\\icone spese\\bills.png");
		JButton billsButton = new JButton(billsIcon);
		billsButton.addActionListener(event -> {	
			this.setVisible(false);
			this.dispose();													// fa sì che la JFramefinestra venga distrutta e ripulita dal sistema operativo.
			new BillsExpenseView(this);
		});
		
		Icon medicalIcon	  = new ImageIcon("C:\\Users\\andre\\Desktop\\GIULIA\\icone spese\\medical.png");
		JButton medicalButton = new JButton(medicalIcon);
		medicalButton.addActionListener(event -> {
			this.setVisible(false);
			this.dispose();													// fa sì che la JFramefinestra venga distrutta e ripulita dal sistema operativo.
			new MedicalExpenseView(this);
		});
		
		Icon eatIcon		 = new ImageIcon("C:\\Users\\andre\\Desktop\\GIULIA\\icone spese\\eat.png");	
		JButton outEatButton = new JButton(eatIcon);
		outEatButton.addActionListener(event -> {	
			this.setVisible(false);
			this.dispose();													// fa sì che la JFramefinestra venga distrutta e ripulita dal sistema operativo.
			new EatExpenseView(this);
		});
		
		Icon shoppingIcon	   = new ImageIcon("C:\\Users\\andre\\Desktop\\GIULIA\\icone spese\\shopping.png");	
		JButton shoppingButton = new JButton(shoppingIcon);
		shoppingButton.addActionListener(event -> {
			this.setVisible(false);
			this.dispose();													// fa sì che la JFramefinestra venga distrutta e ripulita dal sistema operativo.
			new ShoppingExpenseView(this);
		});
		
		Icon sportIcon		= new ImageIcon("C:\\Users\\andre\\Desktop\\GIULIA\\icone spese\\sport.png");	
		JButton sportButton = new JButton(sportIcon);
		sportButton.addActionListener(event -> {
			this.setVisible(false);
			this.dispose();													// fa sì che la JFramefinestra venga distrutta e ripulita dal sistema operativo.
			new SportExpenseView(this);
		});
		
		Icon supermarketIcon	  = new ImageIcon("C:\\Users\\andre\\Desktop\\GIULIA\\icone spese\\supermarket.png");		
		JButton supermarketButton = new JButton(supermarketIcon);
		supermarketButton.addActionListener(event -> {
			this.setVisible(false);
			this.dispose();													// fa sì che la JFramefinestra venga distrutta e ripulita dal sistema operativo.
			new SupermarketExpenseView(this);
		});
		
		Icon travelIcon		 = new ImageIcon("C:\\Users\\andre\\Desktop\\GIULIA\\icone spese\\travel.png");			
		JButton travelButton = new JButton(travelIcon);
		travelButton.addActionListener(event -> {
			this.setVisible(false);
			this.dispose();													// fa sì che la JFramefinestra venga distrutta e ripulita dal sistema operativo.
			new TravelExpenseView(this);
		});
			
		expensePanel.add(billsButton);
		expensePanel.add(medicalButton);
		expensePanel.add(outEatButton);
		expensePanel.add(shoppingButton);
		expensePanel.add(sportButton);
		expensePanel.add(supermarketButton);
		expensePanel.add(travelButton);
		
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
	
		buttonsPanel.add(expensePanel, BorderLayout.PAGE_START);
		buttonsPanel.add(backPanel, BorderLayout.PAGE_END);
		
		return buttonsPanel;
	}
	
}
