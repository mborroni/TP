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
	
	public Detalle(Tema temaSelect) { // ¿
		
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
		panel.setBounds(0, 85, 750, 415);
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
		lblMediosActuales.setBounds(413, 13, 128, 16);
		lblMediosActuales.setFont(new Font("Calibri", Font.PLAIN, 18));
		panel.add(lblMediosActuales);
		
		JTextArea MediosActualesArea = new JTextArea();
		MediosActualesArea.setBounds(398, 37, 224, 105);   //ACA HAY Q COMPLETAR CON UN "temaSelect de medio actual"
		MediosActualesArea.setEditable(false);
		panel.add(MediosActualesArea);
		
		
		
		JLabel lblMediosTradicionales = new JLabel("Medios Tradicionales");
		lblMediosTradicionales.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblMediosTradicionales.setBounds(413, 185, 178, 16);
		panel.add(lblMediosTradicionales);
		
		JTextArea MediosTradiionalesArea = new JTextArea();
		MediosTradiionalesArea.setBounds(398, 214, 224, 120);  //ACA HAY Q COMPLETAR CON UN "temaSelect de medio tradicional"
		MediosTradiionalesArea.setEditable(false);
		panel.add(MediosTradiionalesArea);
		
		
		
		
		
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
