package application.gallery;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.ArrayList;

import application.contact.Contact;
import application.gallery.PanelGallery;
import smartphone.FrameShell;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;

public class PanelGallery extends JPanel{

	static JPanel images = new JPanel();
	static JScrollPane pnl = new JScrollPane(images);
	static int nbImages;
	static int y;
	static int maxRefImg = 0; //last image reference in our image source folder
	static int maxIndex = 0; //last cell in our GridLayout
	
	static File imageFolder = new File("src/application/gallery/images");
	static String[] imageFolderString = imageFolder.list();
	
	public PanelGallery() {

		//btnAddImg is the button that opens a Windows Explorer and enables the 
		//user to add a new image to the gallery
		JButton btnAddImg = new JButton("+");
		
		//larger font for esthetic purposes
		btnAddImg.setFont(new Font("Arial", Font.PLAIN, 80));
						
		images.add(btnAddImg);
				
		//PanelGallery format
		CardLayout cldScreen = new CardLayout();
		setLayout(cldScreen);
		
		setBackground(Color.BLACK);
		setLayout(new CardLayout());
		setPreferredSize(new Dimension(480, 770));

		this.nbImages = countImages();
		
		//size of images panel depends on number of images
		int size = nbImages*85;
		
		//create images Panel, images Panel will hold all the images of the gallery
		images.setLayout(new GridLayout(0,2));
		images.setPreferredSize(new Dimension(480, size));
		images.setBackground(Color.BLACK);
		images.setVisible(true);
		
		//create JScrollPane and put images panel inside, this enables the user to scroll
		//through images
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
		
		//add ScrollPane that holds the imagesPanel to the Gallery Panel
		add(pnl);
		
		//create a PanelImage array that will hold one panel per image
		//when the user clicks on an image, a PanelImage opens with that image
		//in a larger size
		PanelImage[] pnlImages = new PanelImage[nbImages];
				
		//loop to fill images Panel with images from src folder
		for(int i = 0; i<nbImages;i++) 
		{
			
			//get picture based on where you clicked on the grid
			String pictureLink = "src/application/gallery/images/" + this.imageFolderString[i];
			ImageIcon myPicture = new ImageIcon(pictureLink);
			Image myPictureImage = myPicture.getImage();
			Image myPictureImageResized = myPictureImage.getScaledInstance(300, 240, java.awt.Image.SCALE_SMOOTH);
			myPicture = new ImageIcon(myPictureImageResized);
			
			JLabel pictureLabel = new JLabel(myPicture);
	
			int refImage = i;
			modifyIndexRef(refImage+1, refImage);
			//when click on one of the images in GridLayout
			pictureLabel.addMouseListener(new MouseAdapter () {
				@Override
		         public void mousePressed(MouseEvent e) {

					images.setVisible(false);
					pnl.setVisible(false);
					
					pnlImages[refImage].setVisible(true);

					pnlImages[refImage].revalidate();
					pnlImages[refImage].repaint();
				}
			});

			images.add(pictureLabel);
			
			//get the location of the image on the grid in order
			//to delete it from the grid afterwards
			int index = images.getComponentZOrder(pictureLabel);
			pnl.setVisible(false);
			
			pnlImages[i] = new PanelImage(imageFolderString, index, i, images, pnl);
			add(pnlImages[i]);	
		}
				
		//add event on click of btnAddImg
		btnAddImg.addMouseListener(new MouseAdapter () {
				@Override
			        public void mousePressed(MouseEvent e) {
					
					//open Windows Explorer
					JFileChooser choice = new JFileChooser();
					int retour=choice.showOpenDialog(btnAddImg);
					if(retour==JFileChooser.APPROVE_OPTION)
					{					
				
						 //name of selected image
						 choice.getSelectedFile().getName();
						 //absolute Path of said image
						 choice.getSelectedFile().getAbsolutePath();
						 
						 //create the image
						 String pictureLinkAdded = choice.getSelectedFile().getAbsolutePath();
						 ImageIcon myPictureAdded = new ImageIcon(pictureLinkAdded);
						 Image myPictureImageAdded = myPictureAdded.getImage();
						 Image myPictureImageResizedAdded = myPictureImageAdded.getScaledInstance(300, 240, java.awt.Image.SCALE_SMOOTH);
						 myPictureAdded = new ImageIcon(myPictureImageResizedAdded);
							
						 JLabel pictureLabel = new JLabel(myPictureAdded);
						 File FileSource = new File(pictureLinkAdded);
						   
						 try {
							saveFile(FileSource);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						 
						 //add event on click of image
						 pictureLabel.addMouseListener(new MouseAdapter () {
							 @Override
							 public void mousePressed(MouseEvent e) {
						
							 imageFolder = new File("src/application/gallery/images");
							 imageFolderString = imageFolder.list();
							
							 images.setVisible(false);
							 pnl.setVisible(false);
									
							 PanelImage pnlImage = new PanelImage(imageFolderString, maxIndex, maxRefImg, images, pnl);
							
							 pnlImage.revalidate();
							 pnlImage.repaint();
							
							 pnlImage.setVisible(true);
							
							 //since there is one more image, we have to 
							 //increase the index and the image reference
							 maxIndex++; 
							 maxRefImg++;
							
							 }
						});

				images.add(pictureLabel);
	
				images.revalidate();
				}			
			}
		});
				
		revalidate();	
	}

	//refresh the JScrollPane and the images Panel
	public static void refreshGrid() {
		
		pnl.removeAll();
		pnl.repaint();		
		images.repaint();
		
	}
	
	//when creating the PanelImages in the array, adapt the max Index & reference
	//until we arrive on the last image & last cell
	private void modifyIndexRef(int index, int ref) {
		this.maxIndex = index;
		this.maxRefImg = ref;
	}
	
	//method to write an Image inside our source folder
	private void saveFile(File imageSource) throws IOException {
			BufferedImage image = ImageIO.read(imageSource);
		    // retrieve image
		    File outputfile = new File("src/application/gallery/images/zimage" + maxRefImg + ".jpeg");
		    ImageIO.write(image, "jpeg", outputfile);
		    this.nbImages++;
		    this.imageFolder = new File("src/application/gallery/images");
			this.imageFolderString = imageFolder.list();
	}
	
	//return the number of images in our Source Folder
	private int countImages() {
		int nbImages;
		//count the number of images in folder
		nbImages = imageFolder.listFiles().length;
		return nbImages;
	}
}
