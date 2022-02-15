package excepciones;

public class Cuenta {
	private float saldo;
	private EValorNegativo errNegativo = new EValorNegativo();
	private EValorMayorSaldo errSaldo = new EValorMayorSaldo();
	
	
	public Cuenta(float saldoInicial) throws EValorNegativo{
		if(saldoInicial >=0) {
			this.saldo = saldoInicial;
		}
		else {
			throw errNegativo;
		}
		
	}
	
	public void depositar(float v) throws EValorNegativo{
		if(v>0) {
			saldo+=v;
		}
		else {
			throw errNegativo;
		}
	}
	
	public void extraer(float v) throws EValorMayorSaldo,EValorNegativo {
		if(v>0) 
			if(v<=saldo) 
				saldo-=v;
			else
				throw errSaldo;
		else
			throw errNegativo;
	}	
}
	



class EValorNegativo extends Exception{
	public EValorNegativo() {
		super("El saldo a depositar debe ser mayor que cero");
		
	}
}

class EValorMayorSaldo extends Exception{
	public EValorMayorSaldo() {
		super("El saldo a extraer debe ser mayor que cero y no puede superar el saldo actual");
		
	}
}