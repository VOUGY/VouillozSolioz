package main;

import java.awt.Color;

import javax.swing.JPanel;

import application.contact.Contact;
import smartphone.FrameShell;
import application.gallery.PanelGallerie;
import application.home.PanelHome;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Création de nos panels
		PanelHome pnlHome = new PanelHome();
		Contact pnlContact = new Contact();
		PanelGallerie pnlGallery = new PanelGallerie();
		
		//Initialisation de la shell avec pnl d'accueil
		FrameShell myShell = new FrameShell(pnlHome);
		
		// rajout des panels apps
		myShell.addPnlScreen(pnlGallery);
		myShell.addPnlScreen(pnlContact);
	
		//affichage de la fenetre
		myShell.setVisible(true);

	
	}

}
