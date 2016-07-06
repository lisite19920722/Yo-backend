package tiger.core.domain.population.convert;

import tiger.common.dal.persistence.population.SchoolDO;
import tiger.common.util.BeanUtil;
import tiger.core.domain.population.SchoolDomain;

/**
 * Created by Winter on 2016/6/30.
 */
public class SchoolConvert {

    public static SchoolDomain convertDOToDomain(SchoolDO schoolDO)
    {

        if(schoolDO==null)
        {return null;}
        SchoolDomain schoolDomain=new SchoolDomain();
        BeanUtil.copyPropertiesWithIgnores(schoolDO,schoolDomain);
        return schoolDomain;
    }

    public static SchoolDO convertDomainToDO(SchoolDomain schoolDomain)
    {

        if(schoolDomain==null)
        {return null;}
        SchoolDO schoolDO=new SchoolDO();
        BeanUtil.copyPropertiesWithIgnores(schoolDomain,schoolDO);
        return schoolDO;
    }
}
