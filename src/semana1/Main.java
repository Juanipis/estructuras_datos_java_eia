/*Juan Pablo Díaz Correa @Juanipis*/
package semana1;

public class Main {

	public static void main(String[] args) {
		NComplejo ncomplejo = new NComplejo();
		ncomplejo.setPReal(-1);
		ncomplejo.setPImag(-1);
		
		System.out.println(ncomplejo.getArgumento());
		System.out.println(ncomplejo.getModulo());

	}

}
