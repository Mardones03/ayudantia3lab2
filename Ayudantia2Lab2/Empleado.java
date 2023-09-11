package Ayudantia2Lab2;

public abstract class Empleado {
	protected String nombre;
	protected String salarioBase;
	public Empleado(String nombre, String salarioBase){
		this.nombre = nombre;
		this.salarioBase = salarioBase;
	}
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSalarioBase() {
		return this.salarioBase;
	}

	public void setSalarioBase(String salarioBase) {
		this.salarioBase = salarioBase;
	}

	public abstract String getTipo();

	public abstract String calcularSalario();
}