package smartphone;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.security.auth.Refreshable;
import javax.swing.*;

public class FrameShell extends JFrame{
	private JPanel pnlHead,pnlScreens,pnlHome;

	CardLayout cldScreen;

	public FrameShell(JPanel pnlScreen) {
		
	JButton btnHome = new JButton();
	//Apply image to btnHome
	try {
		Image imgHome;
		imgHome = ImageIO.read(getClass().getResource("/icons/home.png"));//path
		btnHome.setIcon(new ImageIcon(imgHome));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(480, 840);
	
	pnlHead = new JPanel(); //en-tête du smartphone
	pnlHome = new JPanel(); //fond du smartphone avec bouton home
	pnlScreens =new JPanel(new CardLayout());
	
	pnlScreens.add(pnlScreen,"home");

	pnlHead.setPreferredSize(new Dimension(480, 30));
	pnlHead.setBackground(Color.LIGHT_GRAY);
	
	pnlHome.setPreferredSize(new Dimension(480, 80));
	pnlHome.setBackground(Color.LIGHT_GRAY);
	pnlHome.add(btnHome);

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
