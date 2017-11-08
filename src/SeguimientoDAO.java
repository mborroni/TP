import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public ArrayList<Seguimiento> obtenerSeguimientosPorCodigo(String codigo){
		
		
		ArrayList<Seguimiento> seguimientos = new ArrayList<>();
		try{
			ResultSet rs;

			rs = stmt.executeQuery("Select * " 
					+ "from seguimiento as S inner join operador as O on (S.id_operador = O.id_operador) where S.cod_tema = '"+ codigo +"'");
			while (rs.next()) {
				Seguimiento seguimiento = new Seguimiento(rs.getString("cod_tema"), rs.getString("apellido"), rs.getInt("mintv") , rs.getInt("mincentral"),	rs.getInt("cant_notas"), rs.getInt("cant_tapas"), rs.getString("apreciacion"));
				seguimientos.add(seguimiento);
			}
		} catch(SQLException e){
			JOptionPane.showMessageDialog(null, e);
		}
		return seguimientos;
	}
	
	/*
	 * NO TENGO IDEA COMO HACER EL UPDATE XDXDXDDDXDXD
	 */
	
	public ArrayList<Seguimiento> buscarSeguimientos(String texto){
		
		ArrayList<Seguimiento> seguimientos = new ArrayList<>();
		try{
			ResultSet rs;
			rs = stmt.executeQuery("SELECT S.cod_tema, O.apellido, S.mintv, S.mincentral, S.cant_notas, S.cant_tapas, S.apreciacion FROM seguimientos AS S"
					+ "INNER JOIN operador AS S ON (S.id_operador = O.id_operador");
			while(rs.next()){
				Seguimiento seguimiento = new Seguimiento(rs.getString("cod_tema"),
						rs.getString("id_operador"),rs.getInt("mintv"), rs.getInt("mincentral"),
						rs.getInt("cant_notas"),rs.getInt("cant_tapas"),rs.getString("apreciacion"));
				
				seguimientos.add(seguimiento);
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e);
		}
		
		return seguimientos;
	}
	
	/*
	 * BUSCAR SEGUIMIENTO POR OPERADOR
	 */
	public ArrayList<Seguimiento> buscarSeguimientoPorOp(String apellido){
		
		ArrayList<Seguimiento> seguimientos = new ArrayList<>();
		try{
			ResultSet rs;
			rs = stmt.executeQuery("SELECT S.cod_tema, O.apellido, S.mintv, S.mincentral, S.cant_notas, S.cant_tapas, S.apreciacion FROM seguimientos AS S"
					+ "INNER JOIN operador AS S ON (S.id_operador = O.id_operador) WHERE O.apellido LIKE '" + apellido + "'");
			while(rs.next()){
				Seguimiento seguimiento = new Seguimiento(rs.getString("cod_tema"),
						rs.getString("id_operador"),rs.getInt("mintv"), rs.getInt("mincentral"),
						rs.getInt("cant_notas"),rs.getInt("cant_tapas"),rs.getString("apreciacion"));
				
				seguimientos.add(seguimiento);
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e);
		}
		
		return seguimientos;
	}
	
}

