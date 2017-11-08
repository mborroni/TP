import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

@SuppressWarnings("serial")

public class Detalle extends JSplitPane {

	// TEMA
	private JTextField codigoTema;
	private JTextField palabraClave;
	private JDateChooser fechaInicio;
	private JDateChooser fechaFin;
	private JTextArea descripcionTxtArea;
	
	// BUSQUEDA SEGUIMIENTOS
	private JTextField buscarTxtField;
	private JComboBox<String> operadorCmbBox;
	private static DefaultTableModel model;
	private JTable table;
	
	// SEGUIMIENTOS
	private JTextField televisiontxtField;
	private JTextField hscentraltxtField;
	private JTextField notasDiariostxtField;
	private JTextField tapasRevistatxtField;
	private JTextArea apreciaciontxtArea;
	
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JButton btnAplicar;
	
	//DAOS
	private OperadorDAO operadorDAO = new OperadorDAO();
	private SeguimientoDAO seguimientoDAO = new SeguimientoDAO();
	private Tema tema = null;
	
	public Detalle() { //Tema tema
		
		/*
		if(Consulta.isEditable() == true) {
			this.editable();
		}
		else {
			this.nonEditable();
		}
		*/
	
		
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
		lblCodigo.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblCodigo.setBounds(296, 11, 57, 20);
		barra.add(lblCodigo);

		codigoTema = new JTextField("123ABC");
		codigoTema.setBounds(352, 11, 142, 20);
		codigoTema.setFont(new Font("Calibri", Font.PLAIN, 20));
		codigoTema.setBorder(null);
		codigoTema.setBackground(new Color(69, 193, 100));
		barra.add(codigoTema);
		
		JLabel lblPalabraClave = new JLabel("Palabra Clave");
		lblPalabraClave.setBounds(27, 54, 104, 20);
		barra.add(lblPalabraClave);
		lblPalabraClave.setFont(new Font("Calibri", Font.PLAIN, 16));
		
		palabraClave = new JTextField(); //tema.getPalabraClave()
		palabraClave.setBounds(124, 53, 151, 21);
		palabraClave.setFont(new Font("Calibri", Font.PLAIN, 17));
		palabraClave.setBorder(null);
		palabraClave.setBackground(new Color(65, 182, 94));
		barra.add(palabraClave);
		
		JLabel lblDesde = new JLabel("Desde");
		lblDesde.setBounds(285, 54, 45, 20);
		lblDesde.setFont(new Font("Calibri", Font.PLAIN, 16));
		barra.add(lblDesde);

		fechaInicio = new JDateChooser(); //Date.valueOf(tema.getInicio()));
		//fechaInicio.setDate(tema.getInicio());
		fechaInicio.setBounds(573, 53, 151, 20);
		JTextFieldDateEditor editorInicio = (JTextFieldDateEditor) fechaInicio.getDateEditor();
		editorInicio.setBorder(null);
		editorInicio.setBackground(new Color(65, 182, 94));
		barra.add(fechaInicio);

		JLabel lblHasta = new JLabel("Hasta");
		lblHasta.setBounds(519, 54, 58, 20);
		lblHasta.setFont(new Font("Calibri", Font.PLAIN, 16));
		barra.add(lblHasta);

		fechaFin = new JDateChooser(); //Date.valueOf(tema.getFin()));
		fechaFin.setBounds(342, 54, 151, 20);
		JTextFieldDateEditor editorFin = (JTextFieldDateEditor) fechaFin.getDateEditor();
		editorFin.setBorder(null);
		editorFin.setBackground(new Color(65, 182, 94));
		barra.add(fechaFin);

		/*
		 * DETALLES 
		*/

		JPanel panel = new JPanel();
		panel.setBounds(0, 85, 750, 415);
		panel.setLayout(null);
		panel.setBackground(new Color(246, 246, 246));
		add(panel);
		
		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};

		table = new JTable(model);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setBackground(new Color(252, 252, 252));
		
		model.addColumn("Codigo seguimiento");
		model.addColumn("Operador");
		
		agregarSeguimientos(seguimientoDAO.obtenerSeguimientosPorCodigo(codigoTema.getText()));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(371, 38, 340, 326);
		scrollPane.setViewportBorder(null);
		scrollPane.getViewport().setBackground(new Color(252, 252, 252));;
		panel.add(scrollPane);
		
		buscarTxtField = new JTextField();
		buscarTxtField.setBounds(371, 9, 197, 20);
		panel.add(buscarTxtField);
		buscarTxtField.setColumns(10);
		
