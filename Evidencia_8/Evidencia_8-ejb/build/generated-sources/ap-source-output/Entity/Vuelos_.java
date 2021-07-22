package Entity;

import Entity.Aviones;
import Entity.Ciudades;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-02-18T23:46:55")
@StaticMetamodel(Vuelos.class)
public class Vuelos_ { 

    public static volatile SingularAttribute<Vuelos, Date> horaFin;
    public static volatile SingularAttribute<Vuelos, Integer> noVuelo;
    public static volatile SingularAttribute<Vuelos, Integer> noPasajeros;
    public static volatile SingularAttribute<Vuelos, Date> fechaInicio;
    public static volatile SingularAttribute<Vuelos, Aviones> noDeAvion;
    public static volatile SingularAttribute<Vuelos, Long> id;
    public static volatile SingularAttribute<Vuelos, Ciudades> origen;
    public static volatile SingularAttribute<Vuelos, Ciudades> destino;
    public static volatile SingularAttribute<Vuelos, Date> fechaFin;
    public static volatile SingularAttribute<Vuelos, Date> horaInicio;

}