package com.empleados.appgestionempleados;

import static com.empleados.appgestionempleados.Menu.ingresarDatos;
import static com.empleados.appgestionempleados.Menu.mostrarMenu;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import logica.Empleado;
import static logica.Exception.validarApellido;
import static logica.Exception.validarCargo;
import static logica.Exception.validarFecha;
import static logica.Exception.validarNombre;
import static logica.Exception.validarSalario;
import persistencia.ControladoraPersistencia;


public class AppGestionEmpleados {

    public static void main(String[] args) {
        
        ControladoraPersistencia controlPersis = new ControladoraPersistencia();
        Scanner teclado = new Scanner(System.in);
        int opcion=0;
        

        System.out.println("\nGestor de empleados\n");

        while (opcion != 6) {

            mostrarMenu();
            System.out.println("Seleccione una opción: ");

            try {

                opcion = teclado.nextInt();
                teclado.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("\nIngrese los datos del empleado: ");
                        Empleado nuevoEmpleado = ingresarDatos();
                        controlPersis.crearEmpleado(nuevoEmpleado);
                        System.out.println("\nSe agregó correctamente");

                        break;

                    case 2:
                        System.out.println("\nTodos los empleados: ");
                        List<Empleado> listaEmpleados = controlPersis.traerEmpleados();

                        for (Empleado emp : listaEmpleados) {
                            
                            System.out.println("\nId: " + emp.getId());
                            System.out.println("Nombre: " + emp.getNombre());
                            System.out.println("Apellido: " + emp.getApellido());
                            System.out.println("Cargo: " + emp.getCargo());
                            System.out.println("Salario: " + emp.getSalario());
                        }

                        break;

                    case 3:
                        System.out.println("\nPor favor, indique el Id del empleado a actualizar: ");
                        int id = teclado.nextInt();
                        teclado.nextLine();
                        Empleado empleado = controlPersis.traerEmpleado(id);
                        Empleado datos_Actualizados = ingresarDatos();
                        empleado.setNombre(datos_Actualizados.getNombre());
                        empleado.setApellido(datos_Actualizados.getApellido());
                        empleado.setCargo(datos_Actualizados.getCargo());
                        empleado.setSalario(datos_Actualizados.getSalario());
                        empleado.setFecha_ingreso(datos_Actualizados.getFecha_ingreso());

                        controlPersis.modificarEmpleado(empleado);
                        System.out.println("\nEmpleado actualizado exitosamente.");

                        break;

                    case 4:
                        System.out.println("\nIndique el Id del empleado para borrar el registro");
                        int borrar_id = teclado.nextInt();
                        teclado.nextLine();

                        Empleado empleadoABorrar = controlPersis.traerEmpleado(borrar_id);

                        if (empleadoABorrar != null) {

                            controlPersis.borrarEmpleado(borrar_id);
                            System.out.println("\nEmpleado borrado exitosamente.");
                        } else {

                            System.out.println("\nNo se encontró un empleado con el ID ");
                        }

                        break;

                    case 5:
                        System.out.println("\nPara realizar la búsqueda indique el cargo:");
                        String puestos = teclado.nextLine().trim();

                        List<Empleado> empleadosEncontrados = controlPersis.traerEmpleadoPorCargo(puestos);

                        if (empleadosEncontrados != null && !empleadosEncontrados.isEmpty()) {
                            System.out.println("\nEmpleados con el cargo " + puestos + ":");
                            for (Empleado emp : empleadosEncontrados) {
                                System.out.println("\nId: " + emp.getId());
                                System.out.println("Nombre: " + emp.getNombre());
                                System.out.println("Apellido: " + emp.getApellido());
                                System.out.println("Cargo: " + emp.getCargo());
                                System.out.println("Salario: " + emp.getSalario());                                
                            }
                        } else {
                            System.out.println("\nNo se encontraron empleados con el cargo '" + puestos + "'.");
                        }
                        break;



                    default:
                        System.out.println("\nIngrese solo las opciones ofrecidas");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nPor favor, ingrese un número válido");
                teclado.next();
            }
        }

        teclado.close();

    }



    

}
            
    

