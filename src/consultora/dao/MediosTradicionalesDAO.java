package consultora.dao;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
			preparedStmt.setInt(3, seguimientoMT.getMinsTelevision());
			preparedStmt.setInt(4, seguimientoMT.getMinsHorarioCentral());
			preparedStmt.setInt(5, seguimientoMT.getCantNotasDiarios());
			preparedStmt.setInt(6, seguimientoMT.getCantTapasRevistas());
			preparedStmt.setString(7, seguimientoMT.getApreciacion());

			preparedStmt.execute();
			conn.close();
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public ArrayList<Seguimiento> buscarSeguimientos(String texto) {
		
		ArrayList<Seguimiento> seguimientos = new ArrayList<>();
		Statement stmt = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, "root", "admin");
			stmt = (Statement) conn.createStatement();
			
			ResultSet rs;
			rs = stmt.executeQuery("SELECT S.cod_seguimiento, S.cod_tema, O.apellido, S.mintv, S.mincentral, S.cant_notas, S.cant_tapas, S.apreciacion FROM seguimientos AS S"
					+ "INNER JOIN operador AS S ON (S.id_operador = O.id_operador");
			while(rs.next()){
				Seguimiento seguimiento = new MediosTradicionales(rs.getInt("cod_seguimiento"), rs.getString("cod_tema"), rs.getString("apellido"), rs.getInt("mintv"), rs.getInt("mincentral"), rs.getInt("cant_notas"), rs.getInt("cant_tapas"), rs.getString("apreciacion"));
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
		MediosTradicionales seguimientoMT = (MediosTradicionales) seguimiento;
		Statement stmt = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, "root", "admin");
			stmt = (Statement) conn.createStatement();
			
			ResultSet rs;

			rs = stmt.executeQuery("Select * " 
					+ "from seguimiento as S inner join operador as O on (S.id_operador = O.id_operador) where S.cod_tema = '"+ codigo +"'");
			while (rs.next()) {
				seguimientoMT = new MediosTradicionales(rs.getInt("cod_seguimiento"), rs.getString("cod_tema"), rs.getString("apellido"), rs.getInt("mintv"), rs.getInt("mincentral"), rs.getInt("cant_notas"), rs.getInt("cant_tapas"), rs.getString("apreciacion"));
			
			}
			conn.close();
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
		
		return seguimientoMT;
	}
	
	public ArrayList<Seguimiento> obtenerSeguimientosPorCodigo(String codigo){
		
		ArrayList<Seguimiento> seguimientos = new ArrayList<>();
		Statement stmt = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, "root", "admin");
			stmt = (Statement) conn.createStatement();
			
			ResultSet rs;

			rs = stmt.executeQuery("Select * " 
					+ "from seguimiento as S inner join operador as O on (S.id_operador = O.id_operador) where S.cod_tema = '"+ codigo +"'");
			while (rs.next()) {
				Seguimiento seguimiento = new MediosTradicionales(rs.getInt("cod_seguimiento"), rs.getString("cod_tema"), rs.getString("apellido"), rs.getInt("mintv"), rs.getInt("mincentral"), rs.getInt("cant_notas"), rs.getInt("cant_tapas"), rs.getString("apreciacion"));
				seguimientos.add(seguimiento);
			}
			conn.close();
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
		return seguimientos;
	
	}
	
	public ArrayList<Seguimiento> buscarSeguimientoPorOp(String apellido) {
		
		ArrayList<Seguimiento> seguimientos = new ArrayList<>();
		Statement stmt = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, "root", "admin");
			stmt = (Statement) conn.createStatement();
			
			ResultSet rs;
			rs = stmt.executeQuery("SELECT S.cod_seguimiento, S.cod_tema, O.apellido, S.mintv, S.mincentral, S.cant_notas, S.cant_tapas, S.apreciacion FROM seguimientos AS S"
					+ "INNER JOIN operador AS S ON (S.id_operador = O.id_operador) WHERE O.apellido LIKE '" + apellido + "'");
			while(rs.next()){
				Seguimiento seguimiento = new MediosTradicionales(rs.getInt("cod_seguimiento"), rs.getString("cod_tema"),	rs.getString("apellido"),rs.getInt("mintv"), rs.getInt("mincentral"), rs.getInt("cant_notas"), rs.getInt("cant_tapas"), rs.getString("apreciacion"));
				
				seguimientos.add(seguimiento);
			}
			conn.close();
			
		}catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
		
		return seguimientos;
	}

}
