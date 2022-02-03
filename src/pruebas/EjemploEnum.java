package pruebas;

public class EjemploEnum {
	public enum Precio {BARATO, MEDIO, CARO};
	
	public enum PrecioRango{
		BARATOS(0,10000), MEDIOS(10000,100000), CAROS(100000,1000000);
		
		private double min;
		private double max;
		
		private PrecioRango(double min, double max) {
			this.setMin(min);
			this.setMax(max);
		}

		public double getMin() {
			return min;
		}

		public void setMin(double min) {
			this.min = min;
		}

		public double getMax() {
			return max;
		}

		public void setMax(double max) {
			this.max = max;
		}
	};
	
	public static void main(String[] args) {
		Precio precio1= Precio.valueOf("CARO");
		Precio precio2 = Precio.BARATO;
		System.out.println(precio1);
		
		switch (precio1) {
		case BARATO: {
			System.out.println("es barato");
			break;
		}
		case MEDIO:{
			System.out.println("es medio");
			break;
		}
		case CARO:{
			System.out.println("es caro");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + precio1);
		}
	}
}
