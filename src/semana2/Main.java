package semana2;



public class Main {

	public static void main(String[] args) {
		Empresa em1 = new Empresa();
		Mes m1 = new Mes();
		Proyecto pr1 = new Proyecto(); /*Proyecto 0*/
		
		/*Creamos trabajadores*/
		Trabajador tr1 = new Trabajador("Pepe", 9999.912);
		Trabajador tr2 = new Trabajador("Arnonldo", 1000023.21);
		Trabajador tr3 = new Trabajador("Jhoana", 33123.21);
		Trabajador tr4 = new Trabajador("Joaquin", 765871.912);
		Trabajador tr5 = new Trabajador("Mañiño", 78542.6);
		Trabajador tr6 = new Trabajador("Gabriel", 12344.55);
		
		/*Establecemos días de los trabajadores*/
		tr1.setCantDiasTrabajados(13);
		tr2.setCantDiasTrabajados(2);
		tr3.setCantDiasTrabajados(9);
		tr4.setCantDiasTrabajados(20);
		tr5.setCantDiasTrabajados(14);
		tr6.setCantDiasTrabajados(18);
		
		/*Añadimos trabajadores*/
		pr1.addTrabajador(tr1);
		pr1.addTrabajador(tr2);
		pr1.addTrabajador(tr3);
		pr1.addTrabajador(tr4);
		pr1.addTrabajador(tr5);
		pr1.addTrabajador(tr6);

		/*Probamos salarios*/
		System.out.println(pr1.buscarSalarioTrabajador("Pepe"));
		System.out.println(pr1.buscarSalarioTrabajador("Joaquin"));
		
		/*Probamos el obtener horas de proyecto*/
		System.out.println(pr1.getHorasProyecto());
		
		m1.addProyecto(0, pr1);
		System.out.println(m1.getHorasProyecto(0));
		
		em1.addProyecto(0, m1);
		
		
		System.out.println(em1.getHorasTotalProyecto(0));
		
		

	}

}
