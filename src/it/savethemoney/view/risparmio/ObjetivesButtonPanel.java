package it.savethemoney.view.risparmio;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ObjetivesButtonPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ObjetivesButtonPanel() {
	
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(20,20,20,20)); 
	}
}
