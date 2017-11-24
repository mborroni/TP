import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")

public class App extends JFrame {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					App frame = new App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public App() {

		setFont(new Font("Calibri", Font.PLAIN, 13));
		setTitle("Consultora");
		ImageIcon img = (new ImageIcon(this.getClass().getResource("/home.png")));
		setIconImage(img.getImage());
		setSize(750, 550);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new Consulta());
		validate();

		
		// Menu
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(null);
		menuBar.setBackground(new Color(69, 193, 100));

		Font f = (new Font("Calibri", Font.PLAIN, 14));
		// Color c = (new Color(85, 205, 115));
		UIManager.put("Menu.font", f);
		UIManager.put("MenuItem.font", f);

		setJMenuBar(menuBar);

		// Menu > Archivo
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);

		// > Nuevo
		JMenu mnNuevo = new JMenu("Nuevo");
		mnNuevo.setPreferredSize(new Dimension(100, mnNuevo.getPreferredSize().height));
		mnArchivo.add(mnNuevo);

		// >> Tema
		JMenuItem mntmTema = new JMenuItem("Tema");
		mnNuevo.add(mntmTema);

		mnNuevo.add(mntmTema);
		mntmTema.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setContentPane(new Crear()); // CrearTema
				validate();
			}
		});

		// >> Seguimiento
		JMenuItem mntmSeguimiento = new JMenuItem("Seguimiento");
		mnNuevo.add(mntmSeguimiento);

		mntmSeguimiento.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setContentPane(new CrearSeguimiento());
				validate();
			}
		});

		// Separador
		JSeparator separator = new JSeparator();
		mnArchivo.add(separator);

		// Salir
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnArchivo.add(mntmSalir);
		mntmSalir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				System.exit(1);
			}
		});

		// Menu > Consulta
		JMenu mnConsulta = new JMenu("Consultas");
		menuBar.add(mnConsulta);

		// Tema
		JMenuItem mntmTema_2 = new JMenuItem("Tema");
		mntmTema_2.setPreferredSize(new Dimension(100, mntmTema_2.getPreferredSize().height));
		mnConsulta.add(mntmTema_2);
		mntmTema_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setContentPane(new Consulta());
				validate();
			}
		});

		// Menu > Ayuda
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);

		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mntmAcercaDe.setPreferredSize(new Dimension(100, mntmAcercaDe.getPreferredSize().height));
		mnAyuda.add(mntmAcercaDe);
		mntmAcercaDe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				final JFrame popUp = new JFrame();
				popUp.setContentPane(new AcercaDe(popUp));

				JOptionPane.showMessageDialog(popUp,
						"Version: (4.5.2) \n(c) Copyright Consultora contributors and others 1999, 2017. \nAll rights reserved.",
						"Acerca de", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
}