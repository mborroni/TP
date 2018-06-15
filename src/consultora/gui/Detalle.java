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
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import com.toedter.calendar.JDateChooser;

import src.consultora.objects.MediosTradicionales;
import src.consultora.objects.Tema;
import src.consultora.objects.MediosActuales;

@SuppressWarnings("serial")

public class Detalle extends JSplitPane {

	private JTextField codigoTema;
	private JTextField palabraClave;
	private JDateChooser fechaInicio;
	private JDateChooser fechaFin;
	private JTextArea descripcionTxtArea;
	
	private JTextField redSocial;
	private JTextField mgPublicacionApoyo;
	private JTextField mgPublicacionNeutral;
	private JTextField mgPublicacionRechazo;
	private JTextField publicacionApoyo;
	private JTextField publicacionNeutral;
	private JTextField publicacionRechazo;
	private JTextField replicas;

	private JTextArea apreciacion;
	private JTextField cantNotasDiarios;
	private JTextField cantTapasRevistas;
	private JTextField minHsCentral;
	private JTextField minTelevision;
	
	private JLabel lblApreciacin;
	private JLabel lblCantidad;
	private JLabel lblMinutos;
	private JLabel lblEstrascendenteMT;
	private JLabel lblHsCentral;
	private JLabel lblTelevision;
	private JLabel lblApoyo;
	private JLabel lblNeutral;
	private JLabel lblRechazo;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel lblReplicas;

	private JButton btnVolver;
	
	private MediosActuales medioActual;
	private MediosTradicionales medioTradicional;


