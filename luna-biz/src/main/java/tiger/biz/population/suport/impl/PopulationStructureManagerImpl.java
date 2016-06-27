package tiger.biz.population.suport.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.biz.population.suport.PopulationStructureManager;
import tiger.core.basic.BaseResult;
import tiger.core.basic.enums.ErrorCodeEnum;
import tiger.core.basic.exception.TigerException;
import tiger.core.domain.population.PopulationStructureDomain;
import tiger.core.service.population.PopulationStructureService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Winter on 2016/6/10.
 */
@Service
public class PopulationStructureManagerImpl implements PopulationStructureManager{

    @Autowired
    private PopulationStructureService populationStructureService;
    @Override
    public BaseResult read() {
        List arrays=new ArrayList();
        List<PopulationStructureDomain> populationStructureDomainList=populationStructureService.getPopulationStructure();

        if(populationStructureDomainList==null)
        {
            throw new TigerException(ErrorCodeEnum.NOT_FOUND,"出现这个错误，请看一下biz层里面的manager出了什么问题");
        }
       arrays.add(populationStructureDomainList);
        return new BaseResult(arrays);
    }

    /**
     * 创建一条数据结构的记录
     * @param populationStructureDomain
     * @return
     */

    @Override
    public BaseResult<PopulationStructureDomain> create(PopulationStructureDomain populationStructureDomain)
    {
        PopulationStructureDomain resultDomain=populationStructureService.createPopulationStructure(populationStructureDomain);
        return new BaseResult<>(resultDomain);
    }


}
