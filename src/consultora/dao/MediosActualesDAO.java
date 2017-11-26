package consultora.dao;




import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import consultora.objects.MediosActuales;


public class MediosActualesDAO {

	private Connection conn = null;
	private String url = "jdbc:mysql://127.0.0.1:3306/consultora?autoReconnect=true&useSSL=false";


	// Relevancia
	// Calculos
	
	public void agregarSeguimiento(MediosActuales seguimiento) {
	
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, "root", "admin");
			stmt = (Statement) conn.createStatement();
			
			int id_operador = 0;
			String query = " insert into redes_sociales (cod_tema, id_operador, red_social, pub_apoyo, pub_rechazo, pub_neutral, replicas, mg)"
					+ " values (?, ?, ?, ?, ?, ?, ?)";
	
			ResultSet rs = stmt.executeQuery ("SELECT id_operador FROM operador WHERE apellido LIKE '" 
					+ seguimiento.getOperador() + "'");
			while (rs.next()){
				id_operador = rs.getInt("id_operador");	
			}
			PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
			preparedStmt.setString(1, seguimiento.getCodigo());
			preparedStmt.setInt(2, id_operador);
			preparedStmt.setString(3, seguimiento.getRedSocial());
			preparedStmt.setInt(4, seguimiento.getPublicacionesApoyo());
			preparedStmt.setInt(5, seguimiento.getPublicacionesRechazo());
			preparedStmt.setInt(6, seguimiento.getPublicacionesNeutrales());
			preparedStmt.setInt(8, seguimiento.getReplicas());
			preparedStmt.setInt(9, seguimiento.getMg());
	
			preparedStmt.execute();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, e);
			}
		}
}

