package pruebas;

public class Main {

	public static void main(String[] args) {
		String nombre = "Juan González";
		String apellido = nombre.substring(5);
		
		String a = nombre.substring(3,7);
		
		System.out.println(nombre);
		System.out.println(apellido);
		System.out.println(a);
		
		System.out.println(nombre.charAt(6));
	}

}
