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
import java.awt.FlowLayout;
import java.awt.Component;

public class PanelContactMin extends JPanel {

	JLabel lblNomPrenom = new JLabel ();
	JLabel lblAbrevation = new JLabel();
	int iD;
//	MyMouseListener mesinfo = new MyMouseListener();
	public PanelContactMin (int iD)
	{
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		//COntact
		this.iD = iD;
		setBackground(Color.GRAY);
		setPreferredSize(new Dimension(480, 70));
		lblAbrevation.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbrevation.setText("GV");
		
		
		lblAbrevation.setPreferredSize(new Dimension(70, 70));
		lblAbrevation.setFont(new Font("Arial", Font.BOLD, 35));
		lblAbrevation.setVerticalTextPosition(JLabel.CENTER);
		lblNomPrenom.setText("test");
		lblNomPrenom.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomPrenom.setPreferredSize(new Dimension(400, 70));
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
	public int getiD ()
	{
		return iD;
	}
}
