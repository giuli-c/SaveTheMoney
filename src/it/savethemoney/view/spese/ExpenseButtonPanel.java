package it.savethemoney.view.spese;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import it.savethemoney.view.DepositButton;
import it.savethemoney.view.ExpenseButton;
import it.savethemoney.view.PaymentsButton;
import it.savethemoney.view.SavingButton;

public class ExpenseButtonPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton shopping;
	private JButton outEat;
	private JButton bills;
	private JButton supermarket;
	private JButton medicalExpense;
	private JButton sport;
	private JButton travel;
	private JButton name;
	private JButton name2;
	
	public ExpenseButtonPanel() {
		this.shopping 		= new ShoppingButton("Shopping");
		this.outEat			= new OutEatButton("Out Eat");
		this.bills 			= new BillsButton("Bills");
		this.supermarket 	= new SupermarketButton("Supermarket");
		this.medicalExpense = new MedicalExpenseButton("Medical Expense");
		this.sport 			= new SportButton("Sport");
		this.travel 		= new TravelButton("Travel");
				
		setBorder(BorderFactory.createEmptyBorder(20,20,20,20)); 
		setLayout(new GridLayout(3, 3, 5, 5));
		
		add(shopping);
		add(outEat);
		add(bills);
		add(supermarket);
		add(medicalExpense);
		add(sport);
		add(travel);
	}
}
