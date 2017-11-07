import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

@SuppressWarnings("serial")

public class Detalle extends JSplitPane {

	private TemaDAO temaDAO = new TemaDAO();
	private Tema tema1 = null;
	
	public Detalle(JFrame marco, Tema tema) {
		
		this.tema1 = tema;
		
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

		JLabel lblTema = new JLabel("");
		lblTema.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblTema.setBounds(46, 56, 66, 14);
		lblTema.setText(tema1.getCodigo());
		barra.add(lblTema);

		JLabel lblPalabraClave = new JLabel("");
		lblPalabraClave.setBounds(148, 53, 273, 20);
		lblPalabraClave.setText(tema1.getPalabraClave());
		barra.add(lblPalabraClave);

		JLabel lblOperador = new JLabel("Operador");
		lblOperador.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblOperador.setBounds(465, 53, 66, 21);
		barra.add(lblOperador);


		// Seguimiento

		JPanel panel = new JPanel();
		panel.setBounds(0, 85, 750, 415);
		panel.setLayout(null);
		panel.setBackground(new Color(246, 246, 246));
		add(panel);
	}


}
