package application.contact;

import java.awt.List;
import java.io.File;
import java.util.ArrayList;

public class Contacts {

	ArrayList<Contact> contacts = new ArrayList<Contact>();
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contacts mescontacts = new Contacts();
		Contact myContact = new Contact("124");
		myContact.AddContact("DFG", "DFGHJ", "+2387654", "DFGHJIHUIG@hotmail.com", "sdfg/hjk");
		
		mescontacts.viewContact();
	}

	public Contacts() {
		
		listerRepertoire(new File("src/application/contact/contactcsv"));
		viewContact();
		

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
				contacts.add(new Contact(Integer.toString(i), "src/application/contact/contactcsv/" + listefichiers[i]));
			}
		}

	}
}
