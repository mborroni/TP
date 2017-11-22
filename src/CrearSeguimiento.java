import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")

public class CrearSeguimiento extends JPanel {
	private JTextField televisiontxtField;
	private JTextField hscentraltxtField;
	private JTextField notasDiariostxtField;
	private JTextField tapasRevistatxtField;
	
	
	private TemaDAO temaDAO = new TemaDAO();
	private SeguimientoDAO seguimientoDAO = new MediosTradicionalesDAO();
	private OperadorDAO operadorDAO = new OperadorDAO();

	public CrearSeguimiento(){
		
		setLayout(null);

		// Barra

		JPanel barra = new JPanel();
		barra.setLocation(0, 0);
		barra.setSize(750, 85);
		barra.setLayout(null);
		barra.setBackground(new Color(69, 193, 100));
		add(barra);
		
		JLabel lblSeguimiento = new JLabel("Seguimiento");
		lblSeguimiento.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblSeguimiento.setBounds(320, 11, 134, 20);
		barra.add(lblSeguimiento);
		
		JLabel lblTema = new JLabel("Tema");
		lblTema.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblTema.setBounds(46, 56, 46, 14);
		barra.add(lblTema);
		
		JComboBox<String> temacmbBox = new JComboBox<String>();
		for (String tema: temaDAO.listarTemasPorCodigo()) {

			temacmbBox.addItem(tema);
		}
		temacmbBox.setBounds(102, 53, 319, 20);
		barra.add(temacmbBox);
		
		JLabel lblOperador = new JLabel("Operador");
		lblOperador.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblOperador.setBounds(465, 53, 66, 21);
		barra.add(lblOperador);
		
		JComboBox<String> operadorcmbBox = new JComboBox<String>();
		for (String operadores : operadorDAO.listarOperadores()) {
			
			operadorcmbBox.addItem(operadores);
			
		}
		operadorcmbBox.setBounds(541, 53, 160, 20);
		barra.add(operadorcmbBox);

		// Seguimiento

		JPanel panel = new JPanel();
		panel.setBounds(0, 85, 750, 415);
		panel.setLayout(null);
		panel.setBackground(new Color(246, 246, 246));
		add(panel);
		
		JLabel lblPromedioMinutos = new JLabel("Promedio minutos");
		lblPromedioMinutos.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblPromedioMinutos.setBounds(46, 17, 150, 25);
		panel.add(lblPromedioMinutos);
		
		JLabel lblDeTelevisin = new JLabel("De televisi\u00F3n");
		lblDeTelevisin.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDeTelevisin.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblDeTelevisin.setBounds(119, 53, 109, 21);
		panel.add(lblDeTelevisin);
		
		televisiontxtField = new JTextField();
		televisiontxtField.setBounds(238, 53, 126, 20);
		panel.add(televisiontxtField);
		televisiontxtField.setColumns(10);
		
		JLabel lblEnHorarioCentral = new JLabel("En horario central");
		lblEnHorarioCentral.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblEnHorarioCentral.setBounds(438, 53, 135, 21);
		panel.add(lblEnHorarioCentral);
		
		hscentraltxtField = new JTextField();
		hscentraltxtField.setBounds(569, 53, 126, 20);
		panel.add(hscentraltxtField);
		hscentraltxtField.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCantidad.setBounds(46, 111, 123, 17);
		panel.add(lblCantidad);
		
		JLabel lblNotasEnDiarios = new JLabel("Notas en diarios");
		lblNotasEnDiarios.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNotasEnDiarios.setBounds(121, 139, 118, 14);
		panel.add(lblNotasEnDiarios);
		
		notasDiariostxtField = new JTextField();
		notasDiariostxtField.setBounds(239, 135, 126, 20);
		panel.add(notasDiariostxtField);
		notasDiariostxtField.setColumns(10);
		
		JLabel lblTapasDeRevista = new JLabel("Tapas de revista");
		lblTapasDeRevista.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblTapasDeRevista.setBounds(442, 139, 118, 13);
		panel.add(lblTapasDeRevista);
		
		tapasRevistatxtField = new JTextField();
		tapasRevistatxtField.setBounds(570, 134, 126, 20);
		panel.add(tapasRevistatxtField);
		tapasRevistatxtField.setColumns(10);
		
		JLabel lblApreciacin = new JLabel("Apreciaci\u00F3n");
		lblApreciacin.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblApreciacin.setBounds(46, 186, 89, 19);
		panel.add(lblApreciacin);
		
		JTextArea apreciaciontxtArea = new JTextArea();
		JScrollPane scrollpane = new JScrollPane(apreciaciontxtArea);
		scrollpane.setBounds(158, 188, 553, 156);
		panel.add(scrollpane);
		
		JButton btnCancelar = new JButton("Cancelar");
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
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(513, 355, 94, 23);
		btnAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Seguimiento seguimiento = new MediosTradicionales(0, (String)temacmbBox.getSelectedItem(), (String)operadorcmbBox.getSelectedItem(), Integer.parseInt(televisiontxtField.getText()), Integer.parseInt(hscentraltxtField.getText()), Integer.parseInt(notasDiariostxtField.getText()), Integer.parseInt(tapasRevistatxtField.getText()), (String)apreciaciontxtArea.getText());
				seguimientoDAO.agregarSeguimiento(seguimiento);
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				frame.setContentPane(new Consulta()); 
				frame.validate();
			}
		});
		panel.add(btnAceptar);


	}
}
