package smartphone;

import java.awt.Color;

import javax.swing.JPanel;

import frame.FrameShell;
import jpanel.PanelHome;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PanelHome frmHome = new PanelHome();
		FrameShell myShell = new FrameShell(frmHome);
		JPanel card1 = new JPanel();
		card1.setBackground(Color.GREEN);
		
		
		myShell.addPnlScreen(card1, "Carte 1");
		myShell.changePnlScreen("Carte 1");
		
		
		myShell.setVisible(true);

	
	}

}
