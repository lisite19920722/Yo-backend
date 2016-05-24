package tiger.common.dal.persistence.mapper;

import tiger.common.dal.persistence.air.AirPollutionDO;

/**
 * Created by lisite on 16/5/22.
 */
public interface AirPollutionMapper {

    AirPollutionDO selectByPrimaryKey(Long id);

    int deleteByPrimaryKey(Long id);

}
