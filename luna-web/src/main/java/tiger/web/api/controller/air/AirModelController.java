package tiger.web.api.controller.air;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tiger.biz.air.support.AirModelManager;
import tiger.common.dal.annotation.LoginRequired;
import tiger.common.dal.annotation.Permission;
import tiger.common.dal.enums.PermissionEnum;
import tiger.core.basic.BaseResult;
import tiger.web.api.constants.APIConstants;


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
public class AirModelController {
    @Autowired
    private AirModelManager airModelManager;

    /**
     * 获取AirModelDomain
     *
     * @return
     */
    @LoginRequired
    @RequestMapping(value = "/air_model", method = RequestMethod.GET)
    @Permission(permission = {PermissionEnum.ENVIRONMENT,PermissionEnum.VIEW_ALL,PermissionEnum.MANAGE_ALL})
    @ResponseBody
    public BaseResult getAirModel(@RequestParam("test") String test, @RequestParam("test1") String test1){
        return  airModelManager.read(test, test1);
    }

}
