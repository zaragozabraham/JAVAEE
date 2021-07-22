package evidencia_6;

// @author Zaragoza

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Evidencia_6 {
    public static void main(String[] args) throws IOException {
        // Objetos de Escritura.
        FileWriter file = null;
        PrintWriter write = null;
        
        // Objetos de Lectura.
        File fileR = null;
        FileReader read = null;
        BufferedReader reader = null;
        
        // Escritura de archivo nuevo con el nombre AEZG.
        try{
            file = new FileWriter("..\\AEZG.txt");
            write = new PrintWriter(file);
            String content = "Abraham Enrique Zaragoza García";
            write.println(content);
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        finally{
            write.close();
        }
        
        // Lectura del archivo creado previamente.
        try{
            fileR = new File("..\\AEZG.txt");
            read = new FileReader(fileR);
            reader = new BufferedReader(read);
            String content = "";
            while((content = reader.readLine()) != null){
                System.out.println(content);
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        finally{
            try{
                read.close();
            } // Se busca un error en caso de no encontrar el archivo.
            catch(IOException ex){
                System.out.println(ex.toString());
            }
        }
    }
    
}
