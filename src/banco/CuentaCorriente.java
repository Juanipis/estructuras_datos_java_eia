package banco;


public class CuentaCorriente extends Cuenta {

	public CuentaCorriente(double saldo) {
		super(saldo);
	}

	
	public void setIntereses() {
		super.setSaldo((super.getSaldo()*3)/100 + super.getSaldo());
	}
	

}
