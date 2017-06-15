package application.contact;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

/**
 * Change panel in application Contact
 * @author guill
 *
 */
public class MyMouseListener extends MouseAdapter {
	int iD;		
	public MyMouseListener(int iD)
	{
		this.iD = iD;
	}
	public void mouseClicked(MouseEvent e) {
		Contacts.changePnlScreen(String.valueOf(iD));
	}
}