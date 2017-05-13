package smartphone;

import frame.FrameShell;
import jpanel.PanelHome;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PanelHome frmHome = new PanelHome();
		FrameShell myShell = new FrameShell(frmHome);
		myShell.setVisible(true);

	
	}

}
