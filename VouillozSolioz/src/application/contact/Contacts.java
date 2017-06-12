package application.contact;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
import javax.swing.event.MouseInputAdapter;

public class Contacts extends JPanel {
	
	protected static ArrayList<Contact> contacts = new ArrayList<Contact>();
	static JPanel myPanel = new JPanel();
	JButton btnAdd = new JButton("New Contact");

	// NEW
	protected static CardLayout cldScreen = new CardLayout();
	protected static JPanel pnlScreens = new JPanel();
	static ArrayList<JPanel> pnlApp = new ArrayList<JPanel>();
	protected static int indice = 1;

	public Contacts() {

		listerRepertoire(new File("src/application/contact/contactcsv"));
		viewContact();

		// create JScrollPane
		JPanel mylistcontact = new JPanel();
		JScrollPane pnl = new JScrollPane(myPanel);
		pnl.setLayout(new ScrollPaneLayout());
		pnl.setMinimumSize(new Dimension(480, 660));
		pnl.setPreferredSize(new Dimension(480, 660));
		pnl.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		pnl.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		// add images Panel to scrollPane & add scrollPane to PanelGallery
		// add(pnl);
		// add(myPanel);

		mylistcontact.add(pnl);
		pnlApp.add(mylistcontact);
		
		pnlScreens.setLayout(cldScreen);
		pnlScreens.add(pnlApp.get(0), "Home");
		
		add(pnlScreens);
		cldScreen.show(pnlScreens, "Home");

		for (int i = 0; i < contacts.size(); i++) {

			myPanel.add(contacts.get(i).getMyPanelContactMin());
			myPanel.setMinimumSize(new Dimension(480, 660));
			myPanel.setPreferredSize(new Dimension(480, 5000));
			
			System.out.println(contacts.get(i).getId());
			pnlScreens.add(contacts.get(i).getMyPanelContactMax(), contacts.get(i).getId());
		}
		
		btnAdd.addActionListener(new actAddContact());
		myPanel.add(btnAdd);
		
	}
	public class actAddContact implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			pnlScreens.add(new PanelContactMax(), "Add");
			Contacts.changePnlScreen("Add");
		}

	}

	public void viewContact() {
		for (Contact contact : contacts) {
			System.out.println(contact.toString());
		}
	}

	public void deleteContact(int Id) {
		contacts.get(Id).DeleteContact();
		contacts.remove(Id);
		
		// delete fichier

	}

	public void listerRepertoire(File repertoire) {

		String[] listefichiers;

		int i;
		listefichiers = repertoire.list();
		for (i = 0; i < listefichiers.length; i++) {
			if (listefichiers[i].endsWith(".txt") == true) {
				contacts.add(
						new Contact(Integer.toString(i), "src/application/contact/contactcsv/" + listefichiers[i]));
			}
		}

	}

	public class MyMouseListener extends MouseAdapter {

		int iD;

		public MyMouseListener(int iD) {
			this.iD = iD;
		}

		public void mouseClicked(MouseEvent e) {
			// JButton temp = (JButton) e.getSource();

			System.out.println(iD);
			// myPanel.add(contacts.get(temp.getiD()).getMyPanelContactMax());
		}
	}
	

	public static void addPnlScreen(JPanel pnlScreen, String Name) {

		pnlScreens.add(pnlScreen, Name);
		indice++;
	}
	public static void delPnlScreen(int Id) {

		pnlScreens.remove(Id+1);
		myPanel.remove(Id);
		indice--;
	}


	public static void changePnlScreen(String stScreen) {
		cldScreen = (CardLayout) pnlScreens.getLayout();
		cldScreen.show(pnlScreens, stScreen);
	}
}
