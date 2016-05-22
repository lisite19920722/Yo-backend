package tiger.biz.air.support.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.biz.air.support.AirPollutionManager;
import tiger.core.basic.BaseResult;
import tiger.core.basic.enums.ErrorCodeEnum;
import tiger.core.basic.exception.TigerException;
import tiger.core.domain.air.AirPollutionDomain;
import tiger.core.domain.message.MessageDomain;
import tiger.core.service.air.AirPollutionService;

/**
 * Created by lisite on 16/5/22.
 */

@Service
public class AirPollutionManagerImpl implements AirPollutionManager {

    @Autowired
    private AirPollutionService airPollutionService;

    @Override
    public BaseResult<AirPollutionDomain> read(Long id) {
        AirPollutionDomain airPollution = airPollutionService.getAirPollutionById(id);

        if (airPollution == null) {
            throw new TigerException(ErrorCodeEnum.NOT_FOUND, "不存在的空气污染记录");
        }

        return new BaseResult<AirPollutionDomain>(airPollution);
    }
}
