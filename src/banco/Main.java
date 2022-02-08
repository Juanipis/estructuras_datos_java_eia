package banco;

import java.util.Date;

public class Main {

	public static void main(String[] args) {
		Banco bn = new Banco();
		//añadimos clientes
		bn.addCliente("Juan", "Diaz", new Date(), "Av 32", "125124", "100082721", 'C', 123123);
		bn.addCliente("Juan", "Diaz", new Date(), "Av 32", "125124", "100082721", 'C', 123123);
		System.err.println(bn);
		
		//Eliminamos cliente
		bn.eliminarCliente("100082721");
		System.out.println(bn);
		
	}

}
