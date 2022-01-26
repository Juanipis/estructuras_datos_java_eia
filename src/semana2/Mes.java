package semana2;

public class Mes {
	private Proyecto[] proyectos;
	
	public Mes() {
		super();
		
		this.proyectos = new Proyecto[20];
	}
	
	public Proyecto[] getProyectos() {
		return proyectos;
	}
	
	public void addProyecto(int posicion, Proyecto pr) {
		this.getProyectos()[posicion] = pr;
	}
	
	public int getHorasProyecto(int posicion) {
		return this.getProyectos()[posicion].getHorasProyecto();
	}
	



	
}
