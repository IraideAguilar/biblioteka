package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Prestamo_modelo {
	
	public Prestamo_modelo(String dbIzena) {
		super(dbIzena);
	}
	
	public ArrayList<Prestamo> select() {
		ArrayList<Prestamo> prestamo = new ArrayList<Prestamo>();
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from biblioteka");
			while (rs.next()) {
				prestamo.add(new Socio(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"),
						rs.getString("direccion"), rs.getString("poblacion"), rs.getString("provincia"),
						rs.getString("dni")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prestamo;
	}

}
