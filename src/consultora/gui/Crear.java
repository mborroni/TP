package consultora.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import com.toedter.calendar.JDateChooser;

import consultora.dao.TemaDAO;
import consultora.objects.Tema;
@SuppressWarnings("serial")

public class Crear extends JPanel {

	private JTextField palabraClavetxtFld;
	private JTextField codigotxtFld;
	private JDateChooser fechaInicio;
	private JDateChooser fechaFin;
	private JTextArea descripciontxtArea;
	private JButton btnCancelar;
	private JButton btnAceptar;

	private TemaDAO temaDAO = new TemaDAO();

	public Crear() {

		setLayout(null);

		// Barra

		JPanel barra = new JPanel();
		barra.setLocation(0, 0);
		barra.setSize(749, 85);
		barra.setLayout(null);
		barra.setBackground(new Color(69, 193, 100));
		add(barra);

		setLayout(null);

		// Panel

		JPanel panel = new JPanel();
		panel.setBounds(0, 83, 750, 428);
		panel.setBackground(new Color(246, 246, 246));
		add(panel);

		panel.setLayout(null);

		JLabel lblPalabraClave = new JLabel("Palabra Clave");
		lblPalabraClave.setBounds(39, 25, 104, 20);
		lblPalabraClave.setFont(new Font("Calibri", Font.PLAIN, 18));
		panel.add(lblPalabraClave);

		palabraClavetxtFld = new JTextField();
		palabraClavetxtFld.setBounds(153, 26, 388, 20);
		palabraClavetxtFld.setColumns(10);
		panel.add(palabraClavetxtFld);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(563, 25, 64, 20);
		lblCodigo.setFont(new Font("Calibri", Font.PLAIN, 18));
		panel.add(lblCodigo);

		codigotxtFld = new JTextField();
		codigotxtFld.setHorizontalAlignment(SwingConstants.CENTER);
		codigotxtFld.setBounds(621, 25, 64, 20);
		codigotxtFld.setText(codigoTema());
		codigotxtFld.setEditable(false);
		codigotxtFld.setBackground(null);

		lblCodigo.setFont(new Font("Calibri", Font.PLAIN, 18));
		panel.add(codigotxtFld);

		JLabel lblSeguimiento = new JLabel("Seguimiento");
		lblSeguimiento.setBounds(39, 61, 127, 20);
		lblSeguimiento.setFont(new Font("Calibri", Font.PLAIN, 18));
		panel.add(lblSeguimiento);

		JLabel lblDesde = new JLabel("Desde");
		lblDesde.setBounds(158, 89, 45, 20);
		lblDesde.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel.add(lblDesde);

		fechaInicio = new JDateChooser();
		fechaInicio.setBounds(477, 89, 171, 20);
		panel.add(fechaInicio);

		JLabel lblHasta = new JLabel("Hasta");
		lblHasta.setBounds(426, 89, 58, 20);
		lblHasta.setFont(new Font("Calibri", Font.PLAIN, 16));
		panel.add(lblHasta);

		fechaFin = new JDateChooser();
		fechaFin.setBounds(213, 89, 172, 20);
		panel.add(fechaFin);

		JLabel lblDescipcin = new JLabel("Descipci\u00F3n");
		lblDescipcin.setBounds(38, 136, 104, 20);
		lblDescipcin.setFont(new Font("Calibri", Font.PLAIN, 18));
		panel.add(lblDescipcin);

		descripciontxtArea = new JTextArea();
		JScrollPane scrollpane = new JScrollPane(descripciontxtArea);
		scrollpane.setBounds(158, 138, 553, 206);
		panel.add(scrollpane);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(617, 355, 94, 23);
		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				frame.setContentPane(new Consulta());
				frame.validate();

			}
		});
		panel.add(btnCancelar);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(513, 355, 94, 23);
		btnAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Tema tema = new Tema(codigotxtFld.getText(), palabraClavetxtFld.getText(), fechaInicio.getDate(),
						fechaFin.getDate(), descripciontxtArea.getText());
				temaDAO.agregarTema(tema);

				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				frame.setContentPane(new Consulta());
				frame.validate();
			}
		});

		panel.add(btnAceptar);
	}

	public String codigoTema() {
		Random random = new SecureRandom();
		char[] var = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		char[] result = new char[6];
		
			for (int i = 0; i < result.length; i++) {
				// picks a random index out of character set > random character
				int randomCharIndex = random.nextInt(var.length);
				result[i] = var[randomCharIndex];
			}
			
			return new String(result);
	}
}
