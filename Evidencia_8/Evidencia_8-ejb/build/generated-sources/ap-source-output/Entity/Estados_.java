package Entity;

import Entity.Ciudades;
import Entity.Paises;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-02-18T23:46:55")
@StaticMetamodel(Estados.class)
public class Estados_ { 

    public static volatile ListAttribute<Estados, Ciudades> ciudadList;
    public static volatile SingularAttribute<Estados, Long> id;
    public static volatile SingularAttribute<Estados, String> nombre;
    public static volatile SingularAttribute<Estados, Paises> pais;

}