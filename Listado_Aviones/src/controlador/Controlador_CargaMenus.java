package controlador;

import java.awt.event.*;
import modelo.*;
import vista.*;

public class Controlador_CargaMenus extends WindowAdapter {
	
	
	CargaMenus obj= new CargaMenus();
	private Ventana_Aplicacion ventana;
	
	
	
	
	public Controlador_CargaMenus(Ventana_Aplicacion ventana){
		
		this.ventana=ventana;
		
	}



	public void windowOpened(WindowEvent e)
	{
		obj.EjecutarConsultas();
		
		try
		{
			while(obj.rs.next()) 
			{
				ventana.tipo.addItem(obj.rs.getString(1));
			}
			
			while(obj.rs2.next())
			{
				ventana.paises.addItem(obj.rs2.getString(1));
			}
			
		}
		
		catch(Exception e2)
			{
				e2.printStackTrace();
			}
	}
}
