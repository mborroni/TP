package src.consultora.gui;

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

import src.consultora.dao.MediosTradicionalesDAO;
import src.consultora.objects.MediosTradicionales;
import src.consultora.objects.Seguimiento;
import src.consultora.objects.Tema;
import src.consultora.objects.MediosActuales;

import javax.swing.JSeparator;

@SuppressWarnings("serial")

public class ModificarSeguimiento extends JPanel {

	private JLabel lblTema;
	private JTextField operador;

	private JTextField redSocial;
	private JTextField mgPublicacionApoyo;
	private JTextField mgPublicacionNeutral;
	private JTextField mgPublicacionRechazo;
	private JTextField publicacionApoyo;
	private JTextField publicacionNeutral;
	private JTextField publicacionRechazo;
	private JTextField replicas;

	private JSeparator separator;
	
	private JTextArea apreciacion;
	private JTextField cantNotasDiarios;
	private JTextField cantTapasRevista;
	private JTextField minHsCentral;
	private JTextField minTelevision;
	private JLabel lblApreciacion;

	private JButton btnCancelar;
	private JButton btnAceptar;
	
	private MediosActuales medioActual;
	private MediosTradicionales medioTradicional;

	
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
		
		lblTema = new JLabel("Tema");
		lblTema.setBounds(277, 16, 79, 42);
		lblTema.setFont(new Font("Calibri", Font.PLAIN, 30));
		barra.add(lblTema);

		JTextField codigoTema = new JTextField(temaSelect.getCodigo());
		codigoTema.setHorizontalAlignment(SwingConstants.LEFT);
		codigoTema.setBounds(366, 21, 163, 32);
		codigoTema.setFont(new Font("Calibri", Font.PLAIN, 30));
		codigoTema.setBorder(null);
		codigoTema.setBackground(new Color(69, 193, 100));
		barra.add(codigoTema);

		JLabel lblPalabraClave = new JLabel("Palabra Clave");
		lblPalabraClave.setBounds(32, 13, 104, 20);
		lblPalabraClave.setFont(new Font("Calibri", Font.PLAIN, 18));
		panel.add(lblPalabraClave);

		JTextField palabraClave = new JTextField(temaSelect.getPalabraClave());
		palabraClave.setBounds(146, 13, 170, 21);
		palabraClave.setFont(new Font("Calibri", Font.PLAIN, 17));
		palabraClave.setEditable(false);
		panel.add(palabraClave);
		
		JLabel lblOperador = new JLabel("Operador");
		lblOperador.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblOperador.setBounds(409, 13, 94, 20);
		panel.add(lblOperador);
		
		operador = new JTextField(medioTradicional.getOperador());
		operador.setFont(new Font("Calibri", Font.PLAIN, 17));
		operador.setEditable(false);
		operador.setBounds(497, 13, 170, 21);
		panel.add(operador);

		JLabel lblMediosActuales = new JLabel("Medios Actuales");
		lblMediosActuales.setBounds(106, 65, 128, 16);
		lblMediosActuales.setFont(new Font("Calibri", Font.PLAIN, 18));
		panel.add(lblMediosActuales);

		JLabel lblCod = new JLabel("Red Social");
		lblCod.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblCod.setBounds(76, 98, 75, 16);
		panel.add(lblCod);

		redSocial = new JTextField(medioActual.getRedSocial());
		redSocial.setBounds(156, 94, 116, 22);
		panel.add(redSocial);
		redSocial.setEditable(false);

		JLabel lblMg = new JLabel("Me gustas");
		lblMg.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblMg.setHorizontalAlignment(SwingConstants.LEFT);
		lblMg.setBounds(39, 125, 88, 16);
		panel.add(lblMg);

		JLabel lblApoyo = new JLabel("Apoyo");
		lblApoyo.setBounds(54, 152, 73, 14);
		panel.add(lblApoyo);

		mgPublicacionApoyo = new JTextField("" + medioActual.getMgPublicacionApoyo());
		mgPublicacionApoyo.setEditable(false);
		mgPublicacionApoyo.setBounds(54, 168, 62, 22);
		panel.add(mgPublicacionApoyo);

		JLabel lblNeutral = new JLabel("Neutral");
		lblNeutral.setBounds(138, 152, 75, 14);
		panel.add(lblNeutral);

		mgPublicacionNeutral = new JTextField("" + medioActual.getMgPublicacionNeutral());
		mgPublicacionNeutral.setEditable(false);
		mgPublicacionNeutral.setBounds(138, 168, 62, 22);
		panel.add(mgPublicacionNeutral);

		JLabel lblRechazo = new JLabel("Rechazo");
		lblRechazo.setBounds(226, 152, 74, 14);
		panel.add(lblRechazo);

		mgPublicacionRechazo = new JTextField("" + medioActual.getMgPublicacionRechazo());
		mgPublicacionRechazo.setEditable(false);
		mgPublicacionRechazo.setBounds(226, 168, 62, 22);
		panel.add(mgPublicacionRechazo);

