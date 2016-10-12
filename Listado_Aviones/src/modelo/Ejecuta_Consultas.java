package modelo;

import java.sql.*;

public class Ejecuta_Consultas {
	
	private Conexion miConexion;
	
	private ResultSet rs;
	
	private PreparedStatement enviaConsultaTipo;
	
	private PreparedStatement enviaConsultaPais;
	
	private PreparedStatement enviaConsultaTodos;
	
	private final String consultaTipo= "SELECT tipo, modelo, tiempo_de_utilidad, alias, nacionalidad, autonomia FROM aviones WHERE tipo=?";
	
	private final String consultaPaises= "SELECT tipo, modelo, tiempo_de_utilidad, alias, nacionalidad, autonomia FROM aviones WHERE nacionalidad=?";
	
	private final String consultaTodos= "SELECT tipo, modelo, tiempo_de_utilidad, alias, nacionalidad, autonomia FROM aviones WHERE tipo=? AND nacionalidad=?";
			
	
	public Ejecuta_Consultas()
		{
			miConexion= new Conexion();
		}
	
			public ResultSet FiltraDB(String tipo, String nacionalidad)
				{
				
				Connection conecta= miConexion.getConexion();
				
				rs=null;
				
		try
			{
				
				if(!tipo.equals("Todos") && nacionalidad.equals("Todos"))
					{
						enviaConsultaTipo= conecta.prepareStatement(consultaTipo);
						
						enviaConsultaTipo.setString(1, tipo);
						
						rs= enviaConsultaTipo.executeQuery();
						
					}
					else if (tipo.equals("Todos") && !nacionalidad.equals("Todos"))
					{
						enviaConsultaPais= conecta.prepareStatement(consultaPaises);
						
						enviaConsultaPais.setString(1, nacionalidad);
						
						rs= enviaConsultaPais.executeQuery();
					}
					else
						{
						enviaConsultaTodos= conecta.prepareStatement(consultaTodos);
						
						enviaConsultaTodos.setString(1, tipo);
						
						enviaConsultaTodos.setString(2, nacionalidad);
						
						rs= enviaConsultaTodos.executeQuery();
						}
				
				}
				catch(Exception e)
									{
					
									}
		
		return rs; 
	}

}
