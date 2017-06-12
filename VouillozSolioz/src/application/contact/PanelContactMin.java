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
import javax.swing.JButton;

public class PanelContactMin extends JPanel {

	JButton btnNomPrenom = new JButton ();
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
		btnNomPrenom.setBorder(null);
		btnNomPrenom.setContentAreaFilled(false);
		btnNomPrenom.setFocusTraversalKeysEnabled(false);
		btnNomPrenom.setFocusPainted(false);
		btnNomPrenom.setOpaque(false);
		btnNomPrenom.setBackground(Color.GRAY);
		btnNomPrenom.setText("test");
		btnNomPrenom.setHorizontalAlignment(SwingConstants.LEFT);
		btnNomPrenom.setPreferredSize(new Dimension(400, 70));
		btnNomPrenom.setFont(new Font("Arial", Font.BOLD, 25));
		btnNomPrenom.addMouseListener(new MyMouseListener(iD));
	//	addMouseListener(mesinfo);
		add(lblAbrevation);
		add(btnNomPrenom);
		
	}
	public void setInfos(String Nom, String Prenom)
	{
		btnNomPrenom.setText(Prenom +" "+ Nom);
		lblAbrevation.setText(Prenom.substring(0, 1)+ Nom.substring(0, 1));
	}
	public int getiD ()
	{
		return iD;
	}
}
