package frame;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.security.auth.Refreshable;
import javax.swing.*;

public class FrameShell extends JFrame{
	private JPanel pnlHead,pnlScreens,pnlHome;
	private JButton btnHome,btnReturn;
	CardLayout cldScreen;


	public FrameShell(JPanel pnlScreen) {
	
	
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(480, 840);
	setBackground(Color.black);
	
	pnlHead = new JPanel();
	pnlHome = new JPanel();
	pnlScreens =new JPanel(new CardLayout());
	
	pnlScreens.add(pnlScreen,"home");
	
	btnHome = new JButton("Home");
	btnReturn  = new JButton("Return");
	
	pnlHead.setPreferredSize(new Dimension(480, 30));
	pnlHead.setBackground(Color.BLACK);
	
	pnlHome.setPreferredSize(new Dimension(480, 80));
	pnlHome.setBackground(Color.BLACK);
	pnlHome.add(btnHome);
	pnlHome.add(btnReturn);
	
	
	add(BorderLayout.NORTH,pnlHead);
	add(BorderLayout.CENTER,pnlScreen);
	add(BorderLayout.SOUTH,pnlHome);
	

	}


	public void addPnlScreen(JPanel pnlScreen, String stScreen) {
		pnlScreens.add(pnlScreen, stScreen);
		pack();
	}
	public void changePnlScreen(String stScreen) {
		cldScreen = (CardLayout) pnlScreens.getLayout();
		cldScreen.next(pnlScreens);
	}
	
	
}
