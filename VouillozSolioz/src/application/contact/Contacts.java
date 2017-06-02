package application.contact;

import java.awt.List;
import java.util.ArrayList;

public class Contacts {

	ArrayList<Contact> contacts = new ArrayList<Contact>();
	Contact myContact,myContact1;
	
	public Contacts() 
	{
		//Test
		contacts.add(myContact);
		contacts.add(myContact1);
		
		viewContact();
	
	}
	public void viewContact()
	{
		for (Contact contact : contacts) {
			System.out.println(contact.toString());
		}
	}
	public void deleteContact(int Id)
	{
		contacts.remove(Id);
		//delete fichier
		
	}
	
}
