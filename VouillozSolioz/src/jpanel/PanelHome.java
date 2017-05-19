package jpanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.crypto.spec.SecretKeySpec;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import label.LabelApplication;

public class PanelHome extends JPanel {

	 JButton[] tabbtnHome = new JButton[2];
	LabelApplication monContact[] = new LabelApplication[2];
	
	public PanelHome() {
		setPreferredSize(new Dimension(480, 770));
		setBackground(Color.BLUE);
		for (int i = 0; i < monContact.length; i++) {
			monContact[i] = new LabelApplication();
			
		}
		add(monContact[0]);
		add(monContact[1]);
		
		System.out.println("Test");
		revalidate();
		System.out.println("TEst");
	}
}
