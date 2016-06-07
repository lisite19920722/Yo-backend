/**
 * 310 Inc.
 * All Right Reserved.
 */
package tiger.biz.power.support.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.biz.power.support.PowerGdpCorrelationEnterpriseAverageManager;
import tiger.core.domain.power.PowerGdpCorrelationEnterpriseAverageDomain;
import tiger.core.service.power.PowerGdpCorrelationEnterpriseAverageService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Bongo on 16/3/9.
 */
@Service
public class PowerGdpCorrelationEnterpriseAverageManagerImpl implements PowerGdpCorrelationEnterpriseAverageManager {
    @Autowired
    PowerGdpCorrelationEnterpriseAverageService pgcs;

    @Override
    public List<double[]> getPowerGdpArray(){

        List<double[]> arrays = new ArrayList<>();


        double[] years = new double[13],
                gdps=new double[13],
                powers =new double[13];
        int mark = 0;

        Iterator<PowerGdpCorrelationEnterpriseAverageDomain> e = getPowerGdpCorrelationEnterpriseAverageDomainList().iterator();

        while(e.hasNext()){

            PowerGdpCorrelationEnterpriseAverageDomain temp = e.next();
            years[mark] = temp.getYear();
            gdps[mark] = temp.getGdpValue();
            powers[mark] = temp.getPowerValue();
            mark++;

        }
        arrays.add(years);

        arrays.add(gdps);

        arrays.add(powers);

        return arrays;
    }

    /**
     * @return PowerGdpCorrelationDomainList
     * */
    private List<PowerGdpCorrelationEnterpriseAverageDomain> getPowerGdpCorrelationEnterpriseAverageDomainList(){
        return pgcs.getPowerGdpCorrelationEnterpriseAverageDomainList();
    }
}
