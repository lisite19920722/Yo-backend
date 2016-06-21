package tiger.core.domain.population.convert;

import tiger.common.dal.persistence.population.PopulationStructureDO;
import tiger.common.util.BeanUtil;
import tiger.core.domain.population.PopulationStructureDomain;

/**
 * Created by Winter on 2016/6/11.
 */
public class PopulationStructureConvert {
    public static PopulationStructureDomain convertDOToDomain(PopulationStructureDO populationStructureDO) {
        if(null==populationStructureDO)
        {return null;}

        PopulationStructureDomain populationStructureDomain=new PopulationStructureDomain();
        BeanUtil.copyPropertiesWithIgnores(populationStructureDO,populationStructureDomain);
        return populationStructureDomain;
    }
}
