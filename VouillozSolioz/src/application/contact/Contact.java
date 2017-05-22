package application.contact;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class Contact extends JPanel {
 // A changer constructeur avec seulement le chemin et lecture individuelle de chaque contact
	//int iD;
	//String name,firstName,number,eMail,pathFile,pathPicture;
	
	/**
	 * Structure de mesinfos
	 * 	[0] ID 
	 *  [1] pathFile
	 *  [2] FirstName
	 *  [3] Name
	 *  [4] Number
	 *  [5] Email
	 *  [6] pathPicture
	 *  
	 */
	String[] mesinfos = new String[5];
	public Contact (String iD,String pathFile)
	{
		mesinfos[0]= iD;
		mesinfos[1]= pathFile;
	}
	
	public String toString()
    {
		return mesinfos[2] + " ";
	}
	public void ModifyContact (String iD, String name, String firstName, String number,String eMail, String pathPicture)
	{
		/*this.iD = iD;
		this.name = name;
		this.firstName = firstName;
		this.number = number;
		this.pathFile = pathFile;
		this.pathPicture = pathPicture;*/
		mesinfos[0] = iD;
		mesinfos[2] = name;
		mesinfos[3] = firstName;
		mesinfos[4] = number;
		mesinfos[5] = pathPicture;
	}
}
