package genericidad;
import ordenamiento.Persona;

public class Main {
	public static void main(String[] args) {
		Ej ej = new Ej(new Persona("Ernesto",30));
		Persona e1 = (Persona) ej.getObj(); //Para hacer casting de Comparable a persona
		EjGeneric<Persona> ejG1 = new EjGeneric(new Persona("Carlos",12));
		System.out.println(ejG1 instanceof EjGeneric);
	}
}
