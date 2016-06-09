package tiger.core.service.water;

import tiger.core.domain.air.AirPollutionDomain;
import tiger.core.domain.water.WaterPollutionDomain;
import tiger.core.domain.water.WaterQualityDomain;

import java.util.List;

/**
 * Created by lisite on 16/5/22.
 */
public interface WaterQualityService {

    /**
     * 获取waterQuality
     *
     * @return the waterQuality
     */
    List<WaterQualityDomain> getWaterQuality();
    /**
     * 删除waterQuality
     *
     * @param id
     * @return
     */
    boolean deleteWaterQualityByID(Long id);
    /**
     * 更新waterQuality
     *
     * @param waterQualityDomain the waterQuality domain
     * @return the int
     */
    boolean updateWaterQuality(WaterQualityDomain waterQualityDomain);

    /**
     * 创建一个waterQualityDomain
     * @param waterQualityDomain
     * @return
     */
    WaterQualityDomain createWaterQuality(WaterQualityDomain waterQualityDomain);

}
