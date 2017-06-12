package application.contact;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.xml.bind.ParseConversionEvent;

public class Contact {
 // A changer constructeur avec seulement le chemin et lecture individuelle de chaque contact
	//int iD;
	//String name,firstName,number,eMail,pathFile,pathPicture;
	
	/**
	 * Structure of mesinfos
	 * 	[0] ID 
	 *  [1] pathFile
	 *  [2] FirstName
	 *  [3] Name
	 *  [4] Number
	 *  [5] Email
	 *  [6] pathPicture
	 *  
	 */
	String[] mesinfos = new String[7];
    PanelContactMin myPanelContactMin;
    
	PanelContactMax myPanelContactMax;
	
	/**
	 * Use when the contact already exists.
	 * @param iD number to the arraylist
	 * @param pathFile path of the contact's file 
	 */
	public Contact (String iD,String pathFile)
	{
		// initialize variables
		mesinfos[0]= iD;
		mesinfos[1]= pathFile;
		
		//fill other information of the contacts
		read(pathFile,mesinfos);
	}
	
	public PanelContactMin getMyPanelContactMin() {
		myPanelContactMin = new PanelContactMin(Integer.parseInt(mesinfos[0]));
		myPanelContactMin.setInfos(mesinfos[2],mesinfos[3]);
		return myPanelContactMin;
	}
	public PanelContactMax getMyPanelContactMax() {
		myPanelContactMax = new PanelContactMax(mesinfos);
		return myPanelContactMax;
	}
	
	public String[] getMesinfos() {
		return mesinfos;
	}
	public void setMesinfos(String[] mesinfos) {
		this.mesinfos = mesinfos;
	}
	
	
	/**
	 * Use when you create a new Contact
	 * @param iD number to the arraylist
	 */
	public Contact(String iD)
	{
		mesinfos[0]= iD;
	}
	/**
	 * improved version of ToString
	 */
	public String toString()
    {
		return mesinfos[3] + " ";
	}
	/**
	 * 
	 * @return the value of the csv
	 */
	public String toCSV()
    {
		String myCSV = "";
		for (int i = 2; i < mesinfos.length; i++) {
			myCSV += mesinfos[i] + ";";
		}
		return myCSV;
	}
	
	/**
	 * Modification of the contact
	 * @param iD	
	 * @param pathFile
	 * @param name
	 * @param firstName
	 * @param number
	 * @param eMail
	 * @param pathPicture
	 */
	public void ModifyContact (String iD,String pathFile, String name, String firstName, String number,String eMail, String pathPicture)
	{
		mesinfos[0] = iD;
		mesinfos[1] = pathFile;
		mesinfos[2] = name;
		mesinfos[3] = firstName;
		mesinfos[4] = number;
		mesinfos[5] = eMail;
		mesinfos[6] = pathPicture;
		
	}
	/**
	 * Delete contact
	 */
	public void DeleteContact ()
	{
		File myfile = new File(mesinfos[1]);
		if(!myfile.delete())
			System.out.println("Echec");;
	}
	
	/**
	 * Use when you fill a new contact
	 * @param name
	 * @param firstName
	 * @param number
	 * @param eMail
	 * @param pathPicture
	 */
	public void AddContact(String name, String firstName, String number,String eMail, String pathPicture) 
	{	
		ModifyContact(mesinfos[0],name+firstName+".txt",name, firstName, number, eMail, pathPicture);
		
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(
	              new FileOutputStream("src/application/contact/contactcsv/"+mesinfos[1]), "utf-8"))) {
	   writer.write(this.toCSV());
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
	}

	/**
	 * Read the file *.csv
	 * @param pathFile
	 * @param mesinfos
	 */
	public static void read(String pathFile,String[] mesinfos)
	{
		File file = new File(pathFile);
		 String line = "";
	     String cvsSplitBy = ";";
	     String[] info = new String[4];
	        
		try {
			FileReader in = new FileReader(file);
			BufferedReader bin = new BufferedReader(in);
			while ((line = bin.readLine()) != null) {

                // use comma as separator
                info = line.split(cvsSplitBy);
			}
			
			bin.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < info.length; i++) {
			mesinfos[i+2] = info[i];
		}
		
	}
	public String getId()
	{
		return mesinfos[0];
	}
}
