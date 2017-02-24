package modelo;

import java.sql.Date;

public class Prestamo {
	
	int id_libro;
	int id_socio;
	Date fecha;
	boolean devuelto;
	
	public Prestamo(){
		
	}
	
	public Prestamo(int id_libro,int id_socio,Date fecha,boolean devuelto){
		this.id_libro = id_libro;
		this.id_socio = id_socio;
		this.fecha = fecha;
		this.devuelto = devuelto;
		
	}

	public int getId_libro() {
		return id_libro;
	}

	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}

	public int getId_socio() {
		return id_socio;
	}

	public void setId_socio(int id_socio) {
		this.id_socio = id_socio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isDevuelto() {
		return devuelto;
	}

	public void setDevuelto(boolean devuelto) {
		this.devuelto = devuelto;
	}
	
	public void mostrarPrestamo(){
		System.out.println("El libro con el id" + this.id_libro + "del socio " + this.id_socio + "que a fecha de" + this.fecha + " a" + this.devuelto + "su pedido");
	}
	
	

}
