package tiger.core.service.water;

import tiger.core.domain.water.WaterQualityDomain;

/**
 * Created by lisite on 16/5/22.
 */
public interface WaterQualityService {

    /**
     * 根据id获取站内消息.
     *
     * @param id the id
     * @return the waterQuality by id
     */
    WaterQualityDomain getWaterQualityById(Long id);
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
