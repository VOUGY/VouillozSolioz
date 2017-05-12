package smartphone;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameHome extends JPanel {

	JLabel monlabel = new JLabel("test");
	public FrameHome() {
		
		setBackground(Color.BLUE);
		add(monlabel);
		System.out.println("Test");
		revalidate();
	}
	
}
