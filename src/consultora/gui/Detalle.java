package consultora.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import com.toedter.calendar.JDateChooser;

import consultora.objects.MediosActuales;
import consultora.objects.MediosTradicionales;
import consultora.objects.Tema;

@SuppressWarnings("serial")

public class Detalle extends JSplitPane {

	// TEMA
	private JTextField codigoTema;
	private JTextField palabraClave;
	private JDateChooser fechaInicio;
	private JDateChooser fechaFin;
	private JTextArea descripcionTxtArea;
	private JButton btnVolver;
	private JTextField redSocial;
	private JTextField mgPublicacionApoyo;
	private JTextField mgPublicacionNeutral;
	private JTextField mgPublicacionRechazo;
	private JTextField publicacionApoyo;
	private JTextField publicacionNeutral;
	private JTextField publicacionRechazo;
	private JTextArea medioTradicional1;
	private JTextField cantNotasDiarios;
	private JTextField cantTapasRevistas;
	private JTextField minHsCentral;
	private JTextField minTelevision;

	private MediosActuales medioActual;
	private MediosTradicionales medioTradicional;
	private JLabel lblApreciacin;
	private JLabel lblCantidadNotasDiarios;
	private JLabel lblMinutosEnTelevision;
	private JLabel lblEstrascendenteMT;

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
		lblCodigo.setBounds(276, 22, 83, 32);
		barra.add(lblCodigo);

		codigoTema = new JTextField(temaSelect.getCodigo());
		codigoTema.setHorizontalAlignment(SwingConstants.LEFT);
		codigoTema.setBounds(368, 22, 120, 32);
		codigoTema.setFont(new Font("Calibri", Font.PLAIN, 30));
		codigoTema.setBorder(null);
		codigoTema.setBackground(new Color(69, 193, 100));
		barra.add(codigoTema);

		/*
		 * DETALLES
		 */

		JPanel panel = new JPanel();
		panel.setBounds(0, 84, 750, 415);
		panel.setLayout(null);
		panel.setBackground(new Color(246, 246, 246));
		add(panel);

		JLabel lblSeguimiento = new JLabel("Seguimiento");
		lblSeguimiento.setBounds(29, 77, 109, 20);
		panel.add(lblSeguimiento);

		JLabel lblPalabraClave = new JLabel("Palabra Clave");
		lblPalabraClave.setBounds(29, 38, 104, 20);
		lblPalabraClave.setFont(new Font("Calibri", Font.PLAIN, 18));
		panel.add(lblPalabraClave);

		palabraClave = new JTextField(temaSelect.getPalabraClave());
		palabraClave.setBounds(136, 38, 151, 21);
		palabraClave.setFont(new Font("Calibri", Font.PLAIN, 17));
		palabraClave.setEditable(false);
		panel.add(palabraClave);

		JLabel lblDesde = new JLabel("Desde");
		lblDesde.setBounds(58, 116, 45, 20);
		panel.add(lblDesde);

		lblDesde.setFont(new Font("Calibri", Font.PLAIN, 16));

		fechaInicio = new JDateChooser(java.sql.Date.valueOf(temaSelect.getInicio()));
		fechaInicio.setBounds(136, 116, 151, 20);
		fechaInicio.setEnabled(false);
		panel.add(fechaInicio);

		JLabel lblHasta = new JLabel("Hasta");
		lblHasta.setBounds(58, 159, 58, 20);
		panel.add(lblHasta);
		lblHasta.setFont(new Font("Calibri", Font.PLAIN, 16));

		fechaFin = new JDateChooser(java.sql.Date.valueOf(temaSelect.getFin()));
		fechaFin.setBounds(136, 159, 151, 20);
		fechaFin.setEnabled(false);
		panel.add(fechaFin);

		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblDescripcion.setBounds(29, 198, 109, 14);
		panel.add(lblDescripcion);

		descripcionTxtArea = new JTextArea(temaSelect.getDescripcion());
		JScrollPane scrollpane = new JScrollPane(descripcionTxtArea);
		scrollpane.setBounds(29, 223, 316, 111);
		descripcionTxtArea.setEditable(false);
		panel.add(scrollpane);
		lblSeguimiento.setFont(new Font("Calibri", Font.PLAIN, 18));

		JLabel lblMediosActuales = new JLabel("Medios Actuales");
		lblMediosActuales.setBounds(471, 12, 128, 16);
		lblMediosActuales.setFont(new Font("Calibri", Font.PLAIN, 18));
		panel.add(lblMediosActuales);

		// Medio Actual

		JLabel lblCod = new JLabel("Red Social");
		lblCod.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblCod.setBounds(437, 41, 75, 16);
		panel.add(lblCod);

		redSocial = new JTextField(medioActual.getRedSocial());
		redSocial.setBounds(517, 37, 116, 22);
		panel.add(redSocial);
		redSocial.setEditable(false);
		redSocial.setColumns(10);

		JLabel lblMgApoyo = new JLabel("Mg Apoyo/Neutral/Rechazo");
		lblMgApoyo.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblMgApoyo.setHorizontalAlignment(SwingConstants.LEFT);
		lblMgApoyo.setBounds(445, 66, 216, 16);
		panel.add(lblMgApoyo);

		mgPublicacionApoyo = new JTextField("" + medioActual.getMgPublicacionApoyo());
		mgPublicacionApoyo.setEditable(false);
		mgPublicacionApoyo.setBounds(471, 95, 36, 22);
		panel.add(mgPublicacionApoyo);
		mgPublicacionApoyo.setColumns(10);

