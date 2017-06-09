package application.contact;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelContactMin extends JPanel {

	JLabel lblNomPrenom = new JLabel ();
	JLabel lblAbrevation = new JLabel();
//	MyMouseListener mesinfo = new MyMouseListener();
	public PanelContactMin ()
	{
		//COntact
		setBackground(Color.GRAY);
		setPreferredSize(new Dimension(480, 50));
		
	//	lblAbrevation.setBackground(Color.BLUE);
	//	lblAbrevation.setOpaque(true);
		lblAbrevation.setPreferredSize(new Dimension(50, 50));
		lblAbrevation.setFont(new Font("Arial", Font.BOLD, 35));
		lblAbrevation.setAlignmentY(TOP_ALIGNMENT);
		lblAbrevation.setVerticalTextPosition(JLabel.CENTER);
	//	lblNomPrenom.setBackground(Color.WHITE);
	//	lblNomPrenom.setOpaque(true);
		lblNomPrenom.setPreferredSize(new Dimension(400, 50));
		lblNomPrenom.setFont(new Font("Arial", Font.BOLD, 25));
	//	addMouseListener(mesinfo);
		add(lblAbrevation);
		add(lblNomPrenom);
		
	}
	public void setInfos(String Nom, String Prenom)
	{
		lblNomPrenom.setText(Prenom +" "+ Nom);
		lblAbrevation.setText(Prenom.substring(0, 1)+ Nom.substring(0, 1));
	}
	
	public class MyMouseListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e)
		{
			System.out.println("closing");
			
		}
	}
}
