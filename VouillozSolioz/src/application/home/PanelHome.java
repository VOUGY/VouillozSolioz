package application.home;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.crypto.spec.SecretKeySpec;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import application.gallery.PanelGallerie;
import label.LabelApplication;

public class PanelHome extends JPanel {

	 JButton[] tabbtnHome = new JButton[2];
	LabelApplication monContact[] = new LabelApplication[2];
	
	public PanelHome() {
		
		JButton Contacts = new JButton("Contacts");
		JButton Gallerie = new JButton("Gallerie");
		
		setPreferredSize(new Dimension(480, 770));
		setBackground(Color.BLUE);
		for (int i = 0; i < monContact.length; i++) {
			monContact[i] = new LabelApplication();
			
		}
		add(monContact[0]);
		add(monContact[1]);
		
		add(BorderLayout.NORTH, Contacts);
		add(BorderLayout.CENTER, Gallerie);
		
		Contacts.addActionListener(new ClickContacts());
		Gallerie.addActionListener(new ClickGallerie());
		
		System.out.println("Test");
		revalidate();
		System.out.println("TEst");
	}
         
 }

class ClickContacts implements ActionListener { //evenement si on clique sur le bouton "Contacts"
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("Contacts!"); //test
		PanelGallerie PanelGallerie = new PanelGallerie();
		// changePnlScreen(PanelGallerie, "PanelGallerie"); -> il faut faire en sorte d'appeler 
		// la méthode changePnlScreen qui se trouve dans FrameShell.java
		System.out.println("CA VA MARCHER OU PAS CETTE MERDE DE GITHUB");
	}
}

class ClickGallerie implements ActionListener { //evenement si on clique sur le bouton "Gallerie"
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("Gallerie!"); //test
		
	}
}
