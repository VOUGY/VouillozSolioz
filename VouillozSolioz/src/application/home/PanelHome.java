package application.home;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.channels.ClosedSelectorException;

import javax.crypto.spec.SecretKeySpec;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import application.gallery.PanelGallery;
import smartphone.FrameShell;

public class PanelHome extends JPanel {

	JButton[] tabbtnHome = new JButton[2];
	
	public PanelHome() {
		
		JButton btnContacts = new JButton();
		JButton btnGallery = new JButton();
		
		//applying images to button

		//Apply contact image to btnContacts
		try {
			Image imgContacts;
			imgContacts = ImageIO.read(getClass().getResource("/icons/contacts.jpg"));//path
			btnContacts.setIcon(new ImageIcon(imgContacts));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Apply gallery image to btnGallery
		try {
			Image imgGallery;
			imgGallery = ImageIO.read(getClass().getResource("/icons/gallery.png"));//path
			btnGallery.setIcon(new ImageIcon(imgGallery));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setPreferredSize(new Dimension(480, 770));
		setBackground(Color.BLACK);
		
		add(BorderLayout.NORTH, btnContacts);
		add(BorderLayout.CENTER, btnGallery);
		
		btnContacts.addActionListener(new ClickContacts());
		btnGallery.addActionListener(new ClickGallerie());
		
		System.out.println("Test");
		revalidate();
		System.out.println("TEst");
	}
         
 }

class ClickContacts implements ActionListener { //event when click on app "Contacts"
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("Contacts!");
		FrameShell.changePnlScreen("Contact");
		
	}
}

class ClickGallerie implements ActionListener { //event when click on app "Gallerie"
	
	public void actionPerformed(ActionEvent e) {
		FrameShell.changePnlScreen("Gallery");
		
	}
}
