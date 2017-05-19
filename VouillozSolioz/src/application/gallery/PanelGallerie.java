package application.gallery;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class PanelGallerie extends JPanel{
	
	public PanelGallerie() {
		
		setPreferredSize(new Dimension(480, 770));
		setBackground(Color.RED);
		revalidate();
		
	}

}
