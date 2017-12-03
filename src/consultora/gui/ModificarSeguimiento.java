package consultora.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import consultora.dao.MediosTradicionalesDAO;
import consultora.objects.MediosActuales;
import consultora.objects.MediosTradicionales;
import consultora.objects.Seguimiento;
import consultora.objects.Tema;

@SuppressWarnings("serial")

public class ModificarSeguimiento extends JPanel {

	private JButton btnCancelar;
	private JButton btnAceptar;
	private JTextField redSocial;
	private JTextField mgPublicacionApoyo;
	private JTextField mgPublicacionNeutral;
	private JTextField mgPublicacionRechazo;
	private JTextField publicacionApoyo;
	private JTextField publicacionNeutral;
	private JTextField publicacionRechazo;
	private JTextArea apreciacion;
	private JTextField cantNotasDiarios;
	private JTextField cantTapasRevista;
	private JTextField minHsCentral;
	private JTextField minTelevision;

	private MediosActuales medioActual;
	private MediosTradicionales medioTradicional;
	private JLabel lblApreciacin;
	private JLabel lblCantidadNotasDiarios;
	private JLabel lblMinutosEnTelevision;
	private MediosTradicionalesDAO mtDAO;

	public ModificarSeguimiento(Tema temaSelect) {

		medioActual = temaSelect.getSeguimientoMA();
		medioTradicional = temaSelect.getSeguimientoMT();

		if (medioActual == null) {
			medioActual = new MediosActuales("", "", 0, 0, 0, 0, 0, 0, 0);
		}
		if (medioTradicional == null) {
			medioTradicional = new MediosTradicionales("", "", 0, 0, 0, 0, "");
		}

		setLayout(null);

		/*
		 * BARRA
		 */

		JPanel barra = new JPanel();
		barra.setLocation(0, 0);
		barra.setSize(750, 85);
		barra.setLayout(null);
		barra.setBackground(new Color(69, 193, 100));
		add(barra);

		JPanel panel = new JPanel();
		panel.setBounds(0, 84, 750, 415);
		panel.setLayout(null);
		panel.setBackground(new Color(246, 246, 246));
		add(panel);

		JTextField codigoTema = new JTextField(temaSelect.getCodigo());
		codigoTema.setHorizontalAlignment(SwingConstants.LEFT);
		codigoTema.setBounds(368, 22, 120, 32);
		codigoTema.setFont(new Font("Calibri", Font.PLAIN, 30));
		codigoTema.setBorder(null);
		codigoTema.setBackground(new Color(69, 193, 100));
		barra.add(codigoTema);

		JLabel lblPalabraClave = new JLabel("Palabra Clave");
		lblPalabraClave.setBounds(32, 13, 104, 20);
		lblPalabraClave.setFont(new Font("Calibri", Font.PLAIN, 18));
		panel.add(lblPalabraClave);

		JTextField palabraClave = new JTextField(temaSelect.getPalabraClave());
		palabraClave.setBounds(146, 13, 450, 21);
		palabraClave.setFont(new Font("Calibri", Font.PLAIN, 17));
		palabraClave.setEditable(false);
		panel.add(palabraClave);

		JLabel lblMediosActuales = new JLabel("Medios Actuales");
		lblMediosActuales.setBounds(81, 65, 128, 16);
		lblMediosActuales.setFont(new Font("Calibri", Font.PLAIN, 18));
		panel.add(lblMediosActuales);

		JLabel lblCod = new JLabel("Red Social");
		lblCod.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblCod.setBounds(32, 111, 75, 16);
		panel.add(lblCod);

		redSocial = new JTextField(medioActual.getRedSocial());
		redSocial.setBounds(119, 107, 116, 22);
		panel.add(redSocial);
		redSocial.setEditable(false);
		redSocial.setColumns(10);

		JLabel lblPostApoyoneutralrechazo = new JLabel("Post Apoyo/Neutral/Rechazo");
		lblPostApoyoneutralrechazo.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblPostApoyoneutralrechazo.setBounds(32, 170, 216, 16);
		panel.add(lblPostApoyoneutralrechazo);

		publicacionApoyo = new JTextField("" + medioActual.getPublicacionesApoyo());
		publicacionApoyo.setEditable(false);
		publicacionApoyo.setBounds(56, 197, 36, 22);
		panel.add(publicacionApoyo);
		publicacionApoyo.setColumns(10);

		publicacionNeutral = new JTextField("" + medioActual.getPublicacionesNeutrales());
		publicacionNeutral.setEditable(false);
		publicacionNeutral.setBounds(111, 197, 36, 22);
		panel.add(publicacionNeutral);
		publicacionNeutral.setColumns(10);

		publicacionRechazo = new JTextField("" + medioActual.getPublicacionesRechazo());
		publicacionRechazo.setEditable(false);
		publicacionRechazo.setBounds(173, 197, 36, 22);
		panel.add(publicacionRechazo);
		publicacionRechazo.setColumns(10);

		JLabel lblMgApoyo = new JLabel("Mg Apoyo/Neutral/Rechazo");
		lblMgApoyo.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblMgApoyo.setHorizontalAlignment(SwingConstants.LEFT);
		lblMgApoyo.setBounds(32, 248, 216, 16);
		panel.add(lblMgApoyo);

		mgPublicacionApoyo = new JTextField("" + medioActual.getMgPublicacionApoyo());
		mgPublicacionApoyo.setEditable(false);
		mgPublicacionApoyo.setBounds(56, 285, 36, 22);
		panel.add(mgPublicacionApoyo);
		mgPublicacionApoyo.setColumns(10);

		mgPublicacionNeutral = new JTextField("" + medioActual.getMgPublicacionNeutral());
		mgPublicacionNeutral.setEditable(false);
		mgPublicacionNeutral.setBounds(111, 285, 36, 22);
		panel.add(mgPublicacionNeutral);
		mgPublicacionNeutral.setColumns(10);

		mgPublicacionRechazo = new JTextField("" + medioActual.getMgPublicacionRechazo());
		mgPublicacionRechazo.setEditable(false);
		mgPublicacionRechazo.setBounds(173, 285, 36, 22);
		panel.add(mgPublicacionRechazo);
		mgPublicacionRechazo.setColumns(10);

		JLabel lblMediosTradicionales = new JLabel("Medios Tradicionales");
		lblMediosTradicionales.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblMediosTradicionales.setBounds(453, 65, 178, 16);
		panel.add(lblMediosTradicionales);

		lblCantidadNotasDiarios = new JLabel("Cantidad Notas Diarios/Tapas de Revista");
		lblCantidadNotasDiarios.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblCantidadNotasDiarios.setBounds(389, 111, 277, 16);
		panel.add(lblCantidadNotasDiarios);

		cantNotasDiarios = new JTextField("" + medioTradicional.getCantNotasDiarios());
		cantNotasDiarios.setBounds(477, 140, 36, 22);
		panel.add(cantNotasDiarios);
		cantNotasDiarios.setColumns(10);

		cantTapasRevista = new JTextField("" + medioTradicional.getCantTapasRevistas());
		cantTapasRevista.setBounds(568, 140, 36, 22);
		panel.add(cantTapasRevista);
		cantTapasRevista.setColumns(10);

		lblMinutosEnTelevision = new JLabel("Minutos Horario Central/Television");
		lblMinutosEnTelevision.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblMinutosEnTelevision.setBounds(388, 171, 287, 16);
		panel.add(lblMinutosEnTelevision);

		minHsCentral = new JTextField("" + medioTradicional.getMinsHorarioCentral());
		minHsCentral.setBounds(477, 206, 36, 22);
		panel.add(minHsCentral);
		minHsCentral.setColumns(10);

		minTelevision = new JTextField("" + medioTradicional.getMinsTelevision());
		minTelevision.setBounds(568, 206, 36, 22);
		panel.add(minTelevision);
		minTelevision.setColumns(10);

		lblApreciacin = new JLabel("Apreciaci\u00F3n:");
		lblApreciacin.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblApreciacin.setBounds(389, 253, 80, 16);
		panel.add(lblApreciacin);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(477, 248, 198, 71);
		panel.add(scrollPane);

		apreciacion = new JTextArea(medioTradicional.getApreciacion());
		scrollPane.setViewportView(apreciacion);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(512, 372, 94, 23);
		btnAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Seguimiento seguimientoMT = new MediosTradicionales(temaSelect.getCodigo(), "",
						Integer.parseInt(minTelevision.getText()), Integer.parseInt(minHsCentral.getText()),
						Integer.parseInt(cantNotasDiarios.getText()), Integer.parseInt(cantTapasRevista.getText()),
						apreciacion.getText());
				
				
				mtDAO.actualizarSeguimiento(seguimientoMT);
				
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				frame.setContentPane(new Consulta());
				frame.validate();

			}
		});
		panel.add(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(616, 372, 94, 23);
		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				frame.setContentPane(new Consulta());
				frame.validate();
			}
		});
		panel.add(btnCancelar);

	}

}