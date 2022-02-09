package banco;

import java.util.Arrays;
import java.util.Date;

public class Banco {
	private Cliente[] clientes;
	
	public Banco() {
		this.clientes = new Cliente[0];
	}
	
	public void addCliente(String nombre, String apellidos, Date fechaNacimiento, String direccion, String telefono, String cC, char tipoCuenta, double saldo) {
		if(this.buscarCliente(cC) == null) { //Si no existe el cliente lo creamos
			this.clientes = Arrays.copyOf(this.clientes, this.clientes.length+1);
			this.clientes[this.clientes.length-1] = new Cliente(nombre, apellidos, fechaNacimiento, direccion, telefono, cC, tipoCuenta, saldo);
		}
	}
	
	public void eliminarCliente(String CC) {
		int index = this.buscarClienteIndex(CC);
		if(index != -1) {
			Cliente[] tempClientes = new Cliente[this.clientes.length-1];
			System.arraycopy(this.clientes, 0, tempClientes, 0, index);
			System.arraycopy(this.clientes, index+1, tempClientes, index, this.clientes.length-index-1);
			this.clientes = tempClientes;
		}
	}
	
	public Cliente buscarCliente(String CC) {
		int index = 0;
		while(index < this.clientes.length && this.clientes[index] != null && !this.clientes[index].getCC().equals(CC)) index++;
		return (index < this.clientes.length && this.clientes[index] != null && this.clientes[index].getCC().equals(CC)) ? this.clientes[index] : null;
	}
	
	public int buscarClienteIndex(String CC) {
		int index = 0;
		while(index < this.clientes.length && this.clientes[index] != null && !this.clientes[index].getCC().equals(CC)) index++;
		return (index < this.clientes.length && this.clientes[index] != null && this.clientes[index].getCC().equals(CC)) ? index : -1;
	}
	
	public boolean retirarDepositoCliente(String CC,double retiro) {
		return this.buscarCliente(CC).retirar(retiro);
	}
	
	public void hacerDepositoCliente(String CC, double deposito) {
		this.buscarCliente(CC).hacerDeposito(deposito);
	}
	
	public double mostrarSaldo(String CC) {
		return  this.buscarCliente(CC).getSaldo();
	}
	
	public Cuenta buscarCuenta(String nCuenta) {
		int index = 0;
		while(index < this.clientes.length && this.clientes[index] != null && !this.clientes[index].getCuenta().getCodigo().equals(nCuenta)) index++;
		return (index < this.clientes.length && this.clientes[index] != null && this.clientes[index].getCuenta().getCodigo().equals(nCuenta)) ? this.clientes[index].getCuenta() : null;
	}
	
	public void hacerInteresesMes() {
		for(Cliente cl : this.clientes) {
			if(cl != null) {
				cl.getCuenta().setIntereses();
			}
		}
	}
	
	public String reporteCuenta(String CC) {
		Cliente cl = this.buscarCliente(CC);
		if(cl != null) {
			String tipoCuenta= "";
			if(cl.getCuenta() instanceof CuentaCorriente ) {tipoCuenta = "Corriente";}
			else if(cl.getCuenta() instanceof CuentaEspecial ) {tipoCuenta = "Especial";}
			StringBuilder bl = new StringBuilder();
			bl.append("Nombre: " + cl.getNombre() + " " + cl.getApellidos() + "\n");
			bl.append("#Cuenta : " + cl.getCuenta().getCodigo() + " | Tipo : " + tipoCuenta + "\n");
			bl.append("Saldo : " + cl.getCuenta().getSaldo() + "\n");
			bl.append("Depositos : " + Arrays.toString(cl.getCuenta().getDepositos()));
			return bl.toString();
		}
		else {
			return null;
		}
		
	}

	@Override
	public String toString() {
		return "Banco [clientes=" + Arrays.toString(clientes) + "]";
	}
	
	
}
