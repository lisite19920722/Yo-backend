package tiger.core.domain.population.convert;

import tiger.common.dal.persistence.population.LaborGdpRelationDO;
import tiger.common.util.BeanUtil;
import tiger.core.domain.population.LaborGdpRelationDomain;

/**
 * Created by Winter on 2016/6/28.
 */
public class LaborGdpRelationConvert {
    public static LaborGdpRelationDomain convertDOToDomain(LaborGdpRelationDO laborGdpRelationDO)
    {

        if(laborGdpRelationDO==null)
        {return null;}
        LaborGdpRelationDomain laborGdpRelationDomain=new LaborGdpRelationDomain();
        BeanUtil.copyPropertiesWithIgnores(laborGdpRelationDO,laborGdpRelationDomain);
        return laborGdpRelationDomain;
    }

    public static LaborGdpRelationDO convertDomainToDO(LaborGdpRelationDomain laborGdpRelationDomain)
    {

        if(laborGdpRelationDomain==null)
        {return null;}
        LaborGdpRelationDO laborGdpRelationDO=new LaborGdpRelationDO();
        BeanUtil.copyPropertiesWithIgnores(laborGdpRelationDomain,laborGdpRelationDO);
        return laborGdpRelationDO;
    }

}
