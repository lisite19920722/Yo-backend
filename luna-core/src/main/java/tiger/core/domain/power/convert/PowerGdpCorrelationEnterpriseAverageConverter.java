/**
 * 310 Inc.
 * All Right Reserved.
 */
package tiger.core.domain.power.convert;

import tiger.common.dal.persistence.power.CurrentDateElement;
import tiger.common.dal.persistence.power.PowerGdpCorrelationEnterpriseAverageDO;
import tiger.core.domain.power.PowerGdpCorrelationEnterpriseAverageDomain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Bongo on 16/3/4.
 */
public class PowerGdpCorrelationEnterpriseAverageConverter {
    private PowerGdpCorrelationEnterpriseAverageConverter(){}

    public static List<PowerGdpCorrelationEnterpriseAverageDomain> convertByList(List<PowerGdpCorrelationEnterpriseAverageDO> powerDOs){

        int currentYear = CurrentDateElement.YEAR,
            startYear = currentYear-10,
            endYear = currentYear+2;

        Collections.sort(powerDOs);

        List<PowerGdpCorrelationEnterpriseAverageDomain> powerDomains = new ArrayList<>();

        Iterator<PowerGdpCorrelationEnterpriseAverageDO> e = powerDOs.iterator();
        while(e.hasNext()){
            PowerGdpCorrelationEnterpriseAverageDO temp = e.next();
            if (startYear<=temp.getYear()&&temp.getYear()<currentYear){
                powerDomains.add(singleConvertOnReal(temp));
            }else if(temp.getYear()>=currentYear&&temp.getYear()<=endYear){
                powerDomains.add(singleConvertOnForcast(temp));
            }
        }
        return powerDomains;
    }

    //~私有方法
    private static PowerGdpCorrelationEnterpriseAverageDomain singleConvertOnReal(PowerGdpCorrelationEnterpriseAverageDO powerDO){
        PowerGdpCorrelationEnterpriseAverageDomain powerDomain = new PowerGdpCorrelationEnterpriseAverageDomain();
        powerDomain.setYear(powerDO.getYear());
        powerDomain.setGdpValue(powerDO.getRealGdpValue());
        powerDomain.setPowerValue(powerDO.getRealPowerValue());
        return powerDomain;
    }
    public static PowerGdpCorrelationEnterpriseAverageDomain singleConvertOnForcast(PowerGdpCorrelationEnterpriseAverageDO powerDO){
        PowerGdpCorrelationEnterpriseAverageDomain powerDomain = new PowerGdpCorrelationEnterpriseAverageDomain();
        powerDomain.setYear(powerDO.getYear());
        powerDomain.setGdpValue(powerDO.getForcastGdpValue());
        powerDomain.setPowerValue(powerDO.getForcastPowerValue());
        return powerDomain;
    }

}
