package semana3;


public class Produccion {
	private Dia[] semana;
	
	public Produccion(){
		this.semana = new Dia[7];
		for (int i = 0; i < semana.length; i++) {
			this.semana[i] = new Dia();
		}
	}
	
	public void addProductoDia(String nombre, int horasProduccion, int dia, int index) {
		if(dia >= 0 && dia < this.semana.length) {
			this.semana[dia].addProducto(nombre, horasProduccion, index);
		}
	}
	
	public int getProduccionTotal() {
		int horasProduccion = 0;
		for(Dia dia: this.semana) {
			if(dia != null) {
				for(Producto pr: dia.getProductos()) {
					if(pr != null) {
						horasProduccion += pr.getProduccionDiaria();
					}
				}
			}
		}
		return horasProduccion;
	}
	
	public int getProduccionTotalDia(int dia) {
		int horasProduccion = 0;
		if(dia >= 0 && dia < this.semana.length) {
			for(Producto pr: this.semana[dia].getProductos()) {
				if(pr != null) {
					horasProduccion += pr.getProduccionDiaria();
				}
			}
		}
		return horasProduccion;
	}
	
	public int getProduccionTotalProducto(String nombreProducto) {
		int horasProduccion = 0;
		for(Dia dia: this.semana) {
			if(dia != null) {
				for(Producto pr: dia.getProductos()) {
					if(pr != null && pr.getNombre().equals(nombreProducto)) {
						horasProduccion += pr.getProduccionDiaria();
					}
				}
			}
		}
		return horasProduccion;
	}
	
}
