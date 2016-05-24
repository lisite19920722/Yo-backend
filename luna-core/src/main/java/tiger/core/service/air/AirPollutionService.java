package tiger.core.service.air;

import tiger.core.domain.air.AirPollutionDomain;

/**
 * Created by lisite on 16/5/22.
 */
public interface AirPollutionService {

    /**
     * 根据id获取站内消息.
     *
     * @param id the id
     * @return the airPollution by id
     */
    AirPollutionDomain getAirPollutionById(Long id);
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

}
