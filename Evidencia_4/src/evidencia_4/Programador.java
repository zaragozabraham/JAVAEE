package evidencia_4;

public class Programador extends Empleado {
    private int lineasDeCodigoPorHora;
    private String lenguajeDominante;
    
    // Consturcor de Programador.
    public Programador(String nombre, int cedula, int edad, String estadoCivil, double salario, int lineas, String lenguaje) {
        super(nombre, cedula, edad, estadoCivil, salario);
        setLineasDeCodigoPorHora(lineas);
        setLenguajeDominante(lenguaje);
    }

    public int getLineasDeCodigoPorHora() {
        return lineasDeCodigoPorHora;
    }

    public void setLineasDeCodigoPorHora(int lineasDeCodigoPorHora) {
        this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
    }

    public String getLenguajeDominante() {
        return lenguajeDominante;
    }

    public void setLenguajeDominante(String lenguajeDominante) {
        this.lenguajeDominante = lenguajeDominante;
    }
    
    
}
