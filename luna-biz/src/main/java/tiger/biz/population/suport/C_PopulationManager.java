/**
 * Gambition Inc.
 * All Right Reserved.
 */
package tiger.biz.population.suport;

import tiger.common.dal.persistence.population.*;

import java.util.List;

/**
 * @Author: [mondooo.cgq]
 * @version: [V 0.1.1]
 * @CreateDate: [16/6/13 10:51]
 */
public interface C_PopulationManager {
    /**
     * 貌似是获取人口结构的数据
     *
     * @return
     */
    List<PopulationStructurePreDO> getPopulationStructurePreData();

    /**
     * 貌似是获取人口总量的数据
     *
     * @return
     */
    List<SumPopulationDO> getSumPopulationData();

    /**
     * 貌似是获取人口自然增长率的数据
     *
     * @return
     */
    List<BirthrateDO> getBirthrateData();

    /**
     * 貌似是获取就业保险相关数据
     *
     * @return
     */
    List<PopulationEmployInsuranceDO> getEmployInsuranceList();

    /**
     * 貌似是获取教育相关的数据
     *
     * @return
     */
    List<PopulationSchoolDO> getSchoolList();

    /**
     * 貌似是获取劳动力与经济关联分析数据
     *
     * @return
     */
    List<LaborGdpRelationPreDO> getLaborGdpRelationPreData();

    /**
     * 获取民生预测分析的所有数据
     *
     * @return
     */
    List<double[][]> getEmployInsuranceSchoolList();

}
