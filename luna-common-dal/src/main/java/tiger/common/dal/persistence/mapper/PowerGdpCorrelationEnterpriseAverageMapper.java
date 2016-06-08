/**
 * 310 Inc.
 * All Right Reserved.
 */
package tiger.common.dal.persistence.mapper;

import org.apache.ibatis.annotations.Param;
import tiger.common.dal.persistence.power.PowerGdpCorrelationEnterpriseAverageDO;

import java.util.List;

/**
 * Created by Bongo on 16/3/4.
 */
public interface PowerGdpCorrelationEnterpriseAverageMapper {

    /**
     * 根据起止年份获取企业平均值数据
     *
     * @param startYear
     * @param endYear
     * @return
     */
    List<PowerGdpCorrelationEnterpriseAverageDO> getPowerGdpCorrelationEnterpriseAverageDOList(@Param("startYear")String startYear, @Param("endYear") String endYear);

}
