package tiger.web.api.controller.population;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tiger.biz.population.suport.PeopleEmployInsuranceManager;
import tiger.core.basic.BaseResult;
import tiger.core.domain.population.PeopleEmployInsuranceDomain;
import tiger.web.api.constants.APIConstants;
import tiger.web.api.form.population.PeopleEmployInsuranceForm;

import javax.validation.Valid;

/**
 * Created by Winter on 2016/6/29.
 */

@RestController
@ResponseBody
@RequestMapping(APIConstants.BASE_API_URL + "/population")

public class PeopleEmployInsuranceController {

    @Autowired
    PeopleEmployInsuranceManager peopleEmployInsuranceManager;

    @RequestMapping(value="/insert_employ_insurance",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult<PeopleEmployInsuranceDomain> createPopulationStructure(@RequestBody @Valid PeopleEmployInsuranceForm peopleEmployInsuranceForm, BindingResult
            bindingResult)
    {
        PeopleEmployInsuranceDomain peopleEmployInsuranceDomain=peopleEmployInsuranceForm.convert2Domain();
        return peopleEmployInsuranceManager.create(peopleEmployInsuranceDomain);

    }

}
