package tiger.biz.air.support.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.biz.air.support.AirQualityManager;
import tiger.core.basic.BaseResult;
import tiger.core.basic.enums.ErrorCodeEnum;
import tiger.core.basic.exception.TigerException;
import tiger.core.domain.air.AirQualityDomain;
import tiger.core.service.air.AirQualityService;

/**
 * Created by lisite on 16/5/22.
 */

@Service
public class AirQualityManagerImpl implements AirQualityManager {

    @Autowired
    private AirQualityService airQualityService;

    /**
     * @see AirQualityManager#read(Long)
     */
    @Override
    public BaseResult<AirQualityDomain> read(Long id) {
        AirQualityDomain airQuality = airQualityService.getAirQualityById(id);

        if (airQuality == null) {
            throw new TigerException(ErrorCodeEnum.NOT_FOUND, "不存在的空气污染记录");
        }

        return new BaseResult<>(airQuality);
    }

    /**
     * @see AirQualityManager#delete(Long)
     */
    @Override
    public BaseResult<Boolean> delete(Long id) {
        if (id == null) {
            throw new TigerException(ErrorCodeEnum.ILLEGAL_PARAMETER);
        }

        return new BaseResult<>(airQualityService.deleteAirQualityByID(id));
    }

    /**
     * @see AirQualityManager#update(AirQualityDomain)
     */
    @Override
    public BaseResult<Boolean> update(AirQualityDomain airQuality) {
        if (airQuality == null || airQuality.getId() == null) {
            throw new TigerException(ErrorCodeEnum.ILLEGAL_PARAMETER);
        }

        return new BaseResult<>(airQualityService.updateAirQuality(airQuality));
    }

    /**
     * @see AirQualityManager#create(AirQualityDomain)
     */
    @Override
    public BaseResult<AirQualityDomain> create(AirQualityDomain airQualityDomain){
        AirQualityDomain resultDomain = airQualityService.createAirQuality(airQualityDomain);

        return new BaseResult<>(resultDomain);
    }

}
