package smartphone;

<<<<<<< HEAD
import application.gallery.PanelGallerie;

=======
>>>>>>> branch 'master' of https://github.com/VOUGY/VouillozSolioz.git
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
<<<<<<< HEAD
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
=======
import java.awt.Image;
import java.io.IOException;
>>>>>>> branch 'master' of https://github.com/VOUGY/VouillozSolioz.git

import javax.imageio.ImageIO;
import javax.security.auth.Refreshable;
import javax.swing.*;

public class FrameShell extends JFrame{
<<<<<<< HEAD
	private JPanel pnlHead,pnlHome;
	private JButton btnHome,btnReturn;
	
	/**
	 * @author guill
	 * Gestion du changement d'écran
	 */
	CardLayout cldScreen = new CardLayout();
	JPanel pnlScreens = new JPanel();
	JPanel[] pnlApp = new JPanel[3];
	String[] listContent = {"Home","Gallery","Contact"};
	int indice = 1;
	
	
=======
	private JPanel pnlHead,pnlScreens,pnlHome;

	CardLayout cldScreen;

>>>>>>> branch 'master' of https://github.com/VOUGY/VouillozSolioz.git
	public FrameShell(JPanel pnlScreen) {
		
	JButton btnHome = new JButton();
	//Apply image to btnHome
	try {
		Image imgHome;
		imgHome = ImageIO.read(getClass().getResource("/icons/home.png"));//path
		btnHome.setIcon(new ImageIcon(imgHome));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(480, 840);
	
<<<<<<< HEAD
	pnlHead = new JPanel();
	pnlHome = new JPanel();
	pnlApp[0] = pnlScreen;
=======
	pnlHead = new JPanel(); //en-tête du smartphone
	pnlHome = new JPanel(); //fond du smartphone avec bouton home
	pnlApp[0] = pnlScreen;
>>>>>>> branch 'master' of https://github.com/VOUGY/VouillozSolioz.git
	
<<<<<<< HEAD
	pnlScreens.setLayout(cldScreen);
	pnlScreens.add(pnlApp[0],listContent[0]);
	
	btnHome = new JButton("Home");
	btnReturn  = new JButton("Return");
	btnHome.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent event){				
	    	  cldScreen.next(pnlScreens);
	         System.out.println("Test");
	        }
	      });
	
=======
	pnlScreens.add(pnlScreen,"home");

>>>>>>> branch 'master' of https://github.com/VOUGY/VouillozSolioz.git
	pnlHead.setPreferredSize(new Dimension(480, 30));
	pnlHead.setBackground(Color.LIGHT_GRAY);
	
	pnlHome.setPreferredSize(new Dimension(480, 80));
	pnlHome.setBackground(Color.LIGHT_GRAY);
	pnlHome.add(btnHome);

	add(BorderLayout.NORTH,pnlHead);
	add(BorderLayout.CENTER,pnlScreens);
	add(BorderLayout.SOUTH,pnlHome);
	

	}


	public void addPnlScreen(JPanel pnlScreen) {
		pnlApp[indice] = pnlScreen;
		pnlScreens.add(pnlApp[indice], listContent[indice]);
		indice++;
	}
	public void changePnlScreen(String stScreen) {
		cldScreen = (CardLayout) pnlScreens.getLayout();
		cldScreen.next(pnlScreens);
	}	
}
