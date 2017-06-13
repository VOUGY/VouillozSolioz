package application.contact;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;


import smartphone.FrameShell;

import javax.swing.JButton;
import java.awt.Button;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelContactMax extends JPanel {

	JTextField[] mytxtfdinfo = new JTextField[4];
	JLabel[] mylblinfotitle = new JLabel[4];
	String[] myinfotitle = { "Name", "FirstName", "Call ID", "EMail" };
	String[] myinfo;
	private JTextField myName;
	private JTextField textField;
	JButton btnEdit;
	JButton btnDelete;

	public PanelContactMax(String[] myinfo) {
		// COntact
		this.myinfo = myinfo;
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(480, 600));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 150, 92, 95, 142, 0 };
		gridBagLayout.rowHeights = new int[] { 32, 25, 0, 133, 23, 22, 23, 0, 0, 0, 0, 0, 0, 0, 0, 22, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		CreateHead(false);
		CreatePicture();
		ViewsInfos(myinfo, mytxtfdinfo, mylblinfotitle, myinfotitle);

		// lblAbrevation.setBackground(Color.BLUE);
		// lblAbrevation.setOpaque(true);

	}

	public PanelContactMax() {
		// COntact
		this.myinfo = new String[7];
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(480, 600));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 150, 92, 95, 142, 0 };
		gridBagLayout.rowHeights = new int[] { 32, 25, 0, 133, 23, 22, 23, 0, 0, 0, 0, 0, 0, 0, 0, 22, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		CreateHead(true);
		CreatePicture();
		CreateInfos(mytxtfdinfo, mylblinfotitle, myinfotitle);

		// lblAbrevation.setBackground(Color.BLUE);
		// lblAbrevation.setOpaque(true);

	}

	private void ViewsInfos(String[] mesinfo, JTextField[] mytxtfdinfo, JLabel[] mylblinfotitle, String[] myinfotitle) {
		// TODO Auto-generated method stub
		int temp = 4;
		for (int i = 0; i < mytxtfdinfo.length; i++) {

			mylblinfotitle[i] = new JLabel(myinfotitle[i]);
			mylblinfotitle[i].setFont(new Font("Samsung InterFace", Font.PLAIN, 22));
			mylblinfotitle[i].setHorizontalAlignment(SwingConstants.LEFT);
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.NORTH;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.insets = new Insets(0, 10, 5, 5);
			gbc.gridx = 0;
			gbc.gridy = temp;
			add(mylblinfotitle[i], gbc);

			temp++;

			mytxtfdinfo[i] = new JTextField(mesinfo[i + 2]);
			mytxtfdinfo[i].setFont(new Font("Samsung InterFace", Font.PLAIN, 18));
			mytxtfdinfo[i].setHorizontalAlignment(SwingConstants.LEFT);
			mytxtfdinfo[i].setEditable(false);
			GridBagConstraints gbc_txt = new GridBagConstraints();
			gbc_txt.anchor = GridBagConstraints.NORTH;
			gbc_txt.fill = GridBagConstraints.HORIZONTAL;
			gbc_txt.insets = new Insets(0, 5, 5, 5);
			gbc_txt.gridwidth = 5;
			gbc_txt.gridx = 0;
			gbc_txt.gridy = temp;
			add(mytxtfdinfo[i], gbc_txt);
			// mytxtfdinfo[i].setColumns(10);

			temp++;
		}
	}

	private void CreateInfos(JTextField[] mytxtfdinfo, JLabel[] mylblinfotitle, String[] myinfotitle) {
		// TODO Auto-generated method stub
		int temp = 4;
		for (int i = 0; i < mytxtfdinfo.length; i++) {

			mylblinfotitle[i] = new JLabel(myinfotitle[i]);
			mylblinfotitle[i].setFont(new Font("Samsung InterFace", Font.PLAIN, 22));
			mylblinfotitle[i].setHorizontalAlignment(SwingConstants.LEFT);
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.NORTH;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.insets = new Insets(0, 10, 5, 5);
			gbc.gridx = 0;
			gbc.gridy = temp;
			add(mylblinfotitle[i], gbc);

			temp++;

			mytxtfdinfo[i] = new JTextField(myinfotitle[i]);
			mytxtfdinfo[i].setFont(new Font("Samsung InterFace", Font.PLAIN, 18));
			mytxtfdinfo[i].setHorizontalAlignment(SwingConstants.LEFT);

			mytxtfdinfo[i].addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					JTextField texteField = ((JTextField) e.getSource());
					texteField.setText("");
					texteField.getFont().deriveFont(Font.PLAIN);
					texteField.setForeground(Color.black);
					texteField.removeMouseListener(this);
				}
				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}
				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}
				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}
				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}
			});

			GridBagConstraints gbc_txt = new GridBagConstraints();
			gbc_txt.anchor = GridBagConstraints.NORTH;
			gbc_txt.fill = GridBagConstraints.HORIZONTAL;
			gbc_txt.insets = new Insets(0, 5, 5, 5);
			gbc_txt.gridwidth = 5;
			gbc_txt.gridx = 0;
			gbc_txt.gridy = temp;
			add(mytxtfdinfo[i], gbc_txt);
			// mytxtfdinfo[i].setColumns(10);

			temp++;
		}
	}

	private void CreatePicture() {

		// TODO Auto-generated method stub
		JButton btnPicture = new JButton("Photo");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 3;
		btnPicture.setEnabled(false);
		add(btnPicture, gbc_btnNewButton);

	}

	public void CreateHead(boolean NewContact) {
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new actEdit());
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.anchor = GridBagConstraints.NORTH;
		gbc_btnBack.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBack.insets = new Insets(0, 0, 5, 5);
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 1;
		add(btnBack, gbc_btnBack);

		btnEdit = new JButton("Edit");
		if (NewContact)
			btnEdit.setText("Create");
		btnEdit.addActionListener(new actEdit());
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.NORTH;
		gbc_button.fill = GridBagConstraints.HORIZONTAL;
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 3;
		gbc_button.gridy = 1;
		add(btnEdit, gbc_button);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new actEdit());
		btnDelete.setVisible(false);
		btnDelete.setBackground(Color.RED);
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDelete.insets = new Insets(0, 0, 5, 0);
		gbc_btnDelete.gridx = 3;
		gbc_btnDelete.gridy = 2;
		add(btnDelete, gbc_btnDelete);
	}

	public class actEdit implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (((JButton) e.getSource()).getText() == "Edit")
				for (int i = 0; i < mytxtfdinfo.length; i++) {
					mytxtfdinfo[i].setEditable(true);
					btnEdit.setText("Validate");
					btnDelete.setVisible(true);

				}
			else if (((JButton) e.getSource()).getText() == "Validate") {
				for (int i = 0; i < mytxtfdinfo.length; i++) {
					mytxtfdinfo[i].setEditable(false);
					btnEdit.setText("Edit");
					Contacts.ModifyContact(myinfo[0], myinfo[1],
							mytxtfdinfo[0].getText(), mytxtfdinfo[1].getText(), mytxtfdinfo[2].getText(),
							mytxtfdinfo[3].getText(), " ");
					Contacts.changePnlScreen("Home");
				}
			}
			else if (((JButton) e.getSource()).getText() == "Create") {
					Contacts.AddContact(mytxtfdinfo[0].getText(), mytxtfdinfo[1].getText(), mytxtfdinfo[2].getText(),
							mytxtfdinfo[3].getText(),"");
					
					for (int i = 0; i < mytxtfdinfo.length; i++) {
						mytxtfdinfo[i].setEditable(false);
						btnEdit.setText("Edit");
					}
			}
			else if (((JButton) e.getSource()).getText() == "Back") {
				Contacts.changePnlScreen("Home");
			} else if (((JButton) e.getSource()).getText() == "Delete") {
				Contacts.deleteContact(myinfo[0], myinfo[1]);
				Contacts.delPnlScreen(Integer.parseInt(myinfo[0]));
				Contacts.changePnlScreen("Home");
				
			}

		}

	}

}
