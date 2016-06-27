package tiger.core.service.population.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.common.dal.persistence.mapper.PopulationStructureMapper;
import tiger.common.dal.persistence.population.PopulationStructureDO;
import tiger.core.domain.population.PopulationStructureDomain;
import tiger.core.domain.population.convert.PopulationStructureConvert;
import tiger.core.service.population.PopulationStructureService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**

 */
@Service
public class PopulationStructureServiceImpl implements PopulationStructureService {

    @Autowired
    private PopulationStructureMapper populationStructureMapper;

    /**
     *
     * @return
     */
    @Override
    public List<PopulationStructureDomain> getPopulationStructure(){
        List<PopulationStructureDO> populationStructureDOList=populationStructureMapper.select();
        List<PopulationStructureDomain> populationStructureDomainList=new ArrayList<>();

        Iterator<PopulationStructureDO> e=populationStructureDOList.iterator();
        PopulationStructureDO temp=e.next();
        populationStructureDomainList.add(PopulationStructureConvert.convertDOToDomain(temp));
        while (e.hasNext())
        {
            temp=e.next();
            populationStructureDomainList.add(PopulationStructureConvert.convertDOToDomain(temp));
        }
        if(populationStructureDomainList!= null)
        {
            return populationStructureDomainList;
        }
        return null;

    }

    @Override
    public PopulationStructureDomain createPopulationStructure  (PopulationStructureDomain populationStructureDomain){
        if(populationStructureDomain==null)
        {
            return null;
        }

        PopulationStructureDO populationStructureDO=PopulationStructureConvert.convertDomainToDO(populationStructureDomain);
        if(populationStructureMapper.insertSelective(populationStructureDO)>0)
        {
        return PopulationStructureConvert.convertDOToDomain(populationStructureDO);
        }
        return null;
    }


}
