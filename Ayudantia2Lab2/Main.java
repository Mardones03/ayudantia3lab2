package Ayudantia2Lab2;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		String archivoEmpleados = "empleados.txt"; // Nombre del archivo donde se guardar�n los empleados

		Scanner scanner = new Scanner(System.in);
		ArrayList<Empleado> empleados = new ArrayList<>();
		GestorDatosEmpleado gestor = new GestorDatosEmpleado(archivoEmpleados);

		// Cargar empleados existentes desde el archivo .txt
		ArrayList<Empleado> empleadosCargados = gestor.cargarEmpleados();
		empleados.addAll(empleadosCargados);

		int opcion;
		do {
			System.out.println("Men�:");
			System.out.println("1. Agregar un nuevo empleado");
			System.out.println("2. Mostrar lista de empleados");
			System.out.println("3. Salir");
			System.out.print("Seleccione una opci�n: ");
			opcion = scanner.nextInt();
			scanner.nextLine(); // Limpiar el salto de l�nea

			switch (opcion) {
				case 1:
					System.out.println("Agregar un nuevo empleado:");
					System.out.print("Nombre: ");
					String nombre = scanner.nextLine();
					System.out.print("Salario Base: ");
					String salarioBase = scanner.nextLine();

					System.out.println("Seleccione el tipo de empleado:");
					System.out.println("1. Empleado Asalariado");
					System.out.println("2. Empleado por Horas");
					int tipoEmpleado = scanner.nextInt();
					scanner.nextLine(); // Limpiar el salto de l�nea

					if (tipoEmpleado == 1) {
						empleados.add(new EmpleadoAsalariado(nombre, salarioBase));
					} else if (tipoEmpleado == 2) {
						System.out.print("Horas Trabajadas: ");
						int horasTrabajadas = scanner.nextInt();
						System.out.print("Precio por Horas: ");
						int precioHoras = scanner.nextInt();
						scanner.nextLine(); // Limpiar el salto de l�nea
						empleados.add(new EmpleadoPorHoras(nombre, salarioBase, horasTrabajadas, precioHoras));
					} else {
						System.out.println("Opci�n inv�lida.");
					}
					break;
				case 2:
					System.out.println("Lista de Empleados:");
					gestor.mostrarNombresYSalarios(empleados);
					break;
				case 3:
					System.out.println("Saliendo del programa...");
					break;
				default:
					System.out.println("Opci�n inv�lida.");
			}
		} while (opcion != 3);

		// Guardar empleados en el archivo .txt al salir del programa
		gestor.guardarEmpleados(empleados);
	}

}