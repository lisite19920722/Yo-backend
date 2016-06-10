/**
 * 310 Inc.
 * All Right Reserved.
 */
package tiger.biz.power.support;

import java.util.Map;

/**
 * Created by Bongo on 16/3/1.
 * Refactored by Bongo on 16/6/9
 *
 * 用电量部分全部Manager
 */
public interface PowerGdpCorrelationManager {

    /**
     * 获取 工业用电量与GDP增长率关联分析 数据
     *
     * @return
     */
    Map<String, double[]> getPowerGdpArray();

    /**
     * 获取 行业用电量与行业产值增长率对比分析 数据
     * */
    Map<String, double[]> getPowerGdpCorrelationIndustryMap(String year, String season);

    /**
     * 根据行业id和年份 获取某行业某年各季度数据
     *
     * @param industryId
     * @param year
     * @return
     */
    Map<String,double[]> getPowerGdpCorrelationIndustrySoloDomainMap(String industryId, String year, String season);

    /**
     * 根据行业id 获取某行业年度数据
     *
     * @param industryId
     * @return
     */
    Map<String,double[]> getPowerGdpCorrelationIndustrySoloDomainMapTotal(String industryId, String season);

    /**
     * 获取 企业用电量与企业产值关联分析 平均增长率 数据
     *
     * @return
     */
    Map<String, double[]> getEnterpriseAverageArray();

    /**
     * 根据企业id和年份 获取某企业某年各季度数据
     *
     * @param industryId
     * @param year
     * @return
     */
    Map<String,double[]> getPowerGdpCorrelationEnterpriseSoloDomainMap(String industryId, String year, String season);

    /**
     * 根据企业id 获取某企业年度数据
     *
     * @param industryId
     * @return
     */
    Map<String,double[]> getPowerGdpCorrelationEnterpriseSoloDomainMapTotal(String industryId, String season);
}
