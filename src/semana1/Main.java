package semana1;

public class Main {

	public static void main(String[] args) {
		NComplejo ncomplejo = new NComplejo();
		ncomplejo.setPReal(0);
		ncomplejo.setPImag(0);
		
		System.out.println(ncomplejo.getArgumento());
		System.out.println(ncomplejo.getModulo());
		
		System.out.println("---------------");
		
		Cuerpo cuerpo = new Cuerpo();
		cuerpo.setEspacio(15.6);
		cuerpo.setTiempo(3);
		
		System.out.println(cuerpo.calcVel());

	}

}
