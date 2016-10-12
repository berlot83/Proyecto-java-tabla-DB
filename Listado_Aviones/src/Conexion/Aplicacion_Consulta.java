package Conexion;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;



public class Aplicacion_Consulta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame mimarco=new Marco_Aplicacion();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

	}

}

class Marco_Aplicacion extends JFrame{
	
	

	private Connection miConexion;
	
	private PreparedStatement enviarConsultaTipo;
	
	private PreparedStatement enviarConsultaPais;
	
	private PreparedStatement enviarConsultaTodos;
	
	private final String consultaTipo= "SELECT tipo, modelo, tiempo_de_utilidad, alias, nacionalidad, autonomia FROM aviones WHERE tipo=?";	
	
	private final String consultaPais= "SELECT tipo, modelo, tiempo_de_utilidad, alias, nacionalidad, autonomia FROM aviones WHERE nacionalidad=?";
	
	private final String consultaTodos= "SELECT tipo, modelo, tiempo_de_utilidad, alias, nacionalidad, autonomia FROM aviones WHERE tipo=? AND nacionalidad=?";
	
	private JComboBox tipo;
	
	private JComboBox paises;
	
	private JTextArea resultado;	
	
	
	public Marco_Aplicacion(){
		
		setTitle ("Consulta BBDD");
		
		setBounds(500,300,400,400);
		
		setLayout(new BorderLayout());
		
		JPanel menus=new JPanel();
		
		menus.setLayout(new FlowLayout());
		
		tipo=new JComboBox();
		
		tipo.setEditable(false);
		
		tipo.addItem("Todos");
		
		paises=new JComboBox();
		
		paises.setEditable(false);
		
		paises.addItem("Todos");
		
		resultado= new JTextArea(4,50);
		
		resultado.setEditable(false);
		
		add(resultado);
		
		menus.add(tipo);
		
		menus.add(paises);	
		
		add(menus, BorderLayout.NORTH);
		
		add(resultado, BorderLayout.CENTER);
		
		JButton botonConsulta=new JButton("Consulta");	
		
		botonConsulta.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				ejecutaConsulta();
				
			}
			
		});
		
		add(botonConsulta, BorderLayout.SOUTH);
		
		
		//------------------------------Conexion-------------------------//
		try
		{
			Class.forName("org.gjt.mm.mysql.Driver");
// 1) Crear conexión
				miConexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/vehiculos", "root", "");
		
				//2) Crear objeto Statement
				Statement sentencia= miConexion.createStatement();
				
				
//-------------------------------consulta sql tipo-----------------------------//
				//3-Consulta sql
				String consulta= "SELECT DISTINCTROW tipo FROM aviones";
				
				//-4 Resultselt
				ResultSet rs=sentencia.executeQuery(consulta);
				
				//5-cargar datos con bucle
				
				while(rs.next()) { tipo.addItem(rs.getString(1));}
	
		rs.close();
		
		
//-------------------------------consulta sql nacionalidad---------------------//
		//3-Consulta sql
		consulta= "SELECT DISTINCTROW nacionalidad FROM aviones";
		
		//-4 Resultselt
		rs=sentencia.executeQuery(consulta);
		
		//5-cargar datos con bucle
		
		while(rs.next()) { paises.addItem(rs.getString(1));}

rs.close();

		
		}catch(Exception e){}
		
		}	
	
//--------------------este metodo esta ligado al JButton-----------------//	
	private void ejecutaConsulta()
	{
		ResultSet rs=null;	
		
		try{
			String guardardatostipo= (String)tipo.getSelectedItem(); //guarda y convierte datos del jcombobox
			
			String guardardatosnacionalidad= (String)paises.getSelectedItem(); //guarda y convierte datos del jcombobox
			
			
			if(!guardardatostipo.equals("Todos") && guardardatosnacionalidad.equals("Todos"))
				
			{
			
				enviarConsultaTipo= miConexion.prepareStatement(consultaTipo);
			
				enviarConsultaTipo.setString(1, guardardatostipo);
			
				rs= enviarConsultaTipo.executeQuery();
			
				resultado.setText(""); // limpia a las consultas asi no las suma
			
			}	
			
			else if(guardardatostipo.equals("Todos") && !guardardatosnacionalidad.equals("Todos"))
			
			{
				enviarConsultaPais= miConexion.prepareStatement(consultaPais);
				
				enviarConsultaPais.setString(1, guardardatosnacionalidad);
			
				rs= enviarConsultaPais.executeQuery();
			
				resultado.setText(""); // limpia a las consultas asi no las suma
			}
			
			else if(!guardardatostipo.equals("Todos") && !guardardatosnacionalidad.equals("Todos"))
			
			{
				enviarConsultaTodos= miConexion.prepareStatement(consultaTodos);
				
					enviarConsultaTodos.setString(1, guardardatostipo); //se indexa desde donde empieza los parametros
					
					enviarConsultaTodos.setString(2, guardardatosnacionalidad);   //se indexa desde donde empieza los parametros
			
				rs= enviarConsultaTodos.executeQuery();
			
				resultado.setText(""); // limpia a las consultas asi no las suma
			}
			
//------------------------bucle que recorre las filas---------------------//			
			while(rs.next()) 
			{
				resultado.append(rs.getString(1)); //inserta datos en JTextarea
				
				resultado.append(", ");
				
				resultado.append(rs.getString(2));
				
				resultado.append(", ");
				
				resultado.append(rs.getString(3));
				
				resultado.append(", ");
				
				resultado.append(rs.getString(4));
				
				resultado.append(", ");
				
				resultado.append(rs.getString(5));
				
				resultado.append("\n");
			}
		}catch(Exception e){}
		
	}
	
		

	
	

	
}


