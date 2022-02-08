package banco;

import java.util.Date;

public class Cliente {
	private String nombre;
	private String apellidos;
	private Date fechaNacimiento; 
	private String direccion;
	private String telefono;
	private String CC;
	private Cuenta cuenta;
	
	public Cliente(String nombre, String apellidos, Date fechaNacimiento, String direccion, String telefono, String cC, char tipoCuenta, double saldo) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.CC = cC;
		//Creamos cuenta segun tipo cuenta
		
		switch (tipoCuenta) {
		case 'C': {
			this.cuenta = new CuentaCorriente(saldo);
		}
		default: //Cuenta defecto
			this.cuenta = new Cuenta(saldo);
			
		}
		
	}
	
	public boolean retirar(double retiro) {
		return this.cuenta.retirar(retiro);
	}
	
	public void hacerDeposito(double deposito) {
		this.cuenta.hacerDeposito(deposito);
	}
	
	public String getCC() {
		return CC;
	}
	
	public double getSaldo() {
		return this.cuenta.getSaldo();
	}
	
	public Cuenta getCuenta() {
		return this.cuenta;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", CC=" + CC + ", cuenta=" + cuenta + "]";
	}
}
