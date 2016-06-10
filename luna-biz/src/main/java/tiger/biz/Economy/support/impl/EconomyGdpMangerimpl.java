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

    Calendar now = Calendar.getInstance();
    int nowtime = now.get(Calendar.YEAR);

    @Override
    public Map<String, double[]> getGdpDetail(Long year)
    {

       List<GdpDetailDO> gdpDetailDOList = economyGdpService.getGdpDetail(year);

        double RealGdpQuarterDetail[] = new double[4],
               forecastGdpQuarterDetail[] = new double[4],
               quarterErroRate[] = new double[4],
               quarterGrowUp[] = new double[4];
        Map<String,double[]> map = new HashMap<>();
        Iterator<GdpDetailDO> e = gdpDetailDOList.iterator();

        while(e.hasNext()){
            GdpDetailDO temp = e.next();
            if (temp.getIndustryType_id() == 11){
                RealGdpQuarterDetail[temp.getQuarter()-1] = temp.getGdpRealValue();
                forecastGdpQuarterDetail[temp.getQuarter()-1] = temp.getGdpForecastValue();
                if (temp.getGdpRealValue() == 0){

                }else {
                    java.text.DecimalFormat df = new java.text.DecimalFormat("#.0");
                    quarterErroRate[temp.getQuarter()-1]=Double.parseDouble(df.format(Math.abs((temp.getGdpRealValue()-temp.getGdpForecastValue())/temp.getGdpForecastValue())*100));
                }

                quarterGrowUp[temp.getQuarter()-1]=temp.getGdpGrowthRate();
            }

        }
        map.put("realGdpQuarterDetail",RealGdpQuarterDetail);
        map.put("forecastGdpQuterDetail",forecastGdpQuarterDetail);
        map.put("quarterError",quarterErroRate);
        map.put("growRate",quarterGrowUp);
        return map;
    }

    public Map<String, double[]> getYearGdp(){
        List<GdpDetailDO> gdpDetailDOList = economyGdpService.getYearGdp();
        double RealYearGdp[] = new double[12],
                forecastYearGdp[] = new double[12],
                yearErrorRate[] = new double[12],
                yearGrowUp[] = new double[12];
        Map<String, double[]> yearmap = new HashMap<>();

        Iterator<GdpDetailDO> yeare = gdpDetailDOList.iterator();

        while(yeare.hasNext()){
            GdpDetailDO temp = yeare.next();
            if (temp.getIndustryType_id() == 11 && temp.getQuarter() == 4){
                int i = 9-(nowtime-temp.getYear());
                if (i>=0&&i<=11) {
                    RealYearGdp[i] = temp.getGdpRealValue();
                    forecastYearGdp[i] = temp.getGdpForecastValue();
                    if (temp.getGdpRealValue()==0){

                    }else{
                        java.text.DecimalFormat df = new java.text.DecimalFormat("#.0");
                        yearErrorRate[i] = Double.parseDouble(df.format(Math.abs((temp.getGdpRealValue()- temp.getGdpForecastValue()) / temp.getGdpForecastValue())*100));
                    }

                    yearGrowUp[i] = temp.getGdpGrowthRate();
                }
            }
        }
         yearmap.put("realYearGdp",RealYearGdp);
         yearmap.put("forecastYearGdp",forecastYearGdp);
         yearmap.put("yearErrorRate",yearErrorRate);
         yearmap.put("yearGrow",yearGrowUp);
         return yearmap;

    }

    public Map<String,double[]> getIndustryDetail(){
        List<GdpDetailDO> gdpDetailDOList = economyGdpService.getIndustryDetail();
        double FirstRealYearGdp[] = new double[12],
               FirstForecastYearGdp[] = new double[12],
               SecondRealYearGdp[] = new double[12],
                SecondForcastYearGdp[] = new double[12],
                ThirdRealYearGdp[] = new double[12],
                ThirdForcastYearGdp[] = new double[12];
        Map<String,double[]> map = new HashMap<>();

        Iterator<GdpDetailDO> e = gdpDetailDOList.iterator();

        while(e.hasNext()){
            GdpDetailDO temp = e.next();
            if (temp.getIndustryType_id() == 12 && temp.getQuarter() ==4){
                int x = 9-(nowtime-temp.getYear());
                if (x>=0&&x<=11){
                    FirstRealYearGdp[x] = temp.getGdpRealValue();
                    FirstForecastYearGdp[x] = temp.getGdpForecastValue();
                }
            }else if (temp.getIndustryType_id() == 13 && temp.getQuarter() == 4){
                int y = 9-(nowtime-temp.getYear());
                if (y>=0&&y<=11){
                    SecondRealYearGdp[y] = temp.getGdpRealValue();
                    SecondForcastYearGdp[y] = temp.getGdpForecastValue();
                }
            }else if (temp.getIndustryType_id() == 14 && temp.getQuarter() == 4){
                int z = 9-(nowtime-temp.getYear());
                if (z>=0&&z<=11){
                    ThirdRealYearGdp[z] = temp.getGdpRealValue();
                    ThirdForcastYearGdp[z] = temp.getGdpForecastValue();
                }
            }
        }

        map.put("FirstRealYearGdp",FirstRealYearGdp);
        map.put("SecondRealYearGdp",SecondRealYearGdp);
        map.put("ThirdRealYearGdp",ThirdRealYearGdp);
        map.put("FirstForecastYearGdp",FirstForecastYearGdp);
        map.put("SecondForecastYearGdp",SecondForcastYearGdp);
        map.put("ThirdForecastYearGdp",ThirdForcastYearGdp);
        return map;
    }
}
