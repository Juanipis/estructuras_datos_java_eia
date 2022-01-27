package semana2;

public class Mes {
	private Proyecto[] proyectos;
	
	public Mes() {		
		this.proyectos = new Proyecto[20];
	}
	
	public Proyecto[] getProyectos() {
		return proyectos;
	}
	
	public void addProyecto(int posicion, Proyecto pr) {
		if(pr != null) {
			this.getProyectos()[posicion] = pr;
		}
		
	}
	
	public int getHorasProyecto(int posicion) {
		return this.getProyectos()[posicion].getHorasProyecto();
	}
	



	
}
