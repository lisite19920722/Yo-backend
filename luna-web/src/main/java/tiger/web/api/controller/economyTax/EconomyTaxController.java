package tiger.web.api.controller.economyTax;

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
import tiger.biz.Economy.support.EconomyTaxManger;
import java.util.Map;

/**
 * Created by xy86 on 16/6/11.
 */
@RestController
@RequestMapping(APIConstants.BASE_API_URL + "/economy")
public class EconomyTaxController {

    @Autowired
    private EconomyTaxManger economyTaxManger;

    @LoginRequired
    @Permission(permission = {PermissionEnum.VIEW_ALL,PermissionEnum.MANAGE_ALL})
    @RequestMapping(value = "/yearTax", method = RequestMethod.GET)
    public BaseResult getYearTax(){
        Map<String,double[]> map = economyTaxManger.getYearTax();
        return new BaseResult(map);
    }

    @LoginRequired
    @Permission(permission = {PermissionEnum.VIEW_ALL,PermissionEnum.MANAGE_ALL})
    @RequestMapping(value = "/taxDetail/{year}",method = RequestMethod.GET)
    public BaseResult getYearTaxDetail(@PathVariable("year") Long year)
    {
     Map<String,double[]> map = economyTaxManger.getYearTaxDetail(year);
        return new BaseResult(map);
    }
}
