package application.gallery;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelGallery extends JPanel{

	public PanelGallery() {
		
		this.setAutoscrolls(true);
		JScrollPane scrollFrame = new JScrollPane();
		scrollFrame.setPreferredSize(new Dimension(480, 770));
		
		//count the number of images in folder
		File imageFolder = new File("src/application/gallery/images");
		
		String[] imageFolderString = imageFolder.list();
		
		int nbImages = imageFolder.listFiles().length;
		
		//create layout for clear view of images
		GridLayout grid = new GridLayout(3,2,10,10);
		setLayout(grid);
	
		//loop to fill grid with images
		for(int i = 0; i<nbImages;i++) 
		{
			ImageIcon myPicture = new ImageIcon("src/application/gallery/images/" + imageFolderString[i]);
			Image myPictureImage = myPicture.getImage();
			Image myPictureImageResized = myPictureImage.getScaledInstance(300, 240, java.awt.Image.SCALE_SMOOTH);
			myPicture = new ImageIcon(myPictureImageResized);

			add(new JLabel(myPicture));
		}

		
		setPreferredSize(new Dimension(480, 770));
		setBackground(Color.BLACK);
		revalidate();
		setVisible(true);

	}
	


}
