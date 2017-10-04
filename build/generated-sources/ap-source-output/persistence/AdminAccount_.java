package persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-02T15:53:54")
@StaticMetamodel(AdminAccount.class)
public class AdminAccount_ { 

    public static volatile SingularAttribute<AdminAccount, byte[]> password;
    public static volatile SingularAttribute<AdminAccount, byte[]> salt;
    public static volatile SingularAttribute<AdminAccount, Long> id;
    public static volatile SingularAttribute<AdminAccount, String> userId;

}