package tiger.biz.water.support.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.biz.water.support.WaterQualityManager;
import tiger.core.basic.BaseResult;
import tiger.core.basic.enums.ErrorCodeEnum;
import tiger.core.basic.exception.TigerException;
import tiger.core.domain.water.WaterQualityDomain;
import tiger.core.service.water.WaterQualityService;

/**
 * Created by lisite on 16/5/22.
 */

@Service
public class WaterQualityManagerImpl implements WaterQualityManager {

    @Autowired
    private WaterQualityService waterQualityService;

    /**
     * @see WaterQualityManager#read(Long)
     */
    @Override
    public BaseResult<WaterQualityDomain> read(Long id) {
        WaterQualityDomain waterQuality = waterQualityService.getWaterQualityById(id);

        if (waterQuality == null) {
            throw new TigerException(ErrorCodeEnum.NOT_FOUND, "不存在的空气污染记录");
        }

        return new BaseResult<>(waterQuality);
    }

    /**
     * @see WaterQualityManager#delete(Long)
     */
    @Override
    public BaseResult<Boolean> delete(Long id) {
        if (id == null) {
            throw new TigerException(ErrorCodeEnum.ILLEGAL_PARAMETER);
        }

        return new BaseResult<>(waterQualityService.deleteWaterQualityByID(id));
    }

    /**
     * @see WaterQualityManager#update(WaterQualityDomain)
     */
    @Override
    public BaseResult<Boolean> update(WaterQualityDomain waterQuality) {
        if (waterQuality == null || waterQuality.getId() == null) {
            throw new TigerException(ErrorCodeEnum.ILLEGAL_PARAMETER);
        }

        return new BaseResult<>(waterQualityService.updateWaterQuality(waterQuality));
    }

    /**
     * @see WaterQualityManager#create(WaterQualityDomain)
     */
    @Override
    public BaseResult<WaterQualityDomain> create(WaterQualityDomain waterQualityDomain){
        WaterQualityDomain resultDomain = waterQualityService.createWaterQuality(waterQualityDomain);

        return new BaseResult<>(resultDomain);
    }

}