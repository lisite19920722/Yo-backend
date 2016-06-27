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
}
