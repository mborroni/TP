import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;



public class TemaDAO {

	private Connection conn = null;
	private String url = "jdbc:mysql://127.0.0.1:3306/consultora?autoReconnect=true&useSSL=false";
	private Statement stmt = null;

	public TemaDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, "root", "admin");
			stmt = (Statement) conn.createStatement();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 *  AGREGAR TEMA
	 */
	
	public void agregarTema(Tema tema) {

		try {

			String query = " INSERT INTO tema (cod_tema, palabra_clave, descripcion, fecha_inicio, fecha_fin)"
					+ " values (?, ?, ?, ?, ?)";

			PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
			preparedStmt.setString(1, tema.getCodigo());
			preparedStmt.setString(2, tema.getPalabraClave());
			preparedStmt.setString(3, tema.getDescripcion());
			preparedStmt.setObject(4, tema.getInicio());
			preparedStmt.setObject(5, tema.getFin());

			preparedStmt.execute();

			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	/*
	 *  OBTENER TEMAS
	 */

	public ArrayList<Tema> obtenerTemas() {

		ArrayList<Tema> temas = new ArrayList<>();
		try {

			ResultSet rs;
			rs = stmt.executeQuery("SELECT cod_tema, palabra_clave, fecha_inicio, fecha_fin, descripcion FROM tema");
			while (rs.next()) {
				Tema tema = new Tema(rs.getString("cod_tema"), rs.getString("palabra_clave"),
						rs.getDate("fecha_inicio"), rs.getDate("fecha_fin"), rs.getString("descripcion"));
				temas.add(tema);
			}
			

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e);

		}
		return temas;
	}
	
	/*
	 * LISTAR TEMAS POR PALABRA CLAVE
	 */
	
	public ArrayList<String> listarTemasPorPalabraClave() {
		
		ArrayList<String> temas = new ArrayList<String>();
		try{
			ResultSet rs;
			rs = stmt.executeQuery("SELECT palabra_clave FROM tema");
			while (rs.next()) {
				String codigo = (rs.getString("palabra_clave"));
				temas.add(codigo);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return temas;
	}
	
	/*
	 * LISTAR TEMAS POR CODIGO
	 */
	
	public ArrayList<String> listarTemasPorCodigo() {
		
		ArrayList<String> temas = new ArrayList<String>();
		try{
			ResultSet rs;
			rs = stmt.executeQuery("SELECT cod_tema FROM tema");
			while (rs.next()) {
				String codigo = (rs.getString("cod_tema"));
				temas.add(codigo);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return temas;
	}
	
	/*
	 * BUSCAR TEMA POR PALABRA CLAVE
	 */
	
	public ArrayList<Tema> buscarTema(String texto) {
		
		ArrayList<Tema> temas = new ArrayList<Tema>();
		try {
			ResultSet rs;
			rs = stmt.executeQuery("SELECT * FROM tema WHERE palabra_clave like'"
							+ texto + "%'");
			while (rs.next()) {
				Tema tema = new Tema(rs.getString("cod_tema"), rs.getString("palabra_clave"),
						rs.getDate("fecha_inicio"), rs.getDate("fecha_fin"), rs.getString("descripcion"));
				temas.add(tema);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return temas;
	}
	
	/*
	 * OBTENER TEMA POR CODIGO
	 */
	
	public Tema obtenerTemaPorCodigo(String codigo) {
		
		Tema tema = null;
		try {
			ResultSet rs;
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM tema WHERE cod_tema like ?");
			ps.setString(1, codigo + "%");
			rs = ps.executeQuery();
					//stmt.executeQuery("SELECT * FROM tema WHERE cod_tema like '"+ codigo + "%'");
			while (rs.next()) {
				tema = new Tema(rs.getString("cod_tema"), rs.getString("palabra_clave"),
						rs.getDate("fecha_inicio"), rs.getDate("fecha_fin"), rs.getString("descripcion"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
		return tema;
	}
	
	
	/*
	 * ELIMINAR TEMA POR CODIGO
	 */
	
	public void eliminarTemaPorCodigo(String codigo){
	
		try {
			PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement("DELETE FROM tema WHERE cod_tema = '" + codigo + "'");
			preparedStmt.execute();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}	
	}


	/*
	 * UPDATE TEMA
	 */

	
	
	
	
	

	/*
	  					dao.eliminarTemaPorID(
							dao.obtenerTemaPorID(table.getValueAt(table.getSelectedRow(), 0).toString()).getID());
					cargarTabla(dao.obtenerTemas());
	 */
	


}
