package torresHanoi;

public class Hanoi {
	private int[] fila1;
	private int[] fila2;
	private int[] fila3;
	
	public Hanoi(int discos) {
		fila1 = new int[discos];
		for(int i = 0;i< fila1.length; i++) {
			fila1[i] = i+1;
		}
		fila2 = new int[discos];
		fila3 = new int[discos];
	}
	/* Lista de pasos
	 * 1. Mover el primer disco de la primera torre a la segunda torre
	 * 2. Mover el segundo disco de la primera torre a la tercer
	 * 3. Pedirle al programa que complete la torre del segundo disco con el primer disco
	 * 4. Ir a la primera torre, mover disco n a la derecha
	 * 5. Completar disco n
	 * 6. ...
	 * 
	 */
	public void resolver() {
		this.moverDiscoProximaTorre(1);
		this.moverDiscoProximaTorre(1);

		while(!this.resuelto()) {
			if(fila3[this.discoBaseIndexPrimer(3)] == 1) {
				System.out.println("aquí");
				this.buscarDiscoTorreCompletar(this.discoBaseIndexPrimer(2), 2);
			}
			else if(fila2[this.discoBaseIndexPrimer(2)] == 1) {
				
				this.buscarDiscoTorreCompletar(this.discoBaseIndexPrimer(3), 3);
			}
			
		}
	}
	
	public int discoBaseIndexPrimer(int torre) {
		switch (torre) {
		case 1:{
			int index = 0;
			while(index < fila1.length-1 && fila1[index] == 0) { //Encontrar el lugar donde hayan discos
				index++;
			}
			return index;
		}
		case 2: {
			int index = 0;
			while(index < fila2.length-1 && fila2[index] == 0) { //Encontrar el lugar donde hayan discos
				index++;
			}
			return index;	
		}case 3:{
			int index = 0;
			while(index < fila3.length-1 && fila3[index] == 0) { //Encontrar el lugar donde hayan discos
				index++;
			}
			return index;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + torre);
		}
		
	}
	
	public boolean torreLista(int discoBase, int numeroTorre) {
		switch (numeroTorre) {
		case 1: {
			int discoBaseact = discoBase;
			for(int i = fila1.length-1 ; i>=0; i--) {
				if(discoBaseact == fila1[i] && fila1[i] == 0) {
					continue;
				}
				else if(discoBaseact == fila1[i]) {
					discoBaseact--;
				}else {
					return false;
				}
			}
			return true;
		}
		
		case 2: {
			int discoBaseact = discoBase;
			for(int i = fila2.length-1 ; i>=0; i--) {
				if(discoBaseact == fila2[i] && fila2[i] == 0) {
					continue;
				}
				else if(discoBaseact == fila2[i]) {
					discoBaseact--;
				}else {
					return false;
				}
			}
			return true;
		}
		
		case 3: {
			int discoBaseact = discoBase;
			for(int i = fila3.length-1 ; i>=0; i--) {
				if(discoBaseact == fila3[i] && fila3[i] == 0) {
					continue;
				}
				else if(discoBaseact == fila3[i]) {
					discoBaseact--;
				}else {
					return false;
				}
			}
			return true;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + numeroTorre);
		}
	}
	/*
	public void setFila1(int[] arr) {
		fila1 = arr;
	}
	
	public void setFila2(int[] arr) {
		fila2 = arr;
	}
	
	public void setFila3(int[] arr) {
		fila3 = arr;
	}
	*/
	public boolean buscarDiscoTorreCompletar(int discoBase, int numeroTorre) {
		switch (numeroTorre) {
		case 1: {
			while(!this.discoEncima(discoBase, numeroTorre)) {
				if(this.moverDiscoProximaTorre(2)) {} // Movemos a torre 2
				else {this.moverDiscoProximaTorre(3);} // Movemos a torre 3
			}
			if(discoBase-1 >1 && !this.discoEncima(discoBase-1, numeroTorre)) {
				this.buscarDiscoTorreCompletar(discoBase-1, numeroTorre);
			}
			
		}case 2: {
			while(!this.discoEncima(discoBase, numeroTorre)) {
				if(this.moverDiscoProximaTorre(3)) {} // Movemos a torre 3
				else {this.moverDiscoProximaTorre(1);} // Movemos a torre 1
			}
			if(discoBase-1 >1 && !this.discoEncima(discoBase-1, numeroTorre)) {
				this.buscarDiscoTorreCompletar(discoBase-1, numeroTorre);
			}
			return true;
		}case 3: {
			while(!this.discoEncima(discoBase, numeroTorre)) {
				if(this.moverDiscoProximaTorre(1)) {} // Movemos a torre 1
				else {this.moverDiscoProximaTorre(2);} // Movemos a torre 1
			}
			if(discoBase-1 >1 && !this.discoEncima(discoBase-1, numeroTorre)) {
				this.buscarDiscoTorreCompletar(discoBase-1, numeroTorre);
			}
			return true;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + numeroTorre);
		}
	}
	
