package ec.edu.uce.titulacion.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Plan.class)
public abstract class Plan_ {

	public static volatile SingularAttribute<Plan, Integer> idPlan;
	public static volatile SingularAttribute<Plan, Date> fecha;
	public static volatile SingularAttribute<Plan, String> tema;
	public static volatile ListAttribute<Plan, Usuario> usuarioList;

}

