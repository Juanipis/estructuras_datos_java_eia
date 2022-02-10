package banco;

import java.util.Arrays;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		Banco bn = new Banco();
		//añadimos clientes
		bn.addCliente("Juan", "Diaz", new Date(), "Av 32", "125124", "100082721", 'C', 123123);
		bn.addCliente("Kevin", "Jhoan", new Date(), "Av 32", "100029", "1232131", 'E', 13124532);
		bn.addCliente("Chilindrina", "Orsuela", new Date(), "Av 32", "03947912", "31232121", 'E', 4324235);
		bn.addCliente("Chavo", "Del 8", new Date(), "Av 32", "123124334", "1255623", 'E', 4234234);
		bn.addCliente("Pepito", "De Jesus", new Date(), "Av 32", "982536", "2935475", 'E', 234234);
		System.out.println(bn);
		
		//Buscamos a todos los clientes especiales
		System.out.println("*********************");
		System.out.println(Arrays.toString(bn.cantCuentasEpeciales()) );
		System.out.println("*********************");
		
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
