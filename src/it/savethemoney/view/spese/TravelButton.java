package it.savethemoney.view.spese;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class TravelButton extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton name = new JButton();
	//private ImageIcon travelImage;
	
	public TravelButton(Icon travelImage) {
		
		setBorderPainted(false);
		//setContentAreaFilled(false);
		setOpaque(true);
		
		
		setPreferredSize(new Dimension(30, 30));
		setFont(new Font("Cambria", Font.BOLD, 18));
		
		//this.travelImage = new ImageIcon("C:\\Users\\giuli\\ProgettoPmo\\SaveTheMoney\\src\\it\\savethemoney\\view\\spese\\travel.png ");
	}
}
