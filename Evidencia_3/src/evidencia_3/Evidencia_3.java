package evidencia_3;
// @author Zaragoza

import java.util.Scanner;

public class Evidencia_3 {

    public static void main(String[] args) {
        int n, i = 0, j = 0, k = 0, edades=0;
        int hombres=0, mujeres=0, hymc=0, hyms=0;
        float ed_prom, ph, pm, pc, ps;
        String[][] encuesta;
        Boolean on = true;

        Scanner input = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de encuestas a registrar: ");
        n = input.nextInt();

        encuesta = new String[n][4];

        do {
            // Variable respuesta, indica si el procedo debe continuar o no.
            int respuesta = 1, u, temp=0;
            Boolean hombre=false, mujer=false, casado=false, soltero=false;
            u = i + 1;

            // Bloque de ingreso de datos.
            System.out.println("Ingresa el nombre de la persona #" + u + ": ");
            encuesta[i][0] = input.next();

            System.out.println("Ingresa la edad de la persona #" + u + ": ");
            encuesta[i][1] = input.next();
            // Sumatoria de edades.
            temp = Integer.parseInt(encuesta[i][1]);
            edades += temp;
            
            System.out.println("Ingresa el estado civil de la persona #" + u + " (1.Casado, 2.Soltero): ");
            encuesta[i][2] = input.next();
            // Conteo de estado civil registrado.
            temp = Integer.parseInt(encuesta[i][2]);
            if(temp == 1){
                casado = true;
                hymc++;
            }else{
                soltero = true;
                hyms++;
            }
            
            System.out.println("Ingresa el sexo de la persona #" + u + " (1.Mujer 2.Hombre): ");
            encuesta[i][3] = input.next();
            // Conteo de hombres y mujeres registradas.
            temp = Integer.parseInt(encuesta[i][3]);
            if(temp == 2){
                hombre = true;
                hombres++;
            }else{
                mujer = true;
                mujeres++;
            }
            

            i++;
            hombre=false;
            mujer=false;
            casado=false;
            soltero=false;

            // Si se llega al total de encuestas, el proceso se detiene en automático.
            if (i == n) {
                on = false;
            } else {
                // El usuario puede dejar de ingresar datos manualmente.
                System.out.println("¿Desea seguir ingresando datos? (1.Si 2.No)");
                respuesta = input.nextInt();

                if (respuesta != 1) {
                    on = false;
                }
            }
        } while (on == true);
        
        // Calculo de resultados.
        ed_prom = edades/(i);
        ph = (hombres*100)/(i);
        pm = (mujeres*100)/(i);
        pc = (hymc*100)/(i);
        ps = (hyms*100)/(i);
        
        // Impresión de resultados.
        System.out.println("La cantidad de personas capturadas es: "+i);
        System.out.println("El promedio de edad de las personas capturadas es: "+ed_prom);
        System.out.println("El porcentaje de hombres es: "+ph);
        System.out.println("El porcentaje de mujeres es: "+pm);
        System.out.println("El porcentaje de hombres y mujeres casados es: "+pc);
        System.out.println("El porcentaje de hombres y mujeres solteros es: "+ps);
        
    }

}
