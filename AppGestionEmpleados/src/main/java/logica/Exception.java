package logica;

import java.time.LocalDate;


public class Exception {
    public static void validarNombre(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Escriba el nombre nuevamenre");
        }
    }

    public static void validarApellido(String lastname) {
        if (lastname == null || lastname.trim().isEmpty()) {
            throw new IllegalArgumentException("Escriba el apellido nuevamenre");
        }
    }

    public static void validarCargo(String position) {
        if (position == null || position.trim().isEmpty()) {
            throw new IllegalArgumentException("Escriba el cargo nuevamenre");
        }
    }

    public static void validarSalario(double salary) {

        if (salary <= 0) {
            throw new IllegalArgumentException("Salario debe ser mayor a 0");
        }

    }

    public static void validarFecha(LocalDate datein) {
        if (datein.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de ingreso no puede ser en el futuro");
        }
    }

}
