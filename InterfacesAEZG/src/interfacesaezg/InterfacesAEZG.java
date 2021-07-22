package interfacesaezg;

// @author Zaragoza
public class InterfacesAEZG {
    public static void main(String[] args) {
        // Definición de nuevo Piloto, Desarrollador y Cocinero.
        Piloto a = new Piloto("Luis Gerardo", "12");
        Desarrollador b = new Desarrollador("Mario López", "2000");
        Cocinero c = new Cocinero("Antonio Sanchez", "3000");
        
        // Impresión de los tres metodos del Piloto.
        System.out.println(a.encenderObjeto());
        System.out.println(a.maniobrarObjeto());
        System.out.println(a.apagarObjeto()+"\n");
        
        // Impresión de los tres metodos del Desarrollador.
        System.out.println(b.encenderObjeto());
        System.out.println(b.maniobrarObjeto());
        System.out.println(c.apagarObjeto()+"\n");
        
        // Impresión de los tres metodos del Cocinero.
        System.out.println(c.encenderObjeto());
        System.out.println(c.maniobrarObjeto());
        System.out.println(c.apagarObjeto()+"\n");
        
    }
    
}