		JLabel lblPublicaciones = new JLabel("Publicaciones");
		lblPublicaciones.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblPublicaciones.setBounds(39, 204, 109, 16);
		panel.add(lblPublicaciones);

		JLabel label = new JLabel("Apoyo");
		label.setBounds(54, 228, 73, 14);
		panel.add(label);

		publicacionApoyo = new JTextField("" + medioActual.getPublicacionesApoyo());
		publicacionApoyo.setEditable(false);
		publicacionApoyo.setBounds(54, 246, 62, 22);
		panel.add(publicacionApoyo);

		JLabel label_1 = new JLabel("Neutral");
		label_1.setBounds(138, 228, 75, 14);
		panel.add(label_1);

		publicacionNeutral = new JTextField("" + medioActual.getPublicacionesNeutrales());
		publicacionNeutral.setEditable(false);
		publicacionNeutral.setBounds(138, 246, 62, 22);
		panel.add(publicacionNeutral);

		JLabel label_2 = new JLabel("Rechazo");
		label_2.setBounds(226, 228, 74, 14);
		panel.add(label_2);

		publicacionRechazo = new JTextField("" + medioActual.getPublicacionesRechazo());
		publicacionRechazo.setEditable(false);
		publicacionRechazo.setBounds(226, 246, 62, 22);
		panel.add(publicacionRechazo);

		JLabel lblReplicas = new JLabel("Replicas");
		lblReplicas.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblReplicas.setBounds(39, 294, 77, 14);
		panel.add(lblReplicas);

		replicas = new JTextField("" + medioActual.getReplicas());
		replicas.setEditable(false);
		replicas.setBounds(139, 291, 62, 20);
		panel.add(replicas);

		JLabel lblMediosTradicionales = new JLabel("Medios Tradicionales");
		lblMediosTradicionales.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblMediosTradicionales.setBounds(453, 65, 178, 16);
		panel.add(lblMediosTradicionales);
						
								JLabel lblCantidad = new JLabel("Cantidad");
								lblCantidad.setFont(new Font("Calibri", Font.PLAIN, 16));
								lblCantidad.setBounds(409, 180, 94, 16);
								panel.add(lblCantidad);
				
						JLabel lblNotasDiarios = new JLabel("Notas Diarios");
						lblNotasDiarios.setBounds(465, 204, 94, 14);
						panel.add(lblNotasDiarios);

		cantNotasDiarios = new JTextField("" + medioTradicional.getCantNotasDiarios());
		cantNotasDiarios.setBounds(465, 220, 62, 22);
		panel.add(cantNotasDiarios);
		cantNotasDiarios.setColumns(10);

		JLabel lblTapasRevistas = new JLabel("Tapas Revistas");
		lblTapasRevistas.setBounds(583, 204, 101, 14);
		panel.add(lblTapasRevistas);
		
		cantTapasRevista = new JTextField("" + medioTradicional.getCantTapasRevistas());
		cantTapasRevista.setBounds(584, 220, 62, 22);
		panel.add(cantTapasRevista);
		cantTapasRevista.setColumns(10);

		JLabel lblMinutos = new JLabel("Minutos");
		lblMinutos.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblMinutos.setBounds(409, 264, 86, 16);
		panel.add(lblMinutos);

		JLabel lblHsCentral = new JLabel("Hs. Central");
		lblHsCentral.setBounds(465, 285, 94, 14);
		panel.add(lblHsCentral);

		minHsCentral = new JTextField("" + medioTradicional.getMinsHorarioCentral());
		minHsCentral.setBounds(466, 299, 62, 22);
		panel.add(minHsCentral);
		minHsCentral.setColumns(10);

		JLabel lblTelevision = new JLabel("Television");
		lblTelevision.setBounds(583, 285, 101, 14);
		panel.add(lblTelevision);
		
		minTelevision = new JTextField("" + medioTradicional.getMinsTelevision());
		minTelevision.setBounds(585, 299, 59, 22);
		panel.add(minTelevision);
		minTelevision.setColumns(10);

		lblApreciacion = new JLabel("Apreciaci\u00F3n:");
		lblApreciacion.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblApreciacion.setBounds(409, 103, 80, 16);
		panel.add(lblApreciacion);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(497, 98, 170, 71);
		panel.add(scrollPane);

		apreciacion = new JTextArea(medioTradicional.getApreciacion());
		scrollPane.setViewportView(apreciacion);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(512, 372, 94, 23);
		btnAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Seguimiento seguimientoMT = new MediosTradicionales(temaSelect.getCodigo(), "" ,
						Integer.parseInt(minTelevision.getText()), Integer.parseInt(minHsCentral.getText()),
						Integer.parseInt(cantNotasDiarios.getText()), Integer.parseInt(cantTapasRevista.getText()),
						(String)apreciacion.getText());
				
				MediosTradicionalesDAO mtDAO = new MediosTradicionalesDAO();
				mtDAO.updateSeguimiento(seguimientoMT);
				
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
		
		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(372, 85, 7, 286);
		panel.add(separator);

	}

}