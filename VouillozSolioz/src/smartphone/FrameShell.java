package smartphone;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.security.auth.Refreshable;
import javax.swing.*;

public class FrameShell extends JFrame{
	private JPanel pnlHead,pnlScreen,pnlHome;
	private JButton btnHome,btnReturn;

	public FrameShell(JPanel pnlScreen) {
		this.pnlScreen = pnlScreen;
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(480, 840);
	setBackground(Color.black);
	
	pnlHead = new JPanel();
	pnlHome = new JPanel();
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
	public void CreateFrame()
	{
		
	}
	public void monstring()
	{
		System.out.println("test");
	}
	public JPanel getPnlScreen() {
		return pnlScreen;
	}

	public void setPnlScreen(JPanel pnlScreen) {
		 getContentPane().remove(this.pnlScreen);
        getContentPane().add(pnlScreen);
        getContentPane().revalidate();
		this.pnlScreen = pnlScreen;
		pack();
	}
	
	
}
