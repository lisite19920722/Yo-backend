/**
 * Gambition Inc.
 * All Right Reserved.
 */
package tiger.web.api.controller.dataMng;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tiger.biz.dataMng.support.DataMngManager;
import tiger.common.dal.annotation.LoginRequired;
import tiger.common.dal.annotation.Permission;
import tiger.common.dal.enums.PermissionEnum;
import tiger.core.basic.BaseResult;
import tiger.core.domain.power.PowerGdpCorrelationDomain;
import tiger.core.domain.power.PowerGdpCorrelationEnterpriseSoloDomain;
import tiger.core.domain.power.PowerGdpCorrelationIndustrySoloDomain;
import tiger.web.api.constants.APIConstants;
import tiger.web.api.controller.BaseController;
import tiger.web.api.form.dataMng.PowerEnterpriseCreateForm;
import tiger.web.api.form.dataMng.PowerIndustryCreateForm;
import tiger.web.api.form.dataMng.PowerTotalCreateForm;

import javax.validation.Valid;

/**
 * 数据管理接口
 *
 * @Author: [mondooo.cgq]
 * @version: [V 0.1.1]
 * @CreateDate: [16/6/16 13:37]
 */
@RestController
@ResponseBody
@RequestMapping(APIConstants.BASE_API_URL + "/")
public class DataMngController extends BaseController {

    private Logger logger = Logger.getLogger(DataMngController.class);

    @Autowired
    private DataMngManager dataMngManager;

    /**
     * 用电量总体数据录入
     *
     * @param powerTotalCreateForm
     * @param bindingResult
     * @return
     */
    @LoginRequired
    @Permission(permission = {PermissionEnum.MANAGE_ALL})
    @RequestMapping(value = "data/economy/power/total", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult<Boolean> createPowerTotal(@RequestBody @Valid PowerTotalCreateForm powerTotalCreateForm,
                                                       BindingResult bindingResult) {

        return new BaseResult<>(dataMngManager.createPowerTotal((PowerGdpCorrelationDomain)powerTotalCreateForm.convert2Domain()));
    }


    /**
     * 用电行业数据录入
     *
     * @param powerIndustryCreateForm
     * @param bindingResult
     * @return
     */
    @LoginRequired
    @Permission(permission = {PermissionEnum.MANAGE_ALL})
    @RequestMapping(value = "data/economy/power/industry", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult<Boolean> createPowerIndustry(@RequestBody @Valid PowerIndustryCreateForm powerIndustryCreateForm,
                                                BindingResult bindingResult) {

        return new BaseResult<>(dataMngManager.createPowerIndustry((PowerGdpCorrelationIndustrySoloDomain)powerIndustryCreateForm.convert2Domain()));
    }

    @LoginRequired
    @Permission(permission = {PermissionEnum.MANAGE_ALL})
    @RequestMapping(value = "data/economy/power/enterprise", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult<Boolean> createPowerEnterprise(@RequestBody @Valid PowerEnterpriseCreateForm powerEnterpriseCreateForm,
                                                   BindingResult bindingResult) {

        return new BaseResult<>(dataMngManager.createPowerEnterprise((PowerGdpCorrelationEnterpriseSoloDomain)powerEnterpriseCreateForm.convert2Domain()));
    }

    /**
     * 执行权限判断的API 决定是否显示数据录入界面(需要管理员权限)
     *
     * @return
     */
    @LoginRequired
    @Permission(permission = {PermissionEnum.MANAGE_ALL})
    @RequestMapping(value = "data/isshow", method = RequestMethod.GET)
    @ResponseBody
    public BaseResult<Boolean> isShowDataMngPanel() {
        return new BaseResult<>(true);
    }
}
