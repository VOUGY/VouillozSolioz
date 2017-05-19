package application.gallery;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
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

public class PanelGallery extends JPanel{

	public PanelGallery() {
		
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
			
			try {
				BufferedImage myPicture;
				myPicture = ImageIO.read(new File("src/application/gallery/images/" + imageFolderString[i]));
				JLabel picLabel = new JLabel(new ImageIcon(myPicture));
				this.add(picLabel);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}

		
		setPreferredSize(new Dimension(480, 770));
		setBackground(Color.RED);
		revalidate();
		setVisible(true);
		
		

		
	}
	


}
