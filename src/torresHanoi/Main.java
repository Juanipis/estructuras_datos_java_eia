package torresHanoi;

public class Main {
	public static void main(String [] args) {
		Hanoi hn = new Hanoi(4);
		System.out.println(hn.torreLista(4, 1));
		hn.moverDiscoProximaTorre(1);
		System.out.println(hn.torreLista(4, 1));
		hn.moverDiscoProximaTorre(1);
		hn.moverDiscoProximaTorre(2);
		hn.moverDiscoProximaTorre(1);
		hn.moverDiscoProximaTorre(3);
		hn.moverDiscoProximaTorre(1);
		hn.moverDiscoProximaTorre(3);
		hn.moverDiscoProximaTorre(2);
		hn.moverDiscoProximaTorre(3);
		hn.moverDiscoProximaTorre(2);
		hn.moverDiscoProximaTorre(1);
		hn.moverDiscoProximaTorre(1);
		hn.moverDiscoProximaTorre(2);
		System.out.println(hn.torreLista(2, 3));
		
		
		
	}
}
