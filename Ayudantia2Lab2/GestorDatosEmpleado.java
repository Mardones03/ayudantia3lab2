package Ayudantia2Lab2;

import java.io.*;
import java.util.ArrayList;

public class GestorDatosEmpleado {
    private String archivoEmpleados;

    public GestorDatosEmpleado(String archivoEmpleados) {
        this.archivoEmpleados = archivoEmpleados;
    }

    public void guardarEmpleados(ArrayList<Empleado> empleados) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivoEmpleados))) {
            for (Empleado empleado : empleados) {
                writer.println(empleado.getTipo());
                writer.println(empleado.getNombre());
                writer.println(empleado.getSalarioBase());
            }
            System.out.println("Datos de empleados guardados en " + archivoEmpleados);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Empleado> cargarEmpleados() {
        ArrayList<Empleado> empleados = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoEmpleados))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String tipo = linea;
                String nombre = reader.readLine();
                String salarioBase = reader.readLine();

                if (tipo.equals("Empleado Asalariado")) {
                    empleados.add(new EmpleadoAsalariado(nombre, salarioBase));
                } else if (tipo.equals("Empleado por Horas")) {
                    int horasTrabajadas = Integer.parseInt(reader.readLine());
                    int precioHoras = Integer.parseInt(reader.readLine());
                    empleados.add(new EmpleadoPorHoras(nombre, salarioBase, horasTrabajadas, precioHoras));
                }
            }
            System.out.println("Datos de empleados cargados desde " + archivoEmpleados);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return empleados;
    }

    public void mostrarNombresYSalarios(ArrayList<Empleado> empleados) {
        for (Empleado empleado : empleados) {
            System.out.println("Nombre: " + empleado.getNombre());
            System.out.println("Salario: " + empleado.calcularSalario());
            System.out.println();
        }
    }
}