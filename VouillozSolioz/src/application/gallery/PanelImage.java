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
	
	int y = 0;
	
	public PanelImage(int index, int refImage, JPanel images, JScrollPane pnl) {
		
		this.refImage = refImage;
		this.index = index;
		
		setLayout(new FlowLayout());
		
		File imageFolder = new File("src/application/gallery/images");
		
		String[] imageFolderString = imageFolder.list();
		
		this.nbImages = imageFolder.listFiles().length;
		
		String pictureLink = "src/application/gallery/images/" + imageFolderString[refImage];
		ImageIcon myPicture = new ImageIcon(pictureLink);
		Image myPictureImage = myPicture.getImage();
		Image myPictureImageResized = myPictureImage.getScaledInstance(600, 480, java.awt.Image.SCALE_SMOOTH);
		myPicture = new ImageIcon(myPictureImageResized);
		
		this.imageSource = new File("src/application/gallery/images/" + imageFolderString[refImage]);
		
		this.pictureLabel = new JLabel(myPicture);

		JButton btnBack = new JButton("back");
		JButton btnNext = new JButton("next");
		JButton btnDelete = new JButton("delete");
		JButton btnReturn = new JButton("X");
		
		btnNext.addMouseListener(new MouseAdapter () {
			@Override
	         public void mousePressed(MouseEvent e) {
				getNextImg();
				revalidate();
				repaint();
			}
		});
		
		btnBack.addMouseListener(new MouseAdapter () {
			@Override
	         public void mousePressed(MouseEvent e) {
				getPreviousImg();
				revalidate();
				repaint();
			}
		});
		
		btnReturn.addMouseListener(new MouseAdapter () {
			@Override
	         public void mousePressed(MouseEvent e) {
				setVisible(false);
				
				PanelGallery.refreshGrid();
				
				images.setVisible(true);
				pnl.setVisible(true);
				
				
			}
		});
		
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
				 nbImages--;
				 PanelGallery.nbImages--;				 
				 PanelGallery.y++;
				 				 
			}
		});
		
		add(btnBack);
		add(btnNext);
		
		add(btnDelete);
		add(btnReturn);
		add(pictureLabel);

	}
	
	public void getNextImg() {
		
		remove(this.pictureLabel);

		//if last image, next goes back to first image
		if (refImage+1+PanelGallery.y != nbImages)
		{
			this.refImage++;
			this.index++;
		}
		 
		else
		{
			this.refImage = 0;
			this.index = 0;
		}
			
		
		File imageFolder = new File("src/application/gallery/images");
		String[] imageFolderString = imageFolder.list();

		String pictureLink = "src/application/gallery/images/" + imageFolderString[refImage];
		ImageIcon myPicture = new ImageIcon(pictureLink);
		Image myPictureImage = myPicture.getImage();
		Image myPictureImageResized = myPictureImage.getScaledInstance(600, 480, java.awt.Image.SCALE_SMOOTH);
		myPicture = new ImageIcon(myPictureImageResized);
		
		this.pictureLabel = new JLabel(myPicture);
		this.imageSource = new File("src/application/gallery/images/" + imageFolderString[refImage]);
		add(pictureLabel);
	}
	
	public void getPreviousImg() {
		remove(this.pictureLabel);

		if(index == refImage)
			index++;
		//if first image, next goes back to first image
		if (refImage != 0)
		{
			this.refImage--;
			this.index--;
		}			
		else
		{
			this.refImage = nbImages-1;
			this.index = nbImages;
		}			
		
		File imageFolder = new File("src/application/gallery/images");
		String[] imageFolderString = imageFolder.list();

		String pictureLink = "src/application/gallery/images/" + imageFolderString[refImage];
		ImageIcon myPicture = new ImageIcon(pictureLink);
		Image myPictureImage = myPicture.getImage();
		Image myPictureImageResized = myPictureImage.getScaledInstance(600, 480, java.awt.Image.SCALE_SMOOTH);
		myPicture = new ImageIcon(myPictureImageResized);
		
		this.pictureLabel = new JLabel(myPicture);
		this.imageSource = new File("src/application/gallery/images/" + imageFolderString[refImage]);
		add(pictureLabel);
		
		System.out.println("y : " + PanelGallery.y + " index : " + index + " refImage : " + refImage);
	}
	
}
