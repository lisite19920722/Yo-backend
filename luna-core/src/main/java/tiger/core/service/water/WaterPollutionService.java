package tiger.core.service.water;

import tiger.core.domain.air.AirPollutionDomain;
import tiger.core.domain.water.WaterPollutionDomain;

import java.util.List;

/**
 * Created by lisite on 16/5/22.
 */
public interface WaterPollutionService {

    /**
     * 获取waterPollution
     *
     * @return the waterPollution
     */
    List<WaterPollutionDomain> getWaterPollution();
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
