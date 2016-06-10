/**
 * 310 Inc.
 * All Right Reserved.
 */
package tiger.core.domain.power.convert;

import tiger.common.dal.persistence.power.CurrentDateElement;
import tiger.common.dal.persistence.power.PowerGdpCorrelationIndustryDO;
import tiger.core.domain.power.PowerGdpCorrelationIndustrySoloDomain;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Bongo on 16/3/3.
 */
public class PowerGdpCorrelationIndustrySoloConverter {
    private PowerGdpCorrelationIndustrySoloConverter(){}

    public static List<PowerGdpCorrelationIndustrySoloDomain> convertByList(List<PowerGdpCorrelationIndustryDO> dos){

        int currentYear = CurrentDateElement.YEAR,
            startYear = currentYear-10,
            endYear = currentYear+2,
            currentSeason = CurrentDateElement.SEASON;

        List<PowerGdpCorrelationIndustrySoloDomain> domains = new ArrayList<>();

        Iterator<PowerGdpCorrelationIndustryDO> e = dos.iterator();
        while(e.hasNext()){
            PowerGdpCorrelationIndustryDO temp = e.next();

            if(startYear<=temp.getYear()&&temp.getYear()<currentYear){
                domains.add((PowerGdpCorrelationIndustrySoloDomain)PowerConvertUtil.singleConvertOnReal(temp));
            }else if(temp.getYear()==currentYear){
                if (temp.getSeason()>=currentSeason){
                    domains.add((PowerGdpCorrelationIndustrySoloDomain)PowerConvertUtil.singleConvertOnForcast(temp));
                }else {
                    domains.add((PowerGdpCorrelationIndustrySoloDomain)PowerConvertUtil.singleConvertOnReal(temp));
                }
            }else if(temp.getYear()>currentYear&&temp.getYear()<=endYear){
                domains.add((PowerGdpCorrelationIndustrySoloDomain)PowerConvertUtil.singleConvertOnForcast(temp));
            }
        }
        return domains;
    }
}
