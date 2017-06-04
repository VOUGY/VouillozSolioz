package application.gallery;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.ScrollPaneLayout;

public class PanelGallery extends JPanel{

	public PanelGallery() {
		
		//PanelGallery format
		setBackground(Color.BLUE);
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(480, 770));
		
		//count the number of images in folder
		File imageFolder = new File("src/application/gallery/images");
		String[] imageFolderString = imageFolder.list();
		int nbImages = imageFolder.listFiles().length;
		
		//size of images panel depends on number of images
		int size = nbImages*85;
		
		//create images Panel
		JPanel images = new JPanel();
		images.setLayout(new GridLayout(0,2));
		images.setPreferredSize(new Dimension(480, size));
		images.setBackground(Color.BLACK);
		
		//loop to fill images Panel with images from src folder
		for(int i = 0; i<nbImages;i++) 
		{
			String pictureLink = "src/application/gallery/images/" + imageFolderString[i];
			ImageIcon myPicture = new ImageIcon(pictureLink);
			Image myPictureImage = myPicture.getImage();
			Image myPictureImageResized = myPictureImage.getScaledInstance(300, 240, java.awt.Image.SCALE_SMOOTH);
			myPicture = new ImageIcon(myPictureImageResized);
			
			JLabel pictureLabel = new JLabel(myPicture);
			pictureLabel.addMouseListener(new MouseAdapter () {
				@Override
		         public void mousePressed(MouseEvent e) {
					System.out.println(pictureLink);
				}
			});
			
			
			images.add(pictureLabel);
		}
		
		//create JScrollPane
		JScrollPane pnl = new JScrollPane(images);
		pnl.setLayout(new ScrollPaneLayout());
		pnl.setMinimumSize(new Dimension(480,660));
		pnl.setPreferredSize(new Dimension(480, 660));
		pnl.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		pnl.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pnl.setBackground(Color.RED);
		
		//increase speed of vertical bar scrolling
		pnl.getVerticalScrollBar().setUnitIncrement(16);
		
		//add images Panel to scrollPane & add scrollPane to PanelGallery
		add(pnl);
		
		//render Panels visible
		setVisible(true);
		revalidate();
		
		

	}	
}




