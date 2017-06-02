package application.contact;

import java.awt.Color;
import java.awt.Dimension;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

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
	String[] mesinfos = new String[7];
	public Contact (String iD,String pathFile)
	{
		mesinfos[0]= iD;
		mesinfos[1]= pathFile;
		read(pathFile,mesinfos);
	}
	
	public String toString()
    {
		return mesinfos[3] + " ";
	}
	public String toCSV()
    {
		String myCSV = "";
		for (int i = 0; i < mesinfos.length; i++) {
			myCSV += mesinfos[i] + ";";
		}
		return mesinfos[3] + " ";
	}
	public void ModifyContact (String iD,String pathFile, String name, String firstName, String number,String eMail, String pathPicture)
	{
		/*this.iD = iD;
		this.name = name;
		this.firstName = firstName;
		this.number = number;
		this.pathFile = pathFile;
		this.pathPicture = pathPicture;*/
		mesinfos[0] = iD;
		mesinfos[1] = pathFile;
		mesinfos[2] = name;
		mesinfos[3] = firstName;
		mesinfos[4] = number;
		mesinfos[5] = eMail;
		mesinfos[6] = pathPicture;
	}
	public void DeleteContact ()
	{
		File myfile = new File(mesinfos[1]);
		if(!myfile.delete())
			System.out.println("Echec");;
	}
	public void AddContact() throws UnsupportedEncodingException, FileNotFoundException, IOException
	{
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(
	              new FileOutputStream("src/application/contact/contactcsv/"+mesinfos[2]+mesinfos[3]+".txt"), "utf-8"))) {
	   writer.write(this.toCSV());
	}
	}
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
	public void GetInfo()
	{
		
	}
}
