package tiger.common.dal.persistence.mapper;

import tiger.common.dal.persistence.air.AirQualityDO;

/**
 * Created by lisite on 16/5/22.
 */
public interface AirQualityMapper {

    AirQualityDO selectByPrimaryKey(Long id);

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AirQualityDO record);

    int insertSelective(AirQualityDO record);

}
