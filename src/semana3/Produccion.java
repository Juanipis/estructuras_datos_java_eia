package semana3;


public enum Produccion {
	LUNES(),
	MARTES(),
	MIERCOLES(),
	JUEVES(),
	VIERNES();
	
	private Dia dia;
	
	Produccion(){
		this.dia = new Dia();
	}
	public Dia getDia() {
		return this.dia;
	}
	
	public void addProductoDia(String nombre, int cantProducida, int indexProducto) {
		this.dia.addProducto(nombre, cantProducida, indexProducto);
	}
	

	
	public static int getProduccionTotal() {
		int horasProduccion = 0;
		for(Produccion pr: Produccion.values()) {
			if(pr != null) {
				for(Producto pra: pr.getDia().getProductos()) {
					if(pra != null) {
						horasProduccion += pra.getProduccionDiaria();
					}
				}
			}
		}
		return horasProduccion;
	}
	
	public int getProduccionTotalDia() {
		int horasProduccion = 0;
		for(Producto pra: this.getDia().getProductos()) {
			if(pra != null) {
				horasProduccion += pra.getProduccionDiaria();
			}
		}
		return horasProduccion;
	}
	
	public static int getProduccionTotalProducto(String nombreProducto) {
		int horasProduccion = 0;
		for(Produccion pr: Produccion.values()) {
			if(pr != null && pr.getDia().getProducto(nombreProducto) != null) {
				horasProduccion += pr.getDia().getProducto(nombreProducto).getProduccionDiaria();
			}
		}
		return horasProduccion;
	}
	
}
