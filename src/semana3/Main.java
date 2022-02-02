package semana3;

public class Main {

	public static void main(String[] args) {
			
		//Añadimos productos al dia 0
		Produccion.values()[0].addProductoDia("Correas", 12, 0, 0);
		Produccion.values()[0].addProductoDia("Manillas", 5, 0, 1);
		Produccion.values()[0].addProductoDia("Gatos", 2, 0, 2);
		Produccion.values()[0].addProductoDia("Lagartijas", 7, 0, 3);
		Produccion.values()[0].addProductoDia("Ñaños", 24, 0, 4);
		Produccion.values()[0].addProductoDia("Licuscus", 17, 0, 5);
		Produccion.values()[0].addProductoDia("Garrotes", 1, 0, 6);
		Produccion.values()[0].addProductoDia("Muñecas", 13, 0, 7);
		Produccion.values()[0].addProductoDia("Chipotle Chillon", 0, 0, 8);
		Produccion.values()[0].addProductoDia("Acetaminofen", 20, 0, 9);
		
		//Añadimos productos al dia 1,2,3
		Produccion.values()[0].addProductoDia("Correas", 7, 1, 0);
		Produccion.values()[0].addProductoDia("Correas", 15, 2, 0);
		Produccion.values()[0].addProductoDia("Correas", 20, 3, 0);
				
		//Probamos obtener total horas dia 0
		System.out.println("Produccion total en el dia 0: " + Produccion.values()[0].getProduccionTotalDia(0) + " productos" );
		System.out.println("Produccion total en el dia 1: " + Produccion.values()[0].getProduccionTotalDia(1) + " productos" );
		System.out.println("Produccion total en el dia 2: " + Produccion.values()[0].getProduccionTotalDia(2) + " productos" );
		System.out.println("Produccion total en el dia 3: " + Produccion.values()[0].getProduccionTotalDia(3) + " productos" );
		
		//Probamos obtener produccion total de un producto
		System.out.println("Produccion total del producto correas: " + Produccion.values()[0].getProduccionTotalProducto("Correas") + " productos");
	
		//Probamos obtener produccion total
		System.out.println("Produccion total : " + Produccion.values()[0].getProduccionTotal() + " productos");
	}

}
