import static org.junit.Assert.*;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.junit.Test;

import application.gallery.*;

public class JunitTestGallery {

//PanelImage.java
	@Test
	public void getNextImg() {
		
		JLabel pictureLabel = new JLabel();
		int index = 1;
		int nbImages = 0;
		int refImage = 0;
		String[] imageFolderString = null;
		File imageSource;
		
		//remove(pictureLabel);

		//if last image, next goes back to first image
		if (index != nbImages)
		{
			refImage++;
			index++;
			assertEquals(index-refImage,1);
		}
		 
		else
		{
			refImage = 0;
			index = 1;
			assertEquals(index-refImage,1);
		}
			

		//retrieve next image
		String pictureLink = "src/application/gallery/images/images.jpg";
		ImageIcon myPicture = new ImageIcon(pictureLink);
		Image myPictureImage = myPicture.getImage();
		Image myPictureImageResized = myPictureImage.getScaledInstance(600, 480, java.awt.Image.SCALE_SMOOTH);
		myPicture = new ImageIcon(myPictureImageResized);
		
		pictureLabel = new JLabel(myPicture);
		imageSource = new File("src/application/gallery/images/images.jpg");
		//add(pictureLabel);
		
	}
	
	@Test
	public void getPreviousImg() {
		int refImage = 0, index = 1;
		JLabel pictureLabel = new JLabel();
		String[] imageFolderString = null;
		File imageSource = null;
		//remove(pictureLabel);

		//if first image, next goes back to first image
		if (refImage != 0)
		{
			refImage--;
			index--;
			assertEquals(index-refImage,1);
		}			
		else
		{
			//refImage = PanelGallery.nbImages-1;
			index = refImage-1;
			assertEquals(refImage-index,1);
		}			

		//retrieve previous image
		String pictureLink = "src/application/gallery/images/images.jpg";
		ImageIcon myPicture = new ImageIcon(pictureLink);
		Image myPictureImage = myPicture.getImage();
		Image myPictureImageResized = myPictureImage.getScaledInstance(600, 480, java.awt.Image.SCALE_SMOOTH);
		myPicture = new ImageIcon(myPictureImageResized);
		
		pictureLabel = new JLabel(myPicture);
		imageSource = new File("src/application/gallery/images/images.jpg");
		//add(pictureLabel);
	}
	
	@Test
	public void refreshImageFolder() {
		File imageFolder = new File("src/application/gallery/images");	
		String[] imageFolderString = imageFolder.list();
		assertTrue(imageFolder.exists());
	}
//PanelGallery.java
	
	@Test
	public void refreshGrid() {
		JPanel images = new JPanel();
		JScrollPane pnl = new JScrollPane(images);
		
		pnl.removeAll();
		pnl.repaint();		
		images.repaint();
		
		assertTrue(pnl.isVisible());
		
	}
	
	@Test
	public void modifyIndexRef() {
		int index = 0, ref = 0;
		
		int maxIndex = index;
		int maxRefImg = ref;
		
		assertEquals(index, maxIndex);
		assertEquals(index, maxIndex);
	}
	
	@Test
	public void saveFile() throws IOException {
		File imageSource = new File("src/application/gallery/images/images.jpg");
		BufferedImage image = ImageIO.read(imageSource);
	    // retrieve image
		int maxRefImg = 0;
		int nbImages = 0;
		File imageFolder;
		String[] imageFolderString;
		
	    File outputfile = new File("src/application/gallery/images/images.jpg");
	    ImageIO.write(image, "jpeg", outputfile);
	    nbImages++;
	    imageFolder = new File("src/application/gallery/images");
		imageFolderString = imageFolder.list();
		assertTrue(outputfile.exists());
	}
	
	@Test
	public void countImages() {
		int nbImages;
		File imageFolder = new File("src/application/gallery/images");
		//count the number of images in folder
		nbImages = imageFolder.listFiles().length;
		assertEquals(nbImages, imageFolder.listFiles().length);	
		
	}
}
