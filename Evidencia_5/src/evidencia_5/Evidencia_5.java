package evidencia_5;

// @author Zaragoza
import java.util.Scanner;

public class Evidencia_5 {

    public static void main(String[] args) {
        Boolean on = true;
        int i = 0, n;
        // Se define un mensaje de error.
        String errEdad = "La edad capturada no pertenece al rango permitido (18 a 45 años), favor de capturar nuevamente.";

        Scanner input = new Scanner(System.in);

        // Se define la cantidad de empleados a ingresar.
        System.out.println("Ingrese la cantidad de empleados: ");
        n = input.nextInt();

        Empleado[] empleados = new Empleado[n];

        // 
        for (i = 0; i < n; i++) {
            int response = 0, cedula = 0, edad = 0, lineas = 0;
            double salario = 0;
            String nombre = "", estadoCivil = "", lenguaje = "";
            Boolean edadCheck = true, salarioCheck = true;

            System.out.println("¿El empleado es programador? (1.Si 2.No) ");
            response = input.nextInt();

            System.out.println("Ingrese el nombre: ");
            nombre = input.next();

            System.out.println("Ingrese la cedula: ");
            cedula = input.nextInt();

            while (true) {
                try {
                    System.out.println("Ingrese la edad: ");
                    edad = input.nextInt();

                    if (edad < 18 | edad > 45) {
                        // throw de la excepción personalizada
                        throw new EdadCustomException(errEdad);
                    }
                    break;

                } catch (Exception e) {
                    System.out.println("Error de ejecución " + e.toString());
                    input.next();
                }
            }

            System.out.println("Ingrese el estado civil: ");
            estadoCivil = input.next();

            while (true) {
                try {
                    System.out.println("Ingrese el salario: ");
                    salario = input.nextDouble();
                    break;

                } catch (Exception e) {
                    System.out.println("Error de ejecución " + e.toString());
                    input.next();
                }
            }

            if (response == 1) {
                System.out.println("Ingrese las lineas de código por hora: ");
                lineas = input.nextInt();

                System.out.println("Ingrese el lenguaje dominante: ");
                lenguaje = input.next();

                empleados[i] = new Programador(nombre, cedula, edad, estadoCivil, salario, lineas, lenguaje);
            } else {
                empleados[i] = new Empleado(nombre, cedula, edad, estadoCivil, salario);
            }
        }

        System.out.println("\n");
        for (Empleado empleado : empleados) {
            System.out.println(empleado.Imprimir());
        }
    }

}

// Creación de una Excepción personalizada.
class EdadCustomException extends Exception {

    public EdadCustomException(String message) {
        super(message);
    }
}
