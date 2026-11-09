package banco;

public class CuentaEspecial extends Cuenta {

	public CuentaEspecial(double saldo) {
		super(saldo);
		// TODO Auto-generated constructor stub
	}
	public void setIntereses() {
		double saldito = 0;
		int i = super.getDepositos().length-1;
		int b = 1;
		while(i >= 0 && b<=3) {
			saldito += (super.getDepositos()[i]*3)/100;
		}
		super.setSaldo(saldito + super.getSaldo()/100 + super.getSaldo());
	}

}
