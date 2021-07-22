package pia1;

// @author Zaragoza
import java.util.Scanner;

public class PIA1 {

    public static void main(String[] args) {
        int pElectrodomesticos = 0, pLavadora = 0, pTelevision = 0,
                precioBase = 0, peso = 0, carga = 0, resolucion = 0;
        String color;
        char consumo;
        Boolean tdt = false, var = true;
        
        // Creación de Objeto electrodomesticos.
        Electrodomestico[] electrodomesticos = new Electrodomestico[10];

        Scanner input = new Scanner(System.in);
        
        // Se da la opción de ingresar los datos manualmente o ejecutar el código default.
        System.out.println("Desea ingresar los datos o correr automaticamente el programa. 1. Manual 2. Automático");
        int desicion = input.nextInt();

        if (desicion == 2) {
            
            // Se rellena automaticamente cada electrodomestico.
            electrodomesticos[0] = new Television(500, "rojo", 'f', 100, 25, true);
            electrodomesticos[1] = new Electrodomestico(800, "rojo", 'e', 100);
            electrodomesticos[2] = new Electrodomestico(500, "negro", 'a', 50);
            electrodomesticos[3] = new Lavadora(700, "blanco", 'c', 100, 50);
            electrodomesticos[4] = new Television(200, "gris", 'f', 10, 32, true);
            electrodomesticos[5] = new Television(1200, "negro", 'd', 12, 52, true);
            electrodomesticos[6] = new Electrodomestico(2000, "blanco", 'a', 60);
            electrodomesticos[7] = new Electrodomestico(1250, "negro", 'c', 50);
            electrodomesticos[8] = new Lavadora(2300, "blanco", 'a', 80, 28);
            electrodomesticos[9] = new Television(1200, "negro", 'e', 8, 42, false);

        } else {
            // Se recorre electrodomesticos desde su posición 0 a las 9.
            for (Electrodomestico producto : electrodomesticos) {
                System.out.println("Ingrese el tipo de producto: 1. Electrodomestico 2. Lavadora 3. Television ");
                int tipo = input.nextInt();
                while (true) {
                    try {
                        System.out.println("Ingrese el precio base ");
                        precioBase = input.nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.println(e.toString());
                        input.next();
                    }
                }
                var = true;

                System.out.println("Ingrese el color (blanco, negro, rojo, azul y gris) ");
                color = input.next().toLowerCase();

                System.out.println("Ingrese el consumo del producto (a, b, c, d, e, f) ");
                consumo = input.next().charAt(0);

                do {
                    try {
                        System.out.println("Ingrese el peso del producto ");
                        peso = input.nextInt();
                        var = false;
                    } catch (Exception e) {
                        System.out.println(e.toString());
                        input.next();
                    }
                } while (var);
                var = true;

                switch (tipo) {
                    case 2:
                        // Lavadora
                        do {
                            try {
                                System.out.println("Ingrese la carga soportada ");
                                carga = input.nextInt();
                                var = false;
                            } catch (Exception e) {
                                System.out.println(e.toString());
                                input.next();
                            }
                        } while (var);
                        var = true;

                        producto = new Lavadora(precioBase, color, consumo, peso, carga);
                        break;
                    case 3:
                        // Television
                        do {
                            try {
                                System.out.println("Ingrese la resolución del producto ");
                                resolucion = input.nextInt();
                                var = false;
                            } catch (Exception e) {
                                System.out.println(e.toString());
                                input.next();
                            }
                        } while (var);
                        var = true;

                        do {
                            try {
                                System.out.println("Ingrese si el producto presenta sintonizador TDT (true o false) ");
                                tdt = input.nextBoolean();
                                var = false;
                            } catch (Exception e) {
                                System.out.println(e.toString());
                                input.next();
                            }
                        } while (var);
                        var = true;

                        producto = new Television(precioBase, color, consumo, peso, resolucion, tdt);
                    default:
                        producto = new Electrodomestico(precioBase, color, consumo, peso);
                        break;
                }
            }
        }
        
        // Se recorre electrodomesticos, en base a su Clase se añade su precioFinal a su categoria correspondiente.
        for (Electrodomestico item : electrodomesticos) {
            int precio;
            item.comprobarColor();
            item.comprobarConsumoEnergetico();

            if (item.getClass() == Lavadora.class) {
                precio = item.precioFinal();
                pLavadora += precio;
            } else if (item.getClass() == Television.class) {
                precio = item.precioFinal();
                pTelevision += precio;
            } else {
                precio = item.precioFinal();
            }

            pElectrodomesticos += precio;

        }
        
        // Se imprime individualmente cada categoria de precioFInal.
        System.out.println("El precio total de Lavadoras es " + pLavadora);
        System.out.println("El precio total de Lavadoras es " + pTelevision);
        System.out.println("El precio total de Lavadoras es " + pElectrodomesticos);

    }

}
