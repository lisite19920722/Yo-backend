package tiger.biz.water.support.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.biz.water.support.WaterPollutionManager;
import tiger.core.basic.BaseResult;
import tiger.core.basic.enums.ErrorCodeEnum;
import tiger.core.basic.exception.TigerException;
import tiger.core.domain.water.WaterPollutionDomain;
import tiger.core.service.water.WaterPollutionService;

/**
 * Created by lisite on 16/5/22.
 */

@Service
public class WaterPollutionManagerImpl implements WaterPollutionManager {

    @Autowired
    private WaterPollutionService waterPollutionService;

    /**
     * @see WaterPollutionManager#read(Long)
     */
    @Override
    public BaseResult<WaterPollutionDomain> read(Long id) {
        WaterPollutionDomain waterPollution = waterPollutionService.getWaterPollutionById(id);

        if (waterPollution == null) {
            throw new TigerException(ErrorCodeEnum.NOT_FOUND, "不存在的空气污染记录");
        }

        return new BaseResult<>(waterPollution);
    }

    /**
     * @see WaterPollutionManager#delete(Long)
     */
    @Override
    public BaseResult<Boolean> delete(Long id) {
        if (id == null) {
            throw new TigerException(ErrorCodeEnum.ILLEGAL_PARAMETER);
        }

        return new BaseResult<>(waterPollutionService.deleteWaterPollutionByID(id));
    }

    /**
     * @see WaterPollutionManager#update(WaterPollutionDomain)
     */
    @Override
    public BaseResult<Boolean> update(WaterPollutionDomain waterPollution) {
        if (waterPollution == null || waterPollution.getId() == null) {
            throw new TigerException(ErrorCodeEnum.ILLEGAL_PARAMETER);
        }

        return new BaseResult<>(waterPollutionService.updateWaterPollution(waterPollution));
    }

    /**
     * @see WaterPollutionManager#create(WaterPollutionDomain)
     */
    @Override
    public BaseResult<WaterPollutionDomain> create(WaterPollutionDomain waterPollutionDomain){
        WaterPollutionDomain resultDomain = waterPollutionService.createWaterPollution(waterPollutionDomain);

        return new BaseResult<>(resultDomain);
    }

}