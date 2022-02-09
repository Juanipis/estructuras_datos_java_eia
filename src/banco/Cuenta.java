package banco;

import java.util.Arrays;
import java.util.Date;

public class Cuenta {
	private String codigo;
	private Date fechaCreacion;
	private double saldo;
	private double[] depositos;
	private static int contadorCuentas = 0;
	
	public Cuenta(double saldo) {
		this.codigo = "" + contadorCuentas++;
		this.fechaCreacion = new Date();
		this.saldo = saldo;
		this.depositos = new double[0];
	}
	
	public void hacerDeposito(double deposito) {
		this.setSaldo(this.getSaldo()+deposito);
		this.depositos = Arrays.copyOf(this.depositos, this.depositos.length+1);
		this.depositos[this.depositos.length-1] = deposito;
	}
	
	public boolean retirar(double retiro) {
		if(retiro < this.getSaldo()) {
			this.setSaldo(this.getSaldo()-retiro);
			return true;
		}
		else {
			return false;
		}
	}
		
	public double getSaldo() {
		return saldo;
	}

	protected void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getCodigo() {
		return codigo;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	
	protected double[] getDepositos() {
		return this.depositos;
	}
	
	public void setIntereses() {
		//Por defecto hacemos el de cuenta corriente
		this.setSaldo((this.getSaldo()*3)/100 + this.getSaldo());
	}

	@Override
	public String toString() {
		return "Cuenta [codigo=" + codigo + ", saldo=" + saldo + "]";
	}
	
	
}
