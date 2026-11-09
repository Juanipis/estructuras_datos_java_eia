package semana2;

public class Main2 {
	public static void main(String[] args) {
		//Trabajador limpieza
		EmpLimpieza emp1 = new EmpLimpieza("Pepe", 99344.912, 12, 3);
		Trabajador tr1 = new Trabajador("Pepe", 99344.912);
		System.out.println(emp1.getSalario());
		System.out.println(tr1.getSalario());
		System.out.println("-----------------------------------------------");
	}
	
}
