package final2021;

import java.util.*;


class Nota{
    private String materia;
    private double nota;
	
    public Nota(String materia, double nota) {
		this.materia = materia;
		this.nota = nota;
	}
    
	public Nota(double nota) {
		this.nota = nota;
	}

	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
    
    
}

class Estudiante {
    private String nombre;
    private String cedula;
    private LinkedList<Nota> notas;
    public Estudiante(String nombre, String cedula, LinkedList<Nota> notas) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.notas = notas;
    }
	public String getCedula() {
		return cedula;
	}
	public LinkedList<Nota> getNotas() {
		return notas;
	}
	
	public double getPromedio() {
		double actual = 0;
		int contador= 0;
		ListIterator<Nota> it = notas.listIterator();
		while(it.hasNext()) {
			actual += it.next().getNota();
			contador++;
		}
		if(contador>0) {
			return actual/contador;
		}else {
			return 0;
		}
		
	}
	
	public int materiasPerdidas() {
		int contador= 0;
		ListIterator<Nota> it = notas.listIterator();
		while(it.hasNext()) {
			contador += (it.next().getNota() < 3) ? 1:0;
		}
		return contador;
	}
  
}

class ListaEstudintes{
    private ArrayList<Estudiante> estudiantes;

    
    
public ListaEstudintes(ArrayList<Estudiante> estudiantes) {
		super();
		this.estudiantes = estudiantes;
	}

// Completar
    public void imprimirNotas(String cedula) {
    	try {
			Estudiante est = this.buscarEstudiante(cedula);
			System.out.println(est.getPromedio() + " ," + est.materiasPerdidas());
		} catch (NoExisteEstudianteCedula e) {
			System.out.println(e.getMessage());
		}
    }
    
    public Estudiante buscarEstudiante(String cedula) throws NoExisteEstudianteCedula {
    	Estudiante result = null;
    	ListIterator<Estudiante> buscador = estudiantes.listIterator();
    	if(estudiantes.size() != 0) {
    		do {
				result = buscador.next();
			} while (buscador.hasNext() && result.getCedula().compareTo(cedula)!=0);
    	}
    	
    	if(result != null && result.getCedula().compareTo(cedula)==0) {
    		return result;
    	}else {
    		throw new NoExisteEstudianteCedula(cedula);
    	}
    }
}

public class NotasEstudiantes {
    
    
    public static void main(String[] args) {
    	LinkedList<Nota> notas = new LinkedList<>();
    	notas.add(new Nota(3));
    	notas.add(new Nota(2));
    	notas.add(new Nota(5));
    	Estudiante est1 = new Estudiante("Pepito", "10001", notas);
    	System.out.println(est1.getPromedio());
    	System.out.println(est1.materiasPerdidas());
//        Scanner in = new Scanner(System.in);
//		String line= in.nextLine();
//		String[] listEst=line.split(",");
//		
//		ArrayList<Estudiante> estudiantes=new ArrayList<Estudiante>();
//		while ((line=in.nextLine()).compareTo("")!=0) {
//			String[] datos=line.split(",");
//			LinkedList<Nota> notas=new LinkedList<Nota>();			
//			for (int i=2;i<datos.length;i+=2)
//				notas.add(new Nota(datos[i],Double.parseDouble(datos[i+1])));
//			estudiantes.add(new Estudiante(datos[0],datos[1],notas));
//		}
//		ListaEstudintes lista=new ListaEstudintes(estudiantes);
//		for (String c:listEst) {	
//			lista.imprimirNotas(c);
//		}			
//		in.close();

    }

}
class NoExisteEstudianteCedula extends Exception{
	public NoExisteEstudianteCedula(String cedula) {
		super("El estudiante " + cedula +" no existe");
	}
}