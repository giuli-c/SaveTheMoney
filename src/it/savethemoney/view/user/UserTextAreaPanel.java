package it.savethemoney.view.user;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;

public class UserTextAreaPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextArea name;
	private JTextArea amount;
	
	public UserTextAreaPanel(String phraseUser, String amountUser) {
		this.name 	= new JTextArea(phraseUser);
		this.amount = new JTextArea(amountUser);
		
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		add(name, BorderLayout.PAGE_START);
		add(amount, BorderLayout.CENTER);
	}
}
