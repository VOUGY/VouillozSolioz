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
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelImage extends JPanel {

	int refImage;
	JLabel pictureLabel;
	int nbImages;
	
	public PanelImage(int nbImage, JPanel images, JScrollPane pnl) {
		
		this.refImage = nbImage;
		setLayout(new FlowLayout());
		
		File imageFolder = new File("src/application/gallery/images");
		String[] imageFolderString = imageFolder.list();
		this.nbImages = imageFolder.listFiles().length;
		
		String pictureLink = "src/application/gallery/images/" + imageFolderString[nbImage];
		ImageIcon myPicture = new ImageIcon(pictureLink);
		Image myPictureImage = myPicture.getImage();
		Image myPictureImageResized = myPictureImage.getScaledInstance(600, 480, java.awt.Image.SCALE_SMOOTH);
		myPicture = new ImageIcon(myPictureImageResized);
		
		this.pictureLabel = new JLabel(myPicture);

		JButton btnNext = new JButton("next");
		JButton btnBack = new JButton("back");
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
				
				images.setVisible(true);
				pnl.setVisible(true);
				
				
				revalidate();
				repaint();
			}
		});
		
		add(btnNext);
		add(btnBack);
		add(btnReturn);
		add(pictureLabel);

	}
	
	public void getNextImg() {
		
		remove(this.pictureLabel);

		//if last image, next goes back to first image
		if (refImage+1 != nbImages)
		 this.refImage++;
		else
			this.refImage = 0;
		
		File imageFolder = new File("src/application/gallery/images");
		String[] imageFolderString = imageFolder.list();

		String pictureLink = "src/application/gallery/images/" + imageFolderString[refImage];
		ImageIcon myPicture = new ImageIcon(pictureLink);
		Image myPictureImage = myPicture.getImage();
		Image myPictureImageResized = myPictureImage.getScaledInstance(600, 480, java.awt.Image.SCALE_SMOOTH);
		myPicture = new ImageIcon(myPictureImageResized);
		
		this.pictureLabel = new JLabel(myPicture);
		add(pictureLabel);
	}
	
	public void getPreviousImg() {
		remove(this.pictureLabel);

		//if last image, next goes back to first image
		if (refImage != 0)
		 this.refImage--;
		else
			this.refImage = nbImages-1;
		
		File imageFolder = new File("src/application/gallery/images");
		String[] imageFolderString = imageFolder.list();

		String pictureLink = "src/application/gallery/images/" + imageFolderString[refImage];
		ImageIcon myPicture = new ImageIcon(pictureLink);
		Image myPictureImage = myPicture.getImage();
		Image myPictureImageResized = myPictureImage.getScaledInstance(600, 480, java.awt.Image.SCALE_SMOOTH);
		myPicture = new ImageIcon(myPictureImageResized);
		
		this.pictureLabel = new JLabel(myPicture);
		add(pictureLabel);
	}
}
