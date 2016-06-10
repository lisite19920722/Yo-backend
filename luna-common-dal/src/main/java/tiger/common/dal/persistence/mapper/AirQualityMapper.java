package tiger.common.dal.persistence.mapper;

import tiger.common.dal.persistence.air.AirQualityDO;

import java.util.List;

/**
 * Created by lisite on 16/5/22.
 */
public interface AirQualityMapper {

    List<AirQualityDO> select();

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AirQualityDO record);

    int insertSelective(AirQualityDO record);

}
