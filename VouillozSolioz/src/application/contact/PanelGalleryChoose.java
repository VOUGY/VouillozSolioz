package application.contact;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import application.contact.Contact;
import application.gallery.PanelGallery;
import application.gallery.PanelImage;
import smartphone.FrameShell;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
/**
 * Modification of PanelGalleryChoose of Nicolas Solioz (can't time for using the extends.. 
 * @author guill
 *
 */
public class PanelGalleryChoose extends JPanel {


	static JPanel images = new JPanel();
	static JScrollPane pnl = new JScrollPane(images);
	static int nbImages;
	static int y;
	static String pictureLinkFinal;
	
	String ContactId;

	public PanelGalleryChoose(String ContactId) {

			this.ContactId = ContactId;
			
			setBackground(Color.BLACK);
			
			setPreferredSize(new Dimension(480, 770));
			
			//count the number of images in folder
			File imageFolder = new File("src/application/gallery/images");
			String[] imageFolderString = imageFolder.list();
			this.nbImages = imageFolder.listFiles().length;
			
			//size of images panel depends on number of images
			int size = nbImages*85;
			
			//create images Panel
			images.setLayout(new GridLayout(0,2));
			images.setPreferredSize(new Dimension(480, size));
			images.setBackground(Color.BLACK);
			images.setVisible(true);
			images.removeAll();
			
			//create JScrollPane
			JScrollPane pnl = new JScrollPane(images);
			pnl.setLayout(new ScrollPaneLayout());
			pnl.setMinimumSize(new Dimension(480,660));
			pnl.setPreferredSize(new Dimension(480, 660));
			pnl.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			pnl.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			pnl.setBackground(Color.BLACK);
					
			pnl.setVisible(true);
			
			//increase speed of vertical bar scrolling
			pnl.getVerticalScrollBar().setUnitIncrement(16);
			
			//add images Panel to scrollPane & add scrollPane to PanelGallery
			
			add(pnl);
			
			PanelImage[] pnlImages = new PanelImage[nbImages];
					
			//loop to fill images Panel with images from src folder
			for(int i = 0; i<nbImages;i++) 
			{
				
				String pictureLink = "src/application/gallery/images/" + imageFolderString[i];
				ImageIcon myPicture = new ImageIcon(pictureLink);
				Image myPictureImage = myPicture.getImage();
				Image myPictureImageResized = myPictureImage.getScaledInstance(300, 240, java.awt.Image.SCALE_SMOOTH);
				myPicture = new ImageIcon(myPictureImageResized);
				
				JLabel pictureLabel = new JLabel(myPicture);
				System.out.println("index : " + i);
				
				int refImage = i;
				//when click on one of the images in GridLayout -> Transfer information for image source 
				pictureLabel.addMouseListener(new MouseAdapter () {
					@Override
			         public void mousePressed(MouseEvent e) {
						System.out.println(pictureLink);
						Contacts.changePnlScreen(ContactId);
						setPictureLink(pictureLink);
					}
				});
				
				images.add(pictureLabel);
			}

			revalidate();	
		}
	public static String getPictureLink() {
		return pictureLinkFinal;
	}

	public static void setPictureLink(String pictureLink) {
		pictureLinkFinal = pictureLink;
	}

}