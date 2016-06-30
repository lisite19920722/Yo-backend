package tiger.biz.population.suport.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.biz.population.suport.PeopleEmployInsuranceManager;
import tiger.core.basic.BaseResult;
import tiger.core.domain.population.PeopleEmployInsuranceDomain;
import tiger.core.service.population.PeopleEmployInsuranceService;

/**
 * Created by Winter on 2016/6/29.
 */
@Service
public class PeopleEmployInsuranceManagerImpl implements PeopleEmployInsuranceManager {

    @Autowired
    private PeopleEmployInsuranceService peopleEmployInsuranceService;

    @Override
    public  BaseResult<PeopleEmployInsuranceDomain> create(PeopleEmployInsuranceDomain peopleEmployInsuranceDomain){
        PeopleEmployInsuranceDomain resultDomain= peopleEmployInsuranceService.createPeopleEmployInsurance(peopleEmployInsuranceDomain);
        return new BaseResult<>(resultDomain);
    }
}
