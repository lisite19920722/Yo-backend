package tiger.web.api.controller.water;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tiger.biz.water.support.WaterPollutionManager;
import tiger.common.dal.annotation.LoginRequired;
import tiger.common.dal.annotation.Permission;
import tiger.common.dal.enums.PermissionEnum;
import tiger.core.basic.BaseResult;
import tiger.core.domain.water.WaterPollutionDomain;
import tiger.web.api.constants.APIConstants;
import tiger.web.api.form.water.WaterPollutionCreateForm;
import tiger.web.api.form.water.WaterPollutionUpdateForm;

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
public class WaterPollutionController {
    @Autowired
    private WaterPollutionManager waterPollutionManager;

    /**
     * 获取WaterPollutionDomain
     *
     * @return
     */
    @LoginRequired
    @RequestMapping(value = "/water_pollution", method = RequestMethod.GET)
    @Permission(permission = {PermissionEnum.ENVIRONMENT,PermissionEnum.VIEW_ALL,PermissionEnum.MANAGE_ALL})
    @ResponseBody
    public BaseResult getWaterPollution(){
        return  waterPollutionManager.read();
    }

    /**
     * 删除WaterPollutionDomain
     *
     * @param id the id
     * @return the base result
     */
    @LoginRequired
    @RequestMapping(value = "/water_pollution/{id}", method = RequestMethod.DELETE)
    @Permission(permission = {PermissionEnum.ENVIRONMENT,PermissionEnum.VIEW_ALL,PermissionEnum.MANAGE_ALL})
    @ResponseBody
    public BaseResult<Boolean> deleteWaterPollutionById(@PathVariable("id") Long id) {
        return waterPollutionManager.delete(id);
    }

    /**
     * 更新WaterPollutionDomain
     *
     * @param waterPollutionForm   the waterPollution form
     * @param bindingResult the binding result
     * @param id            the id
     * @return the base result
     */
    @LoginRequired
    @RequestMapping(value = "/water_pollution/{id}", method = RequestMethod.PUT)
    @Permission(permission = {PermissionEnum.ENVIRONMENT,PermissionEnum.VIEW_ALL,PermissionEnum.MANAGE_ALL})
    @ResponseBody
    public BaseResult<Boolean> updateWaterPollutionById(@RequestBody @Valid WaterPollutionUpdateForm waterPollutionForm,
                                                       BindingResult bindingResult,
                                                       @PathVariable("id") long id) {
        WaterPollutionDomain waterPollutionDomain = waterPollutionForm.convert2Domain();
        waterPollutionDomain.setId(id);

        return waterPollutionManager.update(waterPollutionDomain);
    }

    /**
     * 创建WaterPollutionDomain
     *
     * @param waterPollutionForm    the id
     * @param bindingResult the binding result
     * @return the base result
     */
    @LoginRequired
    @RequestMapping(value = "/water_pollution", method = RequestMethod.POST)
    @Permission(permission = {PermissionEnum.ENVIRONMENT,PermissionEnum.VIEW_ALL,PermissionEnum.MANAGE_ALL})
    @ResponseBody
    public BaseResult<WaterPollutionDomain> createWaterPollution(@RequestBody @Valid WaterPollutionCreateForm waterPollutionForm,
                                           BindingResult bindingResult) {
        WaterPollutionDomain waterPollutionDomain = waterPollutionForm.convert2Domain();

        return waterPollutionManager.create(waterPollutionDomain);
    }

}
