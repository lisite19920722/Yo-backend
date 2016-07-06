package tiger.web.api.controller.population;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tiger.biz.population.suport.SchoolManager;
import tiger.core.basic.BaseResult;
import tiger.core.domain.population.SchoolDomain;
import tiger.web.api.constants.APIConstants;
import tiger.web.api.form.population.SchoolForm;

import javax.validation.Valid;

/**
 * Created by Winter on 2016/6/30.
 */


@RestController
@ResponseBody
@RequestMapping(APIConstants.BASE_API_URL + "/population")
public class SchoolController {

    @Autowired
    SchoolManager schoolManager;

    @RequestMapping(value="/insert_school",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult<SchoolDomain> createSchool(@RequestBody @Valid SchoolForm schoolForm, BindingResult
            bindingResult)
    {
        SchoolDomain schoolDomain=schoolForm.convert2Domain();
        return schoolManager.create(schoolDomain);

    }
}
