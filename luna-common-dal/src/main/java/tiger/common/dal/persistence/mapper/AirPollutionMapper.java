package tiger.common.dal.persistence.mapper;

import tiger.common.dal.persistence.air.AirPollutionDO;
import tiger.common.dal.persistence.air.AirQualityDO;

import java.util.List;

/**
 * Created by lisite on 16/5/22.
 */
public interface AirPollutionMapper {

    List<AirPollutionDO> select();

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AirPollutionDO record);

    int insertSelective(AirPollutionDO record);

}
