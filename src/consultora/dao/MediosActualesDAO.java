package consultora.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import consultora.objects.MediosActuales;
import consultora.objects.MediosTradicionales;
import consultora.objects.Seguimiento;


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
			String query = " insert into medios_actuales (cod_tema, id_operador, red_social, pub_apoyo, mg_apoyo, pub_rechazo, mg_rechazo, pub_neutral, mg_neutral, replicas)"
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
			
	
			preparedStmt.execute();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, e);
			}
		}
	
	public ArrayList<Seguimiento> buscarSeguimiento(String texto) {
		
		ArrayList<Seguimiento> seguimientos = new ArrayList<>();
		Statement stmt = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, "root", "admin");
			stmt = (Statement) conn.createStatement();
			
			ResultSet rs;
			rs = stmt.executeQuery("SELECT S., S.cod_tema, O.apellido, S.mintv, S.mincentral, S.cant_notas, S.cant_tapas, S.apreciacion FROM medios_tradicionales AS S"
					+ "INNER JOIN operador AS S ON (S.id_operador = O.id_operador");
			while(rs.next()){
				Seguimiento seguimiento = new MediosTradicionales(rs.getString("cod_tema"), rs.getString("apellido"), rs.getInt("mintv"), rs.getInt("mincentral"), rs.getInt("cant_notas"), rs.getInt("cant_tapas"), rs.getString("apreciacion"));
				seguimientos.add(seguimiento);
			}
			conn.close();
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
		
		return seguimientos;
	}
	
	public Seguimiento obtenerSeguimientoPorCodigo(String codigo) {
		
		Seguimiento seguimiento = null;
		MediosActuales seguimientoMT = (MediosActuales) seguimiento;
		Statement stmt = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, "root", "admin");
			stmt = (Statement) conn.createStatement();
			
			ResultSet rs;

			rs = stmt.executeQuery("Select * " 
					+ "from medios_actuales as S inner join operador as O on (S.id_operador = O.id_operador) where S.cod_tema = '"+ codigo +"'");
			while (rs.next()) {
				seguimientoMT = new MediosActuales(rs.getString("cod_tema"), rs.getString("red_social"), rs.getInt("pub_apoyo"), rs.getInt("mg_apoyo"), rs.getInt("pub_rechazo"), rs.getInt("mg_rechazo"), rs.getInt("pub_neutral"), rs.getInt("mg_neutral"), rs.getInt("replicas"));
			
			}
			conn.close();
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
		
		return seguimientoMT;
	}
}

