package main;



import application.contact.Contacts;
//import application.contact.Contact;

//import application.contact.PanelContacts;
import smartphone.FrameShell;
import application.gallery.PanelGallery;

import application.home.PanelHome;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create panels (one panel per app)
		PanelHome pnlHome = new PanelHome();
		PanelGallery pnlGallery = new PanelGallery();
		Contacts pnlContacts = new Contacts();
		
		//Initalize shell of our homescreen
		FrameShell myShell = new FrameShell(pnlHome);
		
		//Add panels (apps) to the shell

		FrameShell.addPnlScreen(pnlGallery,"Gallery");
		FrameShell.addPnlScreen(pnlContacts,"Contact");

		myShell.setVisible(true);
	
	}

}
