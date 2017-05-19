package smartphone;


import application.gallery.PanelGallerie;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.security.auth.Refreshable;
import javax.swing.*;

public class FrameShell extends JFrame{

	private JPanel pnlHead,pnlHome;
	private JButton btnHome,btnReturn;
	
	/**
	 * @author guill
	 * Gestion du changement d'écran
	 */
	protected static CardLayout cldScreen = new CardLayout();
	protected static JPanel pnlScreens = new JPanel();
	JPanel[] pnlApp = new JPanel[3];
	protected String[] listContent = {"Home","Gallery","Contact"};
	protected int indice = 1;

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
	

	pnlHead = new JPanel();
	pnlHome = new JPanel();
	pnlApp[0] = pnlScreen;

	pnlScreens.setLayout(cldScreen);
	pnlScreens.add(pnlApp[0],listContent[0]);
	
	btnReturn  = new JButton("Return");
	btnHome.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent event){				
	    	  cldScreen.show(pnlScreens, "Home");
	    	  //Home
	        }
	      });
	

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
	public static void changePnlScreen(String stScreen) {
		cldScreen = (CardLayout) pnlScreens.getLayout();
		cldScreen.show(pnlScreens, stScreen);
	}	
}
