package modelo;

public class Unidades {

	private String tipo;
	
	private String modelo;
	
	private String alias;
	
	private String nacionalidad;
	
	private int autonomia;
	
	public Unidades()
	{
		this.tipo="";
		this.modelo="";
		this.alias="";
		this.nacionalidad="";
		this.autonomia= autonomia;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public int getAutonomia() {
		return autonomia;
	}

	public void setAutonomia(int autonomia) {
		this.autonomia = autonomia;
	}
	
	
	
	
}
