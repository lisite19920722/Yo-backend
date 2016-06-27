package tiger.web.api.controller.population;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tiger.biz.population.suport.PopulationStructureManager;
import tiger.core.basic.BaseResult;
import tiger.core.domain.population.PopulationStructureDomain;
import tiger.web.api.constants.APIConstants;
import tiger.web.api.form.population.PopulationStructureForm;

import javax.validation.Valid;

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

    /**
     * 获取PopulationStructureDomain
     * @return
     */
    @RequestMapping(value = "/population_structure", method = RequestMethod.GET)
    @ResponseBody
    public BaseResult getPopulationStructure() {
        return populationStructureManager.read();
    }


    /**
     * 下面的方法是用来录入数据
     * @param populationStructureForm
     * @return
     */
    @RequestMapping(value="/insert_population_structure",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult<PopulationStructureDomain> createPopulationStructure(@RequestBody @Valid PopulationStructureForm populationStructureForm, BindingResult
    bindingResult)
    {
    PopulationStructureDomain populationStructureDomain=populationStructureForm.convert2Domain();
        return populationStructureManager.create(populationStructureDomain);
    }

}
