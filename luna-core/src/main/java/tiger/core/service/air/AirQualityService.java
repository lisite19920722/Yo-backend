package tiger.core.service.air;

import tiger.core.domain.air.AirQualityDomain;

import java.util.List;

/**
 * Created by lisite on 16/5/22.
 */
public interface AirQualityService {

    /**
     * 获取airQuality
     *
     * @return the airQuality
     */
    List<AirQualityDomain> getAirQuality();
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