		mgPublicacionNeutral = new JTextField("" + medioActual.getMgPublicacionNeutral());
		mgPublicacionNeutral.setEditable(false);
		mgPublicacionNeutral.setBounds(522, 95, 36, 22);
		panel.add(mgPublicacionNeutral);
		mgPublicacionNeutral.setColumns(10);

		mgPublicacionRechazo = new JTextField("" + medioActual.getMgPublicacionRechazo());
		mgPublicacionRechazo.setEditable(false);
		mgPublicacionRechazo.setBounds(570, 95, 36, 22);
		panel.add(mgPublicacionRechazo);
		mgPublicacionRechazo.setColumns(10);

		JLabel lblPostApoyoneutralrechazo = new JLabel("Post Apoyo/Neutral/Rechazo");
		lblPostApoyoneutralrechazo.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblPostApoyoneutralrechazo.setBounds(437, 125, 216, 16);
		panel.add(lblPostApoyoneutralrechazo);

		publicacionApoyo = new JTextField("" + medioActual.getPublicacionesApoyo());
		publicacionApoyo.setEditable(false);
		publicacionApoyo.setBounds(471, 144, 36, 22);
		panel.add(publicacionApoyo);
		publicacionApoyo.setColumns(10);

		publicacionNeutral = new JTextField("" + medioActual.getPublicacionesNeutrales());
		publicacionNeutral.setEditable(false);
		publicacionNeutral.setBounds(522, 144, 36, 22);
		panel.add(publicacionNeutral);
		publicacionNeutral.setColumns(10);

		publicacionRechazo = new JTextField("" + medioActual.getPublicacionesRechazo());
		publicacionRechazo.setEditable(false);
		publicacionRechazo.setBounds(570, 144, 36, 22);
		panel.add(publicacionRechazo);
		publicacionRechazo.setColumns(10);
		
		JLabel lblEsapoyado = new JLabel("");
		lblEsapoyado.setBounds(29, 345, 94, 14);
		if (medioActual.esApoyado()){
			lblEsapoyado.setText("Fue apoyado en las redes sociales");
		}
		else
			lblEsapoyado.setText("No fue apoyado en las redes sociales");
		panel.add(lblEsapoyado);

		JLabel lblEstrascendenteMA = new JLabel("EsTrascendente");
		lblEstrascendenteMA.setBounds(178, 345, 164, 14);
		if (medioActual.esTrascendente()){
			lblEstrascendenteMA.setText("Es trascendente");
		}
		else
			lblEstrascendenteMA.setText("No es trascendente");
		panel.add(lblEstrascendenteMA);

		JLabel lblMediosTradicionales = new JLabel("Medios Tradicionales");
		lblMediosTradicionales.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblMediosTradicionales.setBounds(455, 175, 178, 16);
		panel.add(lblMediosTradicionales);

		lblApreciacin = new JLabel("Apreciaci\u00F3n:");
		lblApreciacin.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblApreciacin.setBounds(386, 198, 80, 16);
		panel.add(lblApreciacin);

		medioTradicional1 = new JTextArea(medioTradicional.getApreciacion());
		JScrollPane scrollPane = new JScrollPane(medioTradicional1);
		scrollPane.setBounds(475, 195, 198, 71);
		panel.add(scrollPane);

		lblCantidadNotasDiarios = new JLabel("Cantidad Notas Diarios/Tapas de Revista");
		lblCantidadNotasDiarios.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblCantidadNotasDiarios.setBounds(396, 268, 277, 16);
		panel.add(lblCantidadNotasDiarios);

		cantNotasDiarios = new JTextField("" + medioTradicional.getCantNotasDiarios());
		cantNotasDiarios.setEditable(false);
		cantNotasDiarios.setBounds(485, 285, 36, 22);
		panel.add(cantNotasDiarios);
		cantNotasDiarios.setColumns(10);

		cantTapasRevistas = new JTextField("" + medioTradicional.getCantNotasDiarios());
		cantTapasRevistas.setEditable(false);
		cantTapasRevistas.setBounds(570, 285, 36, 22);
		panel.add(cantTapasRevistas);
		cantTapasRevistas.setColumns(10);

		lblMinutosEnTelevision = new JLabel("Minutos Horario Central/Television");
		lblMinutosEnTelevision.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblMinutosEnTelevision.setBounds(390, 308, 287, 16);
		panel.add(lblMinutosEnTelevision);

		minHsCentral = new JTextField("" + medioTradicional.getMinsHorarioCentral());
		minHsCentral.setEditable(false);
		minHsCentral.setBounds(485, 327, 36, 22);
		panel.add(minHsCentral);
		minHsCentral.setColumns(10);

		minTelevision = new JTextField("" + medioTradicional.getMinsTelevision());
		minTelevision.setEditable(false);
		minTelevision.setBounds(570, 327, 36, 22);
		panel.add(minTelevision);
		minTelevision.setColumns(10);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(579, 381, 94, 23);
		btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				frame.setContentPane(new Consulta());
				frame.validate();
			}
		});
		panel.add(btnVolver);
		
		lblEstrascendenteMT = new JLabel("EsTrascendenteMT");
		lblEstrascendenteMT.setBounds(405, 363, 75, 14);
		if (medioTradicional.esTrascendente() == true ){
			lblEstrascendenteMT.setText("Es trascendente");
		}
		else
			lblEstrascendenteMT.setText("No es trascendente");
		panel.add(lblEstrascendenteMT);

	}
}