package tiger.biz.Economy.support.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.biz.Economy.support.EconomyGdpManger;
import tiger.core.basic.BaseResult;
import tiger.core.service.economyGdp.EconomyGdpService;
import tiger.common.dal.persistence.EconomyGDP.GdpDetailDO;

import java.util.*;

/**
 * Created by xy86 on 16/6/9.
 */
@Service
public class EconomyGdpMangerimpl implements EconomyGdpManger{

    @Autowired
    private EconomyGdpService economyGdpService;

    @Override
    public Map<String, double[]> getGdpDetail(Long year)
    {

       List<GdpDetailDO> gdpDetailDOList = economyGdpService.getGdpDetail(year);
        List<double[]> arrays=new ArrayList<>();
        double RealGdpQuarterDetail[] = new double[4],
               forecastGdpQuarterDetail[] = new double[4],
               quarterErroRate[] = new double[4];
        Map<String,double[]> map = new HashMap<>();
        Iterator<GdpDetailDO> e = gdpDetailDOList.iterator();

        while(e.hasNext()){
            GdpDetailDO temp = e.next();
            if (temp.getIndustryType_id() == 11){
                RealGdpQuarterDetail[temp.getQuarter()-1] = temp.getGdpRealValue();
                forecastGdpQuarterDetail[temp.getQuarter()-1] = temp.getGdpForecastValue();
                quarterErroRate[temp.getQuarter()-1]=Math.abs((temp.getGdpRealValue()-temp.getGdpForecastValue())/temp.getGdpForecastValue());
            }

        }
        map.put("realGdpQuarterDetail",RealGdpQuarterDetail);
        map.put("forecastGdpQuterDetail",forecastGdpQuarterDetail);
        map.put("quarterError",quarterErroRate);
        return map;
    }
}
