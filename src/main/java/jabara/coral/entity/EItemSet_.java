package jabara.coral.entity;

import jabara.jpa.entity.EntityBase_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-04-05T00:07:05.369+0900")
@StaticMetamodel(EItemSet.class)
public class EItemSet_ extends EntityBase_ {
	public static volatile SingularAttribute<EItemSet, EProject> project;
	public static volatile SetAttribute<EItemSet, EItem> items;
}
