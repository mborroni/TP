package consultora.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import consultora.objects.MediosActuales;
import consultora.objects.MediosTradicionales;
import consultora.objects.Tema;

public class TemaDAO {

	private Connection conn = null;
	private String url = "jdbc:mysql://127.0.0.1:3306/consultora?autoReconnect=true&useSSL=false";

	private MediosTradicionalesDAO mtDAO = new MediosTradicionalesDAO();
	private MediosActualesDAO maDAO = new MediosActualesDAO();

	public TemaDAO() {
	}

	/*
	 * AGREGAR TEMA
	 */

	public void agregarTema(Tema tema) {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, "root", "admin");

			String query = " INSERT INTO tema (cod_tema, palabra_clave, descripcion, fecha_inicio, fecha_fin)"
					+ " values (?, ?, ?, ?, ?)";

			PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
			preparedStmt.setString(1, tema.getCodigo());
			preparedStmt.setString(2, tema.getPalabraClave());
			preparedStmt.setString(3, tema.getDescripcion());
			preparedStmt.setObject(4, tema.getInicio());
			preparedStmt.setObject(5, tema.getFin());

			preparedStmt.execute();
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
	}

	/*
	 * OBTENER TEMAS
	 */

	public ArrayList<Tema> obtenerTemas() {

		Statement stmt = null;
		ArrayList<Tema> temas = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, "root", "admin");
			stmt = (Statement) conn.createStatement();

			ResultSet rs;
			rs = stmt.executeQuery("SELECT cod_tema, palabra_clave, fecha_inicio, fecha_fin, descripcion FROM tema");
			while (rs.next()) {

				MediosTradicionales mt = (MediosTradicionales) mtDAO.obtenerSeguimientoPorCodigo(rs.getString("cod_tema"));
				 MediosActuales ma = (MediosActuales) maDAO.obtenerSeguimientoPorCodigo(rs.getString("cod_tema"));				
				 Tema tema = new Tema(rs.getString("cod_tema"), rs.getString("palabra_clave"), rs.getDate("fecha_inicio"), 
						 rs.getDate("fecha_fin"), rs.getString("descripcion"), mt, ma); 
				 temas.add(tema);
			}
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
		return temas;
	}

	/*
	 * LISTAR TEMAS POR PALABRA CLAVE
	 */

	public ArrayList<String> listarTemasPorPalabraClave() {

		Statement stmt = null;
		ArrayList<String> temas = new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, "root", "admin");
			stmt = (Statement) conn.createStatement();

			ResultSet rs;
			rs = stmt.executeQuery("SELECT palabra_clave FROM tema");
			while (rs.next()) {
				String codigo = (rs.getString("palabra_clave"));
				temas.add(codigo);
			}
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
		return temas;
	}

	/*
	 * LISTAR TEMAS POR CODIGO
	 */

	public ArrayList<String> listarTemasPorCodigo() {

		Statement stmt = null;
		ArrayList<String> temas = new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, "root", "admin");
			stmt = (Statement) conn.createStatement();

			ResultSet rs;
			rs = stmt.executeQuery("SELECT cod_tema FROM tema");
			while (rs.next()) {
				String codigo = (rs.getString("cod_tema"));
				temas.add(codigo);
			}
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
		return temas;
	}

	/*
	 * BUSCAR TEMA POR PALABRA CLAVE
	 */

	public ArrayList<Tema> buscarTema(String texto) {

		MediosTradicionales mt = (MediosTradicionales) mtDAO.obtenerSeguimientoPorCodigo(texto);
		MediosActuales ma = (MediosActuales) maDAO.obtenerSeguimientoPorCodigo(texto);
		Statement stmt = null;
		ArrayList<Tema> temas = new ArrayList<Tema>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, "root", "admin");
			stmt = (Statement) conn.createStatement();

			ResultSet rs;
			rs = stmt.executeQuery("SELECT * FROM tema WHERE palabra_clave like'" + texto + "%'");
			while (rs.next()) {
				Tema tema = new Tema(rs.getString("cod_tema"), rs.getString("palabra_clave"),
						rs.getDate("fecha_inicio"), rs.getDate("fecha_fin"), rs.getString("descripcion"), mt, ma);
				temas.add(tema);
			}
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return temas;
	}

	/*
	 * OBTENER TEMA POR CODIGO
	 */

	public Tema obtenerTemaPorCodigo(String codigo) {

		MediosTradicionales mt = (MediosTradicionales) mtDAO.obtenerSeguimientoPorCodigo(codigo);
		MediosActuales ma = (MediosActuales) maDAO.obtenerSeguimientoPorCodigo(codigo);
		Tema tema = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, "root", "admin");

			ResultSet rs;
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM tema WHERE cod_tema like ?");
			ps.setString(1, codigo + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				tema = new Tema(rs.getString("cod_tema"), rs.getString("palabra_clave"), rs.getDate("fecha_inicio"),
						rs.getDate("fecha_fin"), rs.getString("descripcion"), mt, ma);
			}
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
		return tema;
	}

	/*
	 * ELIMINAR TEMA POR CODIGO
	 */

	public void eliminarTemaPorCodigo(String codigo) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, "root", "admin");

			PreparedStatement preparedStmt = (PreparedStatement) conn
					.prepareStatement("DELETE FROM tema WHERE cod_tema = '" + codigo + "'");
			preparedStmt.execute();
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}

	}

	/*
	 * UPDATE TEMA
	 */

}
