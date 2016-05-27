package tiger.core.service.water;

import tiger.core.domain.water.WaterPollutionDomain;

/**
 * Created by lisite on 16/5/22.
 */
public interface WaterPollutionService {

    /**
     * 根据id获取站内消息.
     *
     * @param id the id
     * @return the waterPollution by id
     */
    WaterPollutionDomain getWaterPollutionById(Long id);
    /**
     * 删除waterPollution
     *
     * @param id
     * @return
     */
    boolean deleteWaterPollutionByID(Long id);
    /**
     * 更新waterPollution
     *
     * @param waterPollutionDomain the waterPollution domain
     * @return the int
     */
    boolean updateWaterPollution(WaterPollutionDomain waterPollutionDomain);

    /**
     * 创建一个waterPollutionDomain
     * @param waterPollutionDomain
     * @return
     */
    WaterPollutionDomain createWaterPollution(WaterPollutionDomain waterPollutionDomain);

}
