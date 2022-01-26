package semana2;

public class Empresa {
	private Mes[] mesesEmpresa;
	
	public Empresa() {
		this.mesesEmpresa = new Mes[12];
	}

	public Mes[] getMesesEmpresa() {
		return mesesEmpresa;
	}
	
	public void addProyecto(int numPr,int mes, Proyecto  pr) {
		this.getMesesEmpresa()[mes].addProyecto(numPr, pr);
	}
	
	public int getHorasTotalProyecto(int numPr) {
		int horas = 0;
		
		for(int i = 0; i < this.getMesesEmpresa().length; i++) {
			horas += this.getMesesEmpresa()[i].getHorasProyecto(numPr);
		}
		
		return horas;
	}
	
	public int getHorasMesProyecto(int mes, int numPr) {
		return this.getMesesEmpresa()[mes].getHorasProyecto(numPr);
	}
	
	public int getHorasTotalEmpresa() {
		int horas = 0;
		
		for(int mes = 0; mes < this.getMesesEmpresa().length; mes++) {
			for(int pr = 0; pr < this.getMesesEmpresa()[mes].getProyectos().length; pr++) {
				horas += this.getMesesEmpresa()[mes].getProyectos()[pr].getHorasProyecto();
			}
		}
		
		return horas;
	}
	
	
}
