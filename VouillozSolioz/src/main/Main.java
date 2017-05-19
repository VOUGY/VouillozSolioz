package main;

import java.awt.Color;

import javax.swing.JPanel;

import application.contact.Contact;
import application.contact.PanelContact;
import application.contact.PanelContacts;
import smartphone.FrameShell;
import application.gallery.PanelGallery;
import application.home.PanelHome;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create panels (one panel per app)
		PanelHome pnlHome = new PanelHome();
		PanelContacts pnlContacts = new PanelContacts();
		PanelGallery pnlGallery = new PanelGallery();
		
		//Initalize shell of our homescreen
		FrameShell myShell = new FrameShell(pnlHome);
		
		//Add panels (apps) to the shell
		myShell.addPnlScreen(pnlGallery);
		myShell.addPnlScreen(pnlContacts);
	
		//show smartphone
		myShell.setVisible(true);

	
	}

}
