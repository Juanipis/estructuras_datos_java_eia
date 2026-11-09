package semana2;

public class EmpLimpieza extends Trabajador {

	
	private float norma;
	private float cump;
	
	public EmpLimpieza(String nombre, double salarioBasico, float norma, float cump) {
		super(nombre, salarioBasico);
		this.norma = norma;
		this.cump = cump;
	}
	
	public double getSalario() {
		return  (super.getSalario()+super.getSalario()*0.1*cump/norma);
	}
}
