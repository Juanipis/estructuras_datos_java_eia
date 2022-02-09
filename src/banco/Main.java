package banco;

import java.util.Date;

public class Main {

	public static void main(String[] args) {
		Banco bn = new Banco();
		//añadimos clientes
		bn.addCliente("Juan", "Diaz", new Date(), "Av 32", "125124", "100082721", 'C', 123123);
		bn.addCliente("Kevin", "Jhoan", new Date(), "Av 32", "100029", "1232131", 'E', 123123);
		System.out.println(bn);
		
		//Calculamos intereses 
		bn.hacerInteresesMes();
		System.out.println(bn);
		
		//Hacemos depositos a Kevin
		bn.hacerDepositoCliente("1232131", 2000);
		bn.hacerDepositoCliente("1232131", 2000);
		bn.hacerDepositoCliente("1232131", 2000);
		bn.hacerDepositoCliente("1232131", 2000);
		bn.hacerDepositoCliente("1232131", 2000);
		
		System.out.println("---------");
		System.out.println(bn.mostrarSaldo("1232131"));
		//Eliminamos cliente
		bn.eliminarCliente("100082721");
		System.out.println(bn);
		
		System.out.println(bn.reporteCuenta("1232131"));
	}

}
