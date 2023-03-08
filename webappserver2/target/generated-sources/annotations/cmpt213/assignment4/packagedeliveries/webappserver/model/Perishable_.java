package cmpt213.assignment4.packagedeliveries.webappserver.model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Perishable.class)
public abstract class Perishable_ extends cmpt213.assignment4.packagedeliveries.webappserver.model.Package_ {

	public static volatile SingularAttribute<Perishable, LocalDateTime> expiryDate;

	public static final String EXPIRY_DATE = "expiryDate";

}

