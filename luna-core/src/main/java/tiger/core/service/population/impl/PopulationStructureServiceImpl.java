package tiger.core.service.population.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.common.dal.persistence.mapper.PopulationStructureMapper;
import tiger.common.dal.persistence.population.PopulationStructureDO;
import tiger.core.domain.population.PopulationStructureDomain;
import tiger.core.domain.population.convert.PopulationStructureConvert;
import tiger.core.service.population.PopulationStructureService;

/**
 * Created by Winter on 2016/6/10.
 */
@Service
public class PopulationStructureServiceImpl implements PopulationStructureService{

    @Autowired
       private PopulationStructureMapper populationStructureMapper;
    @Override
    public PopulationStructureDomain getPopulationStructureById(Long id)
       {
          PopulationStructureDO populationStructureDO=populationStructureMapper.selectByPrimaryKey(id);

           if(null!=populationStructureDO)
           {
               return PopulationStructureConvert.convertDOToDomain(populationStructureDO);
           }
           return null;
        }
}
