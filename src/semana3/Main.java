package semana3;

public class Main {

	public static void main(String[] args) {
		Produccion pr = new Produccion();
		
		//Añadimos productos al dia 0
		pr.addProductoDia("Correas", 12, 0, 0);
		pr.addProductoDia("Manillas", 5, 0, 1);
		pr.addProductoDia("Gatos", 2, 0, 2);
		pr.addProductoDia("Lagartijas", 7, 0, 3);
		pr.addProductoDia("Ñaños", 24, 0, 4);
		pr.addProductoDia("Licuscus", 17, 0, 5);
		pr.addProductoDia("Garrotes", 1, 0, 6);
		pr.addProductoDia("Muñecas", 13, 0, 7);
		pr.addProductoDia("Chipotle Chillon", 0, 0, 8);
		pr.addProductoDia("Acetaminofen", 20, 0, 9);
		
		//Añadimos productos al dia 1,2,3
		pr.addProductoDia("Correas", 7, 1, 0);
		pr.addProductoDia("Correas", 15, 2, 0);
		pr.addProductoDia("Correas", 20, 3, 0);
				
		//Probamos obtener total horas dia 0
		System.out.println("Total de horas en el dia 0: " + pr.getProduccionTotalDia(0) + " horas" );
		System.out.println("Total de horas en el dia 1: " + pr.getProduccionTotalDia(1) + " horas" );
		System.out.println("Total de horas en el dia 2: " + pr.getProduccionTotalDia(2) + " horas" );
		System.out.println("Total de horas en el dia 3: " + pr.getProduccionTotalDia(3) + " horas" );
		
		//Probamos obtener produccion total de un producto
		System.out.println("Total de horas del producto correas: " + pr.getProduccionTotalProducto("Correas") + " horas");
	
		//Probamos obtener produccion total
		System.out.println("Total de horas de produccion : " + pr.getProduccionTotal() + " horas");
	}

}
