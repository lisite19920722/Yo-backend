/**
 * Gambition Inc.
 * All Right Reserved.
 */
package tiger.biz.population.suport.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.biz.population.suport.C_PopulationManager;
import tiger.common.dal.persistence.population.*;
import tiger.core.service.population.C_PopulationService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: [mondooo.cgq]
 * @version: [V 0.1.1]
 * @CreateDate: [16/6/13 10:55]
 */
@Service
public class C_PopulationManagerImpl implements C_PopulationManager {

    @Autowired
    private C_PopulationService populationService;

    /**
     * @see C_PopulationManager#getPopulationStructurePreData()
     */
    @Override
    public List<PopulationStructurePreDO> getPopulationStructurePreData() {
        return populationService.getPopulationStructurePreData();
    }

    /**
     * @see C_PopulationManager#getSumPopulationData()
     */
    @Override
    public List<SumPopulationDO> getSumPopulationData() {
        return populationService.getSumPopulationData();
    }

    /**
     * @see C_PopulationManager#getBirthrateData()
     */
    @Override
    public List<BirthrateDO> getBirthrateData() {
        return populationService.getBirthrateData();
    }

    /**
     * @see C_PopulationManager#getEmployInsuranceList()
     */
    @Override
    public List<PopulationEmployInsuranceDO> getEmployInsuranceList() {
        return populationService.getEmployInsuranceList();
    }

    /**
     * @see C_PopulationManager#getSchoolList()
     */
    @Override
    public List<PopulationSchoolDO> getSchoolList() {
        return populationService.getSchoolList();
    }

    /**
     * @see C_PopulationManager#getLaborGdpRelationPreData()
     */
    @Override
    public List<LaborGdpRelationPreDO> getLaborGdpRelationPreData() {
        return populationService.getLaborGdpRelationPreData();
    }

    /**
     * @see C_PopulationManager#getEmployInsuranceSchoolList()
     */
    @Override
    public List<double[][]> getEmployInsuranceSchoolList() {
        List<PopulationEmployInsuranceDO> populationEmployInsuranceList = populationService.getEmployInsuranceList();
        List<PopulationSchoolDO> schoolDOList = populationService.getSchoolList();

        Double[][] preLaborPopulation = new Double[3][10],
                preEmployedPopulation = new Double[3][10],
                preFirstPopulation = new Double[3][10],
                preSecondPopulation = new Double[3][10],
                preThirdPopulation = new Double[3][10],
                preInsurance = new Double[3][10],
                preOldRate = new Double[3][10],
                preLaborRate = new Double[3][10];

        Long[][] prePrimarySchool = new Long[3][10],
                preMiddleSchool = new Long[3][10],
                preHighschool = new Long[3][10];

        Iterator iterator = populationEmployInsuranceList.iterator();
        Iterator iteratorSchool = schoolDOList.iterator();
        int index = 0;
        while (iterator.hasNext())
        {
            PopulationEmployInsuranceDO populationEmployInsuranceDO   = (PopulationEmployInsuranceDO) iterator.next();
            PopulationSchoolDO schoolDO = (PopulationSchoolDO) iteratorSchool.next();
            preLaborPopulation[index/10][index%10] = Double.valueOf(populationEmployInsuranceDO.getPreLaborPopulation());
            preEmployedPopulation[index/10][index%10] = Double.valueOf(populationEmployInsuranceDO.getPreEmployedPopulation());
            preFirstPopulation[index/10][index%10] = Double.valueOf(populationEmployInsuranceDO.getPreFirstPopulation());
            preSecondPopulation[index/10][index%10] = Double.valueOf(populationEmployInsuranceDO.getPreSecondPopulation());
            preThirdPopulation[index/10][index%10] = Double.valueOf(populationEmployInsuranceDO.getPreThirdPopulation());
            preInsurance[index/10][index%10] = Double.valueOf(populationEmployInsuranceDO.getPreInsurance());
            preOldRate[index/10][index%10] = Double.valueOf(populationEmployInsuranceDO.getPreOldRate());
            preLaborRate[index/10][index%10] = Double.valueOf(populationEmployInsuranceDO.getPreLaborRate());
            prePrimarySchool[index/10][index%10] =schoolDO.getPrePrimarySchool();
            preMiddleSchool[index/10][index%10] = schoolDO.getPreMiddleSchool();
            preHighschool[index/10][index%10] = schoolDO.getPreHighschool();
            index++;
        }
        List  list  = new ArrayList<>();
        list.add(preLaborPopulation);
        list.add(preEmployedPopulation);
        list.add(preFirstPopulation);
        list.add(preSecondPopulation);
        list.add(preThirdPopulation);
        list.add(preInsurance);
        list.add(preOldRate);
        list.add(preLaborRate);
        list.add(prePrimarySchool);
        list.add(preMiddleSchool);
        list.add(preHighschool);
        return list;
    }
}
