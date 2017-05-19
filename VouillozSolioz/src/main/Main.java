package main;

import java.awt.Color;

import javax.swing.JPanel;

import application.contact.Contact;
import application.gallery.PanelGallerie;
import application.home.PanelHome;
import smartphone.FrameShell;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PanelHome frmHome = new PanelHome();
		Contact pnlContact = new Contact();
		PanelGallerie pnlGallery = new PanelGallerie();
		FrameShell myShell = new FrameShell(frmHome);
		
		myShell.addPnlScreen(pnlGallery);
		myShell.addPnlScreen(pnlContact);
		
	
		
		
		myShell.setVisible(true);

	
	}

}
