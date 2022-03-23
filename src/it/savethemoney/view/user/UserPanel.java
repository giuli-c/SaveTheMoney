package it.savethemoney.view.user;

import java.awt.FlowLayout;
import javax.swing.JPanel;

public class UserPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel userName;
	private JPanel userBalance;
	
	public UserPanel(String sentenceName, String sentenceAmount) {
		this.userName = new UserTextPanel();
		this.userBalance = new UserTextAreaPanel(sentenceName, sentenceAmount);
		
		setLayout(new FlowLayout());
		
		add(userName);
		add(userBalance);
		
	}
}
