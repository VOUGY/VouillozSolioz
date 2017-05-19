package main;

import java.awt.Color;

import javax.swing.JPanel;

import application.contact.Contact;
import application.home.PanelHome;
import smartphone.FrameShell;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PanelHome frmHome = new PanelHome();
		Contact pnlContact = new Contact();
		FrameShell myShell = new FrameShell(frmHome);
		
		myShell.addPnlScreen(frmHome, "Card1");
		myShell.addPnlScreen(pnlContact, "Card2");
		
		
		
		
		myShell.setVisible(true);

	
	}

}
