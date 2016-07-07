package tiger.web.api.controller.water;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tiger.biz.water.support.WaterQualityManager;
import tiger.common.dal.annotation.LoginRequired;
import tiger.common.dal.annotation.Permission;
import tiger.common.dal.enums.PermissionEnum;
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
     * 获取WaterQualityDomain
     *
     * @return
     */
    @LoginRequired
    @RequestMapping(value = "/water_quality", method = RequestMethod.GET)
    @Permission(permission = {PermissionEnum.ENVIRONMENT,PermissionEnum.VIEW_ALL,PermissionEnum.MANAGE_ALL})
    @ResponseBody
    public BaseResult getWaterQuality(){
        return  waterQualityManager.read();
    }

    /**
     * 删除WaterQualityDomain
     *
     * @param id the id
     * @return the base result
     */
    @LoginRequired
    @RequestMapping(value = "/water_quality/{id}", method = RequestMethod.DELETE)
    @Permission(permission = {PermissionEnum.ENVIRONMENT,PermissionEnum.VIEW_ALL,PermissionEnum.MANAGE_ALL})
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
    @LoginRequired
    @RequestMapping(value = "/water_quality/{id}", method = RequestMethod.PUT)
    @Permission(permission = {PermissionEnum.ENVIRONMENT,PermissionEnum.VIEW_ALL,PermissionEnum.MANAGE_ALL})
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
    @LoginRequired
    @RequestMapping(value = "/water_quality", method = RequestMethod.POST)
    @Permission(permission = {PermissionEnum.ENVIRONMENT,PermissionEnum.VIEW_ALL,PermissionEnum.MANAGE_ALL})
    @ResponseBody
    public BaseResult<WaterQualityDomain> createWaterQuality(@RequestBody @Valid WaterQualityCreateForm waterQualityForm,
                                           BindingResult bindingResult) {
        WaterQualityDomain waterQualityDomain = waterQualityForm.convert2Domain();

        return waterQualityManager.create(waterQualityDomain);
    }

}
