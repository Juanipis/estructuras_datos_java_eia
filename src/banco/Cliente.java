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
		this.cuenta = new Cuenta(tipoCuenta, saldo);
	}
	
	public boolean retirar(double retiro) {
		return this.cuenta.retirar(retiro);
	}
	
	public String getCC() {
		return CC;
	}
}
