/**
 * 310 Inc.
 * All Right Reserved.
 */
package tiger.biz.power.support.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.biz.power.support.PowerGdpCorrelationEnterpriseSoloManager;
import tiger.common.dal.persistence.power.CurrentDateElement;
import tiger.core.domain.power.PowerGdpCorrelationEnterpriseSoloDomain;
import tiger.core.service.power.PowerGdpCorrelationEnterpriseAverageService;

import java.util.*;

/**
 * Created by Bongo on 16/3/9.
 */
@Service
public class PowerGdpCorrelationEnterpriseSoloManagerImpl implements PowerGdpCorrelationEnterpriseSoloManager {
    @Autowired
    PowerGdpCorrelationEnterpriseAverageService powerGdpCorrelationEnterpriseAverageService;

    @Override
    public Map<Integer,List> getPowerGdpCorrelationIndustrySoloDomainMap(){

        List<PowerGdpCorrelationEnterpriseSoloDomain> list = getPowerGdpCorrelationEnterpriseSoloDomainList();

        Map<Integer,List> map = new HashMap<>();

        int industryMark=5001;

        for (int i=0;i<50;i++){

            Iterator<PowerGdpCorrelationEnterpriseSoloDomain> e = list.iterator();

            List mapList = new ArrayList();

            double[] gdps = new double[13],
                    powers = new double[13];
            int mark = 0;

            Map<Integer,List<double[]>> nestedMap = new HashMap<>();

            int yearMark = CurrentDateElement.YEAR-10;

            for (int j=0;j<13;j++){

                List<double[]> nestedList = new ArrayList<>();
                double[] gdpss = new double[4],
                        powerss = new double[4];
                int markk=0;

                Iterator<PowerGdpCorrelationEnterpriseSoloDomain> in = list.iterator();
                while(in.hasNext()){

                    PowerGdpCorrelationEnterpriseSoloDomain temp = in.next();
                    if (temp.getEnterpriseId()==industryMark&&temp.getYear()==yearMark&&temp.getSeason()!=0){

                        gdpss[markk] = temp.getGdpValue();
                        powerss[markk] = temp.getPowerValue();

                        markk++;

                    }

                }
                nestedList.add(gdpss);
                nestedList.add(powerss);
                nestedMap.put(yearMark,nestedList);

                yearMark++;

            }

            while(e.hasNext()){

                PowerGdpCorrelationEnterpriseSoloDomain temp = e.next();

                if (temp.getEnterpriseId()==industryMark&&temp.getSeason()==4){

                    gdps[mark] = temp.getGdpValue();
                    powers[mark] = temp.getPowerValue();
                    mark++;

                }

            }

            mapList.add(gdps);
            mapList.add(powers);
            mapList.add(nestedMap);

            map.put(industryMark,mapList);
            industryMark++;

        }
        return map;
    }

    @Override
    public List<PowerGdpCorrelationEnterpriseSoloDomain> getPowerGdpCorrelationEnterpriseSoloDomainList(){
        return powerGdpCorrelationEnterpriseAverageService.getPowerGdpCorrelationEnterpriseSoloDomainList();
    }
}
