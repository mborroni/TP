import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JComponent;

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
	
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JButton btnAplicar;
	
	//DAOS
	private TemaDAO temaDAO = new TemaDAO();
	private OperadorDAO operadorDAO = new OperadorDAO();
	private SeguimientoDAO seguimientoDAO = new MediosTradicionalesDAO();
	
	public Detalle(Tema temaSelect) { // PASAR OBJETO TEMA¿
		
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

		codigoTema = new JTextField("FUNCIONA");
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
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
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
		
		JLabel lblSeguimiento = new JLabel("Seguimiento");
		lblSeguimiento.setBounds(29, 77, 109, 20);
		panel.add(lblSeguimiento);
		panel.add(operadorCmbBox);
		
		JLabel lblPalabraClave = new JLabel("Palabra Clave");
		lblPalabraClave.setBounds(29, 38, 104, 20);
		lblPalabraClave.setFont(new Font("Calibri", Font.PLAIN, 18));
		panel.add(lblPalabraClave);
		
		palabraClave = new JTextField();
		palabraClave.setBounds(136, 38, 151, 21);
		palabraClave.setFont(new Font("Calibri", Font.PLAIN, 17));
		panel.add(palabraClave);

		JLabel lblDesde = new JLabel("Desde");
		lblDesde.setBounds(58, 116, 45, 20);
		panel.add(lblDesde);
		lblDesde.setFont(new Font("Calibri", Font.PLAIN, 16));
		
		fechaInicio = new JDateChooser();
		fechaInicio.setBounds(136, 116, 151, 20);
		panel.add(fechaInicio);

		JLabel lblHasta = new JLabel("Hasta");
		lblHasta.setBounds(58, 159, 58, 20);
		panel.add(lblHasta);
		lblHasta.setFont(new Font("Calibri", Font.PLAIN, 16));
		
		fechaFin = new JDateChooser();
		fechaFin.setBounds(136, 159, 151, 20);
		panel.add(fechaFin);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblDescripcion.setBounds(29, 198, 109, 14);
		panel.add(lblDescripcion);
		
		descripcionTxtArea = new JTextArea();
		JScrollPane scrollpane = new JScrollPane(descripcionTxtArea);
		scrollpane.setBounds(29, 223, 316, 111);;
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
		btnAplicar.setBounds(413, 372, 89, 23);
		panel.add(btnAplicar);
		lblSeguimiento.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		JToggleButton tglbtnEditar = new JToggleButton("Editar");
		tglbtnEditar.setBounds(149, 345, 67, 23);
		panel.add(tglbtnEditar);
		

		
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
