package it.savethemoney.view.pagamenti;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.savethemoney.view.spese.CategoryButton;
import it.savethemoney.view.spese.ExpenseButtonPanel;
import it.savethemoney.view.spese.ExpenseLabel;

public class PaymentFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel nameLabel;
	private JPanel buttonPanel;
	private JButton addCategory;
	
	public PaymentFrame(String name) {
		super(name);
		
		setSize(300, 450);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);				// dove si apre l'interfaccia (al centro)
		getContentPane().setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		
		this.nameLabel		= new ExpenseLabel(name);
		this.buttonPanel 	= new ExpenseButtonPanel();
		this.addCategory 	= new CategoryButton("ADD CATEGORY");

		this.add(nameLabel, BorderLayout.PAGE_START);
		this.add(buttonPanel, BorderLayout.CENTER);
		this.add(addCategory, BorderLayout.PAGE_END);
		
		setVisible(true);
	}
}

}
