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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
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

		myPanel.setMinimumSize(new Dimension(480, 660));
		myPanel.setPreferredSize(new Dimension(480, 5000));
		
		listerRepertoire(new File("src/application/contact/contactcsv"));
		
		btnAdd.addActionListener(new actAddContact());
		myPanel.add(btnAdd);
		
	}
	public static void addContactPan(Contact contact)
	{
		myPanel.add(contact.getMyPanelContactMin());
		pnlScreens.add(contact.getMyPanelContactMax(), contact.getId());
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

	public static void deleteContact(String Id, String PathFile) {
		contacts.remove(Integer.parseInt(Id)-1);
			File myfile = new File(PathFile);
			if(!myfile.delete())
				System.out.println("Echec");;
		
		// delete fichier

	}

	public static void listerRepertoire(File repertoire) {

		String[] listefichiers;
		myPanel.removeAll();
		int i;
		contacts.removeAll(contacts);
		
		listefichiers = repertoire.list();
		for (i = 0; i < listefichiers.length; i++) {
			if (listefichiers[i].endsWith(".txt") == true) {
				contacts.add(
						new Contact(Integer.toString(i), "src/application/contact/contactcsv/" + listefichiers[i]));
			}
		}
		for (Contact contact : contacts) {
			addContactPan(contact);
		}
		
		myPanel.repaint();
			
		

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
	
	/**
	 * Use when you fill a new contact
	 * @param name
	 * @param firstName
	 * @param number
	 * @param eMail
	 * @param pathPicture
	 */
	public static void AddContact(String name, String firstName, String number,String eMail, String pathPicture) 
	{			
		String nameFile = "src/application/contact/contactcsv/"+firstName + name + ".txt";
				try (Writer writer = new BufferedWriter(new OutputStreamWriter(
	              new FileOutputStream(nameFile), "utf-8"))) {
	   writer.write(name + ";" + firstName +";"+number+";"+eMail+";"+pathPicture);
	  
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		Contact mynewcontact = new Contact(String.valueOf(contacts.size()+1),nameFile);
		contacts.add(mynewcontact);
		addContactPan(mynewcontact);
			
	}
	/**
	 * Use when you fill a new contact
	 * @param name
	 * @param firstName
	 * @param number
	 * @param eMail
	 * @param pathPicture
	 */
	public static void ModifyContact(String Id,String namefile, String name, String firstName, String number,String eMail, String pathPicture) 
	{			
		String nameFile = namefile;

		try (Writer writer = new BufferedWriter(new OutputStreamWriter(
	              new FileOutputStream(nameFile), "utf-8"))) {
	   writer.write(name + ";" + firstName +";"+number+";"+eMail+";"+pathPicture);
	  
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		listerRepertoire(new File("src/application/contact/contactcsv/"));
		
			
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
