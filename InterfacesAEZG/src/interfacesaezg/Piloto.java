package interfacesaezg;

// @author Zaragoza
public class Piloto implements Interfaz{
    private String nombre;
    private String aniosVolando;
    
    // Constructor.
    public Piloto(String nombre, String aniosVolando){
        setNombre(nombre);
        setAniosVolando(aniosVolando);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAniosVolando() {
        return aniosVolando;
    }

    public void setAniosVolando(String aniosVolando) {
        this.aniosVolando = aniosVolando;
    }

    // Implementación de métodos de Interfaz.
    @Override
    public String encenderObjeto() {
        String response = "Soy el Piloto "+getNombre()+", encendí mi nave.";
        return response;
    }

    @Override
    public String maniobrarObjeto() {
        String response = "Soy el Piloto "+getNombre()+", y llevo más de "+getAniosVolando()+" años volando.";
        return response;
    }

    @Override
    public String apagarObjeto() {
        String response = "Soy el Piloto "+getNombre()+", apagué mi nave.";
        return response;
    }
}
