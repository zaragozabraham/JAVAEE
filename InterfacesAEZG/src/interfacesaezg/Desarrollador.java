package interfacesaezg;

// @author Zaragoza
public class Desarrollador implements Interfaz{
    private String nombre;
    private String lineasDeCodigo;
    
    // Constructor.
    public Desarrollador(String nombre, String lineas){
        setNombre(nombre);
        setLineasDeCodigo(lineas);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLineasDeCodigo() {
        return lineasDeCodigo;
    }

    public void setLineasDeCodigo(String lineasDeCodigo) {
        this.lineasDeCodigo = lineasDeCodigo;
    }

    // Implementación de métodos de Interfaz.
    @Override
    public String encenderObjeto() {
        String response = "Soy el Desarrollador" +getNombre()+", encendí mi computadora.";
        return response;
    }

    @Override
    public String maniobrarObjeto() {
        String response = "Soy el Desarrollador"+getNombre()+", y llevo más de "+getLineasDeCodigo()+" líneas codificadas.";
        return response;
    }

    @Override
    public String apagarObjeto() {
        String response = "Soy el Desarrollador"+getNombre()+", apagué mi computadora.";
        return response;
    }
}
