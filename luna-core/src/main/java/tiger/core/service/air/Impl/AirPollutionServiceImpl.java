package tiger.core.service.air.Impl;

import org.springframework.stereotype.Service;
import tiger.common.dal.persistence.message.MessageDO;
import tiger.core.domain.air.AirPollutionDomain;
import tiger.core.domain.message.convert.MessageConvert;
import tiger.core.service.air.AirPollutionService;

/**
 * Created by lisite on 16/5/22.
 */

@Service
public class AirPollutionServiceImpl implements AirPollutionService{

    @Override
    public AirPollutionDomain getAirPollutionById(Long id) {
        AirPollutionDO airPollutionDO = AirPollutionMapper.selectByPrimaryKey(id);
        if (null != AirPollutionDO) {
            return AirPollutionConvert.convertDOToDomain(AirPollutionDO);
        }
        return null;
    }

}
