package listasPilasColas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DireccionSalud {
	private ArrayList<String> medicos;
	private ArrayList<Queue<String>> colaMedicos;
	public DireccionSalud() {
		medicos = new ArrayList<>();
		colaMedicos = new ArrayList<>();
	}
	public void addMedico(String nombreMedico) {
		medicos.add(nombreMedico);
		colaMedicos.add(new LinkedList<>());
	}
	public void addPaciente(String nombreMedico, String nombrePaciente) throws MedicoNoEncontrado {
		int index = findMedico(nombreMedico);
		if(index !=-1) {
			colaMedicos.get(index).add(nombrePaciente);
		}else {
			throw new MedicoNoEncontrado(nombreMedico);
		}
	}
	
	public boolean hayPacienteMedicoCola(String nombreMedico) throws MedicoNoEncontrado {
		int index = findMedico(nombreMedico);
		if(index !=-1) {
			return (colaMedicos.get(index).peek() != null) ? true:false;
		}else {
			throw new MedicoNoEncontrado(nombreMedico);
		}
	}
	public int hayPacienteMedicoColaInt(String nombreMedico) throws MedicoNoEncontrado {
		int index = findMedico(nombreMedico);
		if(index !=-1) {
			return (colaMedicos.get(index).peek() != null) ? index:-1;
		}else {
			throw new MedicoNoEncontrado(nombreMedico);
		}
	}
	public void atenderPaciente(String nombreMedico) throws MedicoNoEncontrado, MedicoNoCitas {
		int index = hayPacienteMedicoColaInt(nombreMedico);
		if(index != -1) {
			colaMedicos.get(index).poll();
		}else {
			throw new MedicoNoCitas(nombreMedico);
		}
	}
	public int findMedico(String nombreMedico) {
		int index = 0;
		while(index < medicos.size() && medicos.get(index) != null && !medicos.get(index).equals(nombreMedico)) index++;
		return (index < medicos.size() && medicos.get(index) != null && medicos.get(index).equals(nombreMedico)) ? index:-1;
	}
	public String getPacienteMedico(String nombreMedico) throws MedicoNoCitas, MedicoNoEncontrado {
		int index = hayPacienteMedicoColaInt(nombreMedico);
		if(index !=-1) {
			return colaMedicos.get(index).peek();
		}else {
			throw new MedicoNoCitas(nombreMedico);
		}
	}
	public ArrayList<String> getMedicos() {
		return medicos;
	}
	public ArrayList<Queue<String>> getColaMedicos() {
		return colaMedicos;
	}
	
}
class MedicoNoEncontrado extends Exception{
	public MedicoNoEncontrado(String nombreMedico) {
		super("El medico: " + nombreMedico + " no fue encontrado");
	}
}
class MedicoNoCitas extends Exception{
	public MedicoNoCitas(String nombreMedico) {
		super("El medico: " + nombreMedico + " no tiene citas");
	}
}