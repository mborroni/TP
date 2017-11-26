package consultora.dao;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class OperadorDAO {
	
	private Connection conn = null;
	private String url = "jdbc:mysql://127.0.0.1:3306/consultora?autoReconnect=true&useSSL=false";

	public ArrayList<String> listarOperadores() {
		ArrayList<String> listarOp = new ArrayList<>();
		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, "root", "admin");

			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("SELECT apellido FROM operador");
			while (rs.next()) {
				String operador = rs.getString("apellido");
				listarOp.add(operador);
			}
			conn.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
		return listarOp;
	}
}
