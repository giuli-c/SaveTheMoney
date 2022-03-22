package it.savethemoney.view.pagamenti;

import javax.swing.BorderFactory;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;

public class PaymentButtonPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton transfer;
	private JButton payment;
	private JButton withdraw;
	
	public PaymentButtonPanel() {
		this.transfer 	= new PaymentTransferButton("Credit Transfer");
		this.payment 	= new PaymentButton("Payment");
		this.withdraw 	= new PaymentsWithdrawButton("Withdrawal");
		
		setBorder(BorderFactory.createEmptyBorder(30,30,30,30)); 
		setLayout(new GridLayout(3, 1));
		
		add(transfer);
		add(payment);
		add(withdraw);
	}
}
