package tiger.biz.population.suport;

import tiger.core.basic.BaseResult;
import tiger.core.domain.population.PopulationStructureDomain;


/**
 * Created by Winter on 2016/6/10.
 */
public interface PopulationStructureManager {
    /**
     * 获取一条人口结构记录
     * @param
     * @return
     */
    BaseResult read();

    /**
     * 往人口结构表中插入数据
     * @param populationStructureDomain
     * @return
     */
    BaseResult<PopulationStructureDomain> create(PopulationStructureDomain populationStructureDomain);
}
