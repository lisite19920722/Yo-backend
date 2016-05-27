package tiger.core.service.air;

import tiger.core.domain.air.AirQualityDomain;

/**
 * Created by lisite on 16/5/22.
 */
public interface AirQualityService {

    /**
     * 根据id获取站内消息.
     *
     * @param id the id
     * @return the airQuality by id
     */
    AirQualityDomain getAirQualityById(Long id);
    /**
     * 删除airQuality
     *
     * @param id
     * @return
     */
    boolean deleteAirQualityByID(Long id);
    /**
     * 更新airQuality
     *
     * @param airQualityDomain the airQuality domain
     * @return the int
     */
    boolean updateAirQuality(AirQualityDomain airQualityDomain);

    /**
     * 创建一个airQualityDomain
     * @param airQualityDomain
     * @return
     */
    AirQualityDomain createAirQuality(AirQualityDomain airQualityDomain);

}
