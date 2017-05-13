package smartphone;

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
		myImage.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
		
		setPreferredSize(mySize);
		setMaximumSize(mySize);
		setMinimumSize(mySize);
		setSize(mySize);
		setIcon(myImage);
		addMouseListener(new myListener());
	}
	public class myListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
            System.out.println("Yay you clicked me");
        }
	}
}
