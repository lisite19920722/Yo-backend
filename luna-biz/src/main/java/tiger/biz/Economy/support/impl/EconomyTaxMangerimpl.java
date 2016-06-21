package tiger.biz.Economy.support.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.biz.Economy.support.EconomyTaxManger;
import tiger.common.dal.persistence.EconomyTax.TaxDetailDO;
import tiger.core.service.economyGdp.EconomyTaxService;
import java.util.*;

/**
 * Created by xy86 on 16/6/11.
 */
@Service
public class EconomyTaxMangerimpl implements EconomyTaxManger {


    @Autowired
    private EconomyTaxService economyTaxService;

    Calendar now = Calendar.getInstance();
    int nowtime = now.get(Calendar.YEAR);

    @Override
    public Map<String,double[]> getYearTax(){
        List<TaxDetailDO> taxDetailDOs = economyTaxService.getTaxDetail();

        double RealYearTax[] = new double[13],
                forcastYearTax[] = new double[13],
                yearErrorRate[] = new double[13],
                yearGrowUp[] = new double[13];
        Map<String,double[]> map = new HashMap<>();

        Iterator<TaxDetailDO> e = taxDetailDOs.iterator();

        while(e.hasNext()){
         TaxDetailDO temp = e.next();
            if (temp.getMonth() == 12){
                int i = 10-(nowtime-temp.getYear());
                if (i>=0&&i<=12){
                    RealYearTax[i] = temp.getTaxRealValue();
                    forcastYearTax[i] = temp.getTaxForecastValue();
                    if (temp.getTaxRealValue()==0){

                    }else{
                        java.text.DecimalFormat df = new java.text.DecimalFormat("#.0");
                        yearErrorRate[i] = Double.parseDouble(df.format(Math.abs((temp.getTaxRealValue()- temp.getTaxForecastValue()) / temp.getTaxForecastValue())*100));
                     }

                    yearGrowUp[i] = temp.getTaxGrowthRate();
                }
            }
        }
        map.put("realYearTax",RealYearTax);
        map.put("forecastYearTax",forcastYearTax);
        map.put("yearErrorRate",yearErrorRate);
        map.put("yearGrowUp",yearGrowUp);
        return map;
    }

    @Override
    public Map<String,double[]> getYearTaxDetail(Long year){
        List<TaxDetailDO> taxDetailDOs = economyTaxService.getYearTaxDetail(year);

        double RealTaxMonthDetail[] = new double[11],
                forecastTaxMonthDetail[] = new double[11],
                monthErrorRate[] = new double[11],
                monthGrowUp[] = new double[11];
        Map<String,double[]> map = new HashMap<>();
        Iterator<TaxDetailDO> e = taxDetailDOs.iterator();

        while(e.hasNext()){
            TaxDetailDO temp = e.next();
            RealTaxMonthDetail[temp.getMonth()-2]=temp.getTaxRealValue();
            forecastTaxMonthDetail[temp.getMonth()-2]=temp.getTaxForecastValue();
            if (temp.getTaxRealValue()==0){

            }else{
                java.text.DecimalFormat df = new java.text.DecimalFormat("#.0");
                monthErrorRate[temp.getMonth()-2]=Double.parseDouble(df.format(Math.abs((temp.getTaxRealValue()-temp.getTaxForecastValue())/temp.getTaxForecastValue())*100));
            }
            monthGrowUp[temp.getMonth()-2] = temp.getTaxGrowthRate();
        }
        map.put("realTaxMonthDetail",RealTaxMonthDetail);
        map.put("forecastTaxMonthDetail",forecastTaxMonthDetail);
        map.put("monthErrorRate",monthErrorRate);
        map.put("monthGrowUp",monthGrowUp);
        return map;
    }
}
