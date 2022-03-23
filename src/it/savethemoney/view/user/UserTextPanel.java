package it.savethemoney.view.user;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class UserTextPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField name;
	private JTextField balance;
	
	public UserTextPanel() {
		this.name 		= new UserNameText("Come ti chiami?");
		this.balance 	= new UserBalanceText("Qual è il tuo saldo?");
		
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(20,20,20,20)); 
		
		add(name, BorderLayout.PAGE_START);
		add(balance, BorderLayout.CENTER);
	}
	
}
