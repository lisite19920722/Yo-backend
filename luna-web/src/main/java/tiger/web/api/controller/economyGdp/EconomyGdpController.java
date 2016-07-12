package tiger.web.api.controller.economyGdp;


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
import tiger.biz.Economy.support.EconomyGdpManger;

import java.util.Map;

/**
 * Created by xy86 on 16/6/9.
 */
@RestController
@RequestMapping(APIConstants.BASE_API_URL + "/economy")
public class EconomyGdpController {

    @Autowired
    private EconomyGdpManger economyGdpManger;

    @LoginRequired
    @Permission(permission = {PermissionEnum.VIEW_ALL,PermissionEnum.MANAGE_ALL})
    @RequestMapping(value="/yearGdp",method = RequestMethod.GET)
    public  BaseResult getYearGdp(){
        Map<String,double[]> yearmap =economyGdpManger.getYearGdp();
        return new BaseResult(yearmap);
    }

//    @LoginRequired
//    @Permission(permission = {PermissionEnum.VIEW_ALL,PermissionEnum.MANAGE_ALL})
    @RequestMapping(value="/gdpDetail/{year}",method = RequestMethod.GET)
    public BaseResult getGdpDatil(@PathVariable("year") Long year)
    {

       Map<String,double[]> map = economyGdpManger.getGdpDetail(year);
        return new BaseResult(map);

    }

    @LoginRequired
    @Permission(permission = {PermissionEnum.VIEW_ALL,PermissionEnum.MANAGE_ALL})
    @RequestMapping(value="/industryDetail",method = RequestMethod.GET)
    public BaseResult getIndustryDetail(){

        Map<String,double[]> map = economyGdpManger.getIndustryDetail();
        return new BaseResult(map);
    }

    @LoginRequired
    @Permission(permission = {PermissionEnum.VIEW_ALL,PermissionEnum.MANAGE_ALL})
    @RequestMapping(value = "/getIndustryDetail/{year}",method = RequestMethod.GET)
    public BaseResult getYearIndustryDetail(@PathVariable("year") Long year){

        Map<String,double[]> map = economyGdpManger.getYearIndustryDetail(year);
        return new BaseResult(map);
    }
}
