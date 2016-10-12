package modelo;

import java.sql.*;
import controlador.*;


public class CargaMenus {
	
	public Conexion miConexion;
	public ResultSet rs;
	public ResultSet rs2;
	
			public CargaMenus()
	
				{
					miConexion= new Conexion();
				}
			
				public String EjecutarConsultas()
					{
						Unidades miUnidad= null;
				
						Connection accesoDB= miConexion.getConexion();
					
					try{
						
						Statement tipo= accesoDB.createStatement();
						
						Statement paises= accesoDB.createStatement();
						
							rs= tipo.executeQuery("SELECT DISTINCTROW tipo FROM aviones");
						
							rs2= paises.executeQuery("SELECT DISTINCTROW nacionalidad FROM aviones");
						
						//while(rs.next()) 
						//{
								rs.previous();
								
								miUnidad= new Unidades();
							
								miUnidad.setTipo(rs.getString(1));
							
								miUnidad.setNacionalidad(rs2.getString(2));
							
						//	return miUnidad.getTipo();
						//}
						
						rs.close();
						
						rs2.close();
						
						accesoDB.close();
						
					}
					
					catch(Exception e)
					
						{
						
						}
					
							return miUnidad.getTipo();
					
					}
				
				}


