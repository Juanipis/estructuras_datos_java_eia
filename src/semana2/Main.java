package semana2;



public class Main {

	public static void main(String[] args) {
		Empresa em1 = new Empresa();
		Mes m1 = new Mes();
		Mes m2 = new Mes();
		Proyecto pr1 = new Proyecto(); /*Proyecto 0*/
		Proyecto pr2 = new Proyecto(); /*Proyecto 1*/
		
		pr1.addTrabajador("Pepe", 99992344.912);
		pr1.addTrabajador("Arnoldo", 1000023.21);
		pr1.addTrabajador("Jhoana", 33123.21);
		pr1.addTrabajador("Joaquin", 765871.912);
		pr1.addTrabajador("Mañiño", 78542.6);
		pr1.addTrabajador("Gabriel", 12344.55);
		
		pr2.addTrabajador("Manuel", 9999.912);
		pr2.addTrabajador("Hernesto", 1000023.21);
		pr2.addTrabajador("Filipino", 33123.21);
		pr2.addTrabajador("Mejia", 765871.912);
		pr2.addTrabajador("Florentino", 78542.6);
		pr2.addTrabajador("Miranda", 12344.55);
		
		
		
		/*Establecemos días de los trabajadores*/
		pr1.setCantDiasTrabajados("Pepe",13);
		pr1.setCantDiasTrabajados("Arnoldo", 2);
		pr1.setCantDiasTrabajados("Jhoana", 9);
		pr1.setCantDiasTrabajados("Joaquin", 20);
		pr1.setCantDiasTrabajados("Mañiño", 14);
		pr1.setCantDiasTrabajados("Gabriel", 18);
		
		pr2.setCantDiasTrabajados("Manuel", 5);
		pr2.setCantDiasTrabajados("Hernesto", 1);
		pr2.setCantDiasTrabajados("Filipino", 10);
		pr2.setCantDiasTrabajados("Mejia", 13);
		pr2.setCantDiasTrabajados("Florentino", 17);
		pr2.setCantDiasTrabajados("Miranda", 22);
		
		/*Añadimos trabajadores*/

		/*Probamos salarios*/
		System.out.println(pr1.buscarSalarioTrabajador("Pepe"));
		System.out.println(pr1.buscarSalarioTrabajador("Joaquin"));
		
		/*Probamos el obtener horas de proyecto*/
		System.out.println("Horas proyecto 1"+ pr1.getHorasProyecto());
		System.out.println("Horas proyecto 2" + pr2.getHorasProyecto());
		
		
		/*Añadimos proyectos al mes*/
		m1.addProyecto(0, pr1);
		m1.addProyecto(1, pr2);
		
		m2.addProyecto(0, pr1);
		
		/*Añadimos el mes a la empresa*/
		em1.addMes(0, m1);
		em1.addMes(1, m2);
		
		/*Imprimimos horas totales del proyecto*/
		System.out.println("Horas totales del proyecto 0: " + em1.getHorasTotalProyecto(0));
		
		
		System.out.println("Horas del mes enero del proyecto 0: " + em1.getHorasMesProyecto(0, 0));
		System.out.println("Horas del mes enero del proyecto 1: " + em1.getHorasMesProyecto(0, 1));
		
		System.out.println("Horas del mes febrero del proyecto 0: " + em1.getHorasMesProyecto(0, 0));
		
		System.out.println("Horas totales trabajadas de la empresa: " + em1.getHorasTotalEmpresa());
		
		System.out.println("Trabajador que tiene el salario más pequeño: " + pr1.getSalarioMinTrabajador());

	}

}
