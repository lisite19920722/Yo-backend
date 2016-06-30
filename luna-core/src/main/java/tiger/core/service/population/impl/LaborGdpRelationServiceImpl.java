package tiger.core.service.population.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.common.dal.persistence.mapper.LaborGdpRelationMapper;
import tiger.common.dal.persistence.population.LaborGdpRelationDO;
import tiger.core.domain.population.LaborGdpRelationDomain;
import tiger.core.domain.population.convert.LaborGdpRelationConvert;
import tiger.core.service.population.LaborGdpRelationService;


/**
 * Created by Winter on 2016/6/28.
 */
@Service
public class LaborGdpRelationServiceImpl implements LaborGdpRelationService {
    @Autowired
    private LaborGdpRelationMapper laborGdpRelationMapper;

    @Override
    public LaborGdpRelationDomain createLaborGdpRelation (LaborGdpRelationDomain laborGdpRelationDomain)
    {
        if(laborGdpRelationDomain==null)
        {
            return null;
        }

        LaborGdpRelationDO laborGdpRelationDO= LaborGdpRelationConvert.convertDomainToDO(laborGdpRelationDomain);
                if(laborGdpRelationMapper.insertSelective(laborGdpRelationDO)>0)
                {
                    return LaborGdpRelationConvert.convertDOToDomain(laborGdpRelationDO);
                }
        return null;
    }
}
