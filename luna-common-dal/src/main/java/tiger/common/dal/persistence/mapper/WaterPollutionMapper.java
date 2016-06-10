package tiger.common.dal.persistence.mapper;

import tiger.common.dal.persistence.air.AirPollutionDO;
import tiger.common.dal.persistence.water.WaterPollutionDO;

import java.util.List;

/**
 * Created by lisite on 16/5/22.
 */
public interface WaterPollutionMapper {

    List<WaterPollutionDO> select();

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WaterPollutionDO record);

    int insertSelective(WaterPollutionDO record);

}
