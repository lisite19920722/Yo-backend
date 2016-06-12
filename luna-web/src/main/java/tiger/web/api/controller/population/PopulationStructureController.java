package tiger.web.api.controller.population;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tiger.biz.population.suport.PopulationStructureManager;
import tiger.core.basic.BaseResult;
import tiger.core.domain.population.PopulationStructureDomain;
import tiger.web.api.constants.APIConstants;

/**
 * Created by Winter on 2016/6/7.
 *
 * @author Winter
 * @version v0.5.1
 */
@RestController
@ResponseBody
@RequestMapping(APIConstants.BASE_API_URL + "/population")
public class PopulationStructureController {
    @Autowired
    PopulationStructureManager populationStructureManager;

    @RequestMapping(value = "/population_structure/{id}", method = RequestMethod.GET)
    public BaseResult<PopulationStructureDomain> getPopulationStructureById(@PathVariable("id") Long id) {
        return populationStructureManager.read(id);
    }
}
