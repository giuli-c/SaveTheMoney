package it.savethemoney.view.spese;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

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
	
	private Icon travelIcon;
	private Icon sportIcon;
	private Icon medicalIcon;
	private Icon eatIcon;
	private Icon shoppingIcon;
	private Icon billsIcon;
	private Icon supermarketIcon;
	
	
	public ExpenseButtonPanel() {
		
		this.travelIcon 		= new ImageIcon("C:\\Users\\giuli\\ProgettoPmo\\SaveTheMoney\\src\\it\\savethemoney\\view\\spese\\travel.png");
		this.sportIcon 			= new ImageIcon("C:\\Users\\giuli\\ProgettoPmo\\SaveTheMoney\\src\\it\\savethemoney\\view\\spese\\sport.png");
		this.medicalIcon 		= new ImageIcon("C:\\Users\\giuli\\ProgettoPmo\\SaveTheMoney\\src\\it\\savethemoney\\view\\spese\\medical.png");
		this.eatIcon 			= new ImageIcon("C:\\Users\\giuli\\ProgettoPmo\\SaveTheMoney\\src\\it\\savethemoney\\view\\spese\\eat.png");
		this.shoppingIcon 		= new ImageIcon("C:\\Users\\giuli\\ProgettoPmo\\SaveTheMoney\\src\\it\\savethemoney\\view\\spese\\shopping.png");
		this.billsIcon 			= new ImageIcon("C:\\Users\\giuli\\ProgettoPmo\\SaveTheMoney\\src\\it\\savethemoney\\view\\spese\\bills.png");
		this.supermarketIcon 	= new ImageIcon("C:\\Users\\giuli\\ProgettoPmo\\SaveTheMoney\\src\\it\\savethemoney\\view\\spese\\supermarket.png");
		
		this.shopping 		= new JButton(shoppingIcon);
		this.outEat			= new JButton(eatIcon);
		this.bills 			= new JButton(billsIcon);
		this.supermarket 	= new JButton(supermarketIcon);
		this.medicalExpense = new JButton(medicalIcon);
		this.sport 			= new JButton(sportIcon);
		this.travel 		= new JButton(travelIcon);
				
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
