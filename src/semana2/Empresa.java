package semana2;

public class Empresa {
	public Mes[] mesesEmpresa;
	
	public Empresa() {
		this.mesesEmpresa = new Mes[12];
	}
	

	public Mes[] getMesesEmpresa() {
		return mesesEmpresa;
	}
	
	public void addMes(int mes, Mes  mr) {
		this.getMesesEmpresa()[mes] = mr;
		
	}
	
	public int getHorasTotalProyecto(int numPr) {
		int horas = 0;
		
		for(int i = 0; i < this.getMesesEmpresa().length; i++) {
			try { //Cambiar por condicional
				horas += this.getMesesEmpresa()[i].getHorasProyecto(numPr);
			}
			catch(Exception NullPointerException) {
				continue;
			}
			
		}
		
		return horas;
	}
	
	public int getHorasMesProyecto(int mes, int numPr) {
		try { //Cambiar por condicional
			return this.getMesesEmpresa()[mes].getHorasProyecto(numPr);
		}
		catch(Exception NullPointerException) {
			return -1;
		}
		
	}
	
	public int getHorasTotalEmpresa() {
		int horas = 0;
		
		for(int mes = 0; mes < this.getMesesEmpresa().length; mes++) {
			try { //Cambiar por condicional
				for(int pr = 0; pr < this.getMesesEmpresa()[mes].getProyectos().length; pr++) {
					try { //Cambiar por condicional
						horas += this.getMesesEmpresa()[mes].getProyectos()[pr].getHorasProyecto();
					}
					catch(Exception NullPointerException ){
						continue;
					}
					
				}
			}
			catch(Exception NullPointerException ){
				continue;
			}
			
		}
		
		return horas;
	}
	
	
}
