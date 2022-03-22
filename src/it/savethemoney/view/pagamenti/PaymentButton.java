package it.savethemoney.view.pagamenti;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class PaymentButton extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PaymentButton(String name) {
		super(name);
		
		setSize(new Dimension(200, 50));
		setFont(new Font("Cambria", Font.BOLD, 18)); 
	}
}
