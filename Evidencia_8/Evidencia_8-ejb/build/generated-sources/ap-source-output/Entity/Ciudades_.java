package Entity;

import Entity.Estados;
import Entity.Vuelos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-02-18T23:46:55")
@StaticMetamodel(Ciudades.class)
public class Ciudades_ { 

    public static volatile SingularAttribute<Ciudades, Estados> estado;
    public static volatile ListAttribute<Ciudades, Vuelos> origenList;
    public static volatile ListAttribute<Ciudades, Vuelos> destinosList;
    public static volatile SingularAttribute<Ciudades, Long> id;
    public static volatile SingularAttribute<Ciudades, String> nombre;

}