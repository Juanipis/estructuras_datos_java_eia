package semana3;

public class Dia {
	
	private Producto[] productos;
	
	
	public Dia() {
		this.productos = new Producto[10]; //Son 10 productos por dia
	}
	
	public void addProducto(String nombre, int produccionDiaria, int index) {
		if(index>=0 && index<productos.length && produccionDiaria >=0) {
			this.productos[index] = new Producto(nombre, produccionDiaria);
		}
	}
	
	public Producto[] getProductos() {
		return this.productos;
	}
	
	public Producto getProducto(String nombre) {
		int c = 0;
		while(c < this.productos.length && this.productos[c] != null && !this.productos[c].getNombre().equals(nombre)) {
			c++;
		}
		return (c < this.productos.length && this.productos[c] != null &&this.productos[c].getNombre().equals(nombre)) ? this.productos[c]:null;
	}
	
}
