/**
 * 310 Inc.
 * All Right Reserved.
 */
package tiger.common.dal.persistence.mapper;

import org.apache.ibatis.annotations.Param;
import tiger.common.dal.persistence.power.PowerGdpCorrelationEnterpriseSoloDO;
import java.util.List;

/**
 * Created by Bongo on 16/3/4.
 */
public interface PowerGdpCorrelationEnterpriseSoloMapper {

    /**
     * 根据企业id 起止年份 季度获取企业数据
     *
     * @param enterpriseId
     * @param startYear
     * @param endYear
     * @param season
     * @return
     */
    List<PowerGdpCorrelationEnterpriseSoloDO> getPowerGdpCorrelationEnterpriseSoloDOList(@Param("enterpriseId")String enterpriseId, @Param("startYear")String startYear, @Param("endYear")String endYear, @Param("season")String season);

}
