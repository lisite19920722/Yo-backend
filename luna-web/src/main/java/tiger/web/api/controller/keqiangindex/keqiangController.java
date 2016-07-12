package tiger.web.api.controller.keqiangindex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tiger.common.dal.annotation.LoginRequired;
import tiger.common.dal.annotation.Permission;
import tiger.common.dal.enums.PermissionEnum;
import tiger.core.basic.BaseResult;
import tiger.web.api.constants.APIConstants;
import tiger.biz.Economy.support.KeQiangManger;
import java.util.Map;

/**
 * Created by xy86 on 16/7/11.
 */
@RestController
@RequestMapping(APIConstants.BASE_API_URL+"/economy")
public class keqiangController {

    @Autowired
    private KeQiangManger keQiangManger;

    @LoginRequired
    @Permission(permission = {PermissionEnum.VIEW_ALL,PermissionEnum.MANAGE_ALL})
    @RequestMapping(value = "/yearKeqiang/{year}",method = RequestMethod.GET)
    public BaseResult getyearKeqiang(@PathVariable("year") Long year)
    {
        Map<String,double[]> yearmap = keQiangManger.getyearKeqiang(year);
        return new BaseResult(yearmap);
    }

}
