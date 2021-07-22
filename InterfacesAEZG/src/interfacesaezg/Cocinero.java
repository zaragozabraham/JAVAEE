package interfacesaezg;

// @author Zaragoza
public class Cocinero implements Interfaz{
    private String nombre;
    private String horasEnEstufa;
    
    // Constructor.
    public Cocinero(String nombre, String horas){
        setNombre(nombre);
        setHorasEnEstufa(horas);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorasEnEstufa() {
        return horasEnEstufa;
    }

    public void setHorasEnEstufa(String horasEnEstufa) {
        this.horasEnEstufa = horasEnEstufa;
    }

    // Implementación de métodos de Interfaz.
    @Override
    public String encenderObjeto() {
        String response = "Soy el Cocinero"+getNombre()+", encendí mi estufa.";
        return response;
    }

    @Override
    public String maniobrarObjeto() {
        String response = "Soy el Cocinero"+getNombre()+", y llevo más de "+getHorasEnEstufa()+" horas en la estufa.";
        return response;
    }

    @Override
    public String apagarObjeto() {
        String response = "Soy el Cocinero"+getNombre()+", apagué mi estufa.";
        return response;
    }
}
