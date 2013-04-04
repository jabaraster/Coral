package jabara.coral.entity;

import jabara.jpa.entity.EntityBase_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-04-05T00:07:20.337+0900")
@StaticMetamodel(EItem.class)
public class EItem_ extends EntityBase_ {
	public static volatile SingularAttribute<EItem, String> label;
	public static volatile SingularAttribute<EItem, Integer> index;
	public static volatile SetAttribute<EItem, EItemValueSelection> selections;
}
