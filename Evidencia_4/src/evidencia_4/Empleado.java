package evidencia_4;

public class Empleado {
    protected String nombre;
    protected int cedula;
    protected int edad;
    protected String estadoCivil;
    protected double salario;
    protected String clasificacion;
    
    // Constructor de la clase Empleado.
    Empleado(String nombre, int cedula, int edad, String estadoCivil, double salario){
        setNombre(nombre);
        setCedula(cedula);
        setEdad(edad);
        setEstadoCivil(estadoCivil);
        setSalario(salario);
    }
    
    // Método asignarClasificacion
    public String asignarClasificacion() {
        if(this.edad<= 21){
            this.clasificacion = "Principiante";
        }else if(this.edad >= 22 && this.edad <=35){
            this.clasificacion = "Intermedio";
        }else if(this.edad > 35){
            this.clasificacion = "Senior";
        }else{
            this.clasificacion="";
        }
        return this.clasificacion;
    }
    
    // Método Imprimir.
    public String Imprimir() {
        return "Empleado: "+getNombre()+"\nCedula: "+getCedula()+"\nEdad: "+getEdad()+"\nEstado Civil: "+getEstadoCivil()+"\nSalario: "+getSalario()+"\nClasificación: "+asignarClasificacion()+"\n";
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificación) {
        this.clasificacion = clasificación;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