	public Detalle(Tema temaSelect) {

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

		JLabel lblCodigo = new JLabel("Tema");
		lblCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigo.setFont(new Font("Calibri", Font.PLAIN, 30));
		lblCodigo.setBounds(277, 13, 83, 32);
		barra.add(lblCodigo);

		codigoTema = new JTextField(temaSelect.getCodigo());
		codigoTema.setHorizontalAlignment(SwingConstants.LEFT);
		codigoTema.setBounds(370, 13, 120, 32);
		codigoTema.setFont(new Font("Calibri", Font.PLAIN, 30));
		codigoTema.setBorder(null);
		codigoTema.setBackground(new Color(69, 193, 100));
		barra.add(codigoTema);

		JLabel lblPalabraClave = new JLabel("Palabra Clave:");
		lblPalabraClave.setBounds(277, 53, 104, 20);
		barra.add(lblPalabraClave);
		lblPalabraClave.setFont(new Font("Calibri", Font.PLAIN, 18));

		palabraClave = new JTextField(temaSelect.getPalabraClave());
		palabraClave.setBounds(384, 53, 151, 21);
		palabraClave.setBorder(null);
		palabraClave.setBackground(new Color(69, 193, 100));
		palabraClave.setFont(new Font("Calibri", Font.PLAIN, 17));
		palabraClave.setEditable(false);
		barra.add(palabraClave);
		
		JLabel lblOperador = new JLabel("Operador:");
		lblOperador.setBounds(10, 52, 83, 20);
		barra.add(lblOperador);
		lblOperador.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		JTextField operador = new JTextField(medioTradicional.getOperador());
		operador.setBounds(89, 53, 128, 21);
		operador.setBorder(null);
		operador.setBackground(new Color(69, 193, 100));
		barra.add(operador);
		operador.setFont(new Font("Calibri", Font.PLAIN, 17));
		operador.setEditable(false);

		/*
		 * DETALLES
		 */

		JPanel panel = new JPanel();
		panel.setBounds(0, 84, 750, 415);
		panel.setLayout(null);
		panel.setBackground(new Color(246, 246, 246));
		add(panel);

		JLabel lblSeguimiento = new JLabel("Seguimiento");
		lblSeguimiento.setBounds(29, 10, 109, 20);
		panel.add(lblSeguimiento);

		JLabel lblDesde = new JLabel("Desde");
		lblDesde.setBounds(79, 38, 45, 20);
		panel.add(lblDesde);

		lblDesde.setFont(new Font("Calibri", Font.PLAIN, 16));

		fechaInicio = new JDateChooser(java.sql.Date.valueOf(temaSelect.getInicio()));
		fechaInicio.setBounds(139, 36, 151, 20);
		fechaInicio.setEnabled(false);
		panel.add(fechaInicio);

		JLabel lblHasta = new JLabel("Hasta");
		lblHasta.setBounds(79, 66, 58, 20);
		panel.add(lblHasta);
		lblHasta.setFont(new Font("Calibri", Font.PLAIN, 16));

		fechaFin = new JDateChooser(java.sql.Date.valueOf(temaSelect.getFin()));
		fechaFin.setBounds(139, 66, 151, 20);
		fechaFin.setEnabled(false);
		panel.add(fechaFin);

		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblDescripcion.setBounds(387, 13, 109, 14);
		panel.add(lblDescripcion);

		descripcionTxtArea = new JTextArea(temaSelect.getDescripcion());
		JScrollPane scrollpane = new JScrollPane(descripcionTxtArea);
		scrollpane.setBounds(387, 36, 302, 54);
		descripcionTxtArea.setEditable(false);
		panel.add(scrollpane);
		lblSeguimiento.setFont(new Font("Calibri", Font.PLAIN, 18));

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(369, 102, 11, 286);
		panel.add(separator);

		JLabel lblMediosActuales = new JLabel("Medios Actuales");
		lblMediosActuales.setBounds(100, 114, 128, 16);
		lblMediosActuales.setFont(new Font("Calibri", Font.PLAIN, 18));
		panel.add(lblMediosActuales);

		// Medio Actual

		JLabel lblCod = new JLabel("Red Social");
		lblCod.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblCod.setBounds(66, 143, 75, 16);
		panel.add(lblCod);

		redSocial = new JTextField(medioActual.getRedSocial());
		redSocial.setBounds(146, 139, 116, 22);
		panel.add(redSocial);
		redSocial.setEditable(false);

		JLabel lblMg = new JLabel("Me gustas");
		lblMg.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblMg.setHorizontalAlignment(SwingConstants.LEFT);
		lblMg.setBounds(29, 170, 88, 16);
		panel.add(lblMg);

		lblApoyo = new JLabel("Apoyo");
		lblApoyo.setBounds(44, 197, 73, 14);
		panel.add(lblApoyo);

		mgPublicacionApoyo = new JTextField("" + medioActual.getMgPublicacionApoyo());
		mgPublicacionApoyo.setEditable(false);
		mgPublicacionApoyo.setBounds(44, 213, 62, 22);
		panel.add(mgPublicacionApoyo);

		lblNeutral = new JLabel("Neutral");
		lblNeutral.setBounds(128, 197, 75, 14);
		panel.add(lblNeutral);

		mgPublicacionNeutral = new JTextField("" + medioActual.getMgPublicacionNeutral());
		mgPublicacionNeutral.setEditable(false);
		mgPublicacionNeutral.setBounds(128, 213, 62, 22);
		panel.add(mgPublicacionNeutral);

		lblRechazo = new JLabel("Rechazo");
		lblRechazo.setBounds(216, 197, 74, 14);
		panel.add(lblRechazo);

		mgPublicacionRechazo = new JTextField("" + medioActual.getMgPublicacionRechazo());
		mgPublicacionRechazo.setEditable(false);
		mgPublicacionRechazo.setBounds(216, 213, 62, 22);
		panel.add(mgPublicacionRechazo);

		JLabel lblPublicaciones = new JLabel("Publicaciones");
		lblPublicaciones.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblPublicaciones.setBounds(29, 249, 109, 16);
		panel.add(lblPublicaciones);

		label = new JLabel("Apoyo");
		label.setBounds(44, 273, 73, 14);
		panel.add(label);

		publicacionApoyo = new JTextField("" + medioActual.getPublicacionesApoyo());
		publicacionApoyo.setEditable(false);
		publicacionApoyo.setBounds(44, 291, 62, 22);
		panel.add(publicacionApoyo);

		label_1 = new JLabel("Neutral");
		label_1.setBounds(128, 273, 75, 14);
		panel.add(label_1);

		publicacionNeutral = new JTextField("" + medioActual.getPublicacionesNeutrales());
		publicacionNeutral.setEditable(false);
		publicacionNeutral.setBounds(128, 291, 62, 22);
		panel.add(publicacionNeutral);

		label_2 = new JLabel("Rechazo");
		label_2.setBounds(216, 273, 74, 14);
		panel.add(label_2);

		publicacionRechazo = new JTextField("" + medioActual.getPublicacionesRechazo());
		publicacionRechazo.setEditable(false);
		publicacionRechazo.setBounds(216, 291, 62, 22);
		panel.add(publicacionRechazo);

		lblReplicas = new JLabel("Replicas");
		lblReplicas.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblReplicas.setBounds(29, 339, 77, 14);
		panel.add(lblReplicas);

		replicas = new JTextField("" + medioActual.getReplicas());
		replicas.setEditable(false);
		replicas.setBounds(129, 336, 62, 20);
		panel.add(replicas);

		JLabel lblEsapoyado = new JLabel("Es apoyado.");
		lblEsapoyado.setBounds(189, 374, 170, 14);
		if (medioActual.esApoyado()) {
			lblEsapoyado.setText("Fue apoyado.");
		} else
			lblEsapoyado.setText("No fue apoyado.");
		panel.add(lblEsapoyado);

		JLabel lblEstrascendenteMA = new JLabel("EsTrascendente");
		lblEstrascendenteMA.setBounds(29, 374, 133, 14);
		if (medioActual.esTrascendente()) {
			lblEstrascendenteMA.setText("Es trascendente.");
		} else
			lblEstrascendenteMA.setText("No es trascendente.");
		panel.add(lblEstrascendenteMA);

		JLabel lblMediosTradicionales = new JLabel("Medios Tradicionales");
		lblMediosTradicionales.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblMediosTradicionales.setBounds(471, 114, 178, 16);
		panel.add(lblMediosTradicionales);

		lblApreciacin = new JLabel("Apreciaci\u00F3n:");
		lblApreciacin.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblApreciacin.setBounds(402, 143, 80, 16);
		panel.add(lblApreciacin);

		apreciacion = new JTextArea(medioTradicional.getApreciacion());
		apreciacion.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(apreciacion);
		scrollPane.setBounds(491, 143, 198, 62);
		panel.add(scrollPane);

		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblCantidad.setBounds(402, 216, 94, 16);
		panel.add(lblCantidad);

		JLabel lblNotasDiarios = new JLabel("Notas Diarios");
		lblNotasDiarios.setBounds(471, 228, 94, 14);
		panel.add(lblNotasDiarios);

		cantNotasDiarios = new JTextField("" + medioTradicional.getCantNotasDiarios());
		cantNotasDiarios.setEditable(false);
		cantNotasDiarios.setBounds(471, 246, 62, 22);
		panel.add(cantNotasDiarios);
		cantNotasDiarios.setColumns(10);

		JLabel lblTapasRevistas = new JLabel("Tapas Revistas");
		lblTapasRevistas.setBounds(572, 228, 101, 14);
		panel.add(lblTapasRevistas);

		cantTapasRevistas = new JTextField("" + medioTradicional.getCantNotasDiarios());
		cantTapasRevistas.setEditable(false);
		cantTapasRevistas.setBounds(572, 246, 62, 22);
		panel.add(cantTapasRevistas);
		cantTapasRevistas.setColumns(10);

		lblMinutos = new JLabel("Minutos");
		lblMinutos.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblMinutos.setBounds(402, 286, 86, 16);
		panel.add(lblMinutos);

		lblHsCentral = new JLabel("Hs. Central");
		lblHsCentral.setBounds(471, 295, 94, 14);
		panel.add(lblHsCentral);

		minHsCentral = new JTextField("" + medioTradicional.getMinsHorarioCentral());
		minHsCentral.setEditable(false);
		minHsCentral.setBounds(471, 313, 62, 22);
		panel.add(minHsCentral);
		minHsCentral.setColumns(10);

		lblTelevision = new JLabel("Television");
		lblTelevision.setBounds(572, 295, 101, 14);
		panel.add(lblTelevision);

		minTelevision = new JTextField("" + medioTradicional.getMinsTelevision());
		minTelevision.setEditable(false);
		minTelevision.setBounds(572, 313, 62, 22);
		panel.add(minTelevision);
		minTelevision.setColumns(10);

		lblEstrascendenteMT = new JLabel("EsTrascendente");
		lblEstrascendenteMT.setBounds(400, 374, 133, 14);
		if (medioTradicional.esTrascendente() == true) {
			lblEstrascendenteMT.setText("Es trascendente.");
		} else
			lblEstrascendenteMT.setText("No es trascendente.");
		panel.add(lblEstrascendenteMT);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(599, 381, 94, 23);
		btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				frame.setContentPane(new Consulta());
				frame.validate();
			}
		});
		panel.add(btnVolver);

	}
}