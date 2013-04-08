package jabara.coral.entity;

import jabara.jpa.entity.EntityBase_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-04-08T23:27:14.019+0900")
@StaticMetamodel(EProject.class)
public class EProject_ extends EntityBase_ {
	public static volatile SingularAttribute<EProject, String> name;
	public static volatile SingularAttribute<EProject, EItemSet> items;
}
