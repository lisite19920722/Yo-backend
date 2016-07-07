/**
 * Gambition Inc.
 * All Right Reserved.
 */
package tiger.web.api.controller.privilege;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tiger.common.dal.annotation.LoginRequired;
import tiger.common.dal.annotation.Permission;
import tiger.common.dal.enums.PermissionEnum;
import tiger.core.basic.BaseResult;
import tiger.web.api.constants.APIConstants;
import tiger.web.api.controller.BaseController;

/**
 * 权限管理相关接口
 *
 * @Author: [mondooo.cgq]
 * @version: [V 0.1.1]
 * @CreateDate: [16/7/6 18:19]
 */
@RestController
@ResponseBody
@RequestMapping(APIConstants.BASE_API_URL + "/")
public class PrivilegeController extends BaseController {

    /**
     * 执行权限判断的API 判断是否具有环境的权限
     *
     * @return
     */
    @LoginRequired
    @Permission(permission = {PermissionEnum.ENVIRONMENT, PermissionEnum.VIEW_ALL, PermissionEnum.MANAGE_ALL})
    @RequestMapping(value = "privilege/environment", method = RequestMethod.GET)
    @ResponseBody
    public BaseResult<Boolean> isShowEnvironmentPanel() {
        return new BaseResult<>(true);
    }

    /**
     * 执行权限判断的API 判断是否具有环境的权限
     *
     * @return
     */
    @LoginRequired
    @Permission(permission = {PermissionEnum.ECONOMY, PermissionEnum.VIEW_ALL, PermissionEnum.MANAGE_ALL})
    @RequestMapping(value = "privilege/economy", method = RequestMethod.GET)
    @ResponseBody
    public BaseResult<Boolean> isShowEconomyPanel() {
        return new BaseResult<>(true);
    }

    /**
     * 执行权限判断的API 判断是否具有环境的权限
     *
     * @return
     */
    @LoginRequired
    @Permission(permission = {PermissionEnum.POPULATION, PermissionEnum.VIEW_ALL, PermissionEnum.MANAGE_ALL})
    @RequestMapping(value = "privilege/population", method = RequestMethod.GET)
    @ResponseBody
    public BaseResult<Boolean> isShowPopulationPanel() {
        return new BaseResult<>(true);
    }
}