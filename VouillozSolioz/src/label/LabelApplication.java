package label;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LabelApplication extends JLabel {

	public LabelApplication()
	{
		Dimension mySize = new Dimension(100,100);
		ImageIcon myImage = new ImageIcon("C:/Users/guill/Desktop/contacts.jpg");
	
		
		setPreferredSize(mySize);
		setIcon(myImage);
		
		addMouseListener(new myListener());
	}
	public class myListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
          //ici lancement des applications 
        }
	}
}
