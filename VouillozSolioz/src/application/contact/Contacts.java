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

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
import javax.swing.event.MouseInputAdapter;

public class Contacts extends JPanel {
	final static String PATHFILE = "src/application/contact/contactcsv/";
	
	protected static ArrayList<Contact> contacts = new ArrayList<Contact>();
	protected static int indice = 1;
	
	JButton btnAdd = new JButton("New Contact");
	protected static CardLayout cldScreen = new CardLayout();
	static JPanel myPanel = new JPanel();
	protected static JPanel pnlScreens = new JPanel();
	static ArrayList<JPanel> pnlApp = new ArrayList<JPanel>();

	public Contacts() {

		// create JScrollPane

		
		JScrollPane pnl = new JScrollPane(myPanel);
		pnl.setLayout(new ScrollPaneLayout());
		pnl.setMinimumSize(new Dimension(480, 600));
		pnl.setPreferredSize(new Dimension(480, 660));
		pnl.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		pnl.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		//increase speed of vertical bar scrolling
		pnl.getVerticalScrollBar().setUnitIncrement(16);
		
		
		JPanel mybtn = new JPanel();
		mybtn.setPreferredSize(new Dimension(480, 50));
		mybtn.add(btnAdd);
		
		JPanel mylistcontact = new JPanel();
		mylistcontact.setLayout(new BoxLayout(mylistcontact, BoxLayout.PAGE_AXIS));
	
		mylistcontact.add(mybtn);
		mylistcontact.add(pnl);
		
	
		pnlApp.add(mylistcontact);
		
		pnlScreens.setLayout(cldScreen);
		pnlScreens.add(pnlApp.get(0), "Home");
		
		add(pnlScreens);
		cldScreen.show(pnlScreens, "Home");

		myPanel.setMinimumSize(new Dimension(480, 660));
		myPanel.setPreferredSize(new Dimension(480, 5000));
		
		listinFolder(new File(PATHFILE));
		
		btnAdd.addActionListener(new actAddContact());
	
		
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

	/**
	 * View in console of the contacts' list
	 */
	public void viewContact() {
		for (Contact contact : contacts) {
			System.out.println(contact.toString());
		}
	}

	/**
	 * 
	 * @param Id 
	 * @param PathFile
	 */
	public static void deleteContact(String Id, String PathFile) {
		contacts.remove(Integer.parseInt(Id)-1);
			File myfile = new File(PathFile);
			if(!myfile.delete())
				System.out.println("Echec");;
		
		// delete fichier

	}

	/**
	 * Can find ever contact and add in the arraylist of contacts 
	 * add Panel in the cardlayout
	 * 
	 * @param re folder of contact
	 */
	public static void listinFolder(File folder) {

		String[] filelist;
		myPanel.removeAll();
		int i;
		contacts.removeAll(contacts);
		
		filelist = folder.list();
		for (i = 0; i < filelist.length; i++) {
			if (filelist[i].endsWith(".txt") == true) {
				contacts.add(
						new Contact(Integer.toString(i), PATHFILE + filelist[i]));
			}
		}
		for (Contact contact : contacts) {
			addContactPan(contact);
		}
		
		myPanel.repaint();

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
		String nameFile = PATHFILE +firstName + name + ".txt";
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
				listinFolder(new File(PATHFILE));
			changePnlScreen("Home");
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
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
		
		listinFolder(new File(PATHFILE));

	}


 /**
  * 
  * @param pnlScreen  
  * @param Name info to refind the pnlScreen
  */

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
