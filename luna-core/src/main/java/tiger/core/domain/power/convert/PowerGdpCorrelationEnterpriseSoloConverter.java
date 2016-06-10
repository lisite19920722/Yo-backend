/**
 * 310 Inc.
 * All Right Reserved.
 */
package tiger.core.domain.power.convert;

import tiger.common.dal.persistence.power.CurrentDateElement;
import tiger.common.dal.persistence.power.PowerGdpCorrelationEnterpriseSoloDO;
import tiger.core.domain.power.PowerGdpCorrelationEnterpriseSoloDomain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Bongo on 16/3/4.
 */
public class PowerGdpCorrelationEnterpriseSoloConverter {
    private PowerGdpCorrelationEnterpriseSoloConverter(){}

    public static List<PowerGdpCorrelationEnterpriseSoloDomain> convertByList(List<PowerGdpCorrelationEnterpriseSoloDO> dos){

        int currentYear = CurrentDateElement.YEAR,
            startYear = currentYear-10,
            endYear = currentYear+2,
            currentSeason = CurrentDateElement.SEASON;

        List<PowerGdpCorrelationEnterpriseSoloDomain> domains = new ArrayList<>();

        Iterator<PowerGdpCorrelationEnterpriseSoloDO> e = dos.iterator();
        while(e.hasNext()){
            PowerGdpCorrelationEnterpriseSoloDO temp = e.next();

            if(startYear<=temp.getYear()&&temp.getYear()<currentYear){
                domains.add((PowerGdpCorrelationEnterpriseSoloDomain)PowerConvertUtil.singleConvertOnReal(temp));
            }else if(temp.getYear()==currentYear){
                if (temp.getSeason()==0){
                    domains.add((PowerGdpCorrelationEnterpriseSoloDomain)PowerConvertUtil.singleConvertOnForcast(temp));
                }else if(temp.getSeason()<currentSeason){
                    domains.add((PowerGdpCorrelationEnterpriseSoloDomain)PowerConvertUtil.singleConvertOnReal(temp));
                }else{
                    domains.add((PowerGdpCorrelationEnterpriseSoloDomain)PowerConvertUtil.singleConvertOnForcast(temp));
                }
            }else if(temp.getYear()>currentYear&&temp.getYear()<=endYear){
                domains.add((PowerGdpCorrelationEnterpriseSoloDomain)PowerConvertUtil.singleConvertOnForcast(temp));
            }
        }
        return domains;
    }
}
