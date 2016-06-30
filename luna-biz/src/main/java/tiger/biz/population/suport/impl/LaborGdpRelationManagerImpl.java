package tiger.biz.population.suport.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.biz.population.suport.LaborGdpRelationManager;
import tiger.core.basic.BaseResult;
import tiger.core.domain.population.LaborGdpRelationDomain;
import tiger.core.service.population.LaborGdpRelationService;

/**
 * Created by Winter on 2016/6/29.
 */

@Service
public class LaborGdpRelationManagerImpl implements LaborGdpRelationManager {

    @Autowired
            private LaborGdpRelationService laborGdpRelationService;
    @Override
    public BaseResult <LaborGdpRelationDomain> create(LaborGdpRelationDomain laborGdpRelationDomain){
    LaborGdpRelationDomain resultDomain= laborGdpRelationService.createLaborGdpRelation(laborGdpRelationDomain);
    return new BaseResult<>(resultDomain);
    }

}
