package com.empleados.appgestionempleados;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import logica.Empleado;
import static logica.Exception.validarApellido;
import static logica.Exception.validarCargo;
import static logica.Exception.validarFecha;
import static logica.Exception.validarNombre;
import static logica.Exception.validarSalario;


public class Menu {
    public static void mostrarMenu() {

        
        System.out.println("************************************");
        System.out.println("           MENÚ PRINCIPAL           ");
        System.out.println("************************************");
        System.out.println("       1) ALTA DE EMPLEADO          ");
        System.out.println("       2) MOSTRAR EMPLEADO          ");
        System.out.println("       3) MODIFICAR EMPLEADO        ");
        System.out.println("       4) BAJA DE EMPLEADO          ");
        System.out.println("       5) BUSCAR EMPLEADOS          ");
        System.out.println("       6) SALIR                     ");
        System.out.println("|************************************|\n");
    }

    public static Empleado ingresarDatos() {
        Empleado empleado = new Empleado();
        Scanner teclado = new Scanner(System.in);
        String name = null;
        boolean nombreValido = false;

        while (nombreValido != true) {

            try {
                System.out.print("Nombre: ");
                String nombre = teclado.nextLine().trim();
                validarNombre(nombre);
                nombreValido = true;
                empleado.setNombre(nombre);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String lastname = null;
        boolean apellidoValido = false;

        while (apellidoValido != true) {

            try {
                System.out.print("Apellido: ");
                String apellido = teclado.nextLine();
                validarApellido(apellido);
                apellidoValido = true;
                empleado.setApellido(apellido);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String position = null;
        boolean cargoValido = false;

        while (cargoValido != true) {

            try {
                System.out.print("Cargo: ");
                String cargo = teclado.nextLine();
                validarCargo(cargo);
                cargoValido = true;
                empleado.setCargo(cargo);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        double salary = 0.0;
        boolean salarioValido = false;

        while (salarioValido != true) {
            try {
                System.out.print("Salario: ");
                double salario = teclado.nextDouble();
                teclado.nextLine();
                validarSalario(salario);
                salarioValido = true;
                empleado.setSalario(salario);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        boolean validarfecha = false;

        while (validarfecha != true) {
            try {
                System.out.print("Ingresa la fecha en el siguiente formato yyyy-mm-dd : ");
                String fechaIngreso = teclado.nextLine().trim();
                LocalDate fecha = LocalDate.parse(fechaIngreso);
                validarFecha(fecha);
                validarfecha = true;
                empleado.setFecha_ingreso(fecha);
            } catch (DateTimeParseException e) {
                System.out.println("Fecha incorrecta");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return empleado;    
}
}