package analisisAlgoritmico;

import java.util.Arrays;

public class Algoritmos {
	public static int subsecuenciaSumaMaxima(int []a) {
		//No cuentan
		int secIni;
		int secFin;
		
		
		int sumaActual;  // 1
		
		int sumaMax = 0; // 2
		
		//sea N a.length
		
		//       2          N+1        N
		for (int i = 0; i < a.length; i++) {
			      //N(2)       cv+n        cv 
			for (int j = i; j < a.length; j++) {
				//cv(2)
				sumaActual = 0;  // 
				//    cv(2)      cd+cv   cd
				for (int k = i; k <= j ; k++) {
					//  cd(2)
					sumaActual += a[k];
					//  cd
					if (sumaActual > sumaMax) {
						//cd(2)
						sumaMax = sumaActual;
						//cd(2)
						secIni = i;
						//cd(2)
						secFin = j;
					}
				}
			}
		}
		//9n²+14N+3
		return sumaMax;
	}
	
	
 public static int subMaximaJuan(int []a) {
	int [] listaCombinaciones = new int[0];
	
	int index = 0;
	int handler = 1;
	int sumaSecuencial = a[0];
	int sumMax = 0;
	int sumActual = 0;
	while(index< a.length) {
		if(handler < a.length) {
			sumaSecuencial += a[handler];
			handler++;
			listaCombinaciones = Arrays.copyOf(listaCombinaciones, listaCombinaciones.length+1);
			listaCombinaciones[listaCombinaciones.length-1] = sumaSecuencial; 
		}
		else {
			index++;
			handler = index+1;
			if(index == a.length) {
				break;
			}else {
				sumaSecuencial = a[index];
			}
		}
	}
	
	int max = listaCombinaciones[0];
	for(int num : listaCombinaciones) {
		max = (max < num) ? num:max;
	}
	return (max>0) ? max:0;
	
 }
}

