/**
 * 310 Inc.
 * All Right Reserved.
 */
package tiger.web.api.controller.power;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tiger.biz.power.support.*;
import tiger.core.basic.BaseResult;
import tiger.web.api.constants.APIConstants;

import java.util.List;
import java.util.Map;

/**
 * Created by Bongo on 16/3/1.
 */
@RestController
@RequestMapping(APIConstants.BASE_API_URL+"/power")
public class PowerGdpCorrelationController {

    @Autowired
    PowerGdpCorrelationManager pgcm;
    @Autowired
    PowerGdpCorrelationEnterpriseAverageManager powerGdpCorrelationEnterpriseAverageManager;
    @Autowired
    PowerGdpCorrelationEnterpriseSoloManager powerGdpCorrelationEnterpriseSoloManager;

    /**
     * 获取工业用电量与经济发展关联分析数据
     *
     * */
    @RequestMapping(value="/total", method = RequestMethod.GET)
    public BaseResult<Map<String, double[]>> getTotal() {
        Map<String, double[]> map = pgcm.getPowerGdpArray();
        return new BaseResult(map);
    }

    /**
     * 获取行业用电量与行业产值对比分析数据
     *
     * */
    @RequestMapping(value = "/industry/total/{year}",method = RequestMethod.GET)
    public BaseResult< Map<String, double[]>> getIndustryMap(@PathVariable("year") String year){
        Map<String, double[]> map =pgcm.getPowerGdpCorrelationIndustryMap(year, "4");//第四季度累计增长率 = 该年同比增长率
        return new BaseResult(map);
    }

    /**
     * 行业用电量与经济发展关联分析 根据行业获取各年度数据
     *
     * */
    @RequestMapping(value = "/industry/{industryId}",method = RequestMethod.GET)
    public BaseResult getIndustrySoloMap(@PathVariable("industryId") String industryId){
        Map map = pgcm.getPowerGdpCorrelationIndustrySoloDomainMapTotal(industryId, "4");
        return new BaseResult(map);
    }

    /**
     * 行业用电量与经济发展关联分析 根据行业和年度获取四个季度的数据
     *
     * */
    @RequestMapping(value = "/industry/{industryId}/{year}",method = RequestMethod.GET)
    public BaseResult getIndustrySoloMap(@PathVariable("industryId") String industryId,
                                         @PathVariable("year") String year){
        Map map = pgcm.getPowerGdpCorrelationIndustrySoloDomainMap(industryId, year, null);
        return new BaseResult(map);
    }

    /**
     * 获取 企业用电量与经济发展关联分析 平均值数据
     *
     * */
    @RequestMapping(value = "/enterprise/average",method = RequestMethod.GET)
    public BaseResult getEnterpriseAverageList(){
        List<double[]> list = powerGdpCorrelationEnterpriseAverageManager.getPowerGdpArray();
        return new BaseResult(list);
    }

    /**
     * 行业用电量与经济发展关联分析 根据行业获取各年度数据
     *
     * */
    @RequestMapping(value = "/enterprise/{enterpriseId}",method = RequestMethod.GET)
    public BaseResult getEnterpriseSoloListTotal(){
        Map map = powerGdpCorrelationEnterpriseSoloManager.getPowerGdpCorrelationIndustrySoloDomainMap();
        return new BaseResult(map);
    }

    /**
     * 行业用电量与经济发展关联分析 根据行业和年度获取四个季度的数据
     *
     * */
    @RequestMapping(value = "/enterprise/{enterpriseId}/{year}",method = RequestMethod.GET)
    public BaseResult getEnterpriseSoloList(){
        Map map = powerGdpCorrelationEnterpriseSoloManager.getPowerGdpCorrelationIndustrySoloDomainMap();
        return new BaseResult(map);
    }
}
