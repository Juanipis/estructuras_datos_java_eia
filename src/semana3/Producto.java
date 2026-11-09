package semana3;

public class Producto {
	private String nombre;
	private int produccionDiaria;
	
	public Producto(String nombre, int produccionDiaria) {
		this.setNombre(nombre);
		this.setProduccionDiaria(produccionDiaria);
	}
	
	public String getNombre() {
		return nombre;
	}
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getProduccionDiaria() {
		return this.produccionDiaria;
	}
	private void setProduccionDiaria(int produccionDiaria) {
		if(produccionDiaria >= 0) {
			this.produccionDiaria = produccionDiaria;
		}
	}
	
	@Override
	public String toString() {
		return this.getNombre() + " : " + this.getProduccionDiaria();
	}
	
}
