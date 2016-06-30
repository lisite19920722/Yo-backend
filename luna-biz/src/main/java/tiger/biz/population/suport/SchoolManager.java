package tiger.biz.population.suport;

import tiger.core.basic.BaseResult;
import tiger.core.domain.population.SchoolDomain;

/**
 * Created by Winter on 2016/6/30.
 */
public interface SchoolManager {

    BaseResult<SchoolDomain> create(SchoolDomain schoolDomain);
}
