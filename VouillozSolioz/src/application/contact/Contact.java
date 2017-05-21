package application.contact;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class Contact extends JPanel {

	int iD;
	String name,firstName,number,eMail,path;
	
	public Contact (int iD, String name, String firstName, String number,String eMail, String path)
	{
		this.iD = iD;
		this.name = name;
		this.firstName = firstName;
		this.number = number;
		this.eMail = eMail;
		this.path = path;
	}
	
	public String toString()
    {
		return firstName + " " + name;
	}
}
