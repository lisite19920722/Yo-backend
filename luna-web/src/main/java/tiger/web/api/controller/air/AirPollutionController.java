package tiger.web.api.controller.air;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tiger.biz.air.support.AirPollutionManager;
import tiger.core.basic.BaseResult;
import tiger.core.domain.air.AirPollutionDomain;
import tiger.web.api.constants.APIConstants;
import tiger.web.api.form.air.AirPollutionCreateForm;
import tiger.web.api.form.air.AirPollutionUpdateForm;
import javax.validation.Valid;


/**
 * Created by lisite on 16/5/21.
 *
 * @author lisite
 * @version v0.1.2
 */
@RestController
@ResponseBody
@RequestMapping(APIConstants.BASE_API_URL + "/environment/air")
public class AirPollutionController {
    @Autowired
    private AirPollutionManager airPollutionManager;

    /**
     * 获取AirPollutionDomain
     *
     * @return
     */
    @RequestMapping(value = "/air_pollution", method = RequestMethod.GET)
    @ResponseBody
    public BaseResult getAirPollution(){
        return  airPollutionManager.read();
    }

    /**
     * 删除AirPollutionDomain
     *
     * @param id the id
     * @return the base result
     */
    @RequestMapping(value = "/air_pollution/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public BaseResult<Boolean> deleteAirPollutionById(@PathVariable("id") Long id) {
        return airPollutionManager.delete(id);
    }

    /**
     * 更新AirPollutionDomain
     *
     * @param airPollutionForm   the airPollution form
     * @param bindingResult the binding result
     * @param id            the id
     * @return the base result
     */
    @RequestMapping(value = "/air_pollution/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public BaseResult<Boolean> updateAirPollutionById(@RequestBody @Valid AirPollutionUpdateForm airPollutionForm,
                                                       BindingResult bindingResult,
                                                       @PathVariable("id") long id) {
        AirPollutionDomain airPollutionDomain = airPollutionForm.convert2Domain();
        airPollutionDomain.setId(id);
        return airPollutionManager.update(airPollutionDomain);
    }

    /**
     * 创建AirPollutionDomain
     *
     * @param airPollutionForm    the id
     * @param bindingResult the binding result
     * @return the base result
     */
    @RequestMapping(value = "/air_pollution", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult<AirPollutionDomain> createAirPollution(@RequestBody @Valid AirPollutionCreateForm airPollutionForm,
                                           BindingResult bindingResult) {
        AirPollutionDomain airPollutionDomain = airPollutionForm.convert2Domain();
        return airPollutionManager.create(airPollutionDomain);
    }

}
