/**
 * 310 Inc.
 * All Right Reserved.
 */
package tiger.core.domain.power.convert;

import tiger.common.dal.persistence.power.PowerGdpCorrelationIndustryDO;
import tiger.core.domain.power.PowerGdpCorrelationIndustryDomain;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Bongo on 16/3/2.
 */
public class PowerGdpCorrelationIndustryConverter {
    private PowerGdpCorrelationIndustryConverter(){}

    public static List<PowerGdpCorrelationIndustryDomain> convertByList(List<PowerGdpCorrelationIndustryDO> dos){

        int currentYear = Integer.parseInt( (new SimpleDateFormat("yyyy").format(new Date())) );

        int startYear = currentYear-9;

        int endYear = currentYear+2;

        Collections.sort(dos);

        List<PowerGdpCorrelationIndustryDomain> domains = new ArrayList<>();

        //Domain's target: extract data of certain years(now is 2007->2018)
        Iterator<PowerGdpCorrelationIndustryDO> e = dos.iterator();

        while(e.hasNext()){

            PowerGdpCorrelationIndustryDO temp = e.next();

            if (startYear<=temp.getYear()&&temp.getYear()<currentYear){

                domains.add(singleConvertOnReal(temp));

            }else if(temp.getYear()>=currentYear&&temp.getYear()<=endYear){

                domains.add(singleConvertOnForcast(temp));

            }
        }

        return domains;

    }

    //~私有方法
    /**
     * @return PowerGdpCorrelationIndustryDomain 如果是真实值则调用
     * @param DO
     * */
    private static PowerGdpCorrelationIndustryDomain singleConvertOnReal(PowerGdpCorrelationIndustryDO DO){

        PowerGdpCorrelationIndustryDomain domain = new PowerGdpCorrelationIndustryDomain();

        domain.setYear(DO.getYear());

        domain.setIndustryId(DO.getIndustryId());

        domain.setIndustryGdp(DO.getRealIndustryGdp());

        domain.setIndustryPower(DO.getRealIndustryPower());

        return domain;

    }

    /**
     * @return PowerGdpCorrelationIndustryDomain 如果是预测值则调用
     * @param DO
     * */
    private static PowerGdpCorrelationIndustryDomain singleConvertOnForcast(PowerGdpCorrelationIndustryDO DO){

        PowerGdpCorrelationIndustryDomain domain = new PowerGdpCorrelationIndustryDomain();

        domain.setYear(DO.getYear());

        domain.setIndustryId(DO.getIndustryId());

        domain.setIndustryGdp(DO.getForcastIndustryGdp());

        domain.setIndustryPower(DO.getForcastIndustryPower());

        return domain;

    }

}
