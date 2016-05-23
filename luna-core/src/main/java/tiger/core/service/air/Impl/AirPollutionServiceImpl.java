package tiger.core.service.air.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.common.dal.persistence.air.AirPollutionDO;
import tiger.common.dal.persistence.mapper.AirPollutionMapper;
import tiger.core.domain.air.AirPollutionDomain;
import tiger.core.domain.air.convert.AirPollutionConvert;
import tiger.core.service.air.AirPollutionService;

/**
 * Created by lisite on 16/5/22.
 */

@Service
public class AirPollutionServiceImpl implements AirPollutionService{

    @Autowired
    private AirPollutionMapper airPollutionMapper;

    @Override
    public AirPollutionDomain getAirPollutionById(Long id) {
        AirPollutionDO airPollutionDO = airPollutionMapper.selectByPrimaryKey(id);
        if (null != airPollutionDO) {
            return AirPollutionConvert.convertDOToDomain(airPollutionDO);
        }
        return null;
    }

}
