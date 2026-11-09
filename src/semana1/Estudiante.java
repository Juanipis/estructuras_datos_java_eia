/*Juan Pablo Díaz Correa @Juanipis*/
package semana1;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {
	List<Double> notas = new ArrayList<Double>();
	
	public void addNota(double nota) {
		notas.add(nota);
	}
	
	public List<Double> getNotas() {
		return this.notas;
	}
	
	public int getPrometdio() {
		int promedio = 0;
		if(notas.size() <2) {
			return -1; /*Hacen falta más notas*/
		}
		else {
			for(int i=notas.size()-1; i >= 0; i--) {
				promedio += Math.round(notas.get(i));
			}
			
			return Math.round(promedio/notas.size());
		}
	}
	
	public char getEvaluacion() {
		switch(this.getPrometdio()) {
			case 5:
				return 'B';
			case 4:
				return 'B';
			case 3:
				return 'R';
			case 2:
				return 'M';
			default:
				return '0';
		
		}
		
	}
	
	
}
