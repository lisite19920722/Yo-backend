/**
 * Gambition Inc.
 * All Right Reserved.
 */
package tiger.core.service.population.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.common.dal.persistence.mapper.*;
import tiger.common.dal.persistence.population.*;
import tiger.core.service.population.C_PopulationService;

import java.util.List;

/**
 * @Author: [mondooo.cgq]
 * @version: [V 0.1.1]
 * @CreateDate: [16/6/13 11:07]
 */
@Service
public class C_PopulationServiceImpl implements C_PopulationService {
    @Autowired
    private EmployInsuranceMapper employInsuranceMapper;
    @Autowired
    private SchoolPredictionMapper schoolPredictionMapper;
    @Autowired
    private LaborGdpRelationPreMapper laborGdpRelationPreMapper;
    @Autowired
    private PopulationStructurePreMapper populationStructurePreMapper;
    @Autowired
    private SumPopulationMapper sumPopulationMapper;
    @Autowired
    private BirthrateMapper birthrateMapper;

    /**
     * @see C_PopulationService#getPopulationStructurePreData()
     */
    @Override
    public List<PopulationStructurePreDO> getPopulationStructurePreData() {
        return populationStructurePreMapper.getPopulationStructurePreData();
    }

    /**
     * @see C_PopulationService#getSumPopulationData()
     */
    @Override
    public List<SumPopulationDO> getSumPopulationData() {
        return sumPopulationMapper.getSumPopulationData();
    }

    /**
     * @see C_PopulationService#getBirthrateData()
     */
    @Override
    public List<BirthrateDO> getBirthrateData() {
        return birthrateMapper.getBirthrateData();
    }

    /**
     * @see C_PopulationService#getLaborGdpRelationPreData()
     */
    @Override
    public List<LaborGdpRelationPreDO> getLaborGdpRelationPreData() {
        return laborGdpRelationPreMapper.getLaborGdpRelationPreData();
    }

    /**
     * @see C_PopulationService#getEmployInsuranceList()
     */
    @Override
    public List<PopulationEmployInsuranceDO> getEmployInsuranceList() {
        return employInsuranceMapper.getEmployInsuranceList();
    }

    /**
     * @see C_PopulationService#getSchoolList()
     */
    @Override
    public List<PopulationSchoolDO> getSchoolList() {
        return schoolPredictionMapper.getSchoolList();
    }
}
