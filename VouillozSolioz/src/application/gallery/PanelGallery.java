package application.gallery;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class PanelGallery extends JPanel{
	
	public PanelGallery() {
		
		setPreferredSize(new Dimension(480, 770));
		setBackground(Color.RED);
		revalidate();
		setVisible(true);
		
	}
	


}
