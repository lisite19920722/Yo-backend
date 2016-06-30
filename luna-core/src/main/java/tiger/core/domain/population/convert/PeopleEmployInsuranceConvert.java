package tiger.core.domain.population.convert;

import tiger.common.dal.persistence.population.PeopleEmployInsuranceDO;
import tiger.common.dal.persistence.population.PopulationStructureDO;
import tiger.common.util.BeanUtil;
import tiger.core.domain.population.PeopleEmployInsuranceDomain;

/**
 * Created by Winter on 2016/6/29.
 */
public class PeopleEmployInsuranceConvert {




    public static PeopleEmployInsuranceDomain convertDOToDomain(PeopleEmployInsuranceDO peopleEmployInsuranceDO) {
        if(null==peopleEmployInsuranceDO)
        {return null;}

        PeopleEmployInsuranceDomain peopleEmployInsuranceDomain=new PeopleEmployInsuranceDomain();
        BeanUtil.copyPropertiesWithIgnores(peopleEmployInsuranceDO,peopleEmployInsuranceDomain);
        return peopleEmployInsuranceDomain;
    }

    public static PeopleEmployInsuranceDO convertDomainToDO(PeopleEmployInsuranceDomain peopleEmployInsuranceDomain)
    {
        if(peopleEmployInsuranceDomain==null)
        { return null;}
        PeopleEmployInsuranceDO peopleEmployInsuranceDO=new PeopleEmployInsuranceDO();
        BeanUtil.copyPropertiesWithIgnores(peopleEmployInsuranceDomain,peopleEmployInsuranceDO);
        return peopleEmployInsuranceDO;
    }
}
