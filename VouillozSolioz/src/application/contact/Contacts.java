package application.contact;

import java.awt.List;
import java.util.ArrayList;

public class Contacts {

	ArrayList<Contact> contacts = new ArrayList<Contact>();
	Contact myContact,myContact1;
	
	public Contacts() 
	{
		//Test
		myContact = new Contact(1234,"Paul", "Carron", "+2345678", "dfghj@fhgjk.gh", "/ghjk/fgvhbjk/vgh");
		myContact1 = new Contact(1235,"Henri", "Carron", "+2345678", "dfghj@fhgjk.gh", "/ghjk/fgvhbjk/vgh");
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
	
}
