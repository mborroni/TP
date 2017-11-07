import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class SeguimientoDAO {

	private Connection conn = null;
	private String url = "jdbc:mysql://127.0.0.1:3306/consultora?autoReconnect=true&useSSL=false";
	private Statement stmt = null;

	public SeguimientoDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, "root", "admin");
			stmt = (Statement) conn.createStatement();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void agregarSeguimiento(Seguimiento seguimiento) {

		try {
			int id_operador = 0;
			String query = " insert into seguimiento (cod_tema, id_operador, mintv, mincentral, cant_notas, cant_tapas, apreciacion)"
					+ " values (?, ?, ?, ?, ?, ?, ?)";

			ResultSet rs = stmt.executeQuery ("SELECT id_operador FROM operador WHERE apellido LIKE '" 
					+ seguimiento.getOperador() + "'");
			while (rs.next()){
				id_operador = rs.getInt("id_operador");	
			}
			PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
			preparedStmt.setString(1, seguimiento.getCodigo());
			preparedStmt.setInt(2, id_operador);
			preparedStmt.setInt(3, seguimiento.getMinsTelevion());
			preparedStmt.setInt(4, seguimiento.getMinsHorarioCentral());
			preparedStmt.setInt(5, seguimiento.getCantNotasDiarios());
			preparedStmt.setInt(6, seguimiento.getCantTapasRevistas());
			preparedStmt.setString(7, seguimiento.getApreciacion());

			preparedStmt.execute();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
}
