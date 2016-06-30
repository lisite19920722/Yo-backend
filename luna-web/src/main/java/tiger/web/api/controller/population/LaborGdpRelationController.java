package tiger.web.api.controller.population;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tiger.biz.population.suport.LaborGdpRelationManager;
import tiger.core.basic.BaseResult;
import tiger.core.domain.population.LaborGdpRelationDomain;
import tiger.web.api.constants.APIConstants;
import tiger.web.api.form.population.LaborGdpRelationForm;

import javax.validation.Valid;

/**
 * Created by Winter on 2016/6/29.
 */


@RestController
@ResponseBody
@RequestMapping(APIConstants.BASE_API_URL + "/population")


public class LaborGdpRelationController {
      @Autowired
    LaborGdpRelationManager laborGdpRelationManager;

    @RequestMapping(value="/insert_labor_gdp_relation",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult<LaborGdpRelationDomain> createPopulationStructure(@RequestBody @Valid LaborGdpRelationForm laborGdpRelationForm, BindingResult
            bindingResult)
    {
        LaborGdpRelationDomain laborGdpRelationDomain=laborGdpRelationForm.convert2Domain();
        return laborGdpRelationManager.create(laborGdpRelationDomain);

    }

}
