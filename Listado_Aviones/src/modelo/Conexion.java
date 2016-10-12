package modelo;
import java.sql.*;

import java.sql.DriverManager;

public class Conexion {

	private Connection miConexion=null;
	
	public Conexion()
	
	{
		
	}
	
	public Connection getConexion(){
		
		try
		{
			Class.forName("org.gjt.mm.mysql.Driver");
// 1) Crear conexión
				miConexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/vehiculos", "root", "");
		} 
		catch (Exception e)
		{
			
		}
		
return miConexion;
	}
}
