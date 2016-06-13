/**
 * Gambition Inc.
 * All Right Reserved.
 */
package tiger.core.service.population;

import tiger.common.dal.persistence.population.*;

import java.util.List;

/**
 * @Author: [mondooo.cgq]
 * @version: [V 0.1.1]
 * @CreateDate: [16/6/13 11:03]
 */
public interface C_PopulationService {

    /**
     * 貌似是返回人口结构dos
     *
     * @return
     */
    List<PopulationStructurePreDO> getPopulationStructurePreData();

    /**
     * 貌似是返回人口总量dos
     *
     * @return
     */
    List<SumPopulationDO> getSumPopulationData();

    /**
     * 貌似是返回人口自然增长率dos
     *
     * @return
     */
    List<BirthrateDO> getBirthrateData();

    /**
     * 貌似是返回劳动力与经济关联分析dos
     *
     * @return
     */
    List<LaborGdpRelationPreDO> getLaborGdpRelationPreData();

    /**
     * 貌似是返回就业保险相关dos
     *
     * @return
     */
    List<PopulationEmployInsuranceDO> getEmployInsuranceList();

    /**
     * 貌似是返回教育相关dos
     *
     * @return
     */
    List<PopulationSchoolDO> getSchoolList();

}
