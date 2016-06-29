package tiger.biz.population.suport;

import tiger.core.basic.BaseResult;
import tiger.core.domain.population.LaborGdpRelationDomain;

/**
 * Created by Winter on 2016/6/29.
 */
public interface LaborGdpRelationManager {

    BaseResult<LaborGdpRelationDomain> create(LaborGdpRelationDomain laborGdpRelationDomain);
}
