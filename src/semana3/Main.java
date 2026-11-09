package semana3;

public class Main {

	public static void main(String[] args) {
		
		//Añadimos productos al dia 0
		Produccion.LUNES.addProductoDia("Correas", 12, 0);
		Produccion.LUNES.addProductoDia("Manillas", 7, 1);
		Produccion.LUNES.addProductoDia("Gatos", 2, 2);
		Produccion.LUNES.addProductoDia("Lagartijas", 30, 3);
		Produccion.LUNES.addProductoDia("Ñaños", 1, 4);
		Produccion.LUNES.addProductoDia("Licuscus", 200, 5);
		Produccion.LUNES.addProductoDia("Garrotes", 18, 6);
		Produccion.LUNES.addProductoDia("Muñecas", 13, 7);
		Produccion.LUNES.addProductoDia("Chipotle Chillon", 1, 8);
		Produccion.LUNES.addProductoDia("Acetaminofen", 10000, 9);
		
		
		//A�adimos productos al dia 1,2,3
		Produccion.MARTES.addProductoDia("Correas", 7, 0);
		Produccion.MIERCOLES.addProductoDia("Correas", 15, 0);
		Produccion.JUEVES.addProductoDia("Correas", 20, 0);
		
		//Añadir productos

		
		
				
		//Probamos obtener total horas dia 0
		System.out.println("Produccion total en el dia LUNES: " + Produccion.getProduccionTotalDia("lunes") + " productos" );
		System.out.println("Produccion total en el dia MARTES: " + Produccion.getProduccionTotalDia("martes") + " productos" );
		System.out.println("Produccion total en el dia MIERCOLES: " + Produccion.getProduccionTotalDia("miercoles") + " productos" );
		System.out.println("Produccion total en el dia JUEVES: " + Produccion.getProduccionTotalDia("jueves") + " productos" );
		
		//Probamos obtener produccion total de un producto
		System.out.println("Produccion total del producto correas: " + Produccion.getProduccionTotalProducto("Correas") + " productos");
	
		//Probamos obtener produccion total
		System.out.println("Produccion total : " + Produccion.getProduccionTotal() + " productos");
			
	}
}
