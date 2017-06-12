package smartphone;


import application.gallery.PanelGallery;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
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
	static ArrayList<JPanel> pnlApp = new ArrayList<JPanel>();
	protected static String[] Home = {"Home","Gallery","Contact"};
	protected static int indice = 1;

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
	setResizable(false);
	

	pnlHead = new JPanel();
	pnlHome = new JPanel();
	pnlApp.add(pnlScreen);

	pnlScreens.setLayout(cldScreen);
	pnlScreens.add(pnlApp.get(0),"Home");
	
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


	public static void addPnlScreen(JPanel pnlScreen, String Name) {
		
		pnlScreens.add(pnlScreen, Name);
		indice++;
	}
	public static void changePnlScreen(String stScreen) {
		cldScreen = (CardLayout) pnlScreens.getLayout();
		cldScreen.show(pnlScreens, stScreen);
	}	
}