	public boolean discoEncima(int discoBase, int numeroTorre) {
		switch (numeroTorre) {
		case 1: {
			int indexDiscoEncima = this.buscarIndexDiscoTorre(discoBase, numeroTorre)-1;
			if(indexDiscoEncima < fila1.length && indexDiscoEncima>=0 && fila1[indexDiscoEncima] == discoBase-1) {
				return true;
			}else {
				return false;
			}
		}case 2: {
			int indexDiscoEncima = this.buscarIndexDiscoTorre(discoBase, numeroTorre)-1;
			if(indexDiscoEncima < fila2.length && indexDiscoEncima>=0 && fila2[indexDiscoEncima] == discoBase-1) {
				return true;
			}else {
				return false;
			}
			
		}case 3:{
			int indexDiscoEncima = this.buscarIndexDiscoTorre(discoBase, numeroTorre)-1;
			if(indexDiscoEncima < fila3.length && indexDiscoEncima>=0 && fila3[indexDiscoEncima] == discoBase-1) {
				return true;
			}else {
				return false;
			}
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + 1);
		}
	}
	
	public boolean moverDiscoProximaTorre(int numTorre) {
		switch (numTorre) {
		case 1: { //El disco está en la torre1
			int indexDisco = 0;
			while(indexDisco < fila1.length-1 && fila1[indexDisco] == 0) { // Encontremos el disco que vamos a pasar
				indexDisco++;
			}
			if(moverDiscoTorre2(fila1[indexDisco])) { //intentemos moverlo a la segunda torre
				fila1[indexDisco] = 0;
				this.ImpresionPaso();
				return true;
			}else if(moverDiscoTorre3(fila1[indexDisco])) { //intentemos moverlo a la tercera torre
				fila1[indexDisco] = 0;
				this.ImpresionPaso();
				return true;
			}else {
				return false;
			}
		}case 2:{ //El disco está en la torre2
			int indexDisco = 0;
			while(indexDisco < fila2.length-1 && fila2[indexDisco] == 0) { // Encontremos el disco que vamos a pasar
				indexDisco++;
			}
			if(moverDiscoTorre3(fila2[indexDisco])) { //intentemos moverlo a la tercera torre
				fila2[indexDisco] = 0;
				this.ImpresionPaso();
				return true;
			}else if(moverDiscoTorre1(fila2[indexDisco])) { //intentemos moverlo a la primera torre
				fila2[indexDisco] = 0;
				this.ImpresionPaso(); 
				return true;
			}else {
				return false;
			}
		}case 3:{ //El disco está en la torre3
			int indexDisco = 0;
			while(indexDisco < fila3.length-1 && fila3[indexDisco] == 0) { // Encontremos el disco que vamos a pasar
				indexDisco++;
			}
			if(moverDiscoTorre1(fila3[indexDisco])) { //intentemos moverlo a la primera torre
				fila3[indexDisco] = 0;
				this.ImpresionPaso();
				return true;
			}else if(moverDiscoTorre2(fila3[indexDisco])) { //intentemos moverlo a la segunda torre
				fila3[indexDisco] = 0;
				this.ImpresionPaso();
				return true;
			}else {
				return false;
			}
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + numTorre);
		}
		
	}
	
