package application.contact;

import java.awt.Dimension;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
import javax.swing.event.MouseInputAdapter;



public class Contacts extends JPanel {

	ArrayList<Contact> contacts = new ArrayList<Contact>();
	JPanel myPanel = new JPanel();
	MyMouseListener mesinfo = new MyMouseListener();

	public Contacts() {

		listerRepertoire(new File("src/application/contact/contactcsv"));
		viewContact();
		for (int i = 0; i < contacts.size(); i++) {
			
			myPanel.add(contacts.get(i).getMyPanelContactMax());
			contacts.get(i).getMyPanelContactMin().addMouseListener(new MyMouseListener());
			myPanel.setMinimumSize(new Dimension(480, 660));
			myPanel.setPreferredSize(new Dimension(480, 5000));
		}
		//System.out.println(contacts.size());
		
		// create JScrollPane
		JScrollPane pnl = new JScrollPane(myPanel);
		pnl.setLayout(new ScrollPaneLayout());
		pnl.setMinimumSize(new Dimension(480, 660));
		pnl.setPreferredSize(new Dimension(480, 660));
		pnl.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		pnl.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		// add images Panel to scrollPane & add scrollPane to PanelGallery
		add(pnl);
		// add(myPanel);

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
		public void mouseClicked(MouseEvent e)
		{
			PanelContactMin temp = (PanelContactMin) e.getSource();
			
			System.out.println(contacts.get(temp.getiD()).toString());
			myPanel.add(contacts.get(temp.getiD()).getMyPanelContactMax());
			revalidate();
			
		}
	}

}

