package evidencia_1;

import java.util.Scanner;

// @author Zaragoza
 
public class Evidencia_1 {
    public static void main(String[] args) {
        // Declaración de variables donde se alojara la información dada por el usuario.
        String nombre;
        int entero;
        float decimal, suma;
        
        // Definición de nuevo Scanner como objeto 'input'.
        Scanner input = new Scanner(System.in);
        
        // Solcitud de datos y escaneo de los mismos.
        System.out.println("Ingrese su nombre: ");
        nombre = input.nextLine();
        
        System.out.println("Ingrese un número entero: ");
        entero = input.nextInt();
        
        System.out.println("Ingrese un número decimal: ");
        decimal = input.nextFloat();
        
        // Realización de la suma
        suma = entero+decimal;
        
        // Impresión final con concatenación de variables y texto.
        System.out.println("Hola "+nombre+", el resultado de la suma entre "+entero+" y "+decimal+" es "+suma+".");
    }
    
}
