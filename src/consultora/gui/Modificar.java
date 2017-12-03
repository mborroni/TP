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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import com.toedter.calendar.JDateChooser;

import consultora.dao.MediosTradicionalesDAO;
import consultora.dao.SeguimientoDAO;
import consultora.objects.MediosActuales;
import consultora.objects.MediosTradicionales;
import consultora.objects.Seguimiento;
import consultora.objects.Tema;



@SuppressWarnings("serial")

public class Modificar extends JPanel{
	
	private JButton btnCancelar;
	private JButton btnAceptar;
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
	private MediosTradicionales mt;
	
	public Modificar(Tema temaSelect) {

		medioActual = temaSelect.getSeguimientoMA();
		medioTradicional = temaSelect.getSeguimientoMT();
		
		if (medioActual == null){
			medioActual = new MediosActuales("", "", 0, 0, 0, 0, 0, 0, 0);
		}
		if (medioTradicional == null){
			medioTradicional =  new MediosTradicionales("", "", 0, 0, 0, 0, "");
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
		palabraClave.setBounds(134, 13, 151, 21);
		palabraClave.setFont(new Font("Calibri", Font.PLAIN, 17));
		palabraClave.setEditable(false);
		panel.add(palabraClave);

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

		
		JLabel lblMediosActuales = new JLabel("Medios Actuales");
		lblMediosActuales.setBounds(81, 65, 128, 16);
		lblMediosActuales.setFont(new Font("Calibri", Font.PLAIN, 18));
		panel.add(lblMediosActuales);

		JLabel lblMediosTradicionales = new JLabel("Medios Tradicionales");
		lblMediosTradicionales.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblMediosTradicionales.setBounds(453, 65, 178, 16);
		panel.add(lblMediosTradicionales);

		// Medio Actual

		JLabel lblCod = new JLabel("Red Social");
		lblCod.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblCod.setBounds(32, 111, 75, 16);
		panel.add(lblCod);

		medioActual1 = new JTextField(medioActual.getRedSocial());
		medioActual1.setBounds(119, 107, 116, 22);
		panel.add(medioActual1);
		medioActual1.setEditable(false);
		medioActual1.setColumns(10);

		JLabel lblMgApoyo = new JLabel("Mg Apoyo/Neutral/Rechazo");
		lblMgApoyo.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblMgApoyo.setHorizontalAlignment(SwingConstants.LEFT);
		lblMgApoyo.setBounds(32, 161, 216, 16);
		panel.add(lblMgApoyo);

		medioActual2 = new JTextField("" + medioActual.getMgPublicacionApoyo());
		medioActual2.setEditable(false);
		medioActual2.setBounds(56, 198, 36, 22);
		panel.add(medioActual2);
		medioActual2.setColumns(10);

		medioActual3 = new JTextField("" + medioActual.getMgPublicacionNeutral());
		medioActual3.setEditable(false);
		medioActual3.setBounds(111, 198, 36, 22);
		panel.add(medioActual3);
		medioActual3.setColumns(10);

		medioActual4 = new JTextField("" + medioActual.getMgPublicacionRechazo());
		medioActual4.setEditable(false);
		medioActual4.setBounds(173, 198, 36, 22);
		panel.add(medioActual4);
		medioActual4.setColumns(10);

		JLabel lblPostApoyoneutralrechazo = new JLabel("Post Apoyo/Neutral/Rechazo");
		lblPostApoyoneutralrechazo.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblPostApoyoneutralrechazo.setBounds(32, 250, 216, 16);
		panel.add(lblPostApoyoneutralrechazo);

		medioActual5 = new JTextField("" + medioActual.getPublicacionesApoyo());
		medioActual5.setEditable(false);
		medioActual5.setBounds(56, 285, 36, 22);
		panel.add(medioActual5);
		medioActual5.setColumns(10);

		medioActual6 = new JTextField("" + medioActual.getPublicacionesNeutrales());
		medioActual6.setEditable(false);
		medioActual6.setBounds(111, 285, 36, 22);
		panel.add(medioActual6);
		medioActual6.setColumns(10);

		medioActual7 = new JTextField("" + medioActual.getPublicacionesRechazo());
		medioActual7.setEditable(false);
		medioActual7.setBounds(173, 285, 36, 22);
		panel.add(medioActual7);
		medioActual7.setColumns(10);


		lblApreciacin = new JLabel("Apreciaci\u00F3n:");
		lblApreciacin.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblApreciacin.setBounds(391, 111, 80, 16);
		panel.add(lblApreciacin);

		lblCantidadNotasDiarios = new JLabel("Cantidad Notas Diarios/Tapas de Revista");
		lblCantidadNotasDiarios.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblCantidadNotasDiarios.setBounds(391, 190, 277, 16);
		panel.add(lblCantidadNotasDiarios);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(479, 106, 198, 71);
		panel.add(scrollPane);
		
		medioTradicional1 = new JTextArea(medioTradicional.getApreciacion());
		scrollPane.setViewportView(medioTradicional1);


		medioTradicional2 = new JTextField("" + medioTradicional.getCantNotasDiarios());
		medioTradicional2.setBounds(479, 219, 36, 22);
		panel.add(medioTradicional2);
		medioTradicional2.setColumns(10);


		medioTradicional3 = new JTextField("" + medioTradicional.getCantTapasRevistas());
		medioTradicional3.setBounds(570, 219, 36, 22);
		panel.add(medioTradicional3);
		medioTradicional3.setColumns(10);


		lblMinutosEnTelevision = new JLabel("Minutos Horario Central/Television");
		lblMinutosEnTelevision.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblMinutosEnTelevision.setBounds(390, 250, 287, 16);
		panel.add(lblMinutosEnTelevision);

		medioTradicional4 = new JTextField("" + medioTradicional.getMinsHorarioCentral());
		medioTradicional4.setBounds(479, 285, 36, 22);
		panel.add(medioTradicional4);
		medioTradicional4.setColumns(10);

		medioTradicional5 = new JTextField("" + medioTradicional.getMinsTelevision());
		medioTradicional5.setBounds(570, 285, 36, 22);
		panel.add(medioTradicional5);
		medioTradicional5.setColumns(10);

		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(512, 372, 94, 23);
		btnAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Seguimiento seguimiento = new MediosTradicionales((String)medioTradicional1.getSelectedItem(), 
						(String)operadorcmbBox.getSelectedItem(), 
						Integer.parseInt(televisiontxtField.getText()),
						Integer.parseInt(hscentraltxtField.getText()), 
						Integer.parseInt(notasDiariostxtField.getText()),
						Integer.parseInt(tapasRevistatxtField.getText()),
						(String)apreciaciontxtArea.getText());
				SeguimientoDAO.actualizarSeguimiento(seguimiento);
				
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				frame.setContentPane(new Consulta());
				frame.validate();
				
				MediosTradicionalesDAO seguimientomT = new MediosTradicionalesDAO();
				seguimientomT.actualizarSeguimiento(mt);
			}
		});
		panel.add(btnAceptar);

		
		// EDITAR >>
		// https://stackoverflow.com/questions/14153544/jtable-how-to-update-cell-using-custom-editor-by-pop-up-input-dialog-box/14176961
		
		}

}
	// TODO Pantalla modificar
	
	// https://stackoverflow.com/questions/29612481/how-to-update-refresh-jpanel-on-jbutton-click


