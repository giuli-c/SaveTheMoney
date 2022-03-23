package it.savethemoney.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class BankAccountTransactionsPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JComboBox<JButton> expenseCombo;

	public BankAccountTransactionsPanel(String name) {
		
		// le spese devono diventrare dei bottoni
		this.expenseCombo = new JComboBox<>(new JButton[5]);
		
		setBounds(80, 50, 140, 20);
		setLayout(new BorderLayout());
		add(expenseCombo, BorderLayout.CENTER);
	}
}
