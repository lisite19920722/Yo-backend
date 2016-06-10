package tiger.biz.population.suport.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.biz.population.suport.PopulationStructureManager;
import tiger.core.basic.BaseResult;
import tiger.core.basic.enums.ErrorCodeEnum;
import tiger.core.basic.exception.TigerException;
import tiger.core.domain.population.PopulationStructureDomain;

/**
 * Created by Winter on 2016/6/10.
 */
@Service
public class PopulationStructureImpl implements PopulationStructureManager{

    @Autowired
    private PopulationStructureService populationStructureService;
    @Override
    public BaseResult<PopulationStructureDomain> read(Long id) {
        PopulationStructureDomain populationstructure=populationStructureService.getPopulationStructureById(id);

        if(populationstructure==null)
        {
            throw new TigerException(ErrorCodeEnum.NOT_FOUND,"没有从service里面成功获得数据")
        }
        return new BaseResult<PopulationStructureDomain>(populationstructure);
    }
}
