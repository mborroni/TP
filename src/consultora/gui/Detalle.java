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

import consultora.dao.MediosActualesDAO;
import consultora.dao.MediosTradicionalesDAO;
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
	
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JButton btnAplicar;
	private JTextField medioActual1;
	private JTextField medioActual2;
	private JTextField medioActual3;
	private JTextField medioActual4;
	private JTextField medioActual5;
	private JTextField medioActual6;
	private JTextField medioActual7;
	private JTextArea medioTradicional1;	
	private JTextField medioTradicional2;
	private JTextField medioTradicional3;
	private JTextField medioTradicional4;
	private JTextField medioTradicional5;
	
	private MediosActuales medioActual;
	private MediosTradicionales medioTradicional; 
	private JLabel lblApreciacin;
	private JLabel lblCantidadNotasDiarios;
	private JLabel lblMinutosEnTelevision;
	
	public Detalle(Tema temaSelect) {
		
		medioTradicional = temaSelect.getSeguimientoMT();
		medioActual = temaSelect.getSeguimientoMA();
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
		
		fechaInicio = new JDateChooser(temaSelect.getInicio());
		fechaInicio.setBounds(136, 116, 151, 20);
		fechaInicio.setEnabled(false);
		panel.add(fechaInicio);

		JLabel lblHasta = new JLabel("Hasta");
		lblHasta.setBounds(58, 159, 58, 20);
		panel.add(lblHasta);
		lblHasta.setFont(new Font("Calibri", Font.PLAIN, 16));
		
		fechaFin = new JDateChooser(temaSelect.getFin());
		fechaFin.setBounds(136, 159, 151, 20);
		fechaFin.setEnabled(false);
		panel.add(fechaFin);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblDescripcion.setBounds(29, 198, 109, 14);
		panel.add(lblDescripcion);
		
		descripcionTxtArea = new JTextArea(temaSelect.getDescripcion());
		JScrollPane scrollpane = new JScrollPane(descripcionTxtArea);
		scrollpane.setBounds(29, 223, 316, 111);;
		descripcionTxtArea.setEditable(false);
		panel.add(scrollpane);
		
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
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(512, 372, 94, 23);
		btnAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				frame.setContentPane(new Consulta()); 
				frame.validate();
			}
		});
		panel.add(btnAceptar);
		
		btnAplicar = new JButton("Aplicar");
		btnAplicar.setBounds(413, 372, 89, 23);
		panel.add(btnAplicar);
		lblSeguimiento.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		JLabel lblMediosActuales = new JLabel("Medios Actuales");
		lblMediosActuales.setBounds(471, 12, 128, 16);
		lblMediosActuales.setFont(new Font("Calibri", Font.PLAIN, 18));
		panel.add(lblMediosActuales);
		
		JLabel lblMediosTradicionales = new JLabel("Medios Tradicionales");
		lblMediosTradicionales.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblMediosTradicionales.setBounds(455, 175, 178, 16);
		panel.add(lblMediosTradicionales);
		
		// Medio Actual
		
		JLabel lblCod = new JLabel("Red Social");
		lblCod.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblCod.setBounds(437, 41, 75, 16);
		panel.add(lblCod);
		
		medioActual1 = new JTextField();//medioActual.getRedSocial());
		medioActual1.setBounds(517, 37, 116, 22);
		panel.add(medioActual1);
		medioActual1.setEditable(false);
		medioActual1.setColumns(10);
		
		
		JLabel lblMgApoyo = new JLabel("Mg Apoyo/Neutral/Rechazo");
		lblMgApoyo.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblMgApoyo.setHorizontalAlignment(SwingConstants.LEFT);
		lblMgApoyo.setBounds(445, 66, 216, 16);
		panel.add(lblMgApoyo);
		
		medioActual2 = new JTextField();//medioActual.getMgPublicacionApoyo());
		medioActual2.setEditable(false);
		medioActual2.setBounds(471, 95, 36, 22);
		panel.add(medioActual2);
		medioActual2.setColumns(10);
		
		medioActual3 = new JTextField();//medioActual.getMgPublicacionNeutral());
		medioActual3.setEditable(false);
		medioActual3.setBounds(522, 95, 36, 22);
		panel.add(medioActual3);
		medioActual3.setColumns(10);
		
		medioActual4 = new JTextField();//medioActual.getMgPublicacionRechazo());
		medioActual4.setEditable(false);
		medioActual4.setBounds(570, 95, 36, 22);
		panel.add(medioActual4);
		medioActual4.setColumns(10);
				
		JLabel lblPostApoyoneutralrechazo = new JLabel("Post Apoyo/Neutral/Rechazo");
		lblPostApoyoneutralrechazo.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblPostApoyoneutralrechazo.setBounds(437, 125, 216, 16);
		panel.add(lblPostApoyoneutralrechazo);
		
		medioActual5 = new JTextField();//medioActual.getPublicacionesApoyo());
		medioActual5.setEditable(false);
		medioActual5.setBounds(471, 144, 36, 22);
		panel.add(medioActual5);
		medioActual5.setColumns(10);
		
		medioActual6 = new JTextField();//medioActual.getPublicacionesNeutrales());
		medioActual6.setEditable(false);
		medioActual6.setBounds(522, 144, 36, 22);
		panel.add(medioActual6);
		medioActual6.setColumns(10);
		
		medioActual7 = new JTextField();//medioActual.getPublicacionesRechazo());
		medioActual7.setEditable(false);
		medioActual7.setBounds(570, 144, 36, 22);
		panel.add(medioActual7);
		medioActual7.setColumns(10);
		


		
		medioTradicional1= new JTextArea(medioTradicional.getApreciacion());
		JScrollPane scrollPane = new JScrollPane(medioTradicional1);
		scrollPane.setBounds(475, 195, 198, 71);
		panel.add(scrollPane);
		
		lblApreciacin = new JLabel("Apreciaci\u00F3n:");
		lblApreciacin.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblApreciacin.setBounds(386, 198, 80, 16);
		panel.add(lblApreciacin);
		
		lblCantidadNotasDiarios = new JLabel("Cantidad Notas Diarios/Tapas de Revista");
		lblCantidadNotasDiarios.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblCantidadNotasDiarios.setBounds(396, 268, 277, 16);
		panel.add(lblCantidadNotasDiarios);
		
		medioTradicional2 = new JTextField(medioTradicional.getCantNotasDiarios());
		medioTradicional2.setEditable(false);
		medioTradicional2.setBounds(485,285, 36, 22);
		panel.add(medioTradicional2);
		medioTradicional2.setColumns(10);
		
		medioTradicional3 = new JTextField(medioTradicional.getCantNotasDiarios());
		medioTradicional3.setEditable(false);
		medioTradicional3.setBounds(570,285, 36, 22);
		panel.add(medioTradicional3);
		medioTradicional3.setColumns(10);
		
		lblMinutosEnTelevision = new JLabel("Minutos Horario Central/Television");
		lblMinutosEnTelevision.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblMinutosEnTelevision.setBounds(390, 308, 287, 16);
		panel.add(lblMinutosEnTelevision);
		
		medioTradicional4 = new JTextField(medioTradicional.getMinsHorarioCentral());
		medioTradicional4.setEditable(false);
		medioTradicional4.setBounds(485,327, 36, 22);
		panel.add(medioTradicional4);
		medioTradicional4.setColumns(10);
		
		medioTradicional5 = new JTextField(medioTradicional.getMinsTelevision());
		medioTradicional5.setEditable(false);
		medioTradicional5.setBounds(570,327, 36, 22);
		panel.add(medioTradicional5);
		medioTradicional5.setColumns(10);		
		
		//EDITAR >> https://stackoverflow.com/questions/14153544/jtable-how-to-update-cell-using-custom-editor-by-pop-up-input-dialog-box/14176961
		btnAplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JTextField firstName = new JTextField("holab");
				JTextArea descripcion = new JTextArea("hola");
				descripcion.setBounds(0, 0, 200, 200);
				final JComponent[] inputs = new JComponent[] {
				        new JLabel("Palabra Clave"),
				        firstName,
				        new JLabel("Descripcion"),
				        descripcion

				};
				int result = JOptionPane.showConfirmDialog(null, inputs, "Editar", JOptionPane.PLAIN_MESSAGE);
				if (result == JOptionPane.OK_OPTION) {
				    System.out.println("You entered " +
				            firstName.getText() + ", " +
				            descripcion.getText() + ", " );
				            
				} else {
				    System.out.println("User canceled / closed the dialog, result = " + result);
				}
				
			}
		});
		
	}
}