package smartphone;

import application.gallery.PanelGallerie;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.security.auth.Refreshable;
import javax.swing.*;

public class FrameShell extends JFrame{
	private JPanel pnlHead,pnlHome;
	private JButton btnHome,btnReturn;
	
	/**
	 * @author guill
	 * Gestion du changement d'�cran
	 */
	CardLayout cldScreen = new CardLayout();
	JPanel pnlScreens = new JPanel();
	JPanel[] pnlApp = new JPanel[3];
	String[] listContent = {"Home","Gallery","Contact"};
	int indice = 1;
	
	
	public FrameShell(JPanel pnlScreen) {
	
	
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(480, 840);
	setBackground(Color.black);
	
	pnlHead = new JPanel();
	pnlHome = new JPanel();
	pnlApp[0] = pnlScreen;
	
	pnlScreens.setLayout(cldScreen);
	pnlScreens.add(pnlApp[0],listContent[0]);
	
	btnHome = new JButton("Home");
	btnReturn  = new JButton("Return");
	btnHome.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent event){				
	    	  cldScreen.next(pnlScreens);
	         System.out.println("Test");
	        }
	      });
	
	pnlHead.setPreferredSize(new Dimension(480, 30));
	pnlHead.setBackground(Color.BLACK);
	
	pnlHome.setPreferredSize(new Dimension(480, 80));
	pnlHome.setBackground(Color.BLACK);
	pnlHome.add(btnHome);
	pnlHome.add(btnReturn);
	
	
	add(BorderLayout.NORTH,pnlHead);
	add(BorderLayout.CENTER,pnlScreens);
	add(BorderLayout.SOUTH,pnlHome);
	

	}


	public void addPnlScreen(JPanel pnlScreen) {
		pnlApp[indice] = pnlScreen;
		pnlScreens.add(pnlApp[indice], listContent[indice]);
		indice++;
	}
	public void changePnlScreen(String stScreen) {
		cldScreen = (CardLayout) pnlScreens.getLayout();
		cldScreen.next(pnlScreens);
	}	
}