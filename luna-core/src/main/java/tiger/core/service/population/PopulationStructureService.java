package tiger.core.service.population;

import tiger.core.domain.population.PopulationStructureDomain;

import java.util.List;

/**
 * 接口
 * Created by Winter on 2016/6/10.
 */
public interface PopulationStructureService {

    List<PopulationStructureDomain> getPopulationStructure();//函数的返回值是domain类型的数据

    /**
     * 创建一个人口结构记录
     * @param populationStructureDomain
     * @return
     */
    PopulationStructureDomain createPopulationStructure(PopulationStructureDomain populationStructureDomain);

}
