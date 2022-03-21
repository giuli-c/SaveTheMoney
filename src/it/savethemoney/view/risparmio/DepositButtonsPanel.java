package it.savethemoney.view.risparmio;

import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.FlowLayout;

public class DepositButtonsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton newObjectivesButton;
	private JButton removeObjetivesButton;
	
	public DepositButtonsPanel() {
		this.newObjectivesButton 	= new DepositAddObjectivesButton("ADD");
		this.removeObjetivesButton 	= new DepositRemoveObjectivesButton("REMOVE");
		
		this.setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		this.add(newObjectivesButton, BorderLayout.LINE_START);
		this.add(removeObjetivesButton, BorderLayout.LINE_END);
	}
}
