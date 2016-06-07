/**
 * 310 Inc.
 * All Right Reserved.
 */
package tiger.biz.power.support.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.biz.power.support.PowerGdpCorrelationManager;
import tiger.common.dal.persistence.power.CurrentDateElement;
import tiger.core.domain.power.PowerGdpCorrelationDomain;
import tiger.core.domain.power.PowerGdpCorrelationIndustryDomain;
import tiger.core.domain.power.PowerGdpCorrelationIndustrySoloDomain;
import tiger.core.service.power.PowerGdpCorrelationIndustryService;
import tiger.core.service.power.PowerGdpCorrelationService;

import java.util.*;

/**
 * Created by Bongo on 16/3/9.
 */
@Service
public class PowerGdpCorrelationManagerImpl implements PowerGdpCorrelationManager {

    @Autowired
    PowerGdpCorrelationService total;
    @Autowired
    PowerGdpCorrelationIndustryService industry;
    @Autowired
    PowerGdpCorrelationIndustryService industrySolo;

    /**
     * @see PowerGdpCorrelationManager#getPowerGdpArray()
     */
    @Override
    public Map<String, double[]> getPowerGdpArray(){

        int startYear = CurrentDateElement.YEAR - 10;
        int endYear = CurrentDateElement.YEAR + 2;
        Iterator<PowerGdpCorrelationDomain> e = getPowerGdpCorrelationDomainList(Integer.toString(startYear), Integer.toString(endYear)).iterator();
        Map<String, double[]> map = new HashMap<>();
        //显示十三年数据
        double[] years = new double[13],
                 gdps = new double[13],
                 powers = new double[13];
        int count = 0;
        while(e.hasNext()){
            PowerGdpCorrelationDomain temp = e.next();
            years[count] = temp.getYear();
            gdps[count] = temp.getGdpValue();
            powers[count] = temp.getPowerValue();
            count++;
        }
        map.put("years",years);
        map.put("gdps",gdps);
        map.put("powers",powers);

        return map;
    }

    /**
     * @see PowerGdpCorrelationManager#getPowerGdpCorrelationIndustryMap(String, String)
     * */
    public Map<String, double[]> getPowerGdpCorrelationIndustryMap(String year, String season){
        Map<String, double[]> map = new HashMap<>();
        List<PowerGdpCorrelationIndustryDomain> domains = getPowerGdpCorrelationIndustryDomainList(year, season);
        Iterator<PowerGdpCorrelationIndustryDomain> e = domains.iterator();

        double[] industryIds = new double[8],
                 gdps = new double[8],
                 powers = new double[8];
        int count = 0;
        while(e.hasNext()){
            PowerGdpCorrelationIndustryDomain temp = e.next();
            industryIds[count] = temp.getIndustryId();
            gdps[count] = temp.getIndustryGdp();
            powers[count] = temp.getIndustryPower();
            count++;
        }
        map.put("ids",industryIds);
        map.put("gdps",gdps);
        map.put("powers",powers);
        return map;
    }

    /**
     * @see PowerGdpCorrelationManager#getPowerGdpCorrelationIndustrySoloDomainMap(String, String, String)
     */
    @Override
    public Map<String,double[]> getPowerGdpCorrelationIndustrySoloDomainMap(String industryId, String year, String season){

        List<PowerGdpCorrelationIndustrySoloDomain> list = getPowerGdpCorrelationIndustrySoloDomainList(industryId, year, year, season);
        Map<String,double[]> map = new HashMap<>();

        double[] gdps = new double[4],
                 powers = new double[4],
                 seasons = new double[4];
        int count = 0;
        Iterator<PowerGdpCorrelationIndustrySoloDomain> in = list.iterator();
        while(in.hasNext()){
            PowerGdpCorrelationIndustrySoloDomain temp = in.next();
            seasons[count] = temp.getSeason();
            gdps[count] = temp.getGdpValue();
            powers[count] = temp.getPowerValue();
            count++;
        }
        map.put("seasons",seasons);
        map.put("gdps",gdps);
        map.put("powers",powers);
        return map;
    }

    /**
     * @see PowerGdpCorrelationManager#getPowerGdpCorrelationIndustrySoloDomainMapTotal(String, String)
     */
    @Override
    public Map<String, double[]> getPowerGdpCorrelationIndustrySoloDomainMapTotal(String industryId, String season) {
        int startYear = CurrentDateElement.YEAR - 10;
        int endYear = CurrentDateElement.YEAR + 2;
        List<PowerGdpCorrelationIndustrySoloDomain> list = getPowerGdpCorrelationIndustrySoloDomainList(industryId, Integer.toString(startYear), Integer.toString(endYear), season);
        Map<String,double[]> map = new HashMap<>();
        double[] gdps = new double[13],
                 powers = new double[13],
                 years = new double[13];
        int count = 0;
        Iterator<PowerGdpCorrelationIndustrySoloDomain> in = list.iterator();
        while(in.hasNext()){
            PowerGdpCorrelationIndustrySoloDomain temp = in.next();
            years[count] = temp.getYear();
            gdps[count] = temp.getGdpValue();
            powers[count] = temp.getPowerValue();
            count++;
        }
        map.put("years",years);
        map.put("gdps",gdps);
        map.put("powers",powers);
        return map;
    }

    //~ private method
    private List<PowerGdpCorrelationIndustrySoloDomain> getPowerGdpCorrelationIndustrySoloDomainList(String industryId, String startYear, String endYear, String season){
        return industrySolo.getPowerGdpCorrelationIndustrySoloDomainList(industryId, startYear, endYear, season);
    }
    private List<PowerGdpCorrelationDomain> getPowerGdpCorrelationDomainList(String startYear, String endYear){
        return total.getPowerGdpCorrelationDomainList(startYear, endYear);
    }
    private List<PowerGdpCorrelationIndustryDomain> getPowerGdpCorrelationIndustryDomainList(String year, String season){
        return industry.getPowerGdpCorrelationIndustryDomainList(year, season);
    }
}
