package tiger.biz.population.suport;

import tiger.core.basic.BaseResult;
import tiger.core.domain.population.PeopleEmployInsuranceDomain;

/**
 * Created by Winter on 2016/6/29.
 */
public interface PeopleEmployInsuranceManager {

    BaseResult<PeopleEmployInsuranceDomain> create(PeopleEmployInsuranceDomain peopleEmployInsuranceDomain);
}
