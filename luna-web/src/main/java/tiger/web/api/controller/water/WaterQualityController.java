package tiger.web.api.controller.water;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tiger.biz.water.support.WaterQualityManager;
import tiger.core.basic.BaseResult;
import tiger.core.domain.water.WaterQualityDomain;
import tiger.web.api.constants.APIConstants;
import tiger.web.api.form.water.WaterQualityCreateForm;
import tiger.web.api.form.water.WaterQualityUpdateForm;

import javax.validation.Valid;


/**
 * Created by lisite on 16/5/21.
 *
 * @author lisite
 * @version v0.1.2
 */
@RestController
@ResponseBody
@RequestMapping(APIConstants.BASE_API_URL + "/environment/water")
public class WaterQualityController {
    @Autowired
    private WaterQualityManager waterQualityManager;

    /**
     * 根据id获取WaterQualityDomain
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/water_quality/{id}", method = RequestMethod.GET)
    @ResponseBody
    public BaseResult getWaterQualityById(@PathVariable("id") Long id){
        return  waterQualityManager.read(id);
    }

    /**
     * 删除WaterQualityDomain
     *
     * @param id the id
     * @return the base result
     */
    @RequestMapping(value = "/water_quality/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public BaseResult<Boolean> deleteWaterQualityById(@PathVariable("id") Long id) {
        return waterQualityManager.delete(id);
    }

    /**
     * 更新WaterQualityDomain
     *
     * @param waterQualityForm   the waterQuality form
     * @param bindingResult the binding result
     * @param id            the id
     * @return the base result
     */
    @RequestMapping(value = "/water_quality/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public BaseResult<Boolean> updateWaterQualityById(@RequestBody @Valid WaterQualityUpdateForm waterQualityForm,
                                                       BindingResult bindingResult,
                                                       @PathVariable("id") long id) {
        WaterQualityDomain waterQualityDomain = waterQualityForm.convert2Domain();
        waterQualityDomain.setId(id);

        return waterQualityManager.update(waterQualityDomain);
    }

    /**
     * 创建WaterQualityDomain
     *
     * @param waterQualityForm    the id
     * @param bindingResult the binding result
     * @return the base result
     */
    @RequestMapping(value = "/water_quality", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult<WaterQualityDomain> createWaterQuality(@RequestBody @Valid WaterQualityCreateForm waterQualityForm,
                                           BindingResult bindingResult) {
        WaterQualityDomain waterQualityDomain = waterQualityForm.convert2Domain();

        return waterQualityManager.create(waterQualityDomain);
    }

}
