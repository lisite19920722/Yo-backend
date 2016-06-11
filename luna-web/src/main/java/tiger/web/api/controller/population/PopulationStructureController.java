package tiger.web.api.controller.population;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tiger.biz.population.suport.PopulationStructureManager;
import tiger.core.basic.BaseResult;
import tiger.core.domain.population.PopulationStructureDomain;

/**
 * Created by Winter on 2016/6/7.
 */
@RestController
@ResponseBody
public class PopulationStructureController {
    @Autowired
    PopulationStructureManager populationStructureManager;

    @RequestMapping(value="/population_structure/{id}",method= RequestMethod.GET)
    public BaseResult<PopulationStructureDomain> getPopulationStructureById(@PathVariable("id") long id)
    {
        return populationStructureManager.read(id);
    }
}
