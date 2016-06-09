package tiger.biz.water.support.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.biz.water.support.WaterQualityManager;
import tiger.core.basic.BaseResult;
import tiger.core.basic.enums.ErrorCodeEnum;
import tiger.core.basic.exception.TigerException;
import tiger.core.domain.water.WaterPollutionDomain;
import tiger.core.domain.water.WaterQualityDomain;
import tiger.core.service.water.WaterQualityService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lisite on 16/5/22.
 */

@Service
public class WaterQualityManagerImpl implements WaterQualityManager {

    @Autowired
    private WaterQualityService waterQualityService;

    /**
     * @see WaterQualityManager#read()
     */
    @Override
    public BaseResult read() {
        List arrays=new ArrayList();
        List<WaterQualityDomain> waterQualityDomainList = waterQualityService.getWaterQuality();
        if (waterQualityDomainList == null) {
            throw new TigerException(ErrorCodeEnum.NOT_FOUND, "不存在的空气污染记录");
        }
        arrays.add(waterQualityDomainList);
        return new BaseResult(arrays);
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
