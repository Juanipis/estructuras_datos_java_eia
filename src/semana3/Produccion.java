package semana3;


public enum Produccion {
	LUNES("Lunes"),
	MARTES("Martes"),
	MIERCOLES("Miercoles"),
	JUEVES("Jueves"),
	VIERNES("Viernes");
	
	private Dia dia;
	private String nombre;
	
	Produccion(String nombre){
		this.dia = new Dia();
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
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
	
	public static int getProduccionTotalDia(String nombreDia) {
		int horasProduccion = 0;
		if(Produccion.valueOf(nombreDia.toUpperCase()) != null) {
			for(Producto pra: Produccion.valueOf(nombreDia.toUpperCase()).getDia().getProductos()) {
				if(pra != null) {
					horasProduccion += pra.getProduccionDiaria();
				}
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
