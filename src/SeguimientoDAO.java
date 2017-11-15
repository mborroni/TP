import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public abstract class SeguimientoDAO {

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
	
	public abstract void agregarSeguimiento(Seguimiento seguimiento);
	
	public abstract ArrayList<Seguimiento> buscarSeguimientos(String texto);
	
	public abstract ArrayList<Seguimiento> obtenerSeguimientosPorCodigo(String codigo);
	
	public abstract ArrayList<Seguimiento> buscarSeguimientoPorOp(String apellido);
	/*
	public ArrayList<Seguimiento> obtenerSeguimientosPorCodigo(String codigo){
		
		
		ArrayList<Seguimiento> seguimientos = new ArrayList<>();
		try{
			ResultSet rs;

			rs = stmt.executeQuery("Select * " 
					+ "from seguimiento as S inner join operador as O on (S.id_operador = O.id_operador) where S.cod_tema = '"+ codigo +"'");
			while (rs.next()) {
				Seguimiento seguimiento = new Seguimiento(rs.getString("cod_tema"), rs.getString("apellido"));
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
	/*
	public ArrayList<Seguimiento> buscarSeguimientos(String texto){
		
		ArrayList<Seguimiento> seguimientos = new ArrayList<>();
		try{
			ResultSet rs;
			rs = stmt.executeQuery("SELECT S.cod_tema, O.apellido, S.mintv, S.mincentral, S.cant_notas, S.cant_tapas, S.apreciacion FROM seguimientos AS S"
					+ "INNER JOIN operador AS S ON (S.id_operador = O.id_operador");
			while(rs.next()){
				Seguimiento seguimiento = new Seguimiento(rs.getString("cod_tema"),
						rs.getString("id_operador"),rs.getString("apreciacion"));
				
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
	/*
	public ArrayList<Seguimiento> buscarSeguimientoPorOp(String apellido){
		
		ArrayList<Seguimiento> seguimientos = new ArrayList<>();
		try{
			ResultSet rs;
			rs = stmt.executeQuery("SELECT S.cod_tema, O.apellido, S.mintv, S.mincentral, S.cant_notas, S.cant_tapas, S.apreciacion FROM seguimientos AS S"
					+ "INNER JOIN operador AS S ON (S.id_operador = O.id_operador) WHERE O.apellido LIKE '" + apellido + "'");
			while(rs.next()){
				Seguimiento seguimiento = new Seguimiento(rs.getString("cod_tema"),
						rs.getString("id_operador"),rs.getString("apreciacion"));
				
				seguimientos.add(seguimiento);
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e);
		}
		
		return seguimientos;
	}
	*/
}

