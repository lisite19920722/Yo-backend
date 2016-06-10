package tiger.core.service.air;

import tiger.core.domain.air.AirPollutionDomain;
import tiger.core.domain.air.AirQualityDomain;

import java.util.List;

/**
 * Created by lisite on 16/5/22.
 */
public interface AirPollutionService {

    /**
     * 获取airPollution
     *
     * @return the airPollution
     */
    List<AirPollutionDomain> getAirPollution();
    /**
     * 删除airPollution
     *
     * @param id
     * @return
     */
    boolean deleteAirPollutionByID(Long id);
    /**
     * 更新airPollution
     *
     * @param airPollutionDomain the airPollution domain
     * @return the int
     */
    boolean updateAirPollution(AirPollutionDomain airPollutionDomain);

    /**
     * 创建一个airPollutionDomain
     * @param airPollutionDomain
     * @return
     */
    AirPollutionDomain createAirPollution(AirPollutionDomain airPollutionDomain);

}
