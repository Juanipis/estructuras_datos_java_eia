package excepciones;

public class Main {

	public static void main(String[] args) {
		Cuenta cn;
		try {
			cn = new Cuenta(12.354f);
			
			try {
				cn.depositar(2213.2f);
			} catch (EValorNegativo e) {
				System.out.println(e.getMessage());
			}
			
			try {
				cn.extraer(12444443.3f);
			} catch (EValorMayorSaldo e) {
				System.out.println(e.getMessage());
			} catch (EValorNegativo e) {
				System.out.println(e.getMessage());
			}
			
		} catch (EValorNegativo e1) {
			System.out.println(e1.getMessage());
		}
		
		
		
		
	}

}