	public boolean moverDiscoTorre1(int disco) {
		if(disco == 0) {
			return false;
		}
		int index = 0;
		while(index < fila1.length-1 && fila1[index] == 0) { //Encontrar el lugar donde hayan discos
			index++;
		}
		if(index == 0) {
			return false; // Torre llena
		}
		else if(index == fila1.length-1 && fila1[index] == 0) { // Base de la torre
			fila1[index] = disco;
			return true;
		}
		if(index < fila1.length && fila1[index] != 0 && disco<fila1[index]) { // Hay un disco en index, si es menor lo ponemos en la anterior posicion
			fila1[index-1] = disco;
			return true;
		}else {
			return false;
		}
	}
	
	
	public boolean moverDiscoTorre2(int disco) {
		if(disco == 0) {
			return false;
		}
		int index = 0;
		while(index < fila2.length-1 && fila2[index] == 0) { //Encontrar el lugar donde hayan discos
			index++;
		}
		if(index == 0) {
			return false; // Torre llena
		}
		else if(index == fila2.length-1 && fila2[index] == 0) { // Base de la torre
			fila2[index] = disco;
			return true;
		}
		if(index < fila2.length && fila2[index] != 0 && disco<fila2[index]) { // Hay un disco en index, si es menor lo ponemos en la anterior posicion
			fila2[index-1] = disco;
			return true;
		}else {
			return false;
		}
	}
	
	public boolean moverDiscoTorre3(int disco) {
		if(disco == 0) {
			return false;
		}
		int index = 0;
		while(index < fila3.length-1 && fila3[index] == 0) { //Encontrar el lugar donde hayan discos
			index++;
		}
		if(index == 0) {
			return false; // Torre llena
		}
		else if(index == fila3.length-1 && fila3[index] == 0) { // Base de la torre
			fila3[index] = disco;
			return true;
		}
		if(index < fila3.length && fila3[index] != 0 && disco<fila3[index]) { // Hay un disco en index, si es menor lo ponemos en la anterior posicion
			fila3[index-1] = disco;
			return true;
		}else {
			return false;
		}
	}
	
	public int buscarIndexDiscoTorre(int disco, int torre) {
		int indexReturn;
		switch (torre) {
		case 1: {
			for(indexReturn = fila1.length-1; indexReturn>0; indexReturn--) {
				if(disco == fila1[indexReturn]) {
					return indexReturn; 				
				}
			}
			return(disco == fila1[indexReturn]) ? indexReturn:-1;
		}case 2: {
			for(indexReturn = fila2.length-1; indexReturn>0; indexReturn--) {
				if(disco == fila2[indexReturn]) {
					return indexReturn; 				
				}
			}
			return(disco == fila2[indexReturn]) ? indexReturn:-1;
		}case 3: {
			for(indexReturn = fila3.length-1; indexReturn>0; indexReturn--) {
				if(disco == fila3[indexReturn]) {
					return indexReturn; 				
				}
			}
			return(disco == fila3[indexReturn]) ? indexReturn:-1;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + torre);
		}
	}
	
	public boolean resuelto() {
		int index = 0; //-1 para llegar al ultimo
		while(index < fila3.length-1 && fila3[index] !=0) {
			index++;
		}
		return (index < fila3.length && fila3[index] != 0) ? true:false;
	}
	public void ImpresionPaso() {
		StringBuilder bld = new StringBuilder();
		for (int i = 0; i < fila1.length; i++) { //Todas las filas deben tener el mismo length
			bld.append(fila1[i] + "   " + fila2[i] + "   " + fila3[i]+"\n");
		}
		bld.append("---------");
		System.out.println(bld.toString());
	}
}
