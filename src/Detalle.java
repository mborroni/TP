import java.awt.Color;
import java.awt.Font;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

@SuppressWarnings("serial")

public class Detalle extends JSplitPane {

	private JTextField codigoTema;
	private JTextField palabraClave;
	private JDateChooser fechaInicio;
	private JDateChooser fechaFin;
	private static DefaultTableModel model;
	private JTable table;
	private TemaDAO temaDAO = new TemaDAO();
	private SeguimientoDAO seguimientoDAO = new SeguimientoDAO();
	private Tema tema = new Tema("123A", "Morsa", null, null, "ABC");

	public Detalle(Tema tema) {
		
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

		codigoTema = new JTextField(tema.getCodigo());
		codigoTema.setBounds(352, 11, 142, 20);
		codigoTema.setFont(new Font("Calibri", Font.PLAIN, 20));
		codigoTema.setBorder(null);
		codigoTema.setBackground(new Color(69, 193, 100));
		codigoTema.setEnabled(false);
		barra.add(codigoTema);
		
		JLabel lblPalabraClave = new JLabel("Palabra Clave");
		lblPalabraClave.setBounds(27, 54, 104, 20);
		barra.add(lblPalabraClave);
		lblPalabraClave.setFont(new Font("Calibri", Font.PLAIN, 16));
		
		palabraClave = new JTextField(tema.getPalabraClave());
		palabraClave.setBounds(124, 53, 151, 21);
		palabraClave.setFont(new Font("Calibri", Font.PLAIN, 17));
		palabraClave.setBorder(null);
		palabraClave.setBackground(new Color(65, 182, 94));
		palabraClave.setEnabled(false);
		barra.add(palabraClave);
		
		JLabel lblDesde = new JLabel("Desde");
		lblDesde.setBounds(285, 54, 45, 20);
		lblDesde.setFont(new Font("Calibri", Font.PLAIN, 16));
		barra.add(lblDesde);

		fechaInicio = new JDateChooser(); //Date.valueOf(tema.getInicio()));
		fechaInicio.setDate(tema.getInicio());
		fechaInicio.setBounds(573, 53, 151, 20);
		JTextFieldDateEditor editorInicio = (JTextFieldDateEditor) fechaInicio.getDateEditor();
		editorInicio.setBorder(null);
		editorInicio.setBackground(new Color(65, 182, 94));
		fechaInicio.setEnabled(false);
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
		fechaFin.setEnabled(false);
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
		table.getTableHeader().setBackground(new Color(252, 252, 252));
		
		model.addColumn("Codigo tema");
		model.addColumn("Palabra clave");
		model.addColumn("Inicio");
		model.addColumn("Fin");
		
		//agregarSeguimientos(seguimientoDAO.obtenerSeguimientos());
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(180, 10, 537, 382);
		scrollPane.setViewportBorder(null);
		scrollPane.getViewport().setBackground(new Color(252, 252, 252));;

		panel.add(scrollPane);
	}
/*
	public static void agregarSeguimientos(ArrayList<Seguimiento> seguimientos) {
		model.setRowCount(0);
		for (int i = 0; i < seguimientos.size(); i++) {
			Object[] v = { seguimientos.get(i).getCodigo(), seguimientos.get(i).getPalabraClave(),
					seguimientos.get(i).getInicio(), seguimientos.get(i).getFin()
					 };
			model.addRow(v);
	
		}
		
	}*/


}
