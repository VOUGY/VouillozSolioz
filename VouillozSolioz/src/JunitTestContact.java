import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import application.contact.Contact;
import application.contact.Contacts;


public class JunitTestContact {
	
	
	@Test
	public void infoContact() {
		Contact myContact = new Contact("1");
		myContact.ModifyContact("1", "pathFile", "test", "firstname", "test", "test", "test");
		assertEquals("firstname", myContact.getMesinfos()[3]);
		assertEquals("pathFile", myContact.getMesinfos()[1]);
	}
	@Test
	public void fileContact()
	{
		Contact myContact = new Contact("1","src/application/contact/contactcsv/GuillaumeVouilloz.txt");
		assertEquals("Guillaume", myContact.getMesinfos()[3]);
	}
	@Test
	public void modifyContact()
	{
		
		Contacts.ModifyContact("1","src/application/contact/contactcsv/GuillaumeVouilloz.txt", "Vouilloz2", "Guillaume", "+41796425741", "guillaume.vouilloz@outlook.com", "src/app");
		Contact myContact = new Contact("1","src/application/contact/contactcsv/GuillaumeVouilloz.txt");
		assertEquals("Vouilloz2", myContact.getMesinfos()[2]);
		Contacts.ModifyContact("1","src/application/contact/contactcsv/GuillaumeVouilloz.txt", "Vouilloz", "Guillaume", "+41796425741", "guillaume.vouilloz@outlook.com", "src/app");
	}
	@Test
	public void adddelContact()
	{
		Contacts mycontact = new Contacts();
		Contacts.AddContact("Test", "1", "+23456", "guila@fasf.com", "adssf");
		
		Contact myContact = new Contact("1","src/application/contact/contactcsv/1Test.txt");
		assertEquals("Test", myContact.getMesinfos()[2]);
		
		Contacts.deleteContact("1", "src/application/contact/contactcsv/1Test.txt");
		assertFalse((new File("src/application/contact/contactcsv/Test1.txt").exists()));
		
	}

}
