package application.home;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.crypto.spec.SecretKeySpec;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import application.gallery.PanelGallerie;

public class PanelHome extends JPanel {

	JButton[] tabbtnHome = new JButton[2];
	
	public PanelHome() {
		
		JButton btnContacts = new JButton();
		JButton btnGallery = new JButton();
		
		//applying images to button

		//CONTACTS
		try {
			Image imgContacts;
			imgContacts = ImageIO.read(getClass().getResource("/image/contacts.jpg"));
			btnContacts.setIcon(new ImageIcon(imgContacts));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//GALLERY
		try {
			Image imgGallery;
			imgGallery = ImageIO.read(getClass().getResource("/image/gallery.png"));
			btnGallery.setIcon(new ImageIcon(imgGallery));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		setPreferredSize(new Dimension(480, 770));
		setBackground(Color.BLUE);
		
		add(BorderLayout.NORTH, btnContacts);
		add(BorderLayout.CENTER, btnGallery);
		
		btnContacts.addActionListener(new ClickContacts());
		btnGallery.addActionListener(new ClickGallerie());
		
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
	}
}

class ClickGallerie implements ActionListener { //evenement si on clique sur le bouton "Gallerie"
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("Gallerie!"); //test
		
	}
}
