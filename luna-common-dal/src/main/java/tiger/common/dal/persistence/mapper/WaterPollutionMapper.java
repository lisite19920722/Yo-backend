package tiger.common.dal.persistence.mapper;

import tiger.common.dal.persistence.water.WaterPollutionDO;

/**
 * Created by lisite on 16/5/22.
 */
public interface WaterPollutionMapper {

    WaterPollutionDO selectByPrimaryKey(Long id);

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WaterPollutionDO record);

    int insertSelective(WaterPollutionDO record);

}
