package tiger.web.api.controller.economyGdp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tiger.core.basic.BaseResult;
import tiger.web.api.constants.APIConstants;
import tiger.biz.Economy.support.EconomyGdpManger;
import tiger.common.dal.persistence.mapper.EconomyGDP.GdpDetailDO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Created by xy86 on 16/6/9.
 */
@RestController
@RequestMapping(APIConstants.BASE_API_URL + "/economy/gdp")
public class EconomyGdpController {

    @Autowired
    private EconomyGdpManger economyGdpManger;

    @RequestMapping(value="/gdpDetail/{year}",method = RequestMethod.GET);

    public BaseResult getGdpDatil(@PathVariable("year") Long year)

    {

        List<GdpDetailDO> gdpDatilDOList = economyGdpManger.getGdpDetail(year);
        List<double[]> arrays=new ArrayList<>();
        double RealGdpQuarterDetail[] = new double[4];
        double forecastGdpQuarterDetail[] = new double[4];
        double erroRate[] = new double[4];

        Iterator<GdpDetailDO> e = gdpDatilDOList.iterator();

        while(e.hasNext()){
            GdpDetailDO temp = e.next();
            if (temp.getIndustryType_id() == 11){
                RealGdpQuarterDetail[temp.getQuarter()-1] = temp.getGdpRealValue();
                forecastGdpQuarterDetail[temp.getQuarter()-1] = temp.getGdpForecastValue();
                double
            }
        }
    }
}
