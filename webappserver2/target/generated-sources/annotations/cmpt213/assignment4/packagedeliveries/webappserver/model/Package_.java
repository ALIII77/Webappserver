package cmpt213.assignment4.packagedeliveries.webappserver.model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Package.class)
public abstract class Package_ extends cmpt213.assignment4.packagedeliveries.webappserver.base.BaseEntity_ {

	public static volatile SingularAttribute<Package, String> note;
	public static volatile SingularAttribute<Package, Double> price;
	public static volatile SingularAttribute<Package, LocalDateTime> expectedDeliveryDate;
	public static volatile SingularAttribute<Package, String> name;
	public static volatile SingularAttribute<Package, Double> weight;
	public static volatile SingularAttribute<Package, Boolean> delivered;

	public static final String NOTE = "note";
	public static final String PRICE = "price";
	public static final String EXPECTED_DELIVERY_DATE = "expectedDeliveryDate";
	public static final String NAME = "name";
	public static final String WEIGHT = "weight";
	public static final String DELIVERED = "delivered";

}

