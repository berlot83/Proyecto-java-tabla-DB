package vista;

import java.awt.*;
import javax.imageio.*;
import javax.swing.*;
import controlador.*;
import java.io.*;


public class Ventana_Aplicacion extends JFrame {
	
	public JComboBox tipo;
	
	public JComboBox paises;
	
	public JTextArea resultado;
	

	
		public Ventana_Aplicacion(){
			
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
			
			add(botonConsulta, BorderLayout.SOUTH);
			
			botonConsulta.addActionListener(new Controlador_boton_ejecuta(this));
			
			addWindowListener(new Controlador_CargaMenus(this));
			
	
			

		}
			

/*		public void paintComponent(Graphics g){
			
		super.paintComponents(g);
		
				File miimagen= new File("src/f16transparente.jpg");
				
				try
				{
					img=ImageIO.read(miimagen);
				}
				catch (IOException e)
				{
					System.out.print("no se encuentra la imagen");
				}
				
				g.drawImage(img, 5, 5, null);
				
		}					*/
			

	}
		
		
		

