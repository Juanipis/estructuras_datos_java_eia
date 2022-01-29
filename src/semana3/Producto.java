package semana3;

public class Producto {
	private String nombre;
	private int horasProduccion;
	
	public Producto(String nombre, int horasProduccion) {
		this.setNombre(nombre);
		this.setHorasProduccion(horasProduccion);
	}
	
	public String getNombre() {
		return nombre;
	}
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getHorasProduccion() {
		return horasProduccion;
	}
	private void setHorasProduccion(int horasProduccion) {
		this.horasProduccion = horasProduccion;
	}
	
	@Override
	public String toString() {
		return this.getNombre() + " : " + this.getHorasProduccion();
	}
	
}
