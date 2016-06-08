package tiger.web.api.controller.air;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tiger.biz.air.support.AirQualityManager;
import tiger.core.basic.BaseResult;
import tiger.core.domain.air.AirQualityDomain;
import tiger.web.api.constants.APIConstants;
import tiger.web.api.form.air.AirQualityCreateForm;
import tiger.web.api.form.air.AirQualityUpdateForm;

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
public class AirQualityController {
    @Autowired
    private AirQualityManager airQualityManager;

    /**
     * 根据id获取AirQualityDomain
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/air_quality/{id}", method = RequestMethod.GET)
    @ResponseBody
    public BaseResult getAirQualityById(@PathVariable("id") Long id){
        return  airQualityManager.read(id);
    }

    /**
     * 删除AirQualityDomain
     *
     * @param id the id
     * @return the base result
     */
    @RequestMapping(value = "/air_quality/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public BaseResult<Boolean> deleteAirQualityById(@PathVariable("id") Long id) {
        return airQualityManager.delete(id);
    }

    /**
     * 更新AirQualityDomain
     *
     * @param airQualityForm   the airQuality form
     * @param bindingResult the binding result
     * @param id            the id
     * @return the base result
     */
    @RequestMapping(value = "/air_quality/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public BaseResult<Boolean> updateAirQualityById(@RequestBody @Valid AirQualityUpdateForm airQualityForm,
                                                       BindingResult bindingResult,
                                                       @PathVariable("id") long id) {
        AirQualityDomain airQualityDomain = airQualityForm.convert2Domain();
        airQualityDomain.setId(id);

        return airQualityManager.update(airQualityDomain);
    }

    /**
     * 创建AirQualityDomain
     *
     * @param airQualityForm    the id
     * @param bindingResult the binding result
     * @return the base result
     */
    @RequestMapping(value = "/air_quality", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult<AirQualityDomain> createAirQuality(@RequestBody @Valid AirQualityCreateForm airQualityForm,
                                           BindingResult bindingResult) {
        AirQualityDomain airQualityDomain = airQualityForm.convert2Domain();

        return airQualityManager.create(airQualityDomain);
    }

}
