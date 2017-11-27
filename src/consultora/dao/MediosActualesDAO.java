package consultora.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import consultora.objects.MediosActuales;
import consultora.objects.Seguimiento;
import consultora.objects.Tema;


public class MediosActualesDAO {

	private Connection conn = null;
	private String url = "jdbc:mysql://127.0.0.1:3306/consultora?autoReconnect=true&useSSL=false";

	// Relevancia
	// Calculos
	
	public void agregarSeguimiento(MediosActuales seguimiento) {
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, "root", "admin");
			
			String query = " insert into medios_actuales (cod_tema, red_social, pub_apoyo, mg_apoyo, pub_rechazo, mg_rechazo, pub_neutral, mg_neutral, replicas)"
					+ " values (?, ?, ?, ?, ?, ?, ?)";
	
			PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
			preparedStmt.setString(1, seguimiento.getCodigo());
			preparedStmt.setString(2, seguimiento.getRedSocial());
			preparedStmt.setInt(3, seguimiento.getPublicacionesApoyo());
			preparedStmt.setInt(4, seguimiento.getMgPublicacionApoyo());
			preparedStmt.setInt(5, seguimiento.getPublicacionesRechazo());
			preparedStmt.setInt(6, seguimiento.getMgPublicacionRechazo());
			preparedStmt.setInt(7, seguimiento.getPublicacionesNeutrales());
			preparedStmt.setInt(8, seguimiento.getMgPublicacionNeutral());
			preparedStmt.setInt(9, seguimiento.getReplicas());
			
	
			preparedStmt.execute();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	
	public Seguimiento obtenerSeguimientoPorCodigo(Tema t) {
		
		Seguimiento seguimiento = null;
		MediosActuales seguimientoMA = (MediosActuales) seguimiento;
		Statement stmt = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, "root", "admin");
			stmt = (Statement) conn.createStatement();
			
			ResultSet rs;

			rs = stmt.executeQuery("Select * " 
					+ "from medios_actuales as S where S.cod_tema = '"+ t.getCodigo()+"'");
			while (rs.next()) {
				seguimientoMA = new MediosActuales(rs.getString("cod_tema"), rs.getString("red_social"), rs.getInt("pub_apoyo"), rs.getInt("mg_apoyo"), rs.getInt("pub_rechazo"), rs.getInt("mg_rechazo"), rs.getInt("pub_neutral"), rs.getInt("mg_neutral"), rs.getInt("replicas"));
			
			}
			conn.close();
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		t.setSeguimientoMA(seguimientoMA);
		return seguimientoMA;
	}
}

