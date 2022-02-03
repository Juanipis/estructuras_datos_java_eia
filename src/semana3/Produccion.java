package semana3;


public enum Produccion {
<<<<<<< HEAD
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
=======
	SEMANA1(),
	SEMANA2(),
	SEMANA3(),
	SEMANA4();
	
	
	private Dia[] semana;
	
	Produccion(){
		this.semana = new Dia[7];
		for (int i = 0; i < semana.length; i++) {
			this.semana[i] = new Dia();
		}
	}
	
	public void addProductoDia(String nombre, int horasProduccion, int dia, int index) {
		if(dia >= 0 && dia < this.semana.length) {
			this.semana[dia].addProducto(nombre, horasProduccion, index);
		}
>>>>>>> 366a126ed54db4ab53002c90a4bcf170eb631eb3
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
