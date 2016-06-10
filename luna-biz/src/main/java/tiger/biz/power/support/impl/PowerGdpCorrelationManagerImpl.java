/**
 * 310 Inc.
 * All Right Reserved.
 */
package tiger.biz.power.support.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.biz.power.support.PowerGdpCorrelationManager;
import tiger.common.dal.persistence.power.CurrentDateElement;
import tiger.core.domain.power.*;
import tiger.core.service.power.impl.PowerServiceImpl;

import java.util.*;

/**
 * Created by Bongo on 16/3/1.
 * Refactored by Bongo on 16/6/9
 */
@Service
public class PowerGdpCorrelationManagerImpl implements PowerGdpCorrelationManager {

    @Autowired
    PowerServiceImpl powerService;

    /**
     * @see PowerGdpCorrelationManager#getPowerGdpArray()
     */
    @Override
    public Map<String, double[]> getPowerGdpArray(){

        Map<String, double[]> map = new HashMap<>();
        double[] years = new double[13],
                gdps = new double[13],
                powers = new double[13];

        int startYear = CurrentDateElement.YEAR - 10,
            endYear = CurrentDateElement.YEAR + 2;
        int count = 0;
        Iterator<PowerGdpCorrelationDomain> e = getPowerGdpCorrelationDomainList(Integer.toString(startYear), Integer.toString(endYear)).iterator();
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
        double[] industryIds = new double[8],
                 gdps = new double[8],
                 powers = new double[8];
        List<PowerGdpCorrelationIndustryDomain> domains = getPowerGdpCorrelationIndustryDomainList(year, season);
        int count = 0;
        Iterator<PowerGdpCorrelationIndustryDomain> e = domains.iterator();
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
        Map<String,double[]> map = new HashMap<>();
        double[] gdps = new double[4],
                 powers = new double[4],
                 seasons = new double[4];
        List<PowerGdpCorrelationIndustrySoloDomain> list = getPowerGdpCorrelationIndustrySoloDomainList(industryId, year, year, season);
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
        Map<String,double[]> map = new HashMap<>();
        double[] gdps = new double[13],
                 powers = new double[13],
                 years = new double[13];
        int startYear = CurrentDateElement.YEAR - 10;
        int endYear = CurrentDateElement.YEAR + 2;
        int count = 0;
        List<PowerGdpCorrelationIndustrySoloDomain> list = getPowerGdpCorrelationIndustrySoloDomainList(industryId, Integer.toString(startYear), Integer.toString(endYear), season);
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

    @Override
    public Map<String, double[]> getEnterpriseAverageArray() {
        Map<String, double[]> map = new HashMap<>();
        double[] years = new double[13],
                 gdps = new double[13],
                 powers = new double[13];
        int startYear = CurrentDateElement.YEAR - 10;
        int endYear = CurrentDateElement.YEAR + 2;
        int count = 0;
        Iterator<PowerGdpCorrelationEnterpriseAverageDomain> e = getEnterpriseAverageDomainList(Integer.toString(startYear), Integer.toString(endYear)).iterator();
        while(e.hasNext()){
            PowerGdpCorrelationEnterpriseAverageDomain temp = e.next();
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
     * @see PowerGdpCorrelationManager#getPowerGdpCorrelationEnterpriseSoloDomainMap(String, String, String)
     */
    @Override
    public Map<String,double[]> getPowerGdpCorrelationEnterpriseSoloDomainMap(String industryId, String year, String season){

        Map<String,double[]> map = new HashMap<>();
        double[] gdps = new double[4],
                 powers = new double[4],
                 seasons = new double[4];
        int count = 0;
        List<PowerGdpCorrelationEnterpriseSoloDomain> list = getPowerGdpCorrelationEnterpriseSoloDomainList(industryId, year, year, season);
        Iterator<PowerGdpCorrelationEnterpriseSoloDomain> in = list.iterator();
        while(in.hasNext()){
            PowerGdpCorrelationEnterpriseSoloDomain temp = in.next();
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
     * @see PowerGdpCorrelationManager#getPowerGdpCorrelationEnterpriseSoloDomainMapTotal(String, String)
     */
    @Override
    public Map<String, double[]> getPowerGdpCorrelationEnterpriseSoloDomainMapTotal(String industryId, String season) {
        Map<String,double[]> map = new HashMap<>();
        double[] gdps = new double[13],
                 powers = new double[13],
                 years = new double[13];
        int startYear = CurrentDateElement.YEAR - 10;
        int endYear = CurrentDateElement.YEAR + 2;
        int count = 0;
        List<PowerGdpCorrelationEnterpriseSoloDomain> list = getPowerGdpCorrelationEnterpriseSoloDomainList(industryId, Integer.toString(startYear), Integer.toString(endYear), season);
        Iterator<PowerGdpCorrelationEnterpriseSoloDomain> in = list.iterator();
        while(in.hasNext()){
            PowerGdpCorrelationEnterpriseSoloDomain temp = in.next();
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
        return powerService.getPowerGdpCorrelationIndustrySoloDomainList(industryId, startYear, endYear, season);
    }
    private List<PowerGdpCorrelationEnterpriseSoloDomain> getPowerGdpCorrelationEnterpriseSoloDomainList(String industryId, String startYear, String endYear, String season){
        return powerService.getPowerGdpCorrelationEnterpriseSoloDomainList(industryId, startYear, endYear, season);
    }
    private List<PowerGdpCorrelationDomain> getPowerGdpCorrelationDomainList(String startYear, String endYear){
        return powerService.getPowerGdpCorrelationDomainList(startYear, endYear);
    }
    private List<PowerGdpCorrelationEnterpriseAverageDomain> getEnterpriseAverageDomainList(String startYear, String endYear){
        return powerService.getEnterpriseAverageDomainList(startYear, endYear);
    }
    private List<PowerGdpCorrelationIndustryDomain> getPowerGdpCorrelationIndustryDomainList(String year, String season){
        return powerService.getPowerGdpCorrelationIndustryDomainList(year, season);
    }
}
