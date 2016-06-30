package tiger.core.service.population.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.common.dal.persistence.mapper.PeopleEmployInsuranceMapper;
import tiger.common.dal.persistence.population.PeopleEmployInsuranceDO;
import tiger.core.domain.population.PeopleEmployInsuranceDomain;
import tiger.core.domain.population.convert.PeopleEmployInsuranceConvert;
import tiger.core.service.population.PeopleEmployInsuranceService;


/**
 * Created by Winter on 2016/6/29.
 */
@Service
public class PeopleEmployInsuranceServiceImpl implements PeopleEmployInsuranceService {

    @Autowired
    private PeopleEmployInsuranceMapper peopleEmployInsuranceMapper;

    @Override
    public PeopleEmployInsuranceDomain createPeopleEmployInsurance (PeopleEmployInsuranceDomain peopleEmployInsuranceDomain)
    {
        if(peopleEmployInsuranceDomain==null)
        {
            return null;
        }

        PeopleEmployInsuranceDO peopleEmployInsuranceDO= PeopleEmployInsuranceConvert.convertDomainToDO(peopleEmployInsuranceDomain);
        if(peopleEmployInsuranceMapper.insertSelective(peopleEmployInsuranceDO)>0)
        {
            return PeopleEmployInsuranceConvert.convertDOToDomain(peopleEmployInsuranceDO);
        }
        return null;
    }
}
