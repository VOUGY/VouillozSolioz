package application.contact;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;


public class MyMouseListener extends MouseAdapter {
	int iD;		
	public MyMouseListener(int iD)
	{
		this.iD = iD;
	}
	public void mouseClicked(MouseEvent e) {
		//JButton temp = (JButton) e.getSource();

		System.out.println(iD);
		// myPanel.add(contacts.get(temp.getiD()).getMyPanelContactMax());
		Contacts.changePnlScreen(String.valueOf(iD));
	}
}