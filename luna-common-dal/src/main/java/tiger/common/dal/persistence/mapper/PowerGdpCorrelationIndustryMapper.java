/**
 * 310 Inc.
 * All Right Reserved.
 */
package tiger.common.dal.persistence.mapper;

import org.apache.ibatis.annotations.Param;
import tiger.common.dal.persistence.power.PowerGdpCorrelationIndustryDO;

import java.util.List;

/**
 * Created by Bongo on 16/3/2.
 */
public interface PowerGdpCorrelationIndustryMapper {

    /**
     * 根据年份和季度获取八大行业年数据
     *
     * @param year
     * @param season
     * @return
     */
    List<PowerGdpCorrelationIndustryDO> getPowerGdpCorrelationIndustryDOList(@Param("year")String year, @Param("season")String season);

    /**
     * 根据行业id 起止年份 季度获取数据
     *
     * @param industryId
     * @param startYear
     * @param endYear
     * @return
     */
    List<PowerGdpCorrelationIndustryDO> getPowerGdpCorrelationIndustrySoloDOList(@Param("industryId")String industryId, @Param("startYear")String startYear, @Param("endYear")String endYear, @Param("season")String season);

}
