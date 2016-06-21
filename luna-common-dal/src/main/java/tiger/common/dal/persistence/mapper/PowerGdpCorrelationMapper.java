/**
 * 310 Inc.
 * All Right Reserved.
 */
package tiger.common.dal.persistence.mapper;

import org.apache.ibatis.annotations.Param;
import tiger.common.dal.persistence.power.PowerGdpCorrelationDO;

import java.util.List;

/**
 * Created by Bongo on 16/3/1.
 */
public interface PowerGdpCorrelationMapper {

    /**
     * 根据起止年份获取总表数据
     *
     * @param startYear
     * @param endYear
     * @return
     */
    List<PowerGdpCorrelationDO> getPowerGdpCorrelationDOList(@Param("startYear")String startYear, @Param("endYear")String endYear);

    /**
     * 录入数据
     *
     * @param powerGdpCorrelationDO
     * @return
     */
    int insertSelective(PowerGdpCorrelationDO powerGdpCorrelationDO);

    int updateByPrimaryKey(PowerGdpCorrelationDO powerGdpCorrelationDO);

    PowerGdpCorrelationDO selectByYear(@Param("year")int year);
}
