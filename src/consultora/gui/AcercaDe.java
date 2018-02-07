package consultora.gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")

public class AcercaDe extends JPanel {

	public AcercaDe(JFrame popUp) {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JLabel lblAcercaDe = new JLabel("ACERCA DE");
		lblAcercaDe.setBounds(108, 43, 92, 14);
		add(lblAcercaDe);
		
		JTextArea txtrVersion = new JTextArea();
		txtrVersion.setBackground(Color.LIGHT_GRAY);
		txtrVersion.setForeground(Color.BLACK);
		txtrVersion.setEditable(false);
		txtrVersion.setText("Version:(4.5.2)\r\n\r\n(c) Copyright Consultora contributors and \r\n others 1999, 2017.\r\n\r\n All rights reserved.");
		txtrVersion.setBounds(108, 85, 342, 124);
		add(txtrVersion);
	}
}
