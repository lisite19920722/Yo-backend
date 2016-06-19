/**
 * Gambition Inc.
 * All Right Reserved.
 */
package tiger.web.api.controller.population;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tiger.biz.population.suport.C_PopulationManager;
import tiger.common.dal.annotation.LoginRequired;
import tiger.common.dal.annotation.Permission;
import tiger.common.dal.enums.PermissionEnum;
import tiger.core.basic.BaseResult;
import tiger.web.api.constants.APIConstants;
import tiger.web.api.controller.BaseController;


/**
 * @Author: [mondooo.cgq]
 * @version: [V 0.1.1]
 * @CreateDate: [16/6/13 10:40]
 */
@RestController
@RequestMapping(APIConstants.BASE_API_URL+"/population")
public class C_PopulationController extends BaseController {
    @Autowired
    private C_PopulationManager populationManager;

    /**
     * 貌似是就业和保险相关的API
     *
     * @return
     */
    @LoginRequired
    @Permission(permission = {PermissionEnum.VIEW_ALL,PermissionEnum.MANAGE_ALL})
    @RequestMapping(value="/populationEmployInsuranceData/list", method = RequestMethod.GET)
    public BaseResult getEmployInsuranceSchoolList()
    {
        return new BaseResult(populationManager.getEmployInsuranceSchoolList());
    }

    /**
     * 貌似是人口经济关联分析的API
     *
     * @return
     */
    @LoginRequired
    @Permission(permission = {PermissionEnum.VIEW_ALL,PermissionEnum.MANAGE_ALL})
    @RequestMapping(value="/laborGdpRelationPreData/list", method = RequestMethod.GET)
    public BaseResult getLaborGdpRelationPreData()
    {
        return new BaseResult(populationManager.getLaborGdpRelationPreData());
    }

    /**
     * 貌似是人口结构的API
     *
     * @return
     */
    @LoginRequired
    @Permission(permission = {PermissionEnum.VIEW_ALL,PermissionEnum.MANAGE_ALL})
    @RequestMapping(value="/populationStructurePreData/list", method = RequestMethod.GET)
    public BaseResult getPopulationStructurePreData()
    {
        return new BaseResult(populationManager.getPopulationStructurePreData());
    }

    /**
     * 貌似是人口总量的API
     *
     * @return
     */
    @LoginRequired
    @Permission(permission = {PermissionEnum.VIEW_ALL,PermissionEnum.MANAGE_ALL})
    @RequestMapping(value="/sumPopulationData/list", method = RequestMethod.GET)
    public BaseResult getSumPopulationData()
    {
        return new BaseResult(populationManager.getSumPopulationData());
    }

    /**
     * 貌似是人口自然增长率的API
     *
     * @return
     */
    @LoginRequired
    @Permission(permission = {PermissionEnum.VIEW_ALL,PermissionEnum.MANAGE_ALL})
    @RequestMapping(value="/birthrateData/list", method = RequestMethod.GET)
    public BaseResult getBirthrateData()
    {
        return new BaseResult(populationManager.getBirthrateData());
    }
}
