package repasoParcial;



class elementoNoEncontrado extends Exception{
	private static final long serialVersionUID = 1L;
	public elementoNoEncontrado(String elemento) {
		super("No se encontró el elemento " + elemento + " en el arreglo");
	}
}

class indexNegativoArreglo extends Exception{
	private static final long serialVersionUID = 1L;

	public indexNegativoArreglo(int index) {
		super("El numero " + index + " es una posición invalida para el arreglo");
	}
	
}