		operadorCmbBox = new JComboBox<String>();
		operadorCmbBox.setBounds(578, 9, 133, 20);
		operadorCmbBox.addItem("Todos");
		JComboBox<String> operadorcmbBox = new JComboBox<String>();
		for (String operadores : operadorDAO.listarOperadores()) {
			
			operadorcmbBox.addItem(operadores);
		}
		panel.add(operadorCmbBox);


		
		descripcionTxtArea = new JTextArea();
		JScrollPane scrollpane = new JScrollPane(descripcionTxtArea);
		scrollpane.setBounds(21, 38, 331, 42);;
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblDescripcion.setBounds(21, 11, 109, 14);
		panel.add(lblDescripcion);
		panel.add(scrollpane);
		
		
		
		JLabel lblPromedioMinutos = new JLabel("Promedio minutos");
		lblPromedioMinutos.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblPromedioMinutos.setBounds(20, 87, 150, 25);
		panel.add(lblPromedioMinutos);
		
		JLabel lblDeTelevisin = new JLabel("De televisi\u00F3n");
		lblDeTelevisin.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDeTelevisin.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblDeTelevisin.setBounds(42, 114, 109, 21);
		panel.add(lblDeTelevisin);
		
		televisiontxtField = new JTextField();
		televisiontxtField.setBounds(175, 115, 126, 20);
		panel.add(televisiontxtField);
		televisiontxtField.setColumns(10);
		
		JLabel lblEnHorarioCentral = new JLabel("En horario central");
		lblEnHorarioCentral.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblEnHorarioCentral.setBounds(42, 142, 126, 20);
		panel.add(lblEnHorarioCentral);
		
		hscentraltxtField = new JTextField();
		hscentraltxtField.setBounds(175, 142, 126, 20);
		panel.add(hscentraltxtField);
		hscentraltxtField.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCantidad.setBounds(24, 169, 123, 17);
		panel.add(lblCantidad);
		
		JLabel lblNotasEnDiarios = new JLabel("Notas en diarios");
		lblNotasEnDiarios.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNotasEnDiarios.setBounds(42, 195, 118, 14);
		panel.add(lblNotasEnDiarios);
		
		notasDiariostxtField = new JTextField();
		notasDiariostxtField.setBounds(175, 192, 126, 20);
		panel.add(notasDiariostxtField);
		notasDiariostxtField.setColumns(10);
		
		JLabel lblTapasDeRevista = new JLabel("Tapas de revista");
		lblTapasDeRevista.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblTapasDeRevista.setBounds(42, 223, 118, 14);
		panel.add(lblTapasDeRevista);
		
		tapasRevistatxtField = new JTextField();
		tapasRevistatxtField.setBounds(175, 220, 126, 20);
		panel.add(tapasRevistatxtField);
		tapasRevistatxtField.setColumns(10);
		
		JLabel lblApreciacin = new JLabel("Apreciaci\u00F3n");
		lblApreciacin.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblApreciacin.setBounds(21, 248, 89, 19);
		panel.add(lblApreciacin);
		
		apreciaciontxtArea = new JTextArea();
		JScrollPane scrollpane1 = new JScrollPane(apreciaciontxtArea);
		scrollpane1.setBounds(22, 271, 331, 93);
		panel.add(scrollpane1);
		
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
		
		btnAplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnAplicar.setBounds(413, 372, 89, 23);
		panel.add(btnAplicar);
		
		JToggleButton tglbtnEditar = new JToggleButton("Editar");
		tglbtnEditar.setBounds(151, 372, 67, 23);
		panel.add(tglbtnEditar);
		
	}

	public void nonEditable(){
		codigoTema.setEditable(false);
		palabraClave.setEnabled(false);
		fechaInicio.setEnabled(false);
		fechaFin.setEnabled(false);
		descripcionTxtArea.setEnabled(false);
		televisiontxtField.setEnabled(false);
		hscentraltxtField.setEnabled(false);
		notasDiariostxtField.setEnabled(false);
		tapasRevistatxtField.setEnabled(false);
		apreciaciontxtArea.setEnabled(false);
		btnAplicar.setEnabled(false);
	}
	
	public void editable(){
		codigoTema.setEditable(true);
		palabraClave.setEnabled(true);
		fechaInicio.setEnabled(true);
		fechaFin.setEnabled(true);
		descripcionTxtArea.setEnabled(true);
		televisiontxtField.setEnabled(true);
		hscentraltxtField.setEnabled(true);
		notasDiariostxtField.setEnabled(true);
		tapasRevistatxtField.setEnabled(true);
		apreciaciontxtArea.setEnabled(true);	
		btnAplicar.setEnabled(true);
	}
	
	public static void agregarSeguimientos(ArrayList<Seguimiento> seguimientos) {
		model.setRowCount(0);
		for (int i = 0; i < seguimientos.size(); i++) {
			Object[] v = { seguimientos.get(i).getCod_seguimiento(), seguimientos.get(i).getOperador()
					 };
			model.addRow(v);

		}
		
	}
}
