package evidencia_2;

// @author Zaragoza

import java.util.Scanner;

public class Evidencia_2 {
    public static void main(String[] args) {
        int radio;
        Scanner input = new Scanner(System.in);
        
        // Solicitu de valor y guardado del mismo en una variable.
        System.out.println("Ingrese el valor de radio: ");
        radio = input.nextInt();
        
        // Llamado a los metodos con la variable radio como parametro.
        System.out.println("Circunferencia: "+calcularCircunferencia(radio));
        System.out.println("Area: "+calcularArea(radio));
    }
    
    // Definicion de metodos estáticos.
    static double calcularCircunferencia(int radio){
        double c;
        c = 2*Math.PI*radio;
        return c;
    }
    
    static double calcularArea(int radio){
        double area;
        area = (Math.PI*Math.pow(radio,2));
        return area;
    }
}
