package semana2;



public class Main {

	public static void main(String[] args) {
		Empresa em1 = new Empresa();
		Mes m1 = new Mes();
		Mes m2 = new Mes();
		Proyecto pr1 = new Proyecto(); /*Proyecto 0*/
		Proyecto pr2 = new Proyecto(); /*Proyecto 1*/
		
		/*Añadimos trabajadores*/
		//*
		pr1.addTrabajador("Pepe", 99344.912);
		
		pr1.addTrabajador("Jhoana", 33123.21);
		pr1.addTrabajador("Joaquin", 765871.912);
		pr1.addTrabajador("Mañiño", 78542.6);
		pr1.addTrabajador("Gabriel", 12344.55);
		pr1.addTrabajador("Arnoldo", 1023.21);
		pr1.addTrabajador("AAAmoldo", 1023.21);
		pr1.addTrabajador("Zoraida", 1023.21);
		
		pr2.addTrabajador("Manuel", 9999.912);
		pr2.addTrabajador("Hernesto", 1000023.21);
		pr2.addTrabajador("Filipino", 33123.21);
		pr2.addTrabajador("Mejia", 765871.912);
		pr2.addTrabajador("Florentino", 78542.6);
		pr2.addTrabajador("Miranda", 12344.55);
		//*/
		
		//Probamos el insertar trabajadores
		pr1.insertarTrabajador("Mejia", 12902, 8);
		pr1.insertarTrabajador("Mejia", 12902, 5);
		pr1.insertarTrabajador("Mejia", 12902, -4);
		System.out.println(pr1.getTrabajador("Mejia"));
		
		
		System.out.println("**************");
		for(Trabajador pr : pr1.getTrabajadores()) {
			System.out.println(pr);
		}
		System.out.println("**************");
		
		
		/*Establecemos días de los trabajadores*/
		///*
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
		//*/
		
		//Establecemos cantidad de dias trabajados por mes
		pr1.setCantDiasTrabajadosMes("Pepe", 0, 12);
		pr1.setCantDiasTrabajadosMes("Pepe", 2, 12);
		pr1.setCantDiasTrabajadosMes("Pepe", 4, 12);
		pr1.setCantDiasTrabajadosMes("Pepe", 11, 12);
		
		pr1.setCantDiasTrabajadosMes("Arnoldo", 0, 20);
		pr1.setCantDiasTrabajadosMes("Arnoldo", 2, 1);
		pr1.setCantDiasTrabajadosMes("Arnoldo", 4, 23);
		pr1.setCantDiasTrabajadosMes("Arnoldo", 11, 11);
		
		System.out.println("Pepe tiene como salario para el mes 2" + pr1.getSalarioMesTrabajador("Pepe", 2));
		System.out.println("Arnoldo tiene como salario para el mes 2" + pr1.getSalarioMesTrabajador("Arnoldo", 2));
		System.out.println("Salario promedio por mes: " + pr1.getSalarioPromedioMes(2));
		
		//Eliminamos a Gabriel y Mejia
		pr1.eliminarTrabajador("Gabriel");
		pr1.eliminarTrabajador("Mejia");
		
		
		//Listamos trabajadores
		System.out.println("**************");
		for(Trabajador pr : pr1.getTrabajadores()) {
			System.out.println(pr);
		}
		System.out.println("**************");
		
		/*Probamos salarios*/
		System.out.println("Salario de Pepe: " + pr1.getSalarioTrabajador("Pepe"));
		System.out.println("Salario de Joaquin: " + pr1.getSalarioTrabajador("Joaquin"));
		
		//Probamos obtener el salario mas alto
		System.out.println("Salario mas alto del mes 0: " + pr1.getSalarioMasAltoMes(0));
		System.out.println("Salario mas alto del mes 0: " + pr1.getSalarioMasBajoMes(0));
		
		//Probamos a eliminar trabajadores repetidos
		pr1.addTrabajador("Oracio", 99344.912);
		pr1.addTrabajador("Oracio", 8435.2);
		pr1.addTrabajador("Oracio", 111.23);
		pr1.addTrabajador("Oracio", 993.12);
		System.out.println("----------*****------------");
		for(Trabajador tr : pr1.getTrabajadores()) {
			System.out.println(tr);
		}
		System.out.println("----------*****------------");
		pr1.eliminarTrabajadorRepetido("Oracio");
		
		System.out.println("Se elimino trabajador repetido Oracio");
		
		System.out.println("----------*****------------");
		for(Trabajador tr : pr1.getTrabajadores()) {
			System.out.println(tr);
		}
		System.out.println("----------*****------------");
		
				
				
		
		//Probamos obtener el trabajador de mayor nombre
		System.out.println("El trabajador que tiene mayor nombre es :" + pr1.getTrabajadorMayorNombre());
		
		//Probamos obtener el trabajador menor nombre
		System.out.println("El trabajador que tiene menor nombre es :" + pr1.getTrabajadorMenorNombre());
		
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
