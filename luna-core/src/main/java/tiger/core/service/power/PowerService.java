/**
 * Gambition Inc.
 * All Right Reserved.
 */
package tiger.core.service.power;

import tiger.core.domain.power.*;

import java.util.List;

/**
 * @Author: [mondooo.cgq]
 * @version: [V 0.1.1]
 * @CreateDate: [16/6/9 04:11]
 */
public interface PowerService {
    /**
     * 根据起止年份查询用电量与经济关联总表数据
     *
     * @param startYear
     * @param endYear
     * @return
     */
    List<PowerGdpCorrelationDomain> getPowerGdpCorrelationDomainList(String startYear, String endYear);

    /**
     * 根据年份和季度获取八大行业对比分析数据
     *
     * @param year
     * @param season
     * @return
     */
    List<PowerGdpCorrelationIndustryDomain> getPowerGdpCorrelationIndustryDomainList(String year, String season);

    /**
     * 根据行业id 起止年份 季度 获取行业用电量等数据
     *
     * @param industryId
     * @param startYear
     * @param endYear
     * @param season
     * @return
     */
    List<PowerGdpCorrelationIndustrySoloDomain> getPowerGdpCorrelationIndustrySoloDomainList(String industryId, String startYear, String endYear, String season);

    /**
     * 根据起止年份获取企业用电量与产值关联分析 平均值数据
     *
     * @param startYear
     * @param endYear
     * @return
     */
    List<PowerGdpCorrelationEnterpriseAverageDomain> getEnterpriseAverageDomainList(String startYear, String endYear);

    /**
     * 根据企业id 起止年份 季度获取企业用电量等数据
     *
     * @param enterpriseId
     * @param startYear
     * @param endYear
     * @param season
     * @return
     */
    List<PowerGdpCorrelationEnterpriseSoloDomain> getPowerGdpCorrelationEnterpriseSoloDomainList(String enterpriseId, String startYear, String endYear, String season);
}
