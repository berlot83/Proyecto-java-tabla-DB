package controlador;
import java.awt.event.*;
import modelo.*;
import vista.*;
import java.sql.*;

public class Controlador_boton_ejecuta implements ActionListener {

		Ejecuta_Consultas obj= new Ejecuta_Consultas();// instancia de otra clase
	
		private Ventana_Aplicacion ventana;
		
		private ResultSet resultadoConsulta;
		
		
	
		public Controlador_boton_ejecuta(Ventana_Aplicacion ventana)
				{
					this.ventana=ventana;
				}
	
					@Override
					public void actionPerformed(ActionEvent e) 
	
						{
							// TODO Auto-generated method stub
							String seleccionTipo= (String)ventana.tipo.getSelectedItem();
							
							String seleccionPaises= (String)ventana.paises.getSelectedItem();
							
							resultadoConsulta= obj.FiltraDB(seleccionTipo, seleccionPaises);
							
							try {
								
								ventana.resultado.setText("");
								
								while(resultadoConsulta.next())
								{
									ventana.resultado.append(resultadoConsulta.getString(1));
									
									ventana.resultado.append(", ");
									
									ventana.resultado.append(resultadoConsulta.getString(2));
									
									ventana.resultado.append(", ");
									
									ventana.resultado.append(resultadoConsulta.getString(3));
									
									ventana.resultado.append(", ");
									
									ventana.resultado.append(resultadoConsulta.getString(4));
									
									ventana.resultado.append(", ");
									
									ventana.resultado.append(resultadoConsulta.getString(5));
									
									ventana.resultado.append(", ");
									
									ventana.resultado.append(resultadoConsulta.getString(6));
									
									ventana.resultado.append("\n");
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}

}
