package Ayudantia2Lab2;

public class EmpleadoPorHoras extends Empleado {

	private int horasTrabajadas;
	private int precioHoras;

	public EmpleadoPorHoras(String nombre, String salarioBase, int horasTrabajadas, int precioHoras) {
		super(nombre, salarioBase);
		this.horasTrabajadas = horasTrabajadas;
		this.precioHoras = precioHoras;
	}

	public String getTipo() {
		return "Empleado por Horas";
	}

	public String calcularSalario() {
		return String.valueOf(horasTrabajadas * precioHoras);
	}
}