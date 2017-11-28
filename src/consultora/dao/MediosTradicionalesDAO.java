package consultora.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import consultora.objects.MediosTradicionales;
import consultora.objects.Seguimiento;

public class MediosTradicionalesDAO extends SeguimientoDAO{
	
	private Connection conn = null;
	private String url = "jdbc:mysql://127.0.0.1:3306/consultora?autoReconnect=true&useSSL=false";
	
	public MediosTradicionalesDAO() {}
	
	public void agregarSeguimiento(Seguimiento seguimiento) {

		MediosTradicionales seguimientoMT = (MediosTradicionales) seguimiento; // cast variable
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, "root", "admin");
			stmt = (Statement) conn.createStatement();
			
			int id_operador = 0;
			String query = " insert into medios_tradicionales (cod_tema, id_operador, mintv, mincentral, cant_notas, cant_tapas, apreciacion)"
					+ " values (?, ?, ?, ?, ?, ?, ?)";

			ResultSet rs = stmt.executeQuery ("SELECT id_operador FROM operador WHERE apellido LIKE '" 
					+seguimientoMT.getOperador() + "'");
			while (rs.next()){
				id_operador = rs.getInt("id_operador");	
			}
			PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
			preparedStmt.setString(1, seguimiento.getCodigo());
			preparedStmt.setInt(2, id_operador);
			preparedStmt.setInt(3, seguimientoMT.getMinsTelevision());
			preparedStmt.setInt(4, seguimientoMT.getMinsHorarioCentral());
			preparedStmt.setInt(5, seguimientoMT.getCantNotasDiarios());
			preparedStmt.setInt(6, seguimientoMT.getCantTapasRevistas());
			preparedStmt.setString(7, seguimientoMT.getApreciacion());

			preparedStmt.execute();
			conn.close();
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Seguimiento obtenerSeguimientoPorCodigo(String codigo) {
		
		Seguimiento seguimiento = new MediosTradicionales(null, null, 0, 0, 0, 0, null);
		//MediosTradicionales seguimientoMT = (MediosTradicionales) seguimiento;

		Statement stmt = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, "root", "admin");
			stmt = (Statement) conn.createStatement();
			
			ResultSet rs;

			rs = stmt.executeQuery("Select * " 
					+ "from medios_tradicionales as S inner join operador as O on (S.id_operador = O.id_operador) where S.cod_tema = '"+ codigo +"'");
			while (rs.next()) {
				seguimiento = new MediosTradicionales(rs.getString("cod_tema"), rs.getString("apellido"), rs.getInt("mintv"), rs.getInt("mincentral"), rs.getInt("cant_notas"), rs.getInt("cant_tapas"), rs.getString("apreciacion"));
			
			}
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return seguimiento;
	}

	/*
	 * UPDATE TEMA
	 */

	public void actualizarSeguimiento (MediosTradicionales mt) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, "root", "admin");

			PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement("UPDATE medios_tradicionales SET apellido = ?, "
					+ "mintv= ?, mincentral= ?, cant_notas = ?, cant_tapas = ?, apreciacion = ? WHERE cod_tema = '" + mt.getCodigo() + "'");
			preparedStmt.setString(1, mt.getOperador());
			preparedStmt.setInt(2, mt.getMinsTelevision());
			preparedStmt.setInt(3, mt.getMinsHorarioCentral());
			preparedStmt.setInt(4, mt.getCantNotasDiarios());
			preparedStmt.setInt(5, mt.getCantTapasRevistas());
			preparedStmt.setString(6, mt.getApreciacion());			

			preparedStmt.execute();
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
	}
}
