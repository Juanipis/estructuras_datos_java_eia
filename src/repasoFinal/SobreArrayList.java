package repasoFinal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class SobreArrayList {
	public static void main (String[] args) {
		ArrayList<Integer> numero = new ArrayList<>();
		ListIterator<Integer> it = numero.listIterator();
		System.out.println(it.next());
		
	}
}

class Evaluaciones{
	private ArrayList<Examen> eval;
	private double porcentaje;
	
	public Evaluaciones(ArrayList<Examen> eval, double porcentaje) {
		this.eval = eval;
		this.porcentaje = porcentaje;
	}
	public Evaluaciones(Examen[] eval, double porcentaje) {
		this.eval = new ArrayList<>(Arrays.asList(eval));
		this.porcentaje = porcentaje;
	}
	
	public Evaluaciones() {
		super();
		this.eval = new ArrayList<>();
		this.porcentaje = 0;
	}
	
	public Examen buscarExamen(String cedula) {
		if(eval.size() == 0) {
			return null;
		}
		ListIterator<Examen> it = eval.listIterator();
		Examen extemp = null;
		do {
			extemp = it.next();
		} while (it.hasNext() && extemp.getCedula().compareTo(cedula)!=0);
		
		return (extemp.getCedula().compareTo(cedula)==0) ? extemp:null;
	}
	
	public void addExamen(Examen ex) {
		if(this.buscarExamen(ex.getCedula()) == null) {
			eval.add(ex);
		}
		//Se debe lanzar excepcion de no se puede añadir
	}
	
	public void modificarExamen(String cedula, double nota) {
		Examen extemp = this.buscarExamen(cedula);
		if(extemp!=null) {
			extemp.setNotas(nota);
		}
		else {
			//Lanzar excepcion de examen no existe el examen
		}
	}
	
	public void eliminarExamen(String cedula) {
		Examen extemp = this.buscarExamen(cedula);
		if(extemp!= null) {
			eval.remove(extemp);
		}
		else {
			//Lanzar excepcion de examen no encontrado
		}
	}
	
	public Examen[] getEvaluaciones() {
		return eval.toArray(new Examen[eval.size()]);
	}
	
}

class Examen{
	private double notas;
	private String cedula;
	
	public Examen(double notas, String cedula) {
		this.notas = notas;
		this.cedula = cedula;
	}

	public Examen(String cedula) {
		this.cedula = cedula;
	}

	public double getNotas() {
		return notas;
	}

	public void setNotas(double notas) {
		this.notas = notas;
	}


	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	
	
}