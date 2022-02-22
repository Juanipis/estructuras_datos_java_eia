package analisisAlgoritmico;

public class Funciones {
	public static int mayorNumeros(int a, int b) {
		return (a>=b) ? a:b;
	} //4 pasos, por lo tanto tenemos O(1)
	
	public static int sumaVeces(int a, int b, int N) {
		int total = 0;
		//    2          N+1     N 
		for (int i = 0; i < N; i++) {
			a+=b; //2N, llamada y asignación
			
		}
		//Polinomio 4N +3 - O(4N +3) = O(4N) = O(N)
		return total;
	}
	
	public static void puntoB(int a, int b) {
		// 1 paso
		int k = 100;
		
		//      1       100    99
		for (int i = 1; i < k; i++) {
			a +=b; // (99*2) 
			
		}
		//Tendriamos 400 pasos, entonces O(400) = O(1)
		
	}
	
	public void puntoC(int N) {
		int a = 0;
		int b = 0;
		
		//    2          n+1   N
		for (int i = 0; i < N; i++) {
			//    2N         N(n+1)  N^2
			for (int j = 0; j <N;   j++) {
				a+=b; //2N^2
				
			}
		}
		
		// 2 + n+1 + n + 2n + n(n+1) n² + 2n²
		// 4n²+5n+3  seria O(n²)
	}
	
	public void puntD(int a, int b, int n) {
		//      2        n+1    n
		for (int i = 0; i < n; i++) {
			//    2N         cv+n   cv
			for (int j = 0; j <= i; j++) {  //cv = n(n+1)/2
				a +=b; //2cv
			}
		}
	} //2 + n+1 + n +2N + cv+n+cv+2cv
	// 4cv+3n+3
	// 4(n(n+1)/2)+3n+3
	// 2(n(n+1))+3n+3
	// 2n²+7n+3 --> O(n²)
	
	/*
	 * i |  j
	 * 0    1
	 * 1    2
	 * 2    3 
	 * .    .
	 * n-1 |n
	 * 1+2+3+4+5+...+n = n(n+1)/2*/
	
	public void puntE(int a, int b, int n) {
		//   2
		int c= 1;
		//   
		while(c<n) { //cv
			a +=b; //2(cv -1)
			c= 2*c; //2(cv -1)
		}
		//2 + cv +2cv -2 + 2cv -2
		// 5cv -2
		// 5log2N --> O(LogN)
		
		/*
		 * 2^cv > N
		 * log2N=CV
		 */
	}
	
	public void puntoC(int a, int b, int n) {
		// 2
		int c= n;
		
		while(c>1) { //cv
			a +=b;// 2(cv-1)
			c = c/2; //2(cv-1)
		}
		/*
		 * n/2 , n/4, n/8, ..., n/2^cv
		 * n/2^cv
		 * n=2^cv
		 * log2(n)=cv
		 * 
		 */
	}
}


