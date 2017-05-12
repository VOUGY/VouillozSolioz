package smartphone;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FrameHome frmHome = new FrameHome();
		FrameShell myShell = new FrameShell();
		myShell.setVisible(true);
		myShell.setPnlScreen(frmHome);
	}

}
