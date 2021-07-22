package Entity;

import Entity.Vuelos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-02-18T23:46:55")
@StaticMetamodel(Aviones.class)
public class Aviones_ { 

    public static volatile ListAttribute<Aviones, Vuelos> vuelosList;
    public static volatile SingularAttribute<Aviones, String> aerolinea;
    public static volatile SingularAttribute<Aviones, Integer> capacidadDePasajeros;
    public static volatile SingularAttribute<Aviones, Integer> noDeAvion;
    public static volatile SingularAttribute<Aviones, Long> id;
    public static volatile SingularAttribute<Aviones, String> modelo;

}