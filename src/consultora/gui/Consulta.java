package src.consultora.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import consultora.TextPrompt;
import src.consultora.dao.TemaDAO;
import src.consultora.objects.Tema;

@SuppressWarnings("serial")

public class Consulta extends JSplitPane {

	// CONSULTA
	private JTextField busquedaTxtFld;
	private JButton imagebutton;
	private JLabel lblConsultas;
	private JLabel lblFiltrar;
	private JComboBox<String> filtrarCmbBox;
	private JButton btnCrearTema;
	private JButton btnCrearSeguimiento;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnDetalle;

	// JTABLE
	private static DefaultTableModel model;
	private JTable table;

	// DAOS
	private TemaDAO temaDAO = new TemaDAO();

	public Consulta() {

		setLayout(null);

		// Barra

		JPanel barra = new JPanel();
		barra.setLocation(0, 0);
		barra.setSize(764, 85);
		barra.setLayout(null);
		barra.setBackground(new Color(69, 193, 100));
		add(barra);

		busquedaTxtFld = new JTextField();
		busquedaTxtFld.setBounds(181, 28, 507, 29);
		busquedaTxtFld.setColumns(10);
		busquedaTxtFld.setBorder(null);
		busquedaTxtFld.setBackground(new Color(65, 182, 94));
		busquedaTxtFld.setFont(new Font("Calibri", Font.PLAIN, 14));
		TextPrompt placeholder = new TextPrompt(" Buscar por palabra clave", busquedaTxtFld);
		placeholder.changeAlpha(0.75f);
		placeholder.changeStyle(Font.ITALIC);
		busquedaTxtFld.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				ArrayList<Tema> resultado = new ArrayList<Tema>();
				if (busquedaTxtFld.getText() == "") {
					agregarTemas(temaDAO.obtenerTemas());
				} else {
					resultado.addAll(temaDAO.buscarTema(busquedaTxtFld.getText()));
					agregarTemas(resultado);
				}
			}
		});
		barra.add(busquedaTxtFld);

		imagebutton = new JButton();
		imagebutton.setIcon(new ImageIcon(this.getClass().getResource("/images/searcher1.png")));
		imagebutton.setBounds(687, 28, 31, 29);
		imagebutton.setBorder(new EmptyBorder(0, 0, 0, 0));
		imagebutton.setBackground(new Color(65, 182, 94));
		imagebutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ArrayList<Tema> resultado = new ArrayList<Tema>();
				resultado.addAll(temaDAO.buscarTema(busquedaTxtFld.getText()));
				agregarTemas(resultado);

			}
		});
		barra.add(imagebutton);

		lblConsultas = new JLabel("Consultas");
		lblConsultas.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultas.setBounds(20, 28, 117, 29);
		lblConsultas.setFont(new Font("Calibri", Font.PLAIN, 20));
		barra.add(lblConsultas);

		// JTable

		JPanel panel = new JPanel();
		panel.setBounds(0, 85, 764, 421);
		panel.setBackground(new Color(246, 246, 246));
		panel.setLayout(null);
		add(panel);

		model = new DefaultTableModel() {
		
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};

		table = new JTable(model);
		table.getTableHeader().setBackground(new Color(252, 252, 252));
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		
		model.addColumn("Codigo tema");
		model.addColumn("Palabra clave");
		model.addColumn("Inicio");
		model.addColumn("Fin");
		
		agregarTemas(temaDAO.obtenerTemas());

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(180, 10, 537, 382);
		scrollPane.setViewportBorder(null);
		scrollPane.getViewport().setBackground(new Color(252, 252, 252));
		panel.add(scrollPane);

		table.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent mouseEvent) {

				Point point = mouseEvent.getPoint();

				if (mouseEvent.getClickCount() == 2) {

					Tema temaSelect = temaDAO
							.obtenerTemaPorCodigo(table.getValueAt(table.rowAtPoint(point), 0).toString());
					JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) mouseEvent.getSource());
					frame.setContentPane(new ModificarTema(temaSelect));
					frame.validate();
				}
			}
		});

		lblFiltrar = new JLabel("Filtrar");
		lblFiltrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFiltrar.setBounds(20, 18, 46, 14);
		panel.add(lblFiltrar);

		filtrarCmbBox = new JComboBox<String>();
		filtrarCmbBox.addItem("");
		for (String filtro : temaDAO.listarTemasPorPalabraClave()) {
			filtrarCmbBox.addItem(filtro);
		}
		filtrarCmbBox.setBounds(20, 43, 144, 20);
		filtrarCmbBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ArrayList<Tema> resultado = new ArrayList<Tema>();
				if (filtrarCmbBox.getSelectedItem().toString() == "") {
					agregarTemas(temaDAO.obtenerTemas());
				} else {
					resultado.addAll(temaDAO.buscarTema(filtrarCmbBox.getSelectedItem().toString()));
					agregarTemas(resultado);
				}
			}
		});
		panel.add(filtrarCmbBox);

		btnCrearTema = new JButton("Añadir tema");
		btnCrearTema.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrearTema.setBounds(3, 77, 154, 33);
		btnCrearTema.setIcon(new ImageIcon(this.getClass().getResource("/images/NuevoTema.png")));
		btnCrearTema.setOpaque(false);
		btnCrearTema.setContentAreaFilled(false);
		btnCrearTema.setBorderPainted(false);
		btnCrearTema.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				frame.setContentPane(new CrearTema());
				frame.validate();
			}
		});
		panel.add(btnCrearTema);

		btnCrearSeguimiento = new JButton("Añadir seguimiento");
		btnCrearSeguimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCrearSeguimiento.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrearSeguimiento.setBounds(0, 126, 181, 33);
		btnCrearSeguimiento.setIcon(new ImageIcon(this.getClass().getResource("/images/NuevoSeguimiento.png")));
		btnCrearSeguimiento.setOpaque(false);
		btnCrearSeguimiento.setContentAreaFilled(false);
		btnCrearSeguimiento.setBorderPainted(false);
		btnCrearSeguimiento.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				frame.setContentPane(new CrearSeguimiento());
				frame.validate();
			}
		});
		panel.add(btnCrearSeguimiento);

		btnModificar = new JButton("Modificar seg.");
		btnModificar.setHorizontalAlignment(SwingConstants.LEFT);
		btnModificar.setBounds(3, 170, 157, 33);
		btnModificar.setIcon(new ImageIcon(this.getClass().getResource("/images/Modificar.png")));
		btnModificar.setOpaque(false);
		btnModificar.setContentAreaFilled(false);
		btnModificar.setBorderPainted(false);
		btnModificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (table.getSelectedRow() != -1) {

					Tema temaSelect = temaDAO
							.obtenerTemaPorCodigo(table.getValueAt(table.getSelectedRow(), 0).toString());

					if (temaSelect.getSeguimientoMT() != null) {
						JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) arg0.getSource());
						frame.setContentPane(new ModificarSeguimiento(temaSelect));
						frame.validate();
					}
					else {
						JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(btnDetalle),
								"Este tema no tiene ningún seguimiento cargado.", "Error", JOptionPane.ERROR_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(btnDetalle),
							"No seleccionó ningún tema.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		panel.add(btnModificar);

		btnEliminar = new JButton("Eliminar tema");
		btnEliminar.setHorizontalAlignment(SwingConstants.LEFT);
		btnEliminar.setBounds(0, 212, 155, 33);
		btnEliminar.setIcon(new ImageIcon(this.getClass().getResource("/images/Eliminar.png")));
		btnEliminar.setOpaque(false);
		btnEliminar.setContentAreaFilled(false);
		btnEliminar.setBorderPainted(false);
		btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// check for selected row first
				try {
					int m = JOptionPane.showConfirmDialog(SwingUtilities.getWindowAncestor(btnEliminar),
							"¿Desea eliminar el tema " + table.getValueAt(table.getSelectedRow(), 0) + "?", "Eliminar",
							JOptionPane.YES_NO_OPTION);
					if (m == JOptionPane.YES_OPTION && table.getSelectedRow() != -1) {
						// model.removeRow(table.getSelectedRow());
						temaDAO.eliminarTemaPorCodigo(table.getValueAt(table.getSelectedRow(), 0).toString());
						agregarTemas(temaDAO.obtenerTemas());
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "No seleccionó ningun tema.");
				}
			}
		});

		panel.add(btnEliminar);

		btnDetalle = new JButton("Detalles");
		btnDetalle.setHorizontalAlignment(SwingConstants.LEFT);
		btnDetalle.setBounds(3, 256, 155, 33);
		btnDetalle.setIcon(new ImageIcon(this.getClass().getResource("/more.png")));
		btnDetalle.setOpaque(false);
		btnDetalle.setContentAreaFilled(false);
		btnDetalle.setBorderPainted(false);
		btnDetalle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (table.getSelectedRow() != -1) {

					Tema temaSelect = temaDAO
							.obtenerTemaPorCodigo(table.getValueAt(table.getSelectedRow(), 0).toString());
					JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) arg0.getSource());
					frame.setContentPane(new Detalle(temaSelect));
					frame.validate();

				} else {
					JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(btnDetalle),
							"No seleccionó ningún tema.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		panel.add(btnDetalle);
	}

	public static void agregarTemas(ArrayList<Tema> temas) {

		model.setRowCount(0);
		for (int i = 0; i < temas.size(); i++) {
			Object[] v = { temas.get(i).getCodigo(), temas.get(i).getPalabraClave(), temas.get(i).getInicio(),
					temas.get(i).getFin() };
			model.addRow(v);
			

		}
	}

}
