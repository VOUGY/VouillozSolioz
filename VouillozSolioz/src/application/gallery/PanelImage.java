package application.gallery;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import smartphone.FrameShell;

public class PanelImage extends JPanel {

	int refImage;
	JLabel pictureLabel;
	int nbImages;
	File imageSource;
	int index;
	String[] imageFolderString;
	
	static File imageFolder = new File("src/application/gallery/images");	
	
	int y = 0;
	
	public PanelImage(String[] imageFolderString, int index, int refImage, JPanel images, JScrollPane pnl) {
		
	this.refImage = refImage;
	this.index = index;
		
	setLayout(new FlowLayout());
		
	//check if the image source folder is up to date
	refreshImageFolder();
		
	this.nbImages = imageFolder.listFiles().length;
		
	String pictureLink = "src/application/gallery/images/" + imageFolderString[refImage];
	
	//retrieve the image based on parameters
	ImageIcon myPicture = new ImageIcon(pictureLink);
	Image myPictureImage = myPicture.getImage();
	Image myPictureImageResized = myPictureImage.getScaledInstance(600, 480, java.awt.Image.SCALE_SMOOTH);
	myPicture = new ImageIcon(myPictureImageResized);
		
	this.imageSource = new File(pictureLink);
		
	this.pictureLabel = new JLabel(myPicture);

	//navigation buttons
	JButton btnBack = new JButton("back");
	JButton btnNext = new JButton("next");
	JButton btnDelete = new JButton("delete");
	JButton btnReturn = new JButton("X");
	
	//go to the next image in the list
	btnNext.addMouseListener(new MouseAdapter () {
		@Override
	    public void mousePressed(MouseEvent e) {
			getNextImg();
			revalidate();
			repaint();
			}
		});
	
	//go to the previous image in the list
	btnBack.addMouseListener(new MouseAdapter () {
		@Override
	    public void mousePressed(MouseEvent e) {
				getPreviousImg();
				revalidate();
				repaint();
			}
		});
	
	//return to the display of all images in the gallery
	btnReturn.addMouseListener(new MouseAdapter () {
		@Override
	    public void mousePressed(MouseEvent e) {
			setVisible(false);
				
			PanelGallery.refreshGrid();
				
			images.setVisible(true);
			pnl.setVisible(true);
				
		}
	});
	
	//delete the current image and return to the display of all images in the gallery
	btnDelete.addMouseListener(new MouseAdapter () {
		@Override
	    public void mousePressed(MouseEvent e) {
				
			int response = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer cette image ?");
				 
			if(response == 0)
			{
				imageSource.delete();
				images.remove(index);
			}				 
			setVisible(false);
 
			pnl.setVisible(true);
			images.setVisible(true);

			PanelGallery.refreshGrid();
			PanelGallery.nbImages--;				 
				 				 
		}
	});
	
	//add to PanelImage the navigation buttons and the pictureLabel
	add(btnBack);
	add(btnNext);
		
	add(btnDelete);
	add(btnReturn);
	add(pictureLabel);

}
	
	//method that removes current pictureLabel and adds the next one in image Folder
	public void getNextImg() {
		
		remove(this.pictureLabel);

		//if last image, next goes back to first image
		if (index != PanelGallery.nbImages)
		{
			refImage++;
			index++;
		}
		 
		else
		{
			refImage = 0;
			index = 1;
		}
			

		//retrieve next image
		String pictureLink = "src/application/gallery/images/" + imageFolderString[refImage];
		ImageIcon myPicture = new ImageIcon(pictureLink);
		Image myPictureImage = myPicture.getImage();
		Image myPictureImageResized = myPictureImage.getScaledInstance(600, 480, java.awt.Image.SCALE_SMOOTH);
		myPicture = new ImageIcon(myPictureImageResized);
		
		this.pictureLabel = new JLabel(myPicture);
		this.imageSource = new File("src/application/gallery/images/" + imageFolderString[refImage]);
		add(pictureLabel);
		
		System.out.println("y : " + PanelGallery.y + " index : " + index + " refImage : " + refImage + " nbImages : " + PanelGallery.nbImages);
	}
	
	//method that removes current pictureLabel and gets the previous image in the image source Folder
	public void getPreviousImg() {
		remove(this.pictureLabel);

		//if first image, next goes back to first image
		if (refImage != 0)
		{
			refImage--;
			index--;
		}			
		else
		{
			refImage = PanelGallery.nbImages-1;
			index = refImage-1;
		}			

		//retrieve previous image
		String pictureLink = "src/application/gallery/images/" + imageFolderString[refImage];
		ImageIcon myPicture = new ImageIcon(pictureLink);
		Image myPictureImage = myPicture.getImage();
		Image myPictureImageResized = myPictureImage.getScaledInstance(600, 480, java.awt.Image.SCALE_SMOOTH);
		myPicture = new ImageIcon(myPictureImageResized);
		
		this.pictureLabel = new JLabel(myPicture);
		this.imageSource = new File("src/application/gallery/images/" + imageFolderString[refImage]);
		add(pictureLabel);
		
		System.out.println("y : " + PanelGallery.y + " index : " + index + " refImage : " + refImage + " nbImages : " + PanelGallery.nbImages);
	}
	
	//makes sure that image source folder is up to date
	public void refreshImageFolder() {
		File imageFolder = new File("src/application/gallery/images");	
		this.imageFolderString = imageFolder.list();
	}
	
}
