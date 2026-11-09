/*Juan Pablo Díaz Correa @Juanipis*/
package semana1;

public class Rectangulo {
	private double base;
	private double altura;
	
	public Rectangulo(double base, double altura) {
		this.setBase(base);
		this.setAltura(altura);
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public double getArea() {
		return this.getBase()*this.getAltura();
	}
	
	public double getPerimetro() {
		return (this.getBase()+this.getAltura())*2;
	}
}
