package tiger.core.service.population;

import tiger.core.domain.population.PopulationStructureDomain;

/**
 * 接口
 * Created by Winter on 2016/6/10.
 */
public interface PopulationStructureService {

    PopulationStructureDomain getPopulationStructureById(Long id);//函数的返回值是domain类型的数据

}